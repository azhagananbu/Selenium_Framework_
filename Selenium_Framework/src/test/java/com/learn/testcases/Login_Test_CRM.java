package com.learn.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.learn.pages.Baseclasses;
import com.learn.pages.Login_page_Factory;

public class Login_Test_CRM extends Baseclasses{
	
	@Test(priority = 1)
	public void LoginApp() 
	{
		
		logger = report.createTest("Login to Cristo");
		
		Login_page_Factory Login_page_Factory = PageFactory.initElements(driver, Login_page_Factory.class);
		
		logger.info("Starting Application");
		
		Login_page_Factory.loginToCristo(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		logger.pass("Login Success");
		
//		Helper.captureScreenshot(driver);
		
	
	}
	
	
	
	
}
 