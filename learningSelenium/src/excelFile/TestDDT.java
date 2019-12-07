package excelFile;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;

public class TestDDT 
{
  @Test(dataProvider = "testdata")
  public void TestFireFox(String uname, String password) 
  {
	  System.setProperty("webdriver.gecko.driver", "gekodriver\\geckodriver.exe");
	  WebDriver driver=new FirefoxDriver();
//	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.get("http://www.facebook.com");
	  driver.manage().window().maximize();
	  
	  driver.findElement(By.id("email")).clear();
	  driver.findElement(By.id("email")).sendKeys(uname);
	  driver.findElement(By.id("pass")).clear();
	  driver.findElement(By.id("pass")).sendKeys(password);
	  

  }

  @DataProvider(name="testdata")
  public Object[][] TestDataFeed()
  {
	  Object [][] facebookdata=new Object[2][2];
	  facebookdata[0][0]="Selenium1@gmail.com";
	  facebookdata[0][1]="password1";
	  
	  facebookdata[1][0]="Selenium2@gmail.com";
	  facebookdata[1][1]="password2";
	  
	  return facebookdata;
  }
}
