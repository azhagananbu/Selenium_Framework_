package com.learn.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BrowserFactory 
{
	
	public static WebDriver startApplication(WebDriver driver, String browserName,String appURL)
	{
		if(browserName.equals("Chrome"))
		{
			io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();;
			driver = new ChromeDriver();
			
//			System.setProperty("webdriver.gecko.driver","/opt/Anbu/Azhagan/WorkSpace/Selenium_Drivers/NEW/chromedriver");
//			driver = new ChromeDriver();
		}
		else if(browserName.equals("Firefox"))
		{ 
			io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();;
			driver = new FirefoxDriver();
			
//			System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver");
//			driver = new FirefoxDriver();
		}
		else if(browserName.equals("Opera"))
		{
			io.github.bonigarcia.wdm.WebDriverManager.operadriver().setup();;
			driver = new OperaDriver();
			
//			System.setProperty("webdriver.opera.driver","./Drivers/operadriver");
//			driver = new OperaDriver();
		}
		else 
		{
			System.out.println("Srooy we do not support this browser");
		}
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		return driver;
	}
	
	 public static void quitBrowser(WebDriver driver)
	 {
		 driver.quit();
	 }

}
