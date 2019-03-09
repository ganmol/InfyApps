package com.infy.test;

import java.util.LinkedList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.infy.business.service.InfyAppsService;
import com.infy.resources.Factory;

public class InfyAppsServiceTest {

	
	
	@Rule
	public ExpectedException ee=ExpectedException.none();
	@Test
	public void installAppsInvalidAppNamesTest() throws Exception {
		ee.expect(Exception.class);
		ee.expectMessage("Validator.INVALID_APPNAME");
		InfyAppsService i=Factory.createInfyAppsService();
		List<String> l=new LinkedList<String>();
		l.add("MyNewApp");
		l.add("WorxMail");
		i.installApps(232328989898898L, l);
	}
	
	@Test
	public void installAppsInvalidIMEINumberTest() throws Exception {
		ee.expect(Exception.class);
		ee.expectMessage("Validator.INVALID_APPNAME");
		InfyAppsService i=Factory.createInfyAppsService();
		List<String> l=new LinkedList<String>();
		l.add("MyNinja");
		l.add("WorxMail");
		i.installApps(123328989898898L, l);
	}
	

	@Test
	public void installAppsNoAppsToInstallTest() throws Exception {
		ee.expect(Exception.class);
		ee.expectMessage("Validator.INVALID_APPNAME");
		InfyAppsService i=Factory.createInfyAppsService();
		List<String> l=new LinkedList<String>();
		l.add("WorxMail");
		i.installApps(232328989898898L, l);
	}

}
