package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.IdentityScope;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.ConnectionGroupManager;
import java.sql.PreparedStatement;
import com.sun.jndi.ldap.sasl.SaslInputStream;
import com.sun.xml.internal.messaging.saaj.soap.ver1_1.Envelope1_1Impl;

import dto.Product;
import dto.Type;
import dto.User;
import dto.noice;
import service.CityService;
import uitls.ConnectionManager;
import uitls.PageModel;

//@WebServlet("/notice")
public class NoticeController extends HttpServlet {

	private Connection con;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private CityService service = new CityService();

	private PageModel PageModel = new PageModel();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 处理请求乱码
		req.setCharacterEncoding("UTF-8");
		//处理发送过来的请求
		String method = req.getParameter("_method");
		switch (method) {
		case "update":
			update(req, resp);
			break;
		case "toaddNotice":
			toaddNotice(req, resp);
			break;
		case "showNotice":
			showNotice(req, resp);
			break;
		case "addNotice":
			addNotice(req, resp);
			break;
		case "publish":
			publish(req, resp);
			break;
		case "updatedo":
			updatedo(req, resp);
			break;
		case "delete":
			delete(req, resp);
			break;
		default:
			break;
		}
	}
	//显示需要更新的信息
	private void update(HttpServletRequest req, HttpServletResponse resp) {
		int id = Integer.parseInt(req.getParameter("id"));
		noice notice = service.getNoticeById(id);
		HttpSession session = req.getSession();
		session.setAttribute("notice", notice);
		List<Type> typeList=service.getNoticeTypes(null);
		req.setAttribute("types", typeList);
		try {
			req.getRequestDispatcher("/WEB-INF/manager/updateNotice.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	//删除指定id的记录
	private void delete(HttpServletRequest req, HttpServletResponse resp) {
		int id = Integer.parseInt(req.getParameter("id"));

		String tip = service.delete(id);
		// 将提示信息添加到req范围
		req.setAttribute("tip", tip);

		try {
//			req.getRequestDispatcher("/notice?_method=showNotice").forward(req, resp);
			resp.sendRedirect("notice?_method=showNotice");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	//得到页面的数据到数据进行更新
	private void updatedo(HttpServletRequest req, HttpServletResponse resp) {
		Integer typeId = Integer.parseInt(req.getParameter("typeId"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		Integer id = Integer.parseInt(req.getParameter("id"));

		noice noice = new noice();
		noice.setTitle(title);
		noice.setContent(content);
		Type type=new Type();
		type.setId(typeId);
		noice.setType(type);
		noice.setId(id);
		String tip = service.update(noice);
		try {
			req.setAttribute("tip", tip);
			req.getRequestDispatcher("/notice?_method=showNotice").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//根据选择中的id进行发布
	private void publish(HttpServletRequest req, HttpServletResponse resp) {
		String ids = req.getParameter("ids");
		try {
			String tip = service.publish(ids.split(","), 1);
			req.setAttribute("tip", tip);
			req.getRequestDispatcher("/notice?_method=showNotice").forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}

	}
	//添加公告
	public void addNotice(HttpServletRequest req, HttpServletResponse resp) {
		Integer typeId = Integer.parseInt(req.getParameter("typeId"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		if (content.contains("<p>")) {
			content = content.substring(3,content.length()-4);
		}
		noice noice = new noice();
		noice.setTitle(title);
		noice.setContent(content);
		
		Type type=service.getNoticeTypes(typeId).get(0);

		noice.setType(type);
		User user = (User)req.getSession().getAttribute("user");
		noice.setUser(user);
		service.addNotice(noice);	
		try {
			resp.sendRedirect("notice?_method=showNotice");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//跳转到添加公告页面
	public void toaddNotice(HttpServletRequest req, HttpServletResponse resp) {
		
		List<Type> typeList=service.getNoticeTypes(null);
		req.setAttribute("types", typeList);
		try {
			req.getRequestDispatcher("/WEB-INF/manager/addNotice.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	//显示所有公告信息
	private void showNotice(HttpServletRequest req, HttpServletResponse resp) {
		String title = req.getParameter("title");
		String pageIndex = req.getParameter("pageIndex");

		if (pageIndex != null && !"".equals(pageIndex)) {
			PageModel.setPageIndex(Integer.valueOf(pageIndex));
		}
		List<noice> noicelist;
		try {
			noicelist = service.getNoticeByPage(title, PageModel);
			req.setAttribute("notices", noicelist);
			req.setAttribute("pageModel", PageModel);
			req.setAttribute("title", title);

			req.getRequestDispatcher("/WEB-INF/manager/notice.jsp").forward(req, resp);

		} catch (ServletException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
