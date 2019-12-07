package fileupload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FileUploader 
{

	public static void main(String[] args) throws Exception 
	{
		String command[]={"AutoIT/fileuploadScript.exe","C:\\Users\\purusingh\\Desktop\\x-path.txt"};
		WebDriver driver=new FirefoxDriver();
		driver.get("http://automationpractice.com/index.php?controller=contact");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.id("fileUpload")).click();
		Runtime.getRuntime().exec(command);
		

	}

}
