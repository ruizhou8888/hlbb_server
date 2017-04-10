package com.hlbb.module.menu;

import java.io.Serializable;

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


}
