package automationFramework;

import java.util.concurrent.TimeUnit;

import org.apache.jasper.tagplugins.jstl.core.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchWindows 
{
	public static WebDriver driver;
	public static void main(String[] args) 
	{
		 driver = new FirefoxDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");
		 driver.manage().window().maximize();
		 String handle= driver.getWindowHandle();
		 System.out.println(handle);
		 driver.findElement(By.name("New Message Window")).click();
		 Set handles = (Set) driver.getWindowHandles();
		 System.out.println(handles);
		 for (String handle1 : driver.getWindowHandles())
		 {
			 System.out.println(handle1);
			 driver.switchTo().window(handle1);
		 }
//		 driver.close();
//		 driver.quit();
	}

}
