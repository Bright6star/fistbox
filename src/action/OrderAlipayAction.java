package action;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ailpay.DirectPayService;
import common.PageModel;
import common.WebConstant;
import dao.GoodsDao;
import dao.GoodsTypeDao;
import dao.OrderDao;
import dao.OrderItemDao;
import dto.Goods;
import dto.GoodsType;
import dto.Order;
import dto.OrderItem;
import dto.User;

@Controller
public class OrderAlipayAction {

	/*
	 * 订单提交方法
	 */
	@RequestMapping(value ="/smOrder")
	public String SubmitOrder(String goodsIdArrays,HttpSession session){
		double totalMoney=0.0;
		List<Goods> goodsList = new ArrayList<>();
		Map<Integer, Integer>shopCar=(Map<Integer, Integer>)session.getAttribute(WebConstant.SHOP_CAR);
		if(shopCar != null){
			GoodsDao dao=new GoodsDao();
			
			String[] ids=goodsIdArrays.split(",");
			for(String goodsId : ids){
				int buyNum=shopCar.get(Integer.parseInt(goodsId));
				Goods goods=dao.getGoodsById(Integer.parseInt(goodsId));
				goods.setBuyNum(buyNum);
				
				totalMoney += goods.getBuyMoney();
				goodsList.add(goods);
			}
			
		}
		DecimalFormat df= new DecimalFormat("0.00");
		totalMoney = Double.valueOf(df.format(totalMoney));
		//为了下一个方法获取方法
		session.setAttribute("totalMoney", totalMoney);
		session.setAttribute("goodsList", goodsList);
		return "confirm_order";
	}
	
	@RequestMapping(value="/saveOrder")
	public String saveOrder(HttpSession session,RedirectAttributes data){
		double totalMoney=(double)session.getAttribute("totalMoney");
		List<Goods> goodsList =(List<Goods>)session.getAttribute("goodsList");
		OrderItemDao orderItemDao=new OrderItemDao();
		Map<Integer, Integer>shopCar=(Map<Integer, Integer>)session.getAttribute(WebConstant.SHOP_CAR);
		Order order=new Order();
		User user=(User)session.getAttribute(WebConstant.SESSION_USER);
		String orderCode=createOrderCode(user.getId());
		order.setUser(user);
		order.setCreateDate(new Date());
		order.setTradingStatus(0);
		order.setTotalAmount(totalMoney);
		order.setOrderCode(orderCode);
		order.setAlipay(0);
		OrderDao orderDao=new OrderDao();
		
		orderDao.saveOrder(order);
		
		for(Goods goods:goodsList){
			OrderItem orderItem=new OrderItem();
			orderItem.setGoods(goods);
			orderItem.setOrder(order);
			orderItem.setOrderNum(goods.getBuyNum());
			orderItemDao.saveOrderItem(orderItem);
			order.getOrderItems().add(orderItem);
			
			shopCar.remove(goods.getId());
		}
		//存储到购物车到session中
		session.setAttribute(WebConstant.SHOP_CAR, shopCar);
		session.removeAttribute("totalMoney");
		session.removeAttribute("goodsList");
		data.addFlashAttribute("order",order);
		return "redirect:/orderAlipay";
	}
	
	@RequestMapping(value="/orderAlipay")
	public ModelAndView orderAlipay(@ModelAttribute("order")Order order){
		//拼装需要支付的参数
		String title=order.getOrderItems().get(0).getGoods().getTitle();
		//指定跳转支付中转界面
		Map<String,String>params=DirectPayService.getRequestDataByDirectPay(order.getOrderCode(), title,String.valueOf(order.getTotalAmount()), title);
		ModelAndView modelAndView= new ModelAndView("alipay/request_alipay");
		modelAndView.addObject("params",params);
		modelAndView.addObject("requestUrl", DirectPayService.direct_alipay_gateway);
		return modelAndView;
	}
	
	@RequestMapping(value="/directPayResult")
	public String directPayResult(String out_trade_no,String trade_no,String trade_status,String buyer_id,String total_fee){
		System.out.println("订单编号:"+out_trade_no);
		System.out.println("交易状态:"+trade_status);
		System.out.println("支付宝交易流水号:"+trade_no);
		System.out.println("买家支付宝帐号:"+buyer_id);
		System.out.println("交易金额:"+total_fee);
		if(trade_status.equals("TRADE_SUCCESS")||trade_status.equals("TRADE_FINISHED")){
			OrderDao dao=new OrderDao();
			dao.updateOrderAlipayStatus(out_trade_no);
		}
		return "redirect:/orderDetails";
	}
	
	@RequestMapping(value="/orderDetails")
	public String orderDetails(@RequestParam(name="pageIndex",defaultValue="0")int pageIndex,Order order,HttpSession session,Model data){
		User user=(User)session.getAttribute(WebConstant.SESSION_USER);
		OrderDao dao=new OrderDao();
		//分页
		System.out.println(user.getId());
		PageModel pageModel=new PageModel();
		pageModel.setPageSize(3);
		Map<String , Object> params=new HashMap<>();
		params.put("userId", user.getId());
		
		int recordCount=dao.count(params);
		if(recordCount!=0){
			//设置分页总共有多少条记录
			pageModel.setRecordCount(recordCount);
			//设置当前页
			pageModel.setPageIndex(pageIndex);
	
			params.put("pageModel", pageModel);
			List<Order> orderList=dao.getPageGoods(params);
			data.addAttribute("pageModel",pageModel);
			data.addAttribute("orderList",orderList);
		}
		GoodsTypeDao goodstypeDao=new GoodsTypeDao();
		List<GoodsType> goodstypeList=goodstypeDao.getGoodsTypeList();
		data.addAttribute("goodstypeList",goodstypeList);
		return "order";
	}
	
	private String createOrderCode(int userId){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		return "luBiao_"+userId+"_"+sdf.format(new Date());
	}
	
	@RequestMapping(value="/orderdetails")
	public String orderDetails(int id,Model data){
		OrderDao dao=new OrderDao();
		List<Order> orderList=dao.getOrderById(id);
		data.addAttribute("orderList",orderList); 
		
		
		return "order_details";
	}
}
