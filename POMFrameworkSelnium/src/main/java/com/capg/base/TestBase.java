package com.capg.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
	
	public static WebDriver driver;
	
	public TestBase() {
		try {
			FileInputStream fis=new FileInputStream("C:\\Users\\richeriy\\workspace\\POMFramework\\src\\main\\resources\\com\\capg\\config\\config.properties");
		    Properties prop=new Properties();
		    prop.load(fis);
		    String browser=prop.getProperty("browser");
		    if(browser.equalsIgnoreCase("chrome"))
		    {
		    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\richeriy\\Selenium\\chromedriver_win32(77)\\chromedriver.exe");
		    	driver=new ChromeDriver();
				
		    }
		    else if(browser.equalsIgnoreCase("firefox"))
		    {
		    	
		    }
		   
		    
		    
		    
		    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void openBrowser()
	{
		driver.get("https://www.myntra.com/login?referer=https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

}
