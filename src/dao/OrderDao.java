package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import dto.Goods;
import dto.Order;


public class OrderDao extends BaseDao{

	//带上分页查询商品数据
	public List<Order> getOrderList(Map<String, Object> params){
		SqlSession session=getSqlSession();
		List<Order> orderList=session.selectList("Order.mapper.findByOrderUser",params);
		closeSqlSession();
		return orderList;
	}
	
	public boolean  saveOrder(Order order){
		SqlSession session=getSqlSession();
	
		int count=session.insert("Order.mapper.save",order);
		session.commit();
		closeSqlSession();
		return count>0?true:false;
	}
	
	public boolean updateOrderAlipayStatus(String orderCode){
		SqlSession session=getSqlSession();
		
		int count=session.update("Order.mapper.updateOrderAlipayStatus",orderCode);
		session.commit();
		closeSqlSession();
		return count>0?true:false;
	}
	
	//根据用户查询用户的订单
	public List<Order> getOrderByUserId(int userId){
		SqlSession session=getSqlSession();
		List<Order> orderList=session.selectList("Order.mapper.findByOrder");
		closeSqlSession();
		return orderList;
	}
	public List<Order> getOrderById(int orderId){
		SqlSession session=getSqlSession();
		List<Order> orderList=session.selectList("OrderItem.mapper.getOrderItem",orderId);
		closeSqlSession();
		return orderList;
	}
	
	//统计商品行数据
	public int count(Map<String , Object> params){
		SqlSession session=getSqlSession();
		int count=session.selectOne("Order.mapper.count",params);
		closeSqlSession();
		return count;
	}
	
	//带上分页查询商品数据
	public List<Order> getPageGoods(Map<String, Object> params){
		SqlSession session=getSqlSession();
		List<Order> goodsList=session.selectList("Order.mapper.findByPage",params);
		closeSqlSession();
		return goodsList;
	}
	
}
