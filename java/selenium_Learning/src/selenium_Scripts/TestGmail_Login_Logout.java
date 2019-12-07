package selenium_Scripts;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestGmail_Login_Logout 
{
	public WebDriver driver;
	
	public void openURL(){
		driver=new FirefoxDriver();
		driver.get("http://gmail.com");
		driver.manage().window().maximize();
		
	}
	public void verifyLogin() throws Exception
	{
		driver.findElement(By.id("Email")).sendKeys("purusingh16");
		driver.findElement(By.id("next")).click();
		Thread.sleep(8000);
		driver.findElement(By.id("Passwd")).sendKeys("dipusingh");
		driver.findElement(By.id("signIn")).click();
		Thread.sleep(20000);
		
	}
	public void verifyLogout()
	{
		driver.findElement
		(By.xpath("//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")).click();
		driver.findElement(By.id("gb_71")).click();
	}
	public static void main(String[] args) throws Exception
	{
		TestGmail_Login_Logout g=new TestGmail_Login_Logout();
		g.openURL();
		g.verifyLogin();
		g.verifyLogout();
		/*WebDriver driver=new FirefoxDriver();
		driver.get("https://accounts.google.com");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.close();
		
		WebElement emailElement=driver.findElement(By.id("email"));
		emailElement.sendKeys("purusingh16@gmail.com");
		
		
		WebElement passwordElement=driver.findElement(By.id("passwd"));
		passwordElement.sendKeys("dipusingh");*/
		
	}

}
