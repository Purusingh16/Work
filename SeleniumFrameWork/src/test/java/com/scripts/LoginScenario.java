package com.scripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.action.LoginAction;
import com.applicationPages.HomePage;
import com.applicationPages.LoginPage;
import com.utilities.SeleniumUtils;

public class LoginScenario
{
	private WebDriver driver=null;
	private SeleniumUtils SeleniumUtils=null;
	@BeforeMethod
	public void setUP()
	{
		SeleniumUtils=new SeleniumUtils();
		driver=SeleniumUtils.openBrowser("firefox", "http://zero.webappsecurity.com/index.html");
	}
  @Test
  public void verifySuccessfulLogin() 
  {
	  HomePage homePage=new HomePage(driver);
	  homePage.clickOnSignIn();
	  
	  LoginAction loginAction=new LoginAction();
	  loginAction.login(driver, "username", "password");
	  
	  /*LoginPage loginPage=new LoginPage(driver);
	  Assert.assertTrue(loginPage.isLoginPage());
	  loginPage.typeUser_Name("username");
	  
	  loginPage.typeUser_Password("password1");
	  loginPage.clickSubmit();
	  Assert.fail();*/
	  
  }
  @Test(enabled=false)
  public void invalidlogin()
  {
	  HomePage homePage=new HomePage(driver);
	  homePage.clickOnSignIn();
	  LoginAction loginAction=new LoginAction();
	  LoginPage loginPage=new LoginPage(driver);
	  loginAction.login(driver, "username", "password");
  }
  @AfterMethod
  public void tearDown()
  {
	  SeleniumUtils.closeBrowser();
  }
}
