package selenium_Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearchTest 
{
	public static void main(String[] args)
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.Google.co.in");
		driver.findElement(By.id("lst-ib")).sendKeys("Selenium");
		driver.findElement(By.name("button")).click();
	}

}
