package info;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Product;
import dto.noice;
import service.CityService;

/**
 * Servlet implementation class pro_detailServlet
 */
@WebServlet("/pro_detailServlet")
public class pro_detailServlet extends HttpServlet {
	CityService service = new CityService();

	protected void service(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		Product product=null;
		try {		
			if (id != null) {
				product = service.getProductById(Integer.parseInt(id));
			}
			request.setAttribute("detail", product);
			request.getRequestDispatcher("/page/product_detalis.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
