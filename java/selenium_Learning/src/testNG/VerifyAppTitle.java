package testNG;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class VerifyAppTitle 
{
	public WebDriver driver=null;
	
  @Test
  public void f() 
  {
	  //actual title
	  String my_title=driver.getPageSource();
	  System.out.println("actual title is "+ my_title);
	  
//	  String expected_title="My Store";
	  
//	  Assert.assertEquals(my_title, expected_title);
	  Assert.assertTrue(my_title.contains("My Store"));
	  System.out.println("test is completed,page verified");
  }
  
  
  
  @BeforeMethod
  public void beforeMethod()
  {
	  driver=new FirefoxDriver();
	  driver.get("http://automationpractice.com");
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }

}
