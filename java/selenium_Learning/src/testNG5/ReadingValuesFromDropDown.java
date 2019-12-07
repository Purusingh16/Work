package testNG5;

import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;

public class ReadingValuesFromDropDown
{
	public WebDriver driver;
  @Test
  public void f() 
  {
	  List<WebElement> str=new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult"))).getOptions();
	  System.out.println(str.size());
	  for(int index=0;index<str.size();index++)
	  {
		  if(!str.get(index).getText().equalsIgnoreCase("5 Adults"))
		  System.out.println(str.get(index).getText());//str[i]
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
