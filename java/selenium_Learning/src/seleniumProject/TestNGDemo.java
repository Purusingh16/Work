package seleniumProject;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TestNGDemo 
{
	public WebDriver driver=null;
  @Test(enabled=false)
  public void verifySigin()
  {
	  WebElement element=driver.findElement(By.xpath("//a[contains(text(),'Signin')]"));
	  Assert.assertEquals(element.isDisplayed(),true,"Signin link should be present on the page");
  }
  

@Test(priority=1)
public void verifyUsernameField() throws Exception
{
	Thread.sleep(5000);
	  WebElement element=driver.findElement(By.xpath("//a[contains(text(),'Signin')]"));
	  element.click();
	  Assert.assertEquals(element.isEnabled(),true,"Username should be enabled");
  }

  @BeforeMethod
  public void beforeMethod()
  {
	  driver=new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get("http://www.way2automation.com/demo.html");
			 String parentWindow=driver.getWindowHandle();
			  
			  WebElement element=driver.findElement(By.linkText("Alert"));
			  element.click();
			  
			  Set<String> windows=driver.getWindowHandles();
			  for(String window : windows)
			  {
				  if(window.equalsIgnoreCase(parentWindow))
				  {
					  continue;
				  }
				  driver.switchTo().window(window);
			  }
			  
	
	}

		  @AfterMethod
		  public void afterMethod()
		  {
			  driver.quit();
			  
		  }
	  		
  }


