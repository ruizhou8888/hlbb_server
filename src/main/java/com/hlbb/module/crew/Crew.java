package com.hlbb.module.crew;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Crew implements Serializable{
	private static final long serialVersionUID = 5670924718305767549L;
	@Id
	@GeneratedValue
	private Long id;
	private String loginId;
	private String password;
	private String randomPwd;
	private String name;
	private String nameEn;
	private int height;
	private int weight;
	private String path;
	private int sex;
	private int onlyChild;
	private String idNumber;
	private Date birthday;
	private int province;
	private int city;
	private int country;
	private int politics;
	private int cet;
	private int speechLevel;
	private int schoolId;
	private int deptId;
	private int majorId;
	private int classes;
	private int classPost;
	private int classRanking;
	private String openId;
	private String token;
	private String regPlace;
	private Date regDate;
	private String docPlace;
	private String regType;
	private int isPerfect;
	private int isBasicPerfect;
	private int isSchoolPerfect;
	private Date lastLoginTime;
	
	@OneToOne(mappedBy="crewId")
	private JobIntent jobIntent;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRandomPwd() {
		return randomPwd;
	}
	public void setRandomPwd(String randomPwd) {
		this.randomPwd = randomPwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getOnlyChild() {
		return onlyChild;
	}
	public void setOnlyChild(int onlyChild) {
		this.onlyChild = onlyChild;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getProvince() {
		return province;
	}
	public void setProvince(int province) {
		this.province = province;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	public int getCountry() {
		return country;
	}
	public void setCountry(int country) {
		this.country = country;
	}
	public int getPolitics() {
		return politics;
	}
	public void setPolitics(int politics) {
		this.politics = politics;
	}
	public int getCet() {
		return cet;
	}
	public void setCet(int cet) {
		this.cet = cet;
	}
	public int getSpeechLevel() {
		return speechLevel;
	}
	public void setSpeechLevel(int speechLevel) {
		this.speechLevel = speechLevel;
	}
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public int getMajorId() {
		return majorId;
	}
	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}
	public int getClasses() {
		return classes;
	}
	public void setClasses(int classes) {
		this.classes = classes;
	}
	public int getClassPost() {
		return classPost;
	}
	public void setClassPost(int classPost) {
		this.classPost = classPost;
	}
	public int getClassRanking() {
		return classRanking;
	}
	public void setClassRanking(int classRanking) {
		this.classRanking = classRanking;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getRegPlace() {
		return regPlace;
	}
	public void setRegPlace(String regPlace) {
		this.regPlace = regPlace;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getDocPlace() {
		return docPlace;
	}
	public void setDocPlace(String docPlace) {
		this.docPlace = docPlace;
	}
	public String getRegType() {
		return regType;
	}
	public void setRegType(String regType) {
		this.regType = regType;
	}
	public int getIsPerfect() {
		return isPerfect;
	}
	public void setIsPerfect(int isPerfect) {
		this.isPerfect = isPerfect;
	}
	public int getIsBasicPerfect() {
		return isBasicPerfect;
	}
	public void setIsBasicPerfect(int isBasicPerfect) {
		this.isBasicPerfect = isBasicPerfect;
	}
	public int getIsSchoolPerfect() {
		return isSchoolPerfect;
	}
	public void setIsSchoolPerfect(int isSchoolPerfect) {
		this.isSchoolPerfect = isSchoolPerfect;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public JobIntent getJobIntent() {
		return jobIntent;
	}
	public void setJobIntent(JobIntent jobIntent) {
		this.jobIntent = jobIntent;
	}

	
}
