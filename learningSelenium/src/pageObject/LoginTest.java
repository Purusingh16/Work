package pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest 
{
	WebDriver driver=null;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver", "gekodriver\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("http://store.demoqa.com");
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@Test
	public void verifyLogin() throws InterruptedException
	{
		WebElement myAccountLogin=driver.findElement(By.className("account_icon"));
		myAccountLogin.click();
		Thread.sleep(2000);
		WebElement userName=driver.findElement(By.id("log"));
		userName.sendKeys("Purushottam");
		
		WebElement password=driver.findElement(By.id("pwd"));
		password.sendKeys("Purusingh@16");
		
		WebElement loginButton=driver.findElement(By.id("login"));
		loginButton.click();
	}
	public void TearDown()
	{
		driver.close();
	}

}
