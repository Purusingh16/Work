package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class Sample
{

	public static void main(String[] args) throws Exception
	{
//		System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","driver\\geckodriver.exe");
//		WebDriver driver=new MarionetteDriver();
		WebDriver driver=new FirefoxDriver();
//		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
//		select driver selectbyindex
		WebElement dropdown1=driver.findElement(By.id("month"));
		Select byIndex=new Select(dropdown1);
		byIndex.selectByIndex(2);
		
//		select by selectbyvalue
	}

	
}


