package com.action;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.applicationPages.LoginPage;

public class LoginAction 
{
	public void login(WebDriver driver,String username,String password)
	{
		LoginPage loginPage=new LoginPage(driver);
		Assert.assertTrue(loginPage.isLoginPage());
		  loginPage.typeUser_Name("username");
		  
		  loginPage.typeUser_Password("password");
		  loginPage.clickSubmit();
	}

}
