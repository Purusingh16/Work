package cssProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FindingCss
{

	public static void main(String[] args) 
	{
		WebDriver webDriver=new FirefoxDriver();
		webDriver.get("http://newtours.demoaut.com");
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		webDriver.findElement(By.cssSelector("a[href*='mercuryregister.php']")).click();
		webDriver.findElement(By.cssSelector("input[name='firstName']")).sendKeys("Purushottam");
		webDriver.findElement(By.cssSelector("input[name='lastName']")).sendKeys("kumar");
		webDriver.findElement(By.cssSelector("input[name='phone']")).sendKeys("7387933229");
		webDriver.findElement(By.cssSelector("input#userName")).sendKeys("dipusingh16@outlook.com");
		webDriver.findElement(By.cssSelector("input[name='address1']")).sendKeys("lohegaon");
		webDriver.findElement(By.cssSelector("input[name='address2']")).sendKeys("pankajassman");
		webDriver.findElement(By.cssSelector("input[name='city']")).sendKeys("pune");
		webDriver.findElement(By.cssSelector("input[name='state']")).sendKeys("maharastra");
		webDriver.findElement(By.cssSelector("input[name='postalCode']")).sendKeys("411047");
		
		Select select=new Select(webDriver.findElement(By.cssSelector("select[name='country']")));
		select.selectByVisibleText("INDIA");
		
		webDriver.findElement(By.cssSelector("input#email")).sendKeys("dipusingh16@outlook.com");
		webDriver.findElement(By.cssSelector("input[name='password']")).sendKeys("raaj@singh");
		webDriver.findElement(By.cssSelector("input[name='confirmPassword']")).sendKeys("raaj@singh");
		webDriver.findElement(By.cssSelector("input[name='register']")).click();
		
		webDriver.findElement(By.linkText(" sign-in ")).click();
		
		
		
	}

	
	

}
