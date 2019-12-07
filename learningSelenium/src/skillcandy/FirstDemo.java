package skillcandy;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstDemo 
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.gecko.driver", "./gekodriver/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://automationpractice.com/");
		
		JavascriptExecutor executor=(JavascriptExecutor) driver;
		String windowTile=(String) executor.executeScript("return document.title");
		System.out.println(windowTile);
	}

}
