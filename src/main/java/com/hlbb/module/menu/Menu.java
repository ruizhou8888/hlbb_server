package com.hlbb.module.menu;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="module")
public class Menu implements Serializable{
	private static final long serialVersionUID = 3606059296534465839L;
	@Id
	@GeneratedValue
	private Long id;
	private String moduleName;
	private String moduleRoute;
	private String moduleIcon;
	private String parentId;
	private String createdTime;
	private Long createId;
	private Date updatedTime;
	private Long updated_id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getModuleRoute() {
		return moduleRoute;
	}
	public void setModuleRoute(String moduleRoute) {
		this.moduleRoute = moduleRoute;
	}
	public String getModuleIcon() {
		return moduleIcon;
	}
	public void setModuleIcon(String moduleIcon) {
		this.moduleIcon = moduleIcon;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public Long getCreateId() {
		return createId;
	}
	public void setCreateId(Long createId) {
		this.createId = createId;
	}
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	public Long getUpdated_id() {
		return updated_id;
	}
	public void setUpdated_id(Long updated_id) {
		this.updated_id = updated_id;
	}

}
