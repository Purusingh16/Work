package Com.capg.DemoSeleniumCG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/java/DemoSeleniumCG/src/main/java/Com/capg/DemoSeleniumCG/Newhtml.html");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
//		Thread.sleep(5000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.manage().window().maximize();

	}

}
