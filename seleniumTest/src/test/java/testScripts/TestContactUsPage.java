package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import browser.Driver;
import pages.ContactUsPage;
import pages.FrontPage;

public class TestContactUsPage
{
	WebDriver driver=null;
  @Test
  public void verifyContactUs() throws Exception
  {
	  FrontPage frontPage=new FrontPage(driver);
	  ContactUsPage contactUsPage=new ContactUsPage(driver);
	  ContactUsPage contactUsPage1=frontPage.clickOnContactUs();
	  
	  Assert.assertEquals(contactUsPage.isPageDisplayed(),true);
	  contactUsPage.selectSubjectHeading("Customer service");
	  
	  contactUsPage.typeEmail("purusingh16@test.com");
	  contactUsPage.typeOrderId("order12");
	  contactUsPage.typeMessage("learning maven framework");
	  contactUsPage.uploadFile();
	  Thread.sleep(3000);
	  contactUsPage.clickOnSend();
  }
	  @Parameters("browserName")
	  @BeforeMethod
	  public void setUp() 
	  {
	  	 
	  	   driver = Driver.openBrowser("firefox");

	  	   driver.get("http://automationpractice.com");
	  	  
	  	   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	  	   driver.manage().window().maximize();
	   
	   }
	 /* @AfterMethod
	  public void tearDown()
	 {
		
	  driver.quit();
	  
	 }*/
	  
  	

}



	


