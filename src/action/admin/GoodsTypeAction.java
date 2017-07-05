package action.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.GoodsTypeDao;
import dao.UserDao;
import dto.GoodsType;
import dto.User;

@Controller
@RequestMapping("/admin/goodstype")
public class GoodsTypeAction {
	
	GoodsTypeDao goodstypeDao=null;
	
	@RequestMapping(value="/goodstypeList")
	public String getGoodsTypeList(GoodsType goddstype, Model data){
		goodstypeDao=new GoodsTypeDao();
		
		List<GoodsType> goodstypeList=goodstypeDao.getGoodsTypeList();
		
		data.addAttribute("goodstypeList",goodstypeList);
		
		return "goodstype/goodstypeList";
	}
	
	@RequestMapping(value="/delete")
	public String getDelete(String code){
		System.out.println(code);
		goodstypeDao=new GoodsTypeDao();

		goodstypeDao.getDelete(code);
			
		return "goodstype/goodstypeList";
	}
	
	
	@RequestMapping(value="/showUpdate")
	public String getShowUpdate(String code,Model data){
		goodstypeDao=new GoodsTypeDao();
		GoodsType goodstype=goodstypeDao.getShowUpdate(code);
		data.addAttribute("goodstype",goodstype);
		return "goodstype/updateGoodsType";
	}
	
	@RequestMapping(value="/update")
	public String getUpdate(GoodsType goodstype){
		goodstypeDao=new GoodsTypeDao();
		goodstypeDao.getUpdate(goodstype);	
		return "redirect:/admin/goodstype/goodstypeList";
	}
	
	@RequestMapping(value="/toaddgoodstype")
	public String getTAGoodsType(GoodsType goodstype){

		
		return "goodstype/addGoodsType";
	}
	
	@RequestMapping(value="/addGT")
	public String getAddGT(GoodsType goodstype){
		goodstypeDao=new GoodsTypeDao();
		goodstypeDao.getAddGT(goodstype);	
		
		return "goodstype/goodstypeList";
	}
}
