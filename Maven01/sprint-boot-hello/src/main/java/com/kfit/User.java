package com.kfit;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class User {
	private String name;
	private String id;
	
	@JSONField(format="yyyy-MM-dd HH:mm")
	private Date createTime;
	
	//不想序列化
	@JSONField(serialize = false)
	private String remarks;
	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
