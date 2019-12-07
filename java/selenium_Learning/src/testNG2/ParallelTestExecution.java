package testNG2;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class ParallelTestExecution 
{
	public WebDriver driver;
	@Parameters("myBrowser")
	@BeforeClass
	public void launchBrowser(String myBrowser)
	{
		if(myBrowser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}else if(myBrowser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","F:\\Work\\java\\selenium_Learning\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
	}
  @Test
  public void tc_1() 
  {
	  driver.get("http://www.google.co.in");
	  driver.findElement(By.name("q")).sendKeys("selenium");
  }
  /*@Test
  public void tc_2()
  {
	  System.out.println("second test cases");
  }
  @Test
  public void tc_3()
  {
	  System.out.println("third test cases");
  }*/
}
