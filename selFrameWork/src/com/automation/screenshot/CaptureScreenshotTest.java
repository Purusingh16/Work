package com.automation.screenshot;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CaptureScreenshotTest extends DriverTest
{
	@Test
	public void captureScreenshot()
	{
		driver=new FirefoxDriver();
		driver.get("http://automationtesting.in/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String title=driver.getTitle();
		Assert.assertEquals("Home-Automation Test", title);
		driver.close();
		
	}

}
