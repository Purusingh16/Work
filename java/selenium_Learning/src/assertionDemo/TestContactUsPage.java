package assertionDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class TestContactUsPage
{
	WebDriver driver;
  @Test
  public void clickOnContactusPage() 
  {
	  driver.findElement(By.linkText("Contact us")).click();
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  	driver=new FirefoxDriver();
		driver.get("http://automationpractice.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
  }
  @AfterMethod
  public void afterMethod() 
  {
	  driver.quit();
  }

}
