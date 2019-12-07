package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import automationFrameWork.AmericanDiscountcruises;

public class Verify_Cruise_Test {
  @Test
  public void Verify_FunctionalityTest() 
  {
	 System.setProperty("webdriver.gecko.driver", "F:\\Work\\learningSelenium\\gekodriver\\geckodriver.exe");
	 WebDriver driver=new FirefoxDriver();
	 driver.get("https://deals.americandiscountcruises.com/web/cruises/search.aspx");
	 driver.manage().window().maximize();
	 
	 AmericanDiscountcruises americanDiscountcruises=new AmericanDiscountcruises(driver);
	 americanDiscountcruises.Click_on_StartDate();
	 
	 
  }
}
