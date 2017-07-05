package dto;

import java.io.Serializable;

public class GoodsType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private String name;
	private String remark;
	
	public GoodsType(){
		super();
	}
	
	@Override
	public String toString() {
		return "GoodsType [code=" + code + ", name=" + name + ", remark=" + remark + "]";
	}
	
	public GoodsType(String code, String name, String remark) {
		super();
		this.code = code;
		this.name = name;
		this.remark = remark;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
