package com.hlbb.module.manager;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.hlbb.module.menu.Menu;

@Entity
@Table(name="mng_module")
public class ManagerMenu implements Serializable{
	private static final long serialVersionUID = 285692491313996866L;
	
	@Id
	private Long managerId;
	@Id
	private Long moduleId;
	
	@OneToOne
	@JoinColumn(name="moduleId")
	private Menu menu;
	
	public Long getManagerId() {
		return managerId;
	}
	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}
	public Long getModuleId() {
		return moduleId;
	}
	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
}
