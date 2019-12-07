package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import drivers.Driver;
import pages.FrontPage;
import pages.HomePage;
import pages.LoginPage;
import utils.PropertyFileReader;

public class TestLoginPage extends TestBase
{
	WebDriver driver=null;
  @Test
  public void verifyLogin() 
  {
	
	FrontPage frontPage=new FrontPage(driver);
	LoginPage loginPage=frontPage.clickOnSignIn();
	loginPage.typeEmail(userName+"1");
	loginPage.typePassword(passWord);
	HomePage homePage=loginPage.clickOnSubmit();
	Assert.assertEquals(homePage.getHomePageTitle(), "MY ACCOUNT");	
  }
  
  
  @Parameters("browserName")
  @BeforeMethod
  public void setUp(String browserName) 
  {
	  driver = Driver.openBrowser(browserName,url);	  
  }
  
  @AfterMethod
  public void tearDown() 
  {
	  driver.quit();
  }
}
