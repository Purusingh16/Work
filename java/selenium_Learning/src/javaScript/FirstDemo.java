package javaScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstDemo 
{

	public static void main(String[] args)
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("http://automationpractice.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Contact us")).click();
		driver.findElement(By.id("fileUpload")).sendKeys("C:\\Users\\purusingh\\Desktop\\String Manipulation.txt");
		driver.findElement(By.id("submitMessage"));
		
	}
}
