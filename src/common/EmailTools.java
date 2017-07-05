package common;

import java.util.Properties;

import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class EmailTools {
	
	
	
	
	public static boolean send(String to,String subject,String content){
		//创建session
		Properties pro=new Properties();
		//邮件协议
		pro.setProperty("mail.transport.protocol", "smtp");
		//邮件端口
		pro.put("mail.host", "smtp.163.com");
		//邮件发送人
		pro.put("mail.from", "cjh_dodi@163.com");
		//相当于客户端与邮件服务器的连接对象
		Session session=Session.getDefaultInstance(pro);
		//开启调试模式（正式发布项目的时候设置为false）
		session.setDebug(true);
		//获取邮件发送对象
		try {
			
			Transport transport=session.getTransport();
			//设置发送人邮件帐号（参数1是邮件的登录名,参数2是邮件的授权码）
			transport.connect("cjh_dodi","bigbang163");
			//创建邮件消息体
			MimeMessage message=new MimeMessage(session);
			//设置邮件的标题
			message.setSubject(subject);
			//设置邮件的内容和页面编码
			message.setContent(content,"text/html;charset=UTF-8");
			
			//发送邮件
			transport.sendMessage(message, InternetAddress.parse(to));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
		
	}
	
}
