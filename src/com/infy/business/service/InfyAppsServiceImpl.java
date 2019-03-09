package com.infy.business.service;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.infy.bean.MobileData;
import com.infy.business.validator.Validator;
import com.infy.dao.InfyAppsDAO;
import com.infy.resources.Factory;

public class InfyAppsServiceImpl implements InfyAppsService {

	//do not tamper with the given method signature
	@Override
	public Integer installApps(Long IMEINumber, List<String> appsToBeInstalled) throws Exception {
		// your code goes here
		try{
			Validator v=new Validator();
			v.validateAppNames(appsToBeInstalled);
			InfyAppsDAO i=Factory.createInfyAppsDAO();
			MobileData bean=i.getEligibleAppsAndInstalledApps(IMEINumber);
			if(bean==null){
				throw new Exception("Service.INVALID_IMEI_NUMBER");
			}
			List<String> filteredAppList=new LinkedList<String>();
			for(String s:appsToBeInstalled){
				if((bean.getInstalledApps().contains(s)==false)&&(bean.getEligibleApps().contains(s))){
					filteredAppList.add(s);
				}
			}
			if(filteredAppList.size()==0){
				throw new Exception("Service.NO_APPS_TO_INSTALL");
			}
			return i.installApps(IMEINumber, filteredAppList);
		}
		catch(Exception e)
		{
		DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
		Logger logger = Logger.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
		throw e;
		}
	}

	//do not tamper with the given method signature
	@Override
	public List<MobileData> getMobilesWithLargestApp() throws Exception {
		// your code goes here
		try{
			
			InfyAppsDAO i=Factory.createInfyAppsDAO();
			String app=i.getLargestApp();
			List<MobileData> l=i.getDetailsOfMobiles(app);
			return l;
		}
		catch(Exception e)
		{
		DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
		Logger logger = Logger.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
		throw e;
		}
	}
	
	
}
