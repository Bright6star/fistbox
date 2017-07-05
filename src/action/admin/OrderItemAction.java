package action.admin;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.OrderDao;
import dao.OrderItemDao;
import dto.Order;
import dto.OrderItem;


@Controller
@RequestMapping("/admin/orderItem")
public class OrderItemAction {
	
	OrderItemDao orderItemDao=new OrderItemDao();
	
	/**
	 * 订单明细
	 * @param data
	 * @return
	 */
	
	@RequestMapping(value="/showDeteil")
	public String getOrderItemList(int id,Model data){
		orderItemDao=new OrderItemDao();
		List<OrderItem> orderItemList= orderItemDao.getOrderItem(id);
		System.out.println(orderItemList);
		data.addAttribute("orderItemList",orderItemList);
		return "order/orderItem";
	}
	/*@RequestMapping(value="/delete")
	public String getDelete(int id){
		goodsDao=new GoodsDao();

		goodsDao.getDelete(id);
			
		return "forward:/admin/goods/goodsList";
	}
	
	
	@RequestMapping(value="/showUpdate")
	public String getShowUpdate(int id,Model data){
		goodsDao=new GoodsDao();
		Goods goods=goodsDao.getShowUpdate(id);
		data.addAttribute("goods",goods);
		return "goods/updateGoods";
	}
	
	@RequestMapping(value="/toaddGoods")
	public String getAddGoods(Model data){
		System.out.println("----------走错地了----------------");
		goodsTypeDao=new GoodsTypeDao();
		List<GoodsType> goodstypeList=goodsTypeDao.getGoodsTypeList();
		data.addAttribute("goodstypeList",goodstypeList);
		return "goods/addGoods";
	}
	
	@RequestMapping(value="/addGoods")
	public String getAddGoods(Goods goods,@RequestParam(name="pic")MultipartFile file,HttpSession session) throws IOException{
		System.out.println(goods);
		String fileName=imgsUpload(file, session,"/images/goodsImgs");
		
		goodsDao=new GoodsDao();
		goods.setImage(fileName);
		goods.setCreateDate(new Date());
		boolean flag=goodsDao.saveGoods(goods);	
		
		return "redirect:/admin/goods/goodsList";
	}
	
	@RequestMapping(value="/imgUpload")
	@ResponseBody
	public String getImgUpload(@RequestParam(name="pic")MultipartFile file,HttpSession session) throws IllegalStateException, IOException{
		String fileName=imgsUpload(file, session,"/images/goodsImgs");
		return fileName;
	}
	//文件上传公共方法
	private String imgsUpload(MultipartFile file, HttpSession session,String savePath) throws IOException {
		//获取文件在服务器的存储路径
		String path=session.getServletContext().getRealPath(savePath);
		//获取上传文件的名称
		String fileName=file.getOriginalFilename();
		//进行文件存储
		file.transferTo(new File(path,fileName));
		
		return fileName;
	}*/
	
}