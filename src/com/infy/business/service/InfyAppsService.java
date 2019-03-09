package com.infy.business.service;

import java.util.List;

import com.infy.bean.MobileData;

public interface InfyAppsService {
	public Integer installApps(Long IMEINumber, List<String> appsToBeInstalled) throws Exception;
	public List<MobileData> getMobilesWithLargestApp() throws Exception;
}
