package com.learn.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learn.utility.BrowserFactory;
import com.learn.utility.ConfigDataProvider;
import com.learn.utility.Excel_Data_Provider;
import com.learn.utility.Helper;

public class Baseclasses {
	
	public WebDriver driver;	
	public Excel_Data_Provider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger; 
	
	@BeforeSuite
	public void setUpSuite() 
	{	
		Reporter.log("Seting up reports and The Test getting ready", true);
		
		excel = new Excel_Data_Provider();
		config = new ConfigDataProvider();
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter
				(new File(System.getProperty("user.dir")+"/Reports/OrangeHRm_"+Helper.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting Done >>> The Test can be started", true);

	}
	
//	@Parameters({"browser" , "urlTobeTested"})
	@BeforeClass
	public void setup(String browser , String url) 
	{
		Reporter.log("Trying to start Browser and Getting application ready", true);

//		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());

		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());
		
		Reporter.log("Browser and Application is up and running", true);
		
	}
	
	@AfterClass
	public void teardown() 
	{
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException 
	{
		Reporter.log("Test is about to End", true);

		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());

		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.skip("Test Skiped", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());

		}
		
		report.flush();
		
		Reporter.log("Test Completed >>>>> Reports Generated", true);

		 
	}

}
