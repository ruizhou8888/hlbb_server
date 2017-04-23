package com.hlbb.module.notice;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@OrderBy("createdTime DESC ")
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
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
