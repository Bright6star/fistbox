package dto;

import java.util.Date;

public class Product {
	private Integer id;
	private String product_name;
	private String product_voltage;
	private String product_power;
	private String product_water;
	private String product_pressure;
	private String product_shell;
	private String product_capacity;
	private String content;
	private Type type;
	private String product_url;
	private User user;
	private Date createDate;
	private Date publishDate;
	private Integer publishStatus;
	public Product(){
		super();
	}


	public Product(Integer id, String product_name, String product_voltage, String product_power, String product_water,
			String product_pressure, String product_shell, String product_capacity, String content, Type type,
			String product_url, User user, Date createDate, Date publishDate, Integer publishStatus) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.product_voltage = product_voltage;
		this.product_power = product_power;
		this.product_water = product_water;
		this.product_pressure = product_pressure;
		this.product_shell = product_shell;
		this.product_capacity = product_capacity;
		this.content = content;
		this.type = type;
		this.product_url = product_url;
		this.user = user;
		this.createDate = createDate;
		this.publishDate = publishDate;
		this.publishStatus = publishStatus;
	}



	@Override
	public String toString() {
		return "Product [id=" + id + ", product_name=" + product_name + ", product_voltage=" + product_voltage
				+ ", product_power=" + product_power + ", product_water=" + product_water + ", product_pressure="
				+ product_pressure + ", product_shell=" + product_shell + ", product_capacity=" + product_capacity
				+ ", content=" + content + ", type=" + type + ", product_url=" + product_url + ", user=" + user
				+ ", createDate=" + createDate + ", publishDate=" + publishDate + ", publishStatus=" + publishStatus
				+ "]";
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_voltage() {
		return product_voltage;
	}

	public void setProduct_voltage(String product_voltage) {
		this.product_voltage = product_voltage;
	}

	public String getProduct_power() {
		return product_power;
	}

	public void setProduct_power(String product_power) {
		this.product_power = product_power;
	}

	public String getProduct_water() {
		return product_water;
	}

	public void setProduct_water(String product_water) {
		this.product_water = product_water;
	}

	public String getProduct_pressure() {
		return product_pressure;
	}

	public void setProduct_pressure(String product_pressure) {
		this.product_pressure = product_pressure;
	}

	public String getProduct_shell() {
		return product_shell;
	}

	public void setProduct_shell(String product_shell) {
		this.product_shell = product_shell;
	}

	public String getProduct_capacity() {
		return product_capacity;
	}

	public void setProduct_capacity(String product_capacity) {
		this.product_capacity = product_capacity;
	}


	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getProduct_url() {
		return product_url;
	}

	public void setProduct_url(String product_url) {
		this.product_url = product_url;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Integer getPublishStatus() {
		return publishStatus;
	}

	public void setPublishStatus(Integer publishStatus) {
		this.publishStatus = publishStatus;
	}
	
}
