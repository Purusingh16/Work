package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import drivers.Driver;
import pages.FrontPage;
import pages.HomePage;
import pages.LoginPage;

public class TestLoginPage {
	WebDriver driver=null;
  @Test
  public void verifyLogin() {
	
	FrontPage frontPage=new FrontPage(driver);
	LoginPage loginPage=frontPage.clickOnSignIn();
	loginPage.typeEmail("test123@test.com");
	loginPage.typePassword("test123");
	HomePage homePage=loginPage.clickOnSubmit();
	Assert.assertEquals(homePage.getHomePageTitle(), "MY ACCOUNT");
	
  }
  
  @BeforeMethod
  public void setUp() {
	 
	   driver = Driver.openBrowser("chrome");
	   driver.get("http://automationpractice.com");
	   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   driver.manage().window().maximize();
  }
  
  @AfterMethod
  public void tearDown() {
	  driver.quit();
  }
}
