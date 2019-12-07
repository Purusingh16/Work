package testScripts;

import org.testng.annotations.Test;

import pages.AddressPage;
import pages.BasketPage;
import pages.FrontMenuBarPage;
import pages.LoginPage;
import pages.ShippingPage;
import pages.SummaryPage;
import pages.TshirtPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestTshirtPage 
{
	public WebDriver driver=null;
  @Test
  public void verifyTshirtPage() throws Exception
  {
	  FrontMenuBarPage frontMenuBarPage=new FrontMenuBarPage(driver);
	  TshirtPage tshirtPage=new TshirtPage(driver);
	  BasketPage basketPage=new BasketPage(driver);
	  SummaryPage summaryPage=new SummaryPage(driver);
	  LoginPage loginPage=new LoginPage(driver);
	  AddressPage addressPage=new AddressPage(driver);
	  ShippingPage shippingPage=new ShippingPage(driver);
	  frontMenuBarPage.ClickOnTshirt();
	  tshirtPage.hover_on_Image();
	  tshirtPage.Click_on_AddtoCart();
	  basketPage.ClickOnCheckout();
	  Thread.sleep(3000);
	 summaryPage.ClickOnCheckout();
	 loginPage.typeEmail("purusingh16@test.com");
	 loginPage.typePassword("test16");
	 loginPage.clickOnSubmit();
	 addressPage.ClickOnCheckOut();
	 shippingPage.verifyCheckBox();
	 shippingPage.ClickOnShippingCheckOut();
	 
  }
  @Parameters("browserName")
  @BeforeTest
  public void beforeTest() 
  {
	  driver=new FirefoxDriver();
		driver.get("http://automationpractice.com");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
  }
  @AfterMethod
  public void tearDown()
  {
  	driver.quit();
  }

}
