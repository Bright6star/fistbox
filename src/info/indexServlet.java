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
 * Servlet implementation class indexServlet
 */
@WebServlet("/index")
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CityService service = new CityService();

	PageModel PageModel1 = new PageModel();

	protected void service(HttpServletRequest request, HttpServletResponse response) {
		List<noice> noticeList = null;
		List<Product>productlist=null;
		String typeId = request.getParameter("typeId");
		try {
			if (typeId != null && "".equals(typeId)) {

				noticeList = service.getNotices(Integer.parseInt("typeId"));

			} else {

				noticeList = service.getNotices(null);

			}
			productlist=service.getProducts(null);
			request.setAttribute("products", productlist);
			request.setAttribute("notices", noticeList);

			request.getRequestDispatcher("/page/index.jsp").forward(request, response);
				
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
