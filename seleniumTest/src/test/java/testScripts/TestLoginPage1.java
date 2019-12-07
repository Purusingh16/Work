package testScripts;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browser.Driver;
import pages.FrontPage;
import pages.FrontPage1;
import pages.HomePage;

import pages.LoginPage;
import pages.LoginPage1;


public class TestLoginPage1 
{
	
	WebDriver driver=null;
 
 @Test
 public void verifyLogin() 
 {
	FrontPage1 frontPage=new FrontPage1(driver);
	LoginPage1 loginPage=frontPage.clickOnSignIn();
	Assert.assertTrue(loginPage.isPageDisplayed(),"Login page should be displayed");
 }
 @Parameters({"email","password","homePageTitle"})
 @Test
 public void verifySuccessfulLogin(String email,String password,String homePageTitle)
 {
	 FrontPage1 frontPage=new FrontPage1(driver);
	 LoginPage1 loginPage=frontPage.clickOnSignIn();
	 
	 loginPage.typeEmail(email);
	 loginPage.typePassword(password);
	 HomePage homePage=loginPage.clickOnSubmit();
	 Assert.assertEquals(homePage.getHomePageTitle(), homePageTitle);
 }
  
 @Parameters("browserName")
 @BeforeMethod
 public void setUp(String browserName) 
 {
	 driver = Driver.openBrowser(browserName);
	 driver.get("http://automationpractice.com");
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 driver.manage().window().maximize();
}
@AfterMethod
public void tearDown()
{
	driver.quit();
}

}
