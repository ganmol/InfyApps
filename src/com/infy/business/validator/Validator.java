package com.infy.business.validator;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Validator {
	//do not tamper with the given method signature
	public void validateAppNames(List<String> appNames) throws Exception {
		try{
			for(String a: appNames){
				if((a.equals("Yammer")||a.equals("MyNinja")||a.equals("MyTraining")||a.equals("WorxMail"))==false){
					throw new Exception("Validator.INVALID_APPNAME");
				}
				
			}
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
