package com.hlbb.module.company;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="company")
public class Company implements Serializable{
	private static final long serialVersionUID = 489080002579606763L;
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private BigDecimal money = new BigDecimal("0");
	private BigDecimal needPayMoney = new BigDecimal("0");
	private int readNeedPay;
	private String logoPath;
	private String website;
	private String remark;
	private String businessNo;
	
	private String businessLicencePath;
	private String assignmentPath;
	private String firstDivisionPath;
	
	private String contactName;
	private String contactPhone;
	private String region;
	private int nature;
	private int size;
	private String statusNote;
	private int status;
	private Date createdTime;
	private Date updateTime;
	private Date submitReviewTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public BigDecimal getNeedPayMoney() {
		return needPayMoney;
	}
	public void setNeedPayMoney(BigDecimal needPayMoney) {
		this.needPayMoney = needPayMoney;
	}
	public int getReadNeedPay() {
		return readNeedPay;
	}
	public void setReadNeedPay(int readNeedPay) {
		this.readNeedPay = readNeedPay;
	}
	public String getLogoPath() {
		return logoPath;
	}
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getBusinessNo() {
		return businessNo;
	}
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getNature() {
		return nature;
	}
	public void setNature(int nature) {
		this.nature = nature;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getStatusNote() {
		return statusNote;
	}
	public void setStatusNote(String statusNote) {
		this.statusNote = statusNote;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Date getSubmitReviewTime() {
		return submitReviewTime;
	}
	public void setSubmitReviewTime(Date submitReviewTime) {
		this.submitReviewTime = submitReviewTime;
	}
	public String getBusinessLicencePath() {
		return businessLicencePath;
	}
	public void setBusinessLicencePath(String businessLicencePath) {
		this.businessLicencePath = businessLicencePath;
	}
	public String getAssignmentPath() {
		return assignmentPath;
	}
	public void setAssignmentPath(String assignmentPath) {
		this.assignmentPath = assignmentPath;
	}
	public String getFirstDivisionPath() {
		return firstDivisionPath;
	}
	public void setFirstDivisionPath(String firstDivisionPath) {
		this.firstDivisionPath = firstDivisionPath;
	}
	
}
