package dto;

import java.io.Serializable;

public class OrderItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Order order;
	private Goods goods;
	private int orderNum;
	
	public OrderItem() {
		super();
	}
	
	
	
	@Override
	public String toString() {
		return "OrderItem [order=" + order + ", goods=" + goods + ", orderNum=" + orderNum + "]";
	}



	public OrderItem(Order order, Goods goods, int orderNum) {
		super();
		this.order = order;
		this.goods = goods;
		this.orderNum = orderNum;
	}



	public Order getOrder() {
		return order;
	}



	public void setOrder(Order order) {
		this.order = order;
	}



	public Goods getGoods() {
		return goods;
	}



	public void setGoods(Goods goods) {
		this.goods = goods;
	}



	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	
	
	
}
