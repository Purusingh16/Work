package com.applicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage 
{
	private String SIGN_IN_ID="signin_button";
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickOnSignIn()
	{
		driver.findElement(By.id(SIGN_IN_ID)).click();
	}
}
