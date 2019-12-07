package com.applicationPages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	private String LOGIN_ID="user_login";
	private String PASSWORD_ID="user_password";
	private String SIGN_IN_XPATH="//input[@name='submit']";
	
	private String PAGE_TITLE_XPATH="//h3[text()='Log in to ZeroBank']";
	
	
	private WebDriver driver;
	Logger logger=null;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		logger=LogManager.getLogger(this.getClass().getName());
	}
	
	public void typeUser_Name(String username)
	{
		
		driver.findElement(By.id(LOGIN_ID)).sendKeys(username);
		logger.error("username invalid:"+LOGIN_ID);
	}
	public void typeUser_Password(String password)
	{
		driver.findElement(By.id(PASSWORD_ID)).sendKeys(password);
	}
	public void clickSubmit()
	{
		driver.findElement(By.xpath(SIGN_IN_XPATH)).click();
	}
	public boolean isLoginPage()
	{
		return driver.findElement(By.xpath(PAGE_TITLE_XPATH)).isDisplayed();
	}
	

}
