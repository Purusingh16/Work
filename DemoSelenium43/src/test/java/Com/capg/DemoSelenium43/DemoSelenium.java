package Com.capg.DemoSelenium43;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DemoSelenium {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\richeriy\\Selenium\\chromedriver_win32(77)\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		HashMap prefs=new HashMap();
		prefs.put("profile.default_content_setting_values.notifications",2);
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--start-maximized");
		WebDriver driver=new ChromeDriver(options);
		driver.get("http://www.myntra.com");
		Actions action=new Actions(driver);
		WebElement mensSection=driver.findElement(By.xpath("//*[@id='desktop-header-cnt']/div[2]/nav/div/div[1]/div/a"));
		action.moveToElement(mensSection).perform();
				
				
				

	}

}
