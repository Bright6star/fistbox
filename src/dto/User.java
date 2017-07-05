package dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String userId;
	private String name;
	private String pwd;
	private String email;
	private String phone;
	private String province;
	private String city;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	
	private String address;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createDate;
	
	private int activeStatus;
	private int root;
	private String activeCode;
	//private String code;
	
	
	public User(){
		super();
	}
	



	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", name=" + name + ", pwd=" + pwd + ", email=" + email
				+ ", phone=" + phone + ", province=" + province + ", city=" + city + ", address=" + address
				+ ", createDate=" + createDate + ", activeStatus=" + activeStatus + ", root=" + root + ", activeCode="
				+ activeCode + "]";
	}




	public User(int id, String userId, String name, String pwd, String email, String phone, String province,
			String city, String address, Date createDate, int activeStatus, int root, String activeCode) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.pwd = pwd;
		this.email = email;
		this.phone = phone;
		this.province = province;
		this.city = city;
		this.address = address;
		this.createDate = createDate;
		this.activeStatus = activeStatus;
		this.root = root;
		this.activeCode = activeCode;
	}




	public Date getBirthday() {
		return birthday;
	}




	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getProvince() {
		return province;
	}


	public void setProvince(String province) {
		this.province = province;
	}






	public String getCity() {
		return city;
	}






	public void setCity(String city) {
		this.city = city;
	}






	public int getRoot() {
		return root;
	}





	public void setRoot(int root) {
		this.root = root;
	}






	public int getActiveStatus() {
		return activeStatus;
	}







	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}







	public String getActiveCode() {
		return activeCode;
	}







	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}







	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public Date getCreateDate() {
		return createDate;
	}



	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	};
	
}
