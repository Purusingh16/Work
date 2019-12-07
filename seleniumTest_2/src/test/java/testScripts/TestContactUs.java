package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import drivers.Driver;
import pages.ContactUsPage;
import pages.FrontPage;
import pages.HomePage;
import pages.LoginPage;

public class TestContactUs extends TestBase {
	WebDriver driver=null;
	@Test
	@Parameters("uploadFile")
	  public void verifyContactUs(String uploadFile) {
		
		FrontPage frontPage=new FrontPage(driver);
		ContactUsPage  contactUsPage=frontPage.clickOnContactUs();
		Assert.assertEquals(contactUsPage.getpageTitle().trim(), "CUSTOMER SERVICE - CONTACT US");
		
		contactUsPage.typeEmail(userName);
		contactUsPage.typeMessage("Hello file is uploaded!");
		contactUsPage.typeOrderId("12");
		contactUsPage.uploadFile(uploadFile);
	  }
	
	 @Parameters("browserName")
	  @BeforeMethod
	  public void setUp(String browserName) 
	 {
		  loadProperties();
		   driver = Driver.openBrowser(browserName,url);	  
	  }
	  
	  @AfterMethod
	  public void tearDown() {
		  try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		  driver.quit();
	  }
}
