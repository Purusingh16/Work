package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindElementCommands 
{

	public static void main(String[] args) 
	{
				// Create a new instance of the FireFox driver
				WebDriver driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.get("http://toolsqa.wpengine.com/Automation-practice-form/");
				driver.manage().window().maximize();
				// Type Name in the FirstName text box      
				driver.findElement(By.name("firstname")).sendKeys("Lakshay"); 
				//Type LastName in the LastName text box
				driver.findElement(By.name("lastname")).sendKeys("Sharma");
				// Click on the Submit button
				driver.findElement(By.id("submit")).click();
	}

}
