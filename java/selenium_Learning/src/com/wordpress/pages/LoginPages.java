package com.wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author purusingh
 *
 *
 *This class will store all the locator and methods of login pages
 *
 */
public class LoginPages
{
	WebDriver driver;
	
	By username=By.id("user_login");
	By password=By.xpath("//input[@id='user_pass']");
	By loginbutton=By.name("wp-submit");
	
	public LoginPages(WebDriver driver)
	{
		this.driver=driver;
	}
	public void LoginToWordPress(String userid,String pwd)
	{
		driver.findElement(username).sendKeys(userid);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginbutton).click();
	}
	
	public void typeUserName(String uid)
	{
//		driver.findElement(username).sendKeys("admin");
		driver.findElement(username).sendKeys(uid);
		
	}
	public void typePassWord(String pass)
	{
//		driver.findElement(password).sendKeys("demo123");
		driver.findElement(password).sendKeys(pass);
	}
	public void clickOnloginbutton()
	{
		driver.findElement(loginbutton).click();
	}
			

	

}
