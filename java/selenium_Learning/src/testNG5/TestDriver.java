package testNG5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestDriver {

	
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.ie.driver","drivers/IEDriverServer.exe");
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
//		WebDriver driver=new InternetExplorerDriver();
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.google.com");
	}

}
