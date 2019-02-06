/**
 * 
 */
package com.learn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author anbu
 *
 *This class will all the locator and methods of login page 
 *
 */
public class Login_page_Factory {

	
	WebDriver driver;
		
	public Login_page_Factory(WebDriver ldriver) 
	{
		this.driver = ldriver;
		
	}
	
	@FindBy(linkText="Sign In") WebElement SignIn;
	
	@FindBy(xpath="//input[@id='username']") WebElement username;
	
	@FindBy(xpath="//input[@placeholder='Password']") WebElement password;
	
	@FindBy(xpath="//input[@value='Sign in']") WebElement loginBtn;
	
//	By username = By.xpath("//*[@id=\"login\"]");
//	By password = By.xpath("//*[@id=\"password\"]");
//	By loginBtn	= By.xpath("/html/body/div/div/form/div[3]/button");
	
	public void loginToCristo(String uid,String pass)
	{
		try 
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		SignIn.click();
		username.sendKeys(uid);
		password.sendKeys(pass);
		loginBtn.click();

		
		
	}
	

}
