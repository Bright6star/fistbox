package dto;

import java.io.Serializable;

public class Pic implements Serializable{
	
	private int id;
	private String imageUrl;
	private String requestUrl;
	
	public Pic(){
		super();
	}

	@Override
	public String toString() {
		return "Pic [id=" + id + ", imageUrl=" + imageUrl + ", requestUrl=" + requestUrl + "]";
	}

	public Pic(int id, String imageUrl, String requestUrl) {
		super();
		this.id = id;
		this.imageUrl = imageUrl;
		this.requestUrl = requestUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
	
}
