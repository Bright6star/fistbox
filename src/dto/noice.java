package dto;

import java.io.Serializable;
import java.util.Date;

public class noice implements Serializable{
//	唯一标识符
	private Integer id;
//	标题
	private String title;
//	信息内容
	private String content;
//	创建日期
	private Date createDate;
//	发布日期
	private Date publishDate;
//	发布状态
	private Integer publishStatus;
//	公告类型
	private Type type;
//	公告发布人
	private User user;
	
	public noice(){
		super();
	}
	public noice(String title,String content,Date publishDate,
			Integer publishStatus,Type type,User user){
		super();
		this.title=title;
		this.content=content;
		this.publishDate=publishDate;
		this.publishStatus=publishStatus;
		this.type=type;
		this.user=user;
		
	}
	
	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", content=" + content
				+ ", createDate=" + createDate + ", publishDate=" + publishDate
				+ ", publishStatus=" + publishStatus + "]";
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Date getCreateDate() {
		return createDate;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public Integer getPublishStatus() {
		return publishStatus;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public void setPublishStatus(Integer publishStatus) {
		this.publishStatus = publishStatus;
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

	
}
