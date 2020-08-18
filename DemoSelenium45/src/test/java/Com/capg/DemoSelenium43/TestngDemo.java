package Com.capg.DemoSelenium43;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestngDemo {
	WebDriver driver;
	@BeforeSuite
	public void init()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\richeriy\\Selenium\\chromedriver_win32(77)\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		HashMap prefs=new HashMap();
		prefs.put("profile.default_content_setting_values.notifications",2);
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--start-maximized");
		 driver=new ChromeDriver(options);
		
	}
	
	@BeforeMethod
	public void intest()
	{
		driver.get("http://www.myntra.com");
	}
	
	

	@Test(priority=1,groups="B",invocationCount=2,expectedExceptions=ArithmeticException.class)
	public void test() {
		Actions action=new Actions(driver);
		WebElement mensSection=driver.findElement(By.xpath("//*[@id='desktop-header-cnt']/div[2]/nav/div/div[1]/div/a"));
		action.moveToElement(mensSection).perform();
		driver.findElement(By.xpath("//*[@id='desktop-header-cnt']/div[2]/nav/div/div[1]/div/div/div/div/li[5]/ul/li[14]/a")).click();
		int a=10/0;
		Assert.assertEquals(driver.getTitle(), "Mens Bags & Backpacks - Buy Bags & Backpacks for Men Online");
	}
	
	@AfterMethod
	public void quit()
	{
		//driver.quit();
	}

//	@Test(priority=2,dependsOnMethods="test",alwaysRun=true,enabled=false)
	@Test(groups="A")
	public void test1() {
		System.out.println("Test-1");
	}


}
