package selenium;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Verify_Links 
{
	static WebDriver driver;

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://192.168.1.251/gramin/");
//		driver.get("http://platformx.co.in/TBSWebApplication/website/index.php");
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Total links are:"+links.size());
		
		for (int i = 0; i < links.size(); i++) 
		{
			WebElement element=links.get(i);
			String url=element.getAttribute("href");
			verifyLinkActive(url);
			
		}
		
	}
	public static void verifyLinkActive(String linkUrl)
	{
		 try 
	        {
	           URL url = new URL(linkUrl);
	           
	           HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
	           
	           httpURLConnect.setConnectTimeout(3000);
	           
	           httpURLConnect.connect();
	           
	           if(httpURLConnect.getResponseCode()==200)
	           {
	               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
	            }
	          if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
	           {
	               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
	            }
	        } catch (Exception e) {
	           
	        }
		
	}

}
