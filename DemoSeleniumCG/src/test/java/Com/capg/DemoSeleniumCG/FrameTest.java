package Com.capg.DemoSeleniumCG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/selenium/deprecated.html");
		driver.manage().window().maximize();
//		driver.findElement(By.linkText("All Classes")).click();
		driver.switchTo().frame("classFrame").findElement(By.linkText("Deprecated")).click();
	}

}
