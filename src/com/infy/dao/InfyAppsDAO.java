package com.infy.dao;

import java.util.List;

import com.infy.bean.MobileData;

public interface InfyAppsDAO {
	public MobileData getEligibleAppsAndInstalledApps(Long IMEINumber) throws Exception;
	public Integer installApps(Long IMEINumber, List<String> appNames) throws Exception;
	public String getLargestApp() throws Exception;
	public List<MobileData> getDetailsOfMobiles(String appName) throws Exception;
	
}
