package testNG5;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class WordPressLogin
{
	public WebDriver driver=null;
	
  @Test(dataProvider="wordpressData")
  public void loginToWordPress(String username,String password)
  {
	  driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys(username);
	  driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys(password);
	  driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
	  
//	  System.out.println(driver.getTitle());
	  Assert.assertTrue(driver.getTitle().contains("Dashboard"),"User is not able to login-Invalid Credentials");
	  System.out.println("Page Title Verified User is able to login Successfully");
	  
//	  driver.quit();
  } 
  @DataProvider(name="wordpressData")
  public Object[][] passData()
  {
	  Object[][] data=new Object[3][2];
	  
	  data[0][0]="admin1";
	  data[0][1]="demo1";
	  
	  data[1][0]="admin";
	  data[1][1]="demo123";
	  
	  data[2][0]="admin2";
	  data[2][1]="demo1234";
	  
	  return data;

  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  driver=new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.get("http://demosite.center/wordpress/wp-login.php");
	  
  }
  @AfterMethod
  public void tearDown()
  {
	  driver.quit();
  }
  
}
