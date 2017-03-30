package com.hlbb.module.crew;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="job_intent")
public class JobIntent implements Serializable{
	private static final long serialVersionUID = -2901778151781648662L;
	@Id
	@GeneratedValue
	private Long id;
	private int companyNature;
	private String companyPlace;
	private int intentPost;
	private int term;
	private int shipType;
	private int shipRoute;
	private Long crewId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getCompanyNature() {
		return companyNature;
	}
	public void setCompanyNature(int companyNature) {
		this.companyNature = companyNature;
	}
	public String getCompanyPlace() {
		return companyPlace;
	}
	public void setCompanyPlace(String companyPlace) {
		this.companyPlace = companyPlace;
	}
	public int getIntentPost() {
		return intentPost;
	}
	public void setIntentPost(int intentPost) {
		this.intentPost = intentPost;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public int getShipType() {
		return shipType;
	}
	public void setShipType(int shipType) {
		this.shipType = shipType;
	}
	public int getShipRoute() {
		return shipRoute;
	}
	public void setShipRoute(int shipRoute) {
		this.shipRoute = shipRoute;
	}
	public Long getCrewId() {
		return crewId;
	}
	public void setCrewId(Long crewId) {
		this.crewId = crewId;
	}
	
	
}
