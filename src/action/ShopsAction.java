package action;


import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import common.PageModel;
import dao.GoodsDao;
import dao.GoodsTypeDao;
import dto.Goods;
import dto.GoodsType;


@Controller
public class ShopsAction {
	
	GoodsDao goodsDao=null;
	GoodsTypeDao goodsTypeDao=null;
	PageModel pageModel=new PageModel();
	
	
	@RequestMapping("/searchs")
	public String searchs(Goods goods, @RequestParam(name="pageIndex",defaultValue="0")int pageIndex,Model data){
		GoodsDao goodsDao=null;
		PageModel pageModel=new PageModel();
		
			pageModel.setPageSize(8);
			Map<String , Object> params=new HashMap<>();
			params.put("goods", goods);
			
			goodsDao=new GoodsDao();
			int recordCount=goodsDao.count(params);
			if(recordCount!=0){
				//设置分页总共有多少条记录
				pageModel.setRecordCount(recordCount);
				//设置当前页
				pageModel.setPageIndex(pageIndex);
				
				
				params.put("pageModel", pageModel);
				List<Goods> goodsList2=goodsDao.getPageGoods(params);
				data.addAttribute("pageModel",pageModel);
				data.addAttribute("goodsList",goodsList2);
			}
			
			GoodsTypeDao goodstypeDao=new GoodsTypeDao();
			List<GoodsType> goodstypeList=goodstypeDao.getGoodsTypeList();
			data.addAttribute("goodstypeList",goodstypeList);
		
		return "shop_list";
	}
	
}