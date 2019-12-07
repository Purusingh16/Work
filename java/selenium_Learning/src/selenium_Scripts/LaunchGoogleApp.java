package selenium_Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LaunchGoogleApp {

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","C:\\chrome driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
//		driver.get("http://automationpractice.com");
		driver.get("http://gmail.com");
		driver.manage().window().maximize();
//		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//input[@id='next']")).click();
		
		Thread.sleep(2000);
		
//		String actual_error=driver.findElement(By.xpath("//span[@id='errormsg_0_Email']")).getText();
		String actual_error=driver.findElement(By.xpath("//span[@id='errormsg_0_Email']")).getAttribute("innerHTML");

		String expected_error="Please enter your email.";
		
		Assert.assertEquals(actual_error, expected_error);
		
		Assert.assertTrue(actual_error.contains("dipusingh"));
		System.out.println("test is complete");
	}

}
