package fileuploading;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FileUpload1
{

	public static void main(String[] args) throws Exception
	{
		String command[]={"AutoITScript/file.exe","F:\\Work\\java\\selenium_Learning\\AutoITScript\\file.exe"};
		WebDriver webDriver=new FirefoxDriver();
		webDriver.get("http://automationpractice.com/index.php");
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		webDriver.findElement(By.linkText("Contact us")).click();
		webDriver.findElement(By.id("fileUpload")).click();
		Runtime.getRuntime().exec(command);
		

	}

}
