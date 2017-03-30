package com.hlbb.module.manager;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.hlbb.module.company.Company;

@Entity
@Table(name="manager")
public class Manager implements Serializable{
	private static final long serialVersionUID = 4766821105136765449L;
	@Id
	@GeneratedValue
	private Long id;
	private String loginName;
	private String password;
	private String randomFactor;
	private String remark;
	private Date lastLoginTime;
	private int isActive;
	private int state;
	
	@OneToOne
	@JoinColumn(name="companyId")
	private Company company;
	
	@OneToMany
	@JoinColumn(name="managerId")
	private List<ManagerMenu> menus;
	
	
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public List<ManagerMenu> getMenus() {
		return menus;
	}
	public void setMenus(List<ManagerMenu> menus) {
		this.menus = menus;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRandomFactor() {
		return randomFactor;
	}
	public void setRandomFactor(String randomFactor) {
		this.randomFactor = randomFactor;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}

}
