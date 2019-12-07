package testScripts;

import org.testng.annotations.Test;

import browser.Driver;
import pages.SpiceJetPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestSpiceJet
{
	 WebDriver driver=null;
  @Test
  public void verifyFrontSpiceJetPage() throws Exception
  {
	  SpiceJetPage spiceJetPage=new SpiceJetPage(driver);
	  spiceJetPage.infoCommand("flighttitle");
	  spiceJetPage.clickOnButton("button");
	  spiceJetPage.clickOnDropDown("dropdown");
	  spiceJetPage.chooseCity("Pune (PNQ)");
	  Thread.sleep(3000);
	  spiceJetPage.clickOnDropDown1("dropdown1");
	  Thread.sleep(3000);
	  spiceJetPage.chooseCity1("Delhi (DEL)");
	  Thread.sleep(3000);
	  spiceJetPage.typeDate("20");
	  spiceJetPage.selectAdult("2 Adults");
	  spiceJetPage.selectChildren("1 Child");
	  spiceJetPage.selectInfant("2 Infants");
	  spiceJetPage.clickOnFindFlight("findflight");
	  
  }
  @Parameters("browserName")
  @BeforeTest
  public void beforeTest() 
  {
	  driver=Driver.openBrowser("firefox");
	  driver.get("http://spicejet.com");
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
  }
  

}
