package selenium_Scripts;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class TestDrag_Drop 
{
	WebDriver driver=null;
  @Test
  public void f() throws Exception 
  {
	  Actions builder=new Actions(driver);
	 // driver.findElement(By.linkText("Draggable")).click();
	 
	  WebElement dropme=driver.findElement(By.linkText("Droppable"));
	  dropme.click();
	  Thread.sleep(3000);
	 
	  WebElement dragme=driver.findElement(By.xpath(".//*[@id='draggableview']/p"));
	  
	  WebElement drop=driver.findElement(By.xpath("//div[@id='droppableview']"));
	  builder.dragAndDrop(dragme, drop).build().perform();
	  
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  driver=new FirefoxDriver();
	 
	  driver.get("http://demoqa.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
  }

  @AfterMethod
  public void afterMethod()
  {
	  
  }

}
