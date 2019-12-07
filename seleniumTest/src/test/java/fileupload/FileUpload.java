package fileupload;

import org.testng.annotations.Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

public class FileUpload
{
	public WebDriver driver=null;
  @Test
  public void f() throws Exception 
  {
	  driver.findElement(By.id("1")).click();
	  Thread.sleep(5000);
	  
	  Runtime.getRuntime().exec("C:\\Users\\purusingh\\Desktop\\AutoIT\\Fileupload.exe");
	  
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  driver=new FirefoxDriver();
	  driver.get("file:///C:/Users/purusingh/Desktop/fileupload.html");
	  driver.manage().window().maximize();
  }

}
