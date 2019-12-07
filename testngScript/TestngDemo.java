package testngScript;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

@Test
public class TestngDemo {
	
	public WebDriver driver=null;
	
  @Test(enabled=true, priority=2)
  public void verifySignin() {
	 WebElement element=driver.findElement(By.xpath("//a[contains(text(),'Signin')]"));
	 Assert.assertEquals(element.isDisplayed(), true,"Signin link should be present on the page");
	 
	 
		/*element.click();
		element=driver.findElement(By.xpath("//form[@class='ajaxlogin']//input[@name='username']"));
		element.sendKeys("test123");
		
		element=driver.findElement(By.xpath("//form[@class='ajaxlogin']//input[@name='password']"));
		element.sendKeys("test");
		
		element=driver.findElement(By.xpath("//form[@class='ajaxlogin']//input[@type='submit']"));
		element.click();
		element=driver.findElement(By.linkText("Registration"));
		Assert.assertEquals(element.isDisplayed(), true);*/
	  
  }
  
@Test(priority=1)
  public void verifyUsernameField() {
	    WebElement element=driver.findElement(By.xpath("//a[contains(text(),'Signin')]"));
			element.click();
				element=driver.findElement(By.xpath("//form[@class='ajaxlogin']//input[@name='username']"));
				 Assert.assertEquals(element.isEnabled(), false,"Username should be enabled");
	
  }
@Parameters("browserName")
  @BeforeMethod
  public void beforeMethod(String browserName) {
	if(browserName.equalsIgnoreCase("firefox"))
	    driver=new FirefoxDriver();	
	else 
		System.out.println("different browser");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.way2automation.com/demo.html");
String parentWindow=driver.getWindowHandle();
		
		WebElement element=driver.findElement(By.linkText("Alert"));
		element.click();

		Set<String> windows=driver.getWindowHandles();
		
		for (String window : windows) {
			if(window.equalsIgnoreCase(parentWindow))
			{	continue;
			
			}
			driver.switchTo().window(window);
		}
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

  /*@BeforeClass
  public void beforeClass() {
	  System.out.println("beforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("afterClass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("beforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("afterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("beforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("afterSuite");
  }*/

}
