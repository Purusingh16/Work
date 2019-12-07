package testNG5;

import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class PrintLinks 
{
	public WebDriver driver;
  @Test
  public void f() 
  {
	  List<WebElement> str=driver.findElements(By.tagName("a"));
	  System.out.println(str.size());
	  for(int index=0;index<str.size();index++)
	  {
		  System.out.println(str.get(index).getText());
	  }
  }
  @BeforeTest
  public void beforeTest()
  {
	  driver=new FirefoxDriver();
	  driver.get("http://www.spicejet.com/");
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
  }

}
