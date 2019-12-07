package assertionDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifyErrorLogin 
{
	public static WebDriver driver=null;

	public static void main(String[] args)
	{
		driver=new FirefoxDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.partialLinkText("Sign in")).click();
		driver.findElement(By.id("email")).sendKeys("purusingh16@test.com");
		driver.findElement(By.id("passwd")).sendKeys("test15");
		driver.findElement(By.id("SubmitLogin")).click();
		String str=driver.switchTo().alert().getText();
		System.out.println(str);
	}

}
