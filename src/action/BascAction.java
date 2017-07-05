package action;



import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BascAction {
	
	@RequestMapping("/*.html")
	public void basc(){
		System.out.println("-测试跳转-");
	}
}
