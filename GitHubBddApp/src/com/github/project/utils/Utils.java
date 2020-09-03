package com.github.project.utils;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Utils {
	public static WebDriver getWebDriver() {
		
		//1st register driver in JVM
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\GitHubBddApp\\drivers\\chromedriver.exe");
		
		//2nd create instance of driver
		WebDriver driver = new ChromeDriver();
		
		//3rd settings 
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(30l, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30l, TimeUnit.SECONDS);
		
		return driver;
	}

}