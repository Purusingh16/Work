package Com.capg.DemoSeleniumCG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DemoRegister 
{
	public static WebDriver driver=null;

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.newtours.demoaut.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Purushottam Kumar");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Kumar");
		driver.findElement(By.name("phone")).sendKeys("7387933226");
		driver.findElement(By.id("userName")).sendKeys("Puru Kumar");
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("Capgemini");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Pune");
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys("Maharastra");
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("411047");
		Select select=new Select(driver.findElement(By.xpath("//select[@name='country']")));
		select.selectByVisibleText("ALBANIA");
		driver.findElement(By.id("email")).sendKeys("XYZ@outlook.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("XYZ@16");
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("XYZ@16");
		driver.findElement(By.xpath("//input[@name='register']")).click();
		driver.close();
	}

}
