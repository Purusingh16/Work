package seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGClass 
{
	/*@BeforeMethod
	public void setUp()
	{
		System.out.println("Launch Browser");
	}*/
  @Test
  public void TC_1() 
  {
	  System.out.println("This is first test cases");
	  
	 /* WebDriver driver=new FirefoxDriver();
	  driver.get("http://www.google.co.in");
	  driver.findElement(By.name("q")).sendKeys("Selenium");*/
  }
  @Test(enabled=true)
  public void TC_2()
  {
	  System.out.println("This is second test cases");
  }
  @Test
  public void TC_3()
  {
	  System.out.println("This is third test caes");
  }
 /* @AfterMethod
  public void closeBrowser()
  {
	  System.out.println("kill the browser");
  }
  @BeforeClass
  public void start()
  {
	  System.out.println("Test execution is start ***");
  }
  @AfterClass
  public void end()
  {
	  System.out.println("Test Execution is end ****");
  }*/
  
  
}
