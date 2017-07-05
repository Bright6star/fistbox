package action.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.UserDao;
import dto.User;

@Controller
@RequestMapping("/admin/user")
public class adUserAction {
	
	UserDao userDao=null;
	
	@RequestMapping(value="/userList")
	public String getUserList(User user, Model data){
		userDao=new UserDao();
		List<User> userList=userDao.getUserList(user);
		
		data.addAttribute("userList",userList);
		
		
		return "user/userList";
	}
	
	
	@RequestMapping(value="/delete")
	public String getDelete(int id){
		
		userDao=new UserDao();
		userDao.getDelete(id);
			
		return "forward:/admin/user/userList";
	}
	
	@RequestMapping(value="/showUpdate")
	public String getShowUpdate(int id,Model data){
		
		userDao=new UserDao();
		User user=userDao.getShowUpdate(id);
		data.addAttribute("user",user);	
		return "user/updateUser";
	}
	
	@RequestMapping(value="/update")
	public String getUpdate(User user){
		userDao=new UserDao();
		userDao.getUpdate(user);	
		return "redirect:/admin/user/userList";
	}
	
	@RequestMapping(value="/toadduser")
	public String getToAddUser(User user){
			
		return "user/addUser";
	}
	
	@RequestMapping(value="/adduser")
	public String getAddUser(User user){
		userDao=new UserDao();
		userDao.getInsert(user);
		
		return "redirect:/admin/user/userList";
	}
	
}
