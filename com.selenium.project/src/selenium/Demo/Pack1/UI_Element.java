package selenium.Demo.Pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UI_Element 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Java_Selenium\\chrome_Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		Select select=new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		select.selectByValue("2");
		select.selectByIndex(3);
//		select.selectByVisibleText("5 Adult");
		
	}

}
