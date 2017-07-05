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
import dao.PicDao;
import dto.Goods;
import dto.GoodsType;
import dto.Pic;


@Controller
@RequestMapping("/admin/picturcarousel")
public class picAction {
	
	PicDao picdao=new PicDao();
	@RequestMapping(value="/picList")
	public String getPicList(Model data){
		picdao=new PicDao();
		List<Pic> picList= picdao.getPicList();
		data.addAttribute("picList",picList);
		return "pic/picList";
	}
	
	@RequestMapping(value="/toaddpic")
	public String getToAddPic(Model data){

		return "pic/addPic";
	}
	
	@RequestMapping(value="/showUpdate")
	public String getShowPic(int id,Model data){
		picdao=new PicDao();
		Pic pic=picdao.getShowPic(id);
		data.addAttribute("pic",pic);
		return "pic/updatePic";
	}
	
	@RequestMapping(value="/updatePic")
	public String getUpdatePic(Pic pic,@RequestParam(name="pic")MultipartFile file,HttpSession session) throws IOException{
		System.out.println(pic);
		String fileName=imgsUpload(file, session,"/images/pic");
		picdao=new PicDao();
		if(fileName!=null&&fileName!="")
		pic.setImageUrl(fileName);
		int count=picdao.updatePic(pic);	
		System.out.println(count);
		return "redirect:/admin/picturcarousel/picList";
	}
	
	@RequestMapping(value="/addPic")
	public String getAddPic(Pic pic,@RequestParam(name="pic")MultipartFile file,HttpSession session) throws IOException{

		String fileName=imgsUpload(file, session,"/images/pic");
		picdao=new PicDao();
		pic.setImageUrl(fileName);
		int count=picdao.savePic(pic);	
		
		return "redirect:/admin/picturcarousel/picList";
	}
	
	private String imgsUpload(MultipartFile file, HttpSession session,String savePath) throws IOException {
		//获取文件在服务器的存储路径
		String path=session.getServletContext().getRealPath(savePath);
		//获取上传文件的名称
		String fileName=file.getOriginalFilename();
		//进行文件存储
		file.transferTo(new File(path,fileName));
		
		return fileName;
	}
	
	@RequestMapping(value="/delete")
	public String getDelete(int id){
		picdao=new PicDao();

		picdao.getDelete(id);
			
		return "redirect:/admin/picturcarousel/picList";
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