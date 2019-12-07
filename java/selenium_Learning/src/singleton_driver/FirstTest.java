package singleton_driver;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import config.Configuration;
import utilities.Driver;
import utilities.TestBase;

public class FirstTest extends TestBase
{
	
	@Test
	public void test1() throws InterruptedException
	{
		Driver.Instance.navigate().to(Configuration.url.app_url);
		Driver.Instance.findElement(By.name("q")).sendKeys("selenium");
		Thread.sleep(500);
	}
	
}
