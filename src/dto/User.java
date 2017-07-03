package dto;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private int id;
	private String name;
	private String password;
	private Date loginTime;
	private int root;
	public User(){
		
	}
	
	public int getRoot() {
		return root;
	}

	public void setRoot(int root) {
		this.root = root;
	}

	public User(int id,String name,String password,Date loginTime,int root){
		this.id=id;
		this.name=name;
		this.password=password;
		this.loginTime=loginTime;
		this.root=root;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	
}
