package com.cg.project.utils;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
	public class Utils{
		public static long PAGE_LOAD=20; 
		public static long IMPLICIT_WAIT=30;
		public static WebDriver driver;
		public  static WebDriver getWebDriver() {		
			System.setProperty("webdriver.chrome.driver", "C:\\SatishTrainingData\\TrainingsTopicsWise\\chromedriver_win32 (1)\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Utils.PAGE_LOAD,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT,TimeUnit.SECONDS);
			return driver;
		}
	}