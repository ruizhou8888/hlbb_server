package com.hlbb.module.notice;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="notice")
public class Notice implements Serializable{
	private static final long serialVersionUID = 8516003168808799162L;
	
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String content;
	private Long sendType;
	private Long createdUid;
	private Date createdTime;
	private Long updateId;
	private Date updateTime;
	
	public Notice(){}
	public Notice(String title, String content, String sendType) {
		this.title = title;
		this.content = content;
		this.sendType = Long.valueOf(sendType);
		this.createdTime = new Date();
		this.updateTime = new Date();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Long getSendType() {
		return sendType;
	}
	public void setSendType(Long sendType) {
		this.sendType = sendType;
	}
	public Long getCreatedUid() {
		return createdUid;
	}
	public void setCreatedUid(Long createdUid) {
		this.createdUid = createdUid;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Long getUpdateId() {
		return updateId;
	}
	public void setUpdateId(Long updateId) {
		this.updateId = updateId;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
