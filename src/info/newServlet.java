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
 * Servlet implementation class newServlet
 */
@WebServlet(value = "/newServlet")
public class newServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CityService service = new CityService();

	PageModel PageModel=new PageModel();
	protected void service(HttpServletRequest request, HttpServletResponse response) {
	
		try{
			showNotice(request, response);
			request.getRequestDispatcher("/page/news.jsp").forward(request, response);

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void showNotice(HttpServletRequest req, HttpServletResponse resp) {
		String title = req.getParameter("title");
		String pageIndex = req.getParameter("pageIndex");

		if (pageIndex != null && !"".equals(pageIndex)) {
			PageModel.setPageIndex(Integer.valueOf(pageIndex));
		}
		List<noice> noicelist;
		try {
			noicelist = service.getNoticePublish(title, PageModel);		
			for (noice notice : noicelist) {
				String content = notice.getContent();
				if (content.contains("<p>")) {
					content = content.substring(3,content.length()-4);
					notice.setContent(content);
				}
			}
			req.setAttribute("notices", noicelist);
			req.setAttribute("pageModel", PageModel);
			req.setAttribute("title", title);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
