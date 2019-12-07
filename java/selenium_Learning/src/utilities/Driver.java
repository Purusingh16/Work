package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import config.Configuration;

public  class Driver 
{
	public static WebDriver Instance=null;
//	public static String browser="ff";
	
	public static void Initialize()
	{
		if(Instance == null)
		{
			if(Configuration.Browser.browser.equalsIgnoreCase("ff"))
				Instance = new FirefoxDriver();
			
			else if(Configuration.Browser.browser.equalsIgnoreCase("ie"))
			{
				System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
				Instance = new InternetExplorerDriver();
			}
			else if(Configuration.Browser.browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
				Instance = new ChromeDriver();
			}
		}
		Instance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Instance.manage().window().maximize();
	}
	public static void close()
	{
		System.out.println("closing browser");
		Instance.close();
		Instance=null;
	}
	public static void quit()
	{
		System.out.println("Quiting browser");
		Instance.quit();
		Instance=null;
	}
}
