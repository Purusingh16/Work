package com.utilities;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SeleniumUtils 
{
	private static WebDriver driver=null;
	Logger logger= LogManager.getLogger(this.getClass().getName());
	
	public WebDriver openBrowser(String browserName,String url)
	{
		if(browserName.equalsIgnoreCase("firefox"))
		{
			logger.info("creating firefox browser object");
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			logger.info("creating chrome browser object");
			System.setProperty("webdriver.chrome.driver","servers/chromedriverServer");
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			logger.info("creating IE browser object");
			System.setProperty("webdriver.ie.driver","servers/IEDriverServer");
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
	
	public void closeBrowser()
	{
		if(driver!=null)
			driver.quit();
		else
		{
			logger.warn("Driver is not initialised");
		}
		
	}
	public static WebDriver getDriver()
	{
		return driver;
		
	}

}
