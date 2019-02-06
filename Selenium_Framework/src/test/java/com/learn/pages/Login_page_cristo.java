/**
 * 
 */
package com.learn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author anbu
 *
 *This class will all the locator and methods of login page 
 *
 */
public class Login_page_cristo {

	
		WebDriver driver;
		
		By username = By.xpath("//*[@id=\"login\"]");
		By password = By.xpath("//*[@id=\"password\"]");
		By loginBtn	= By.xpath("/html/body/div/div/form/div[3]/button");

	
	public Login_page_cristo(WebDriver driver) 
	{
		this.driver = driver;
		
	}
	
	public void loginToCristo(String uid,String pass)
	{
		driver.findElement(username).sendKeys(uid);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginBtn).click();

		
		
	}
	
	public void typeusername(String userid)
	{
		driver.findElement(username).sendKeys(userid);
		
	}
	
	public void typepassword(String pass)
	{
		driver.findElement(password).sendKeys(pass);
		
	}
	
	public void clickonloginbutton()
	{
		driver.findElement(loginBtn).click();
		
	}
	
	

}
