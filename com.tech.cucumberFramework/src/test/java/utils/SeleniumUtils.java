package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SeleniumUtils 
{ 
	public static WebDriver driver=null;
    public static WebDriver openBrowser(String browserName,String url)
    {   
    	
    	
    	    if(browserName.equalsIgnoreCase("firefox"))
    	    {
    	    	
    		  System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
    		// System.setProperty("webdriver.firefox.bin","C:/Firefox 56/firefox.exe");
    		  driver=new FirefoxDriver();
    	  }
    	  else if(browserName.equalsIgnoreCase("chrome"))
    	  { System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    		 //System.setProperty("webdriver.chromedriver.driver","C:/Users/Uma/Downloads");
    		  driver=new ChromeDriver();
    	  }
    	  else if(browserName.equalsIgnoreCase("ie"))
    	  {
    		  
    		  System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
    		
    		  driver=new InternetExplorerDriver();
    	}

    		  driver.get(url);
    	  


    	return driver;
    	
    }
    
public static void closeBrowser()
{
	if(driver!=null)
	{
		driver.quit();
	}

}
}

