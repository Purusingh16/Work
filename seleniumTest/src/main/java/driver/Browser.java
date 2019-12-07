package driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Browser {

	private static  WebDriver driver=null;
	
	public  WebDriver open(String browserName,String url)
	{
		if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "SeleniumDrivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.chrome.driver", "SeleniumDrivers/IEDriverServer.exe");			
			driver=new InternetExplorerDriver();
		}
		
		else
		{
			System.out.println("Invalid Browser"+browserName);
			return null;
		}
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	 
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public  WebDriver openRemote(String browserName,String url, String platform, String port)
	{
		DesiredCapabilities des=new DesiredCapabilities();
		des.setBrowserName(browserName);
		des.setPlatform(Platform.VISTA);
		try {
			driver=new RemoteWebDriver(new URL("http://localhost:"+port+"/wd/hub"),des);
		} catch (MalformedURLException e) {
	
			e.printStackTrace();
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
}
