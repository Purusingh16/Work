package skillcandy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DatePicker2 {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.tripadvisor.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@id='global-nav-Flights']")).click();
//		driver.findElement(By.xpath("//div[@class='ui_tabs inverted']//ul//li[2]//a[@class='ui_tab oneWay active']"));
		Thread.sleep(2000);
		driver.findElement(By.linkText("One-way")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='tabContent oneWay active']//div[1]//input[@name='orig']/following::input[@value='Pune, India - Lohegaon (PNQ)']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='tabContent oneWay active']//div[1]//input[@name='orig']/following::input[@value='Pune, India - Lohegaon (PNQ)']")).sendKeys("Mumbai");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='tabContent oneWay active']//div[2]//input[@name='dest']/following::input[@placeholder='City or Airport']")).sendKeys("Delhi");
		
		Thread.sleep(4000);
	    WebElement ele =driver.findElement(By.xpath("//div[@class='ui_picker']//*[@class='ui_icon calendar pickerType']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele);
		act.click().build().perform();
		
		String date="10-Jul 2017";
		String splitter[]=date.split("-");
		String month_year=splitter[1];
		String day=splitter[0];
		
//		System.out.println(month_year);
//		System.out.println(day);
		
		
	}

}
