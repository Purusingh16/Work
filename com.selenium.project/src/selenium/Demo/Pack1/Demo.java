package selenium.Demo.Pack1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo
{
	public static WebDriver driver;
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\com.selenium.project\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://Google.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.navigate().refresh();
//		System.out.println(driver.getPageSource());
//		driver.get("http://facebook.com");
//		System.out.println(driver.getTitle());
//		driver.navigate().back();
//		System.out.println("after back command");
//		driver.navigate().forward();
//		System.out.println(driver.getTitle());
//		driver.close();
//		driver.quit();
		
	}

}
