package selenium_Scripts;

import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

public class ScrollPage 
{
	public WebDriver driver=null;
  @Test
  public void f() throws Exception 
  {
	  Thread.sleep(5000);
	  ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  driver=new FirefoxDriver();
	  driver.get("http://automationpractice.com");
	  driver.manage().window().maximize();
	  
  }

}
