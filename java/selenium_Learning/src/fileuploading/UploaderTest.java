package fileuploading;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UploaderTest 
{

	public static void main(String[] args) 
	{
		WebDriver webDriver=new FirefoxDriver();
		webDriver.get("http://tinypic.com/");
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		webDriver.findElement(By.id("the_file")).sendKeys("C:\\Users\\purusingh\\Desktop\\Resume.txt");

	}

}
