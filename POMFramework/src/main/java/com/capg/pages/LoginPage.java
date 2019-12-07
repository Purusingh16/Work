package com.capg.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capg.base.TestBase;

public class LoginPage extends TestBase{
	@FindBy(xpath="//*[@id='mountRoot']/div/div/div/form/fieldset[1]/div[1]/input")
	WebElement username;
	@FindBy(xpath="//*[@id='mountRoot']/div/div/div/form/fieldset[1]/div[2]/input")
	WebElement password;
	@FindBy(xpath="//*[@id='mountRoot']/div/div/div/form/fieldset[2]/button")
	WebElement submit;
	
	public LoginPage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public String checkLogin(String user,String pass)
	{
		username.sendKeys(user);
		password.sendKeys(pass);
		submit.click();
		return driver.getTitle();
	}
	

}
