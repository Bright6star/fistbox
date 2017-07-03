package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Product;
import dto.Type;
import dto.User;
import dto.noice;
import service.CityService;
import uitls.PageModel;

/**
 * Servlet implementation class ProductController
 */
public class ProductController extends HttpServlet {

	private CityService service = new CityService();

	private PageModel PageModel1 = new PageModel();

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
		String method = req.getParameter("_method");
		switch (method) {
		case "update":
			update(req, resp);
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
		case "toaddproduct":
			toaddproduct(req, resp);
			break;
		case "addproduct":
			addproduct(req, resp);
			break;
		case "showProduct":
			showProduct(req, resp);
			break;
		default:
			break;
		}
	}
	//增加产品
	private void addproduct(HttpServletRequest req, HttpServletResponse resp) {
		Integer typeId = Integer.parseInt(req.getParameter("typeId"));
		String product_name = req.getParameter("product_name");
		String content = req.getParameter("content");
		String product_voltage = req.getParameter("product_voltage");
		String product_power = req.getParameter("product_power");
		String product_water = req.getParameter("product_water");
		String product_pressure = req.getParameter("product_pressure");
		String product_shell = req.getParameter("product_shell");
		String product_capacity = req.getParameter("product_capacity");
		String product_url = req.getParameter("product_url");
		if (content.contains("<p>")) {
			content = content.substring(3, content.length() - 4);
		}
		Product product = new Product();
		product.setProduct_name(product_name);
		product.setContent(content);
		product.setProduct_voltage(product_voltage);
		product.setProduct_power(product_power);
		product.setProduct_water(product_water);
		product.setProduct_pressure(product_pressure);
		product.setProduct_shell(product_shell);
		product.setProduct_capacity(product_capacity);
		product.setProduct_url(product_url);
		Type type = service.getProTypes(typeId).get(0);
		product.setType(type);
		User user = (User) req.getSession().getAttribute("user");
		product.setUser(user);
		service.addProduct(product);
		try {
			resp.sendRedirect("product?_method=showProduct");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//根据id显示需要更新产品信息
	private void update(HttpServletRequest req, HttpServletResponse resp) {
		int id = Integer.parseInt(req.getParameter("id"));
		Product product = service.getProductById(id);
		HttpSession session = req.getSession();
		session.setAttribute("product", product);
		List<Type> typeList = service.getProTypes(null);
		req.setAttribute("types", typeList);
		try {
			req.getRequestDispatcher("/WEB-INF/manager/updateProduct.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	//根据id发布产品
	private void publish(HttpServletRequest req, HttpServletResponse resp) {

		String ids = req.getParameter("ids");
		try {
			String tip = service.publishpro(ids.split(","), 1);
			req.setAttribute("tip", tip);
			req.getRequestDispatcher("product?_method=showProduct").forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} 

	}
	//进行产品更新
	private void updatedo(HttpServletRequest req, HttpServletResponse resp) {

		Integer typeId = Integer.parseInt(req.getParameter("typeId"));
		String content = req.getParameter("content");
		Integer id = Integer.parseInt(req.getParameter("id"));
		String product_name = req.getParameter("product_name");
		String product_voltage = req.getParameter("product_voltage");
		String product_power = req.getParameter("product_power");
		String product_water = req.getParameter("product_water");
		String product_pressure = req.getParameter("product_pressure");
		String product_shell = req.getParameter("product_shell");
		String product_capacity = req.getParameter("product_capacity");
		String product_url = req.getParameter("product_url");

		Product product = new Product();
		product.setId(id);
		product.setProduct_name(product_name);
		product.setProduct_voltage(product_voltage);
		product.setProduct_power(product_power);
		product.setProduct_water(product_water);
		product.setProduct_pressure(product_pressure);
		product.setProduct_shell(product_shell);
		product.setProduct_capacity(product_capacity);
		product.setProduct_url(product_url);
		product.setContent(content);
		Type type = new Type();
		type.setId(typeId);
		product.setType(type);
		product.setId(id);
		String tip = service.updatepro(product);

		try {
			req.setAttribute("tip", tip);
			req.getRequestDispatcher("product?_method=showProduct").forward(req, resp);
		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}
	}
	//删除指定id的记录
	private void delete(HttpServletRequest req, HttpServletResponse resp) {
		int id = Integer.parseInt(req.getParameter("id"));

		String tip = service.deletepro(id);
		// 将提示信息添加到req范围
		req.setAttribute("tip", tip);

		try {
			req.getRequestDispatcher("product?_method=showProduct").forward(req, resp);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}

	}
	//显示所有产品
	public void showProduct(HttpServletRequest req, HttpServletResponse resp) {
		String product_name = req.getParameter("title");
		String pageIndex = req.getParameter("pageIndex");

		if (pageIndex != null && !"".equals(pageIndex)) {
			PageModel1.setPageIndex(Integer.valueOf(pageIndex));
		}
		List<Product> productlist;
		try {
			productlist = service.getProductByPage(product_name, PageModel1);
			req.setAttribute("products", productlist);
			req.setAttribute("pageModel1", PageModel1);
			req.setAttribute("product_name", product_name);
			req.getRequestDispatcher("/WEB-INF/manager/product.jsp").forward(req, resp);

		} catch (ServletException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	//跳转到增加产品页
	public void toaddproduct(HttpServletRequest req, HttpServletResponse resp) {
		List<Type> typeList = service.getProTypes(null);
		req.setAttribute("types", typeList);
		try {
			req.getRequestDispatcher("/WEB-INF/manager/addproduct.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
