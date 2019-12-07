package Com.capg.DemoSeleniumCG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.popuptest.com/popuptest2.html");
//		driver.navigate().to("https://www.google.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
//		if(driver.getTitle().equalsIgnoreCase("google"))
//		{
//			System.out.println("Correct Page!!");
//			WebElement text=driver.findElement(By.name("q"));
//			text.sendKeys("Capgemini pune");
//			text.submit();
//		}
		System.out.println(driver.getCurrentUrl());
//		System.out.println(driver.getPageSource());
//		System.out.println(driver.getTitle());
//		driver.navigate().back();
//		driver.close();
		driver.quit();

	}

}
