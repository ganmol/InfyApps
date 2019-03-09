package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name="app")
public class AppEntity {
	@Id
	private String appName;
	private Integer spaceRequiredInMB;
	private Character appSuitableFor;
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public Integer getSpaceRequiredInMB() {
		return spaceRequiredInMB;
	}
	public void setSpaceRequiredInMB(Integer spaceRequiredInMB) {
		spaceRequiredInMB = spaceRequiredInMB;
	}
	public Character getAppSuitableFor() {
		return appSuitableFor;
	}
	public void setAppSuitableFor(Character appSuitableFor) {
		this.appSuitableFor = appSuitableFor;
	}
	
}
