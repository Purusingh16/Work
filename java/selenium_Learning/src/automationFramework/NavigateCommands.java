package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigateCommands
{

	public static void main(String[] args)
	{
				WebDriver driver = new FirefoxDriver();
				String appUrl = "http://www.DemoQA.com";
				driver.get(appUrl);
				driver.manage().window().maximize();
		 
				driver.findElement(By.xpath(".//*[@id='menu-item-374']/a")).click();
				driver.navigate().back();
				driver.navigate().forward();
				driver.navigate().to(appUrl);
				driver.navigate().refresh();
		 
//				driver.close();

	}

}
