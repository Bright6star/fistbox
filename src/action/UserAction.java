package action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import common.EmailTools;
import dao.UserDao;
import dto.User;

@Controller
public class UserAction {
	
	UserDao dao=new UserDao();
	@RequestMapping("register")
	public String register(User user){
		//发送激活邮件
		String activeCode = String.valueOf(System.currentTimeMillis());
		String activeURL="http://localhost:9090/xiangmu3-4/active?userId="+user.getUserId()+"&activeCode="+activeCode;
		StringBuilder content=new StringBuilder();
		content.append(user.getUserId()+"亲，您好欢迎您使用我们商城，请点击下面的链接进行帐号激活：<br/>");
		content.append("<a href='"+activeURL+"'>"+activeURL+"</a>");
		boolean flag=EmailTools.send(user.getEmail(), "路标商城-注册激活", content.toString());
		if(flag){
			dao=new UserDao();
			user.setCreateDate(new Date());
			user.setActiveCode(activeCode);
			dao.save(user);
		}else{
			return "registe";
		}
		return "index";
	}
	
	@RequestMapping("/active")
	public String active(String userId,String activeCode,Model data){
		dao=new UserDao();
		String tip="";
		Map<String, String >map=new HashMap<>();
		map.put("userId", userId);
		map.put("activeCode", activeCode);
		int count=dao.activeUser(map);
		if(count>0){
			 tip="帐号激活成功";
		}else{
			 tip="帐号激活失败";
		}
		//String tip= count>0?"帐号激活成功":"帐号激活失败";
		data.addAttribute("tip",tip);
		System.out.println(tip);
		return "login";
	}
	
	
	@RequestMapping("invalidate")
	public String invalidate(HttpServletRequest req,HttpServletResponse resp){
		
		HttpSession session=req.getSession();
		session.invalidate();
		return "redirect:index.html";
	}
}
