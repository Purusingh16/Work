package testNG4;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CaptureScreenShot
{
	public static WebDriver driver;
  @Test(priority=1)
  public void tc_1() throws IOException 
  {
	  driver=new FirefoxDriver();
	  driver.get("http://www.google.co.in");
	 /* File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(scrFile, new File("files/screenshot.png"));*/
	  Assert.assertEquals("Test","Test123");
  }
  /**
   * Enter data on search box
 * @throws Exception 
   */
  @Test(priority=2)
  public void tc_2() throws Exception
  {
	  driver.findElement(By.name("q")).sendKeys("Selenium");
	  Thread.sleep(3000);
	  Assert.assertEquals("Test","Test123");
  }
  /**
   * Click on keyboard enter option
 * @throws Exception 
   */
  @Test(priority=3)
  public void tc_3() throws Exception
  {
	  driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	  Thread.sleep(2000);
	  Assert.assertEquals("Test","Test123");
  }
}
