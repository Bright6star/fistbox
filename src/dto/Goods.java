package dto;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Goods implements Serializable{

	private int id;
	private String title;
	private String brandName;
	private double price;
	private double favorablePrice;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date groundingDate;
	private int storage;
	private String image;
	private String description;
	private GoodsType goodstype;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createDate;
	//业务相关属性
	private int buyNum;
	
	public Goods(){
		super();
	}
	
	

	@Override
	public String toString() {
		return "Goods [id=" + id + ", title=" + title + ", brandName=" + brandName + ", price=" + price
				+ ", favorablePrice=" + favorablePrice + ", groundingDate=" + groundingDate + ", storage=" + storage
				+ ", image=" + image + ", description=" + description + ", goodstype=" + goodstype + ", createDate="
				+ createDate + ", buyNum=" + buyNum + "]";
	}



	public Goods(int id, String title, String brandName, double price, double favorablePrice, Date groundingDate,
			int storage, String image, String description, GoodsType goodstype, Date createDate, int buyNum) {
		super();
		this.id = id;
		this.title = title;
		this.brandName = brandName;
		this.price = price;
		this.favorablePrice = favorablePrice;
		this.groundingDate = groundingDate;
		this.storage = storage;
		this.image = image;
		this.description = description;
		this.goodstype = goodstype;
		this.createDate = createDate;
		this.buyNum = buyNum;
	}

	//业务相关方法 计算商品价格
	public double getBuyMoney(){
		DecimalFormat df= new DecimalFormat("0.00");
		return Double.valueOf(df.format(this.favorablePrice*this.buyNum));
	}

	public int getBuyNum() {
		return buyNum;
	}



	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getFavorablePrice() {
		return favorablePrice;
	}
	public void setFavorablePrice(double favorablePrice) {
		this.favorablePrice = favorablePrice;
	}
	public Date getGroundingDate() {
		return groundingDate;
	}
	public void setGroundingDate(Date groundingDate) {
		this.groundingDate = groundingDate;
	}
	public int getStorage() {
		return storage;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public GoodsType getGoodstype() {
		return goodstype;
	}


	public void setGoodstype(GoodsType goodstype) {
		this.goodstype = goodstype;
	}


	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
