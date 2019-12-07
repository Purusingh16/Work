package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class Sample
{

	public static void main(String[] args) throws Exception
	{
//		System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
//		System.setProperty("webdriver.gecko.driver","driver\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
//		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		Assert.assertEquals("Facebook – log in or sign up",driver.getTitle(),"title not matching");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
//		select dropdown  selectbyindex
		/*WebElement dropdown1=driver.findElement(By.id("month"));
		Select byIndex=new Select(dropdown1);
		byIndex.selectByIndex(2);
		
		Thread.sleep(1000);*/
		
//		select dropdown selectbyvalue
	/*	WebElement dropdown2=driver.findElement(By.id("month"));
		Select byValue=new Select(dropdown2);
		byValue.selectByValue("4");*/
		
		Thread.sleep(1000);
		
//		select dropdown selectbyvisibletext
		WebElement dropdown3=driver.findElement(By.id("month"));
		Select byVisibleText=new Select(dropdown3);
		byVisibleText.selectByVisibleText("Oct");
		
	}

	
}


