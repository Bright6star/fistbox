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

import common.PageModel;
import dao.GoodsDao;
import dao.GoodsTypeDao;
import dao.UserDao;
import dto.Goods;
import dto.GoodsType;
import dto.User;


@Controller
@RequestMapping("/admin/goods")
public class GoodsAction {
	
	GoodsDao goodsDao=null;
	GoodsTypeDao goodsTypeDao=null;
	PageModel pageModel=new PageModel();
	
	@RequestMapping(value="/goodsList")
	public String getGoodsList(Goods goods, @RequestParam(name="pageIndex",defaultValue="0")int pageIndex,Model data){
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
		
		goodsTypeDao=new GoodsTypeDao();
		List<GoodsType> goodstypeList=goodsTypeDao.getGoodsTypeList();
		data.addAttribute("goodstypeList",goodstypeList);
		return "goods/goodsList";
	}
	
	@RequestMapping(value="/delete")
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
		goodsTypeDao=new GoodsTypeDao();
		List<GoodsType> goodstypeList=goodsTypeDao.getGoodsTypeList();
		data.addAttribute("goodstypeList",goodstypeList);
		return "goods/addGoods";
	}
	
	@RequestMapping(value="/updateGoods")
	public String getUpdate(Goods goods){
		goodsDao=new GoodsDao();
		goodsDao.updateGoods(goods);
		return "redirect:/admin/goods/goodsList";
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
	}
	
}