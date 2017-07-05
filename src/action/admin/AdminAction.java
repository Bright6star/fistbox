package action.admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import action.AuthCodeAction;
import common.AuthCode;
import common.WebConstant;
import dao.UserDao;
import dto.User;

@Controller
@RequestMapping("/admin")
public class AdminAction {
	
	@RequestMapping(value="/login")
	public String login(){
		System.out.println("text--------houtai");
		return "logins";
	}
	
	@RequestMapping(value="/main")
	public String main(){
		return "main";
	}
	
	@ResponseBody
	@RequestMapping("/adminloginAjax")
	public Map<String, Object> login(String userId,String pwd,String code,HttpSession session){
		Map<String, Object> map=new HashMap<>();
		//0=登录成功 ，1=验证码不正确，2=帐号或密码为空，3=帐号密码格式不正确=3，4=用户还未激活
		
	
		String oldVcod=(String)session.getAttribute(AuthCodeAction.AUTH_CODE);
		if(code == null || ! oldVcod.equals(code)){
			map.put("tip", "验证码不正确");
			map.put("status", 1);
		}else{
		
		UserDao userDao=new UserDao();
		User user=new User();
		user.setUserId(userId);
		user.setPwd(pwd);
		user.setRoot(0);
		//查询登录用户是否存在
		User u=userDao.getAdmin(user);
		//存在用户添加到session中方便后面使用
		if(u != null){
			session.setAttribute(WebConstant.SESSION_USER, u);
			map.put("tip", "管理员登录成功");
			map.put("status", 0);
		}else{
			map.put("tip", "管理员用户名或密码不正确");
			map.put("status", 3);
		}
		}
		
		return map;
	}
	
	@RequestMapping("/logout")
	public String invalidate(HttpServletRequest req,HttpServletResponse resp){
		
		HttpSession session=req.getSession();
		session.invalidate();
		return "logins";
	}
	
}
