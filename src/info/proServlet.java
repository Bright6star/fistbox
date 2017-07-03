package info;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Product;
import dto.noice;
import service.CityService;
import uitls.PageModel;

/**
 * Servlet implementation class proServlet
 */
@WebServlet("/proServlet")
public class proServlet extends HttpServlet {
	
	CityService service = new CityService();

	PageModel pageModel =new PageModel();
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			showProduct(request,response);
			request.getRequestDispatcher("/page/product.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void showProduct(HttpServletRequest req, HttpServletResponse resp) {
		String product_name = req.getParameter("title");
		String pageIndex = req.getParameter("pageIndex");

		if (pageIndex != null && !"".equals(pageIndex)) {
			pageModel.setPageIndex(Integer.valueOf(pageIndex));
		}
		List<Product> productlist;
		try {
			productlist = service.getProductPublish(product_name, pageModel);
			req.setAttribute("products", productlist);
			req.setAttribute("pageModel", pageModel);
			req.setAttribute("product_name", product_name);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
