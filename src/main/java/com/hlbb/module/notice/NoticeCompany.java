package com.hlbb.module.notice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="notice_company")
public class NoticeCompany {
	
	@Id
	@GeneratedValue
	private Long id;
	private Long noticeId;
	private Long companyId;
	
	public NoticeCompany(){}
	public NoticeCompany(Long noticeId,Long companyId){
		this.noticeId = noticeId;
		this.companyId = companyId;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(Long noticeId) {
		this.noticeId = noticeId;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	
	

}
