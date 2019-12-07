package Com.capg.DemoSeleniumCG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/java/DemoSeleniumCG/src/main/java/Com/capg/DemoSeleniumCG/Link.html");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
//		driver.findElement(By.id("capg")).sendKeys(Keys.chord(Keys.CONTROL,Keys.RETURN));
		WebElement l1=driver.findElement(By.id("capg"));
		l1.sendKeys(Keys.CONTROL,Keys.ENTER);
		driver.manage().window().maximize();
		
	}

}
