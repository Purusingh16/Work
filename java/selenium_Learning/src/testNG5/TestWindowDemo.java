package testNG5;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.sql.Driver;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class TestWindowDemo 
{
	WebDriver driver=null;
	
  @Test
  public void element() throws Exception 
  {
	  String parentWindow=driver.getWindowHandle();
	  
	  WebElement element=driver.findElement(By.linkText("Alert"));
	  element.click();
	  Set<String> windows=driver.getWindowHandles();
	  
	  for (String window : windows)
	  {
		  if(window.equalsIgnoreCase(parentWindow))
		  {
			  continue;
		  }
		  driver.switchTo().window(window);
	  }
	  driver.findElement(By.xpath("//a[contains(text(),'Signin')]")).click();
	  
	  driver.findElement(By.xpath("//form[@class='ajaxlogin']/fieldset/input[@name='username']")).sendKeys("test123");
	  driver.findElement(By.xpath("//form[@class='ajaxlogin']/fieldset/input[@name='password']")).sendKeys("test123");
	  driver.findElement(By.xpath("//form[@class='ajaxlogin']//input[@type='submit']")).click();
	  Thread.sleep(3000);
	  
	  driver.findElement(By.linkText("Alert")).click();
	  
	  element=driver.findElement(By.xpath("//div[@id='example-1-tab-1']//iframe[@class='demo-frame']"));
		
		driver.switchTo().frame(element);
				
		element=driver.findElement(By.xpath("//button[contains(text(),'Click the button to display an alert box:')]"));
		element.click();
		
		Thread.sleep(5000);
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		
		
		alert.accept();
		driver.switchTo().defaultContent();
		
		Thread.sleep(5000);
		Actions actions=new Actions(driver);
		WebElement mainMenu=driver.findElement(By.linkText("Interaction"));
		 actions.moveToElement(mainMenu).build().perform();
		
		WebElement subMenu=driver.findElement(By.linkText("Droppable"));
		actions.moveToElement(subMenu);
		actions.click().build().perform();
		Thread.sleep(5000);
	  
	  
  }
  @BeforeMethod
  public void beforeMethod()
  {
	  driver=new FirefoxDriver();
	  driver.get("http://www.way2automation.com/demo.html");
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }

 /* @AfterMethod
  public void teardown()
  {
	  driver.quit();
	  
  }*/

}
