package fileuploading;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FileUpload
{

	public static void main(String[] args)
	{
		WebDriver webDriver=new FirefoxDriver();
		webDriver.get("http://automationpractice.com/index.php");
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		webDriver.findElement(By.linkText("Contact us")).click();
		
		webDriver.findElement(By.id("fileUpload")).sendKeys("C:\\Users\\purusingh\\Desktop\\Resume.txt");

	}

}
