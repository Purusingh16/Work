package www.whatfix.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Verify_WhatfixLinksTest
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException
	{
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://whatfix.com/quickolabs.com/#!flows/how-to-import-google-analytics-solution-of-whatfix/8174f470-9df9-11e3-8178-386077c653fe/");
		driver.manage().window().maximize();

		
		driver.findElement(By.linkText("Self Help")).click();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@title='Get Started with Whatfix']")));
        if(element!=null)
        {
        	driver.switchTo().frame(element);
        	driver.findElement(By.xpath("//a[text()='How to embed flows in my website or application?']")).click();;
        	driver.switchTo().defaultContent();
        	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Click on \'embed\' options.'])")));
        	Thread.sleep(4000);
        	driver.findElement(By.xpath("//a[text()='embed']")).click();
//        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//a[text()='slideshow']")).click();
        	driver.findElement(By.xpath("//a[text()='close']")).click();
        		
        }
	}


}
