/**
 * 
 */
package com.learn.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Cristo_Login_POM.Login_page;

/**
 * @author anbu
 *
 *
 */
public class VerifyCristoLogin {
	
	@Test
	public void verifyValidLogin()
	{
		io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();;
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://cristo.avosa.org:9898/web/login");
		
		Login_page login = new Login_page(driver);
		
		login.typeusername("");
		
		login.typepassword("");
		
		login.clickonloginbutton();
		
		driver.quit();
	}
}
