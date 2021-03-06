package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class First_Script
{
	WebDriver driver;
	
	public void invokeBrowser()
	{
		try {
//			System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver=new ChromeDriver();
			FirefoxDriver driver=new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			driver.get("https://www.edureka.co/");
			searchCourse();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void searchCourse()
	{
		try {
			driver.findElement(By.id("search-inp1")).sendKeys("java");
			Thread.sleep(3000);
			driver.findElement(By.id("search-button-bottom")).click();
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, 800)");
			
			driver.findElement(By.xpath("//label[contains(text(),'Weekend')]")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		First_Script first_Script=new First_Script();
		first_Script.invokeBrowser();

	}

}
