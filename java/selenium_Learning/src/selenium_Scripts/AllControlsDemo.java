package selenium_Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AllControlsDemo
{
	
	public static void main(String[] args) 
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("http://softwaretesting-guru.blogspot.in/p/main-page.html");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Selenium Practice page")).click();
		driver.findElement(By.name("Name")).sendKeys("Selenium");
		driver.findElement(By.name("subscribe")).click();
		driver.findElement(By.name("comments")).sendKeys("Welcome to Selenium class");
		new Select(driver.findElement(By.name("countries"))).selectByVisibleText("Argentina");
		driver.findElement(By.xpath("//input[@value='bad']")).click(); 
		
	}

}
