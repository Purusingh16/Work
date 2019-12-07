package listenerDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listenerDemo.TestNGListener.class)
public class MyFirstTestCase 
{
	@Test
	public void GoogleTitleVerify()
	{
		WebDriver webDriver=new FirefoxDriver();
		webDriver.manage().window().maximize();
		webDriver.get("https://www.google.co.in");
		System.out.println(webDriver.getTitle());
		webDriver.quit();
	}
	@Test
	public void titleVerify_TestToFail()
	{
		System.out.println("Test 2 Dummy");
		Assert.assertTrue(false);
	}

}
