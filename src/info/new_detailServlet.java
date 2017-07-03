package info;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.noice;
import service.CityService;

/**
 * Servlet implementation class new_detailsServlet
 */
@WebServlet(value="/new_detailServlet")
public class new_detailServlet extends HttpServlet {
	CityService service = new CityService();

	protected void service(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		noice notice=null;
		try {		
			if (id != null) {
				notice = service.getNoticeById(Integer.parseInt(id));
			}
			request.setAttribute("detail", notice);
			request.getRequestDispatcher("/page/new_details.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
