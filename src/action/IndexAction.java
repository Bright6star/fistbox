package action;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.GoodsDao;
import dao.GoodsTypeDao;
import dao.PicDao;
import dto.Goods;
import dto.GoodsType;
import dto.Pic;

@Controller
public class IndexAction {

	@RequestMapping("/index")
	public String index(Model data){
		PicDao picdao=new PicDao();
		List<Pic> picList= picdao.getPicList();
		data.addAttribute("picList",picList);
		
		GoodsTypeDao goodstypeDao=new GoodsTypeDao();
		List<GoodsType> goodstypeList=goodstypeDao.getGoodsTypeList();
		data.addAttribute("goodstypeList",goodstypeList);
		//首页新品数据展示
		GoodsDao goodsDao=new GoodsDao();
		List<Goods> newgoodsList=goodsDao.getNewGoodsList();
		data.addAttribute("newgoodsList",newgoodsList);
		//首页新品大数据展示
		List<Goods> newBGgoodsList=goodsDao.getNewBGGoodsList();
		data.addAttribute("newbggoods",newBGgoodsList);
		//首页热卖大数据展示
		List<Goods> hotBGgoodsList=goodsDao.getHotBGGoodsList();
		data.addAttribute("hotBGgoods",hotBGgoodsList);
		//首页热卖数据展示
		List<Goods> hotgoodsList=goodsDao.getHotGoodsList();
		data.addAttribute("hotgoods",hotgoodsList);
		
		//首页夏日数据展示
		List<Goods> summgoodsList=goodsDao.getsummGoodsList();
		data.addAttribute("summgoods",summgoodsList);
		
		return "index";
	
	}
	
	@ResponseBody
	@RequestMapping("/getGoodsTypeAjax")
	public List<GoodsType> getGoodsTypeAjax(){
		GoodsTypeDao goodstypeDao=new GoodsTypeDao();
		List<GoodsType> goodstypeList=goodstypeDao.getGoodsTypeList();
		return goodstypeList;
	}
	
	@RequestMapping("/detail")
	public String getDetail(int id,Model data){
		GoodsDao goodsDao=new GoodsDao();
		Goods goods=goodsDao.getGoodsById(id);
		
		data.addAttribute("goods",goods);
		
		String code=goods.getGoodstype().getCode();
		
		GoodsTypeDao goodsTypeDao=new GoodsTypeDao();
		GoodsType goodsType=goodsTypeDao.findGoodsTypeByCode(code);
		data.addAttribute("goodsType",goodsType);
		
		GoodsTypeDao goodstypeDao=new GoodsTypeDao();
		List<GoodsType> goodstypeList=goodstypeDao.getGoodsTypeList();
		data.addAttribute("goodstypeList",goodstypeList);
		
		return "pro_details";
	}
	
	
}
