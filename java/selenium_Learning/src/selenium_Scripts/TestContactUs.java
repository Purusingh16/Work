package selenium_Scripts;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.Select;

public class TestContactUs {

	public WebDriver driver;
	
	public void openURL()
	{
		driver=new FirefoxDriver();
		driver.get("http://automationpractice.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	public void contact_us()
	{
		driver.findElement(By.xpath("//*[@id='contact-link']/a")).click();
	}
	public void subjectheading_element()
	{
		WebElement element =driver.findElement(By.id("id_contact"));
		Select selectElement=new Select(element);
		selectElement.selectByIndex(2);
		
		selectElement.selectByVisibleText("Customer service");
		
	}
	
	public static void main(String[] args)
	{
		TestContactUs us=new TestContactUs();
		
		us.openURL();
		us.contact_us();
		us.subjectheading_element();
		
	
		
		/*WebDriver driver=new FirefoxDriver();
		driver.get("http://automationpractice.com");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebElement contectUsElement=driver.findElement(By.xpath("//a[@title='Contact Us']"));
		contectUsElement.click();
		
		WebElement subjectHeadingElement=driver.findElement(By.id("id_contact"));
		
		Select selectElement=new Select(subjectHeadingElement);
//		selectElement.selectByIndex(1);
		
		selectElement.selectByVisibleText("Customer service");*/
		
	}

}
