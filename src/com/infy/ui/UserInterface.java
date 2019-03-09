package com.infy.ui;

import java.util.ArrayList;
import java.util.List;

import com.infy.bean.MobileData;
import com.infy.business.service.InfyAppsService;
import com.infy.resources.AppConfig;
import com.infy.resources.Factory;
import com.infy.resources.HibernateUtility;

public class UserInterface {
	
	public static void main(String[] args) {
		try {
			//installApps();
			getMobilesWithLargestApp();
		} finally {
			HibernateUtility.closeSessionFactory();
		}
	}

	
	public static void installApps() {
		
		try {
			
			
			List<String> appsToBeInstalled = new ArrayList<String>();
			appsToBeInstalled.add("Yammer");
			appsToBeInstalled.add("WorxMail");
			appsToBeInstalled.add("MyNinja");

			InfyAppsService service = Factory.createInfyAppsService();
			Integer appsInstalled = service.installApps(243456778787864L,
					appsToBeInstalled);
			System.out.println(AppConfig.PROPERTIES
					.getProperty("UserInterface.TOTAL_APPS_INSTALLED")
					+ appsInstalled);
		} catch (Exception e) {
			
			String message = AppConfig.PROPERTIES.getProperty(e.getMessage());
			if (message == null) {
				message = AppConfig.PROPERTIES.getProperty("General.EXCEPTION");
			}
			System.out.println("ERROR:" + message);
		}

	}
	
public static void getMobilesWithLargestApp() {
		
		try {
			InfyAppsService service = Factory.createInfyAppsService();
			List<MobileData> result = service.getMobilesWithLargestApp();
			
			System.out.println("Mobile Details are:");
			System.out.printf("%-20s%-20s%-20s%-13s%n","IMEINumber", "MobileOS","MobileUserType","AppsInstalled");
			System.out.printf("%-20s%-20s%-20s%-13s%n","==============", "================","==============","================");

			for (MobileData mobileData : result) {
				System.out.printf("%-20s%-20s%-20s%-13s%n",mobileData.getIMEINumber(), mobileData.getMobileOS(),mobileData.getMobileUserType(),mobileData.getAppsCount());
				
			}
			
		} catch (Exception e) {
		
			String message = AppConfig.PROPERTIES.getProperty(e.getMessage());
			if (message == null) {
				message = AppConfig.PROPERTIES.getProperty("General.EXCEPTION");
			}
			System.out.println("ERROR:" + message);
		}
	}

}
