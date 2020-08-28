package selenium.Demo.Pack1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Java_Selenium\\chrome_Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://Google.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
//		System.out.println(driver.getPageSource());
		driver.get("http://facebook.com");
//		driver.navigate().back();
		driver.navigate().forward();
		driver.close();
//		driver.quit();
		
	}

}
