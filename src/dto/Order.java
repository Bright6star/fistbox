package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String orderCode;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date sendDate;
	
	private int tradingStatus;
	private double totalAmount;
	private User user;
	private int alipay;
	
	private List<OrderItem> orderItems =new ArrayList<>();
	
	public Order(){
		super();
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderCode=" + orderCode + ", createDate=" + createDate + ", sendDate=" + sendDate
				+ ", tradingStatus=" + tradingStatus + ", totalAmount=" + totalAmount + ", user=" + user + ", alipay="
				+ alipay + "]";
	}
	public Order(int id, String orderCode, Date createDate, Date sendDate, int tradingStatus, double totalAmount,
			User user, int alipay) {
		super();
		this.id = id;
		this.orderCode = orderCode;
		this.createDate = createDate;
		this.sendDate = sendDate;
		this.tradingStatus = tradingStatus;
		this.totalAmount = totalAmount;
		this.user = user;
		this.alipay = alipay;
	}
	
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public int getTradingStatus() {
		return tradingStatus;
	}
	public void setTradingStatus(int tradingStatus) {
		this.tradingStatus = tradingStatus;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getAlipay() {
		return alipay;
	}
	public void setAlipay(int alipay) {
		this.alipay = alipay;
	}
	
	
}
