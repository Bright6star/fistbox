package dto;

import java.io.Serializable;

/**
 * 公告类型类
 * @author Administrator
 *
 */
public class Type implements Serializable{
	//唯一标识一条数据
	private Integer id;
	//类型名称
	private String name;
	public Type() {
		super();
	}
	public Type(String name) {
		super();
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
