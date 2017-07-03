package info;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import dao.Connect;
import dto.User;
import service.CityService;;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CityService service = new CityService();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("-----服务器----doget()");
		this.doPost(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String userPass = req.getParameter("userPass");
		User user = new User();
		user.setName(userName);
		if(userPass != null && !"".equals(userPass)){
			user.setPassword(userPass);
		}else{
			user.setPassword("0");
		}
		User u = service.getUserByName(user);
		//判断查询返回的User对象不为空，表示有对应的用户存在
		if(u != null){
			//通过Request请求对象获取session对象
			HttpSession session = req.getSession();
			//往session中存储数据，通过key 映射value的方式进行存储（底层就是使用一个Map存储）
			session.setAttribute("user", u);
			//进行页面跳转（服务器端重定向）
			if(u.getRoot()==0){
			req.getRequestDispatcher("/WEB-INF/manager/manager.jsp").forward(req, resp);
			}else{
			req.getRequestDispatcher("/page/index.jsp").forward(req, resp);
			}
		}else{
			//进行页面跳转（客户端重定向）
			resp.sendRedirect("page/login.jsp");
		}

	}

}
