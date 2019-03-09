package com.infy.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


@Entity
@Table(name="mobile")
public class MobileEntity {
	@Id
	private Long IMEINumber;
	private String mobileOS;
	private Character mobileUserType;
	private Integer appsCount;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="MobileApp",
	joinColumns=@JoinColumn(name="IMEINumber", referencedColumnName="IMEINumber"),
	inverseJoinColumns=@JoinColumn(name="appName", referencedColumnName="appName"))
	private List<AppEntity> apps;
	public Long getIMEINumber() {
		return IMEINumber;
	}
	public void setIMEINumber(Long iMEINumber) {
		IMEINumber = iMEINumber;
	}
	public String getMobileOS() {
		return mobileOS;
	}
	public void setMobileOS(String mobileOS) {
		this.mobileOS = mobileOS;
	}
	public Character getMobileUserType() {
		return mobileUserType;
	}
	public void setMobileUserType(Character mobileUserType) {
		this.mobileUserType = mobileUserType;
	}
	public Integer getAppsCount() {
		return appsCount;
	}
	public void setAppsCount(Integer appsCount) {
		this.appsCount = appsCount;
	}
	public List<AppEntity> getApps() {
		return apps;
	}
	public void setApps(List<AppEntity> apps) {
		this.apps = apps;
	}
}
