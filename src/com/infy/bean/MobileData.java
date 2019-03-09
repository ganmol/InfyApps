package com.infy.bean;

import java.util.List;

public class MobileData {
	private Long IMEINumber;
	private String mobileOS;
	private Character mobileUserType;
	private Integer appsCount;
	private List<String> eligibleApps;
	private List<String> installedApps;
	
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
	public List<String> getEligibleApps() {
		return eligibleApps;
	}
	public void setEligibleApps(List<String> eligibleApps) {
		this.eligibleApps = eligibleApps;
	}
	public List<String> getInstalledApps() {
		return installedApps;
	}
	public void setInstalledApps(List<String> installedApps) {
		this.installedApps = installedApps;
	}
	
	}
