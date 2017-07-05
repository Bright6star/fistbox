package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import common.WebConstant;
import dto.User;
/**
 * 登录检测拦截器
 * @author Administrator
 *	在controller类之前执行
 */

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler)
		throws Exception {
		
			HttpSession session=request.getSession();
			
			User user=(User)session.getAttribute(WebConstant.SESSION_USER);
			if(user != null){
				System.out.println("------用户存在----");
				return true;
			}else{
				System.out.println("------不        用户存在----");

				response.sendRedirect(request.getContextPath()+"/admin");
				return false;
			}
			
		
		
	}
	

}
