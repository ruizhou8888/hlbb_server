package com.hlbb.module.constant;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ConstantType {
	@Id
	@GeneratedValue
	private Long id;
	private String typeNo;
	private String name;
	private String remark;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="typeNo")
	private List<Constant> constants;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTypeNo() {
		return typeNo;
	}
	public void setTypeNo(String typeNo) {
		this.typeNo = typeNo;
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
	public List<Constant> getConstants() {
		return constants;
	}
	public void setConstants(List<Constant> constants) {
		this.constants = constants;
	}
	
}
