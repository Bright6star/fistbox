package action;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.AuthCode;



/**
 * 验证码处理Servlet类
 * @author Administrator
 *
 */
public class AuthCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取验证码
		String code = AuthCode.getAuthCode();
		//将验证码存储到session中，方便后面的判断
		HttpSession session = request.getSession();
		session.setAttribute("authCode",code);
		//获取验证码图片
		BufferedImage img = AuthCode.getCodeImg(code);
		//输出验证码图片到客户端
		ImageIO.write(img, "JPEG", response.getOutputStream());
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
}
