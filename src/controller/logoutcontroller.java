package controller;

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
@WebServlet("/logout")
public class logoutcontroller extends HttpServlet {
	private CityService service = new CityService();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			this.doPost(req, resp);

	}
	//避免写两次一样的代码，跳转到首页
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		
		session.invalidate();
		
		resp.sendRedirect("index");

	}

}
