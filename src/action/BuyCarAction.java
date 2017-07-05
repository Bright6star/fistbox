package action;



import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import common.WebConstant;
import dao.GoodsDao;
import dao.GoodsTypeDao;
import dto.Goods;
import dto.GoodsType;

@Controller
public class BuyCarAction {
	
	@ResponseBody
	@RequestMapping("/addBuyCar")
	public Map<String,String> addBuyCar(int goodsId,int shuz,HttpSession session){
		Map<Integer, Integer>shopCar=(Map<Integer, Integer>)session.getAttribute(WebConstant.SHOP_CAR);
		if(shopCar == null){
			
			shopCar =new LinkedHashMap<>();
		}
		/**
		 * 判断之前是否有添加过相同的商品到购物车中
		 */
		if(shopCar.containsKey(goodsId)){
			int oldNum=shopCar.get(goodsId);
			shopCar.put(goodsId, oldNum+shuz);
		}else{
			shopCar.put(goodsId, shuz);
		}
		session.setAttribute(WebConstant.SHOP_CAR,shopCar);
		Map<String,String> data = new HashMap<>();
		data.put("status","0");
		return data;
	}
	
	@RequestMapping("/showBuyCar")
	public String showBuyCar(HttpSession session,Model data){
		double totalMoney = 0.0;
		List<Goods> goodsList = new ArrayList<>();
		GoodsDao dao=new GoodsDao();
		Map<Integer, Integer>shopCar=(Map<Integer, Integer>)session.getAttribute(WebConstant.SHOP_CAR);
		if(shopCar != null){
			//获取购物车中的每一个商品
			for(Map.Entry<Integer, Integer> map:shopCar.entrySet()){
				int goodsId=map.getKey();
				int buyNum=map.getValue();
				
				
				Goods goods=dao.getGoodsById(goodsId);
				goods.setBuyNum(buyNum);
				
				totalMoney += goods.getBuyMoney();
				goodsList.add(goods);
			}
		}
		//最后的统计
		DecimalFormat df= new DecimalFormat("0.00");
		totalMoney = Double.valueOf(df.format(totalMoney));
		data.addAttribute("totalMoney",totalMoney);
		data.addAttribute("goodsList",goodsList);
		
		GoodsTypeDao goodstypeDao=new GoodsTypeDao();
		List<GoodsType> goodstypeList=goodstypeDao.getGoodsTypeList();
		data.addAttribute("goodstypeList",goodstypeList);
		return "shop_cart";
	}
	
	@ResponseBody
	@RequestMapping("/deleteCar")
	public Map deleteCar(int goodsId,HttpSession session,Model data){
		Map<Integer, Integer>shopCar=(Map<Integer, Integer>)session.getAttribute(WebConstant.SHOP_CAR);
		if(shopCar != null){
				shopCar.remove(goodsId);
		}
		session.setAttribute(WebConstant.SHOP_CAR,shopCar);
		Map<String,String> result = new HashMap<>();
		result.put("status","0");
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/updateCar")
	public Map updateCar(Integer goodsId,Integer buyNum,HttpSession session,Model data){
		
		Map<Integer, Integer>shopCar=(Map<Integer, Integer>)session.getAttribute(WebConstant.SHOP_CAR);
		if(shopCar != null){
				shopCar.put(goodsId, buyNum);
		}
		session.setAttribute(WebConstant.SHOP_CAR,shopCar);
		Map<String,String> result = new HashMap<>();
		result.put("status","0");
		return result;
	}
	
	//获取购物车的数量
	@ResponseBody
	@RequestMapping("loadAjaxShopCarNum")
	public Map loadAjaxShopCarNum(HttpSession session){
		
		Map<Integer, Integer>shopCar=(Map<Integer, Integer>)session.getAttribute(WebConstant.SHOP_CAR);
		int totalNum=0;
		if(shopCar != null){
			for(Map.Entry<Integer, Integer> map:shopCar.entrySet()){
				totalNum += map.getValue();
			}
		}
		session.setAttribute(WebConstant.SHOP_CAR,shopCar);
		Map<String,Object> result = new HashMap<>();
		result.put("status","0");
		result.put("totalNum",totalNum);
		return result;
	}
}
