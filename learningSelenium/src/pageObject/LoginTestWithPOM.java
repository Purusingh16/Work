package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automationFrameWork.LoginPOM;

public class LoginTestWithPOM 
{
	WebDriver driver=null;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver", "gekodriver\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("http://store.demoqa.com");
		driver.manage().window().maximize();
	}
	@Test
	public void verifyLogin() throws InterruptedException
	{
		WebElement myAccountLogin=driver.findElement(By.className("account_icon"));
		myAccountLogin.click();
		Thread.sleep(2000);
		LoginPOM loginPOM=new LoginPOM(driver);
		loginPOM.loginwithoutsavingCookie("Purushottam", "Purusingh@16");
	}
	@Test
	public void tearDown()
	{
		driver.quit();
	}

}
