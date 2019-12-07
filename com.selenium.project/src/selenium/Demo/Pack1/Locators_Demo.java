package selenium.Demo.Pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators_Demo 
{

	public static void main1(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Java_Selenium\\chrome_Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys("purusingh16@outlook.com");
		driver.findElement(By.id("pass")).sendKeys("Puru@123");
		driver.findElement(By.linkText("Forgotten account?")).click();
	}
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Java_Selenium\\chrome_Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://login.salesforce.com/?locale=in");
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("purusingh16@outlook.com");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Puru@123");
		driver.findElement(By.xpath("//*[@id='Login']")).click();
		System.out.println(driver.findElement(By.cssSelector("div#error.loginError")).getText());
	}

}
