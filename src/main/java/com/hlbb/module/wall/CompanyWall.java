package com.hlbb.module.wall;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hlbb.module.company.Company;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="company_wall")
public class CompanyWall implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6645689408012805582L;
	
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String subtitle;
	private String remark;
	private String filePath;
	private Long state;
	private String stateNote;

	@Transient
	private String stateName;
	private Long companyId;
	private Long createdUid;
	@OrderBy("createdTime DESC ")
	private Date createdTime;
	private Long updateUid;
	private Date updateTime;
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
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
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
	public Long getUpdateUid() {
		return updateUid;
	}
	public void setUpdateUid(Long updateUid) {
		this.updateUid = updateUid;
	}
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getState() {
		return state;
	}

	public void setState(Long state) {
		this.state = state;
	}

	public String getStateNote() {
		return stateNote;
	}

	public void setStateNote(String stateNote) {
		this.stateNote = stateNote;
	}

	public String getStateName() {
	    if(this.state==0){
            stateName="未送审";
        }else if(this.state==1){
	        stateName="审核中";
        }else if(this.state==2){
            stateName="审核通过";
        }else if(this.state==3){
            stateName="审核不通过";
        }
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
}
