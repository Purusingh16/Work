package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {
	 WebDriver driver=null;
	public static WebDriver openBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("firefox"))
			return new FirefoxDriver();
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			return new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
		return null;
	}
}
