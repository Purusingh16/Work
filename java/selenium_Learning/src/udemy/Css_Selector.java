package udemy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Css_Selector 
{

	public static void main(String[] args)
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.rediff.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//span[@id='signin_info']/a[1]")).click();
//		driver.findElement(By.linkText("Sign in")).click();
//		driver.findElement(By.cssSelector("input[id='login1']")).sendKeys("dipu");
//		driver.findElement(By.cssSelector("input[id='login1'][name='login']")).sendKeys("dipu");
//		driver.findElement(By.cssSelector("#login1")).sendKeys("dipu");
//		driver.findElement(By.cssSelector("div[class='login-form'] div input[id='login1']")).sendKeys("dipu");
//		driver.findElement(By.cssSelector("div.login-form div input#login1")).sendKeys("dipu");
//		driver.findElement(By.cssSelector("input[id^='logi']")).sendKeys("dipu");
		driver.findElement(By.cssSelector("input[id*='ogi']")).sendKeys("dipu");





		
	}

}
