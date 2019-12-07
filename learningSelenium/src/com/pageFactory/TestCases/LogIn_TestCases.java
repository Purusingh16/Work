package com.pageFactory.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class LogIn_TestCases 
{
	static WebDriver driver;
	
//	static WebElement account_icon;
	static WebElement log;
	static WebElement pwd;
	static WebElement login;

	public static void main(String[] args) 
	{
//		System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
//		System.setProperty("webdriver.chrome", value)
//		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://store.demoqa.com/products-page/your-account/");
		driver.manage().window().maximize();
		
		PageFactory.initElements(driver, LogIn_TestCases.class);
//		account_icon.click();
		log.sendKeys("Purushottam");
		pwd.sendKeys("Purusingh@16");
		System.out.println("login success");
		login.click();
	}

}
