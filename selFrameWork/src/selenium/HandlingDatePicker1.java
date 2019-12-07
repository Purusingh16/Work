package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingDatePicker1
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver=new FirefoxDriver();
		driver.navigate().to("http://www.redbus.in/");
		driver.manage().window().maximize();
		
		driver.findElements(By.xpath(".//*[@id='search']/div/div[3]/div/label")).get(1).click();
		Thread.sleep(5000);
		
		
		
	}

}
