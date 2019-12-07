package testNG5;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class InformationCommands
{
	public WebDriver driver;
  @Test
  public void f() 
  {
	  String str,str1,str2;
	  str=driver.findElement(By.linkText("Gmail")).getText();
	  System.out.println(str);
	  
	  str1=driver.findElement(By.name("btnK")).getAttribute("aria-label");
	  System.out.println(str1);
	  
	  str2=driver.findElement(By.id("hplogo")).getAttribute("title");
	  System.out.println(str2);
  }
  @BeforeTest
  public void beforeTest() 
  {
	  driver=new FirefoxDriver();
	  driver.get("http://www.google.com");
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
  }

}
