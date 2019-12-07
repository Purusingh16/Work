package assertionDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestLoginScenario
{
	private WebDriver driver;
  @Test(priority=1)
  public void clickOnSignin() 
  {
	  driver.findElement(By.partialLinkText("Sign in")).click();
	 
	  driver.findElement(By.id("email")).sendKeys("purusingh16@test.com");
	  driver.findElement(By.id("passwd")).sendKeys("test16");
	  driver.findElement(By.id("SubmitLogin")).click();
	  
	  boolean isSuccessfullogin=driver.findElement(By.xpath(".//*[@id='center_column']/h1")).isDisplayed();
	  Assert.assertTrue(isSuccessfullogin);
	  driver.close();
  }
  
  @Test(priority=2)
  public void invalidLogin() 
  {
	  driver.findElement(By.partialLinkText("Sign in")).click();
	 
	  driver.findElement(By.id("email")).sendKeys("purusingh16@test.com");
	  driver.findElement(By.id("passwd")).sendKeys("test16");
	  driver.findElement(By.id("SubmitLogin")).click();
	  WebElement webElement=driver.findElement(By.xpath("//div[@class='alert alert-danger']/p"));
	  String str=webElement.getText();
	  System.out.println(str);
	  Assert.assertEquals("There is 1 error", str);
  }
	  
  @BeforeTest
  public void beforeTest() 
  {
	  driver=new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.get("http://automationpractice.com/index.php");
	  Assert.assertEquals("My Store", driver.getTitle(), "title not matching");
	  driver.manage().window().maximize();
	  
  }
  @AfterTest
  public void afterTest()
  {
	  driver.quit();
  }

}
