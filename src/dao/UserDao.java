package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import dto.Order;
import dto.User;

public class UserDao extends BaseDao{
	
	
	
	public int getUpdate(User user) {
		SqlSession session=getSqlSession();
		int count=session.update("dto.User.getUpdate",user);
		session.commit();
		closeSqlSession();
		return count;
		
	}
	
	
	public User getShowUpdate(int id) {
		SqlSession session=getSqlSession();
		User user=new User();
		user=session.selectOne("dto.User.getUserById",id);
		closeSqlSession();
		return user;
		
	}
	
	//删除单条记录
	public int getDelete(int id){
		SqlSession session=getSqlSession();
		int count=session.delete("dto.User.getDelete",id);
		session.commit();
		closeSqlSession();
		return count;
	}
	
	
	//查询所有用户信息
	public List<User> getUserList(User user){
		SqlSession session=getSqlSession();
		List<User> userList=session.selectList("dto.User.getUserList",user);
		closeSqlSession();
		return userList;
	}
	
	
	public User getUserByUserIdAndByPassword(User user){
		
		SqlSession session=getSqlSession();
		User u=session.selectOne("dto.User.getUserByUserIdAndByPassword",user);
		closeSqlSession();
		return u;
	}
	
	public User getAdmin(User user){
		
		SqlSession session=getSqlSession();
		User u=session.selectOne("dto.User.getAdmin",user);
		closeSqlSession();
		return u;
	}
	
	public boolean getUserByUserId(String userId){
		
		SqlSession session=getSqlSession();
		int count=session.selectOne("dto.User.getUserByUserId",userId);
		closeSqlSession();
		return count>0?false:true;
	}
	
	public List<User> getOrderByUserId(Order order){
		
		SqlSession session=getSqlSession();
		List<User> user=session.selectList("dto.User.getOrderByUserId",order);
		closeSqlSession();
		return user;
	}
	
	public int save(User user){
		SqlSession session=getSqlSession();
		int count=session.insert("dto.User.save",user);
		session.commit();
		closeSqlSession();
		return count;
	}
	
	public int getInsert(User user){
		SqlSession session=getSqlSession();
		int count=session.insert("dto.User.insert",user);
		session.commit();
		closeSqlSession();
		return count;
	}
	
	
	public int activeUser(Map<String,String> map){
		SqlSession session=getSqlSession();
		int count=session.update("dto.User.activeUser",map);
		session.commit();
		closeSqlSession();
		return count;
	}


	
	
	

}
