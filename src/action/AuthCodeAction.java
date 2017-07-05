package action;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import common.AuthCode;


/**
 * 验证码处理类
 * @author Administrator
 *
 */
@Controller
public class AuthCodeAction {
	public static final String AUTH_CODE = "AUTH_CODE";
	private static final long serialVersionUID = 1L;
	@RequestMapping("verify")
	public void getAuthCode(HttpSession session, HttpServletResponse response) throws ServletException, IOException {
		//获取验证码
		String code = AuthCode.getAuthCode();
		//将验证码存储到session中，方便后面的判断
		session.setAttribute(AUTH_CODE,code);
		//获取验证码图片
		BufferedImage img = AuthCode.getCodeImg(code);
		//输出验证码图片到客户端
		ImageIO.write(img, "JPEG", response.getOutputStream());
	}
}
