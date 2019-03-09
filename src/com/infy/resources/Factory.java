package com.infy.resources;

import com.infy.business.service.InfyAppsServiceImpl;
import com.infy.dao.InfyAppsDAOImpl;



public class Factory {
	public static InfyAppsServiceImpl createInfyAppsService() {
		return new InfyAppsServiceImpl();
	}
	
	public static InfyAppsDAOImpl createInfyAppsDAO() {
		return new InfyAppsDAOImpl();
	}
}
