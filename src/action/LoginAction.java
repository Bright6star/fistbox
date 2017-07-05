package action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jcp.xml.dsig.internal.MacOutputStream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import common.WebConstant;
import dao.UserDao;
import dto.User;

@Controller
@RequestMapping("/user")
public class LoginAction {

	@RequestMapping(value="/login")
	public String login(User user){
		return "index";
	}
	
	@ResponseBody
	@RequestMapping("/loginAjax")
	public Map<String, Object> login(String userId,String pwd){
		Map<String, Object> map=new HashMap<>();
		//0=登录成功 ，1=验证码不正确，2=帐号或密码为空，3=帐号密码格式不正确=3，4=用户还未激活
		
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		UserDao userDao=new UserDao();
		User user=new User();
		user.setUserId(userId);
		user.setPwd(pwd);
		//查询登录用户是否存在
		User u=userDao.getUserByUserIdAndByPassword(user);
		//存在用户添加到session中方便后面使用
		if(u != null){
			request.getSession().setAttribute(WebConstant.SESSION_USER, u);
			map.put("tip", "登录成功");
			map.put("status", 0);
		}else{
			map.put("tip", "用户名或密码不正确");
			map.put("status", 3);
		}
		
		
		return map;
	}
	
	
	@RequestMapping("/userIdCheck")
	@ResponseBody
	public Map<String, Object> userIdCheck(String userId){
		UserDao dao=new UserDao();
		boolean flag=dao.getUserByUserId(userId);
		Map<String, Object> map=new HashMap<>();
		map.put("status", flag?1:0);
		return map;
	}
}
