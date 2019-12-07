package screenshot_pkg;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class Taking_WebElement_Image_Demo 
{
	WebDriver driver;

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.gecko.driver","driver\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://demo.automationtesting.in/Index.html");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
//		WebElement webElement=driver.findElement(By.id("imagetrgt"));
		WebElement webElement=driver.findElement(By.cssSelector("#logo"));
		
		Screenshot screenshot=new AShot().takeScreenshot(driver,webElement);
		ImageIO.write(screenshot.getImage(),"PNG",new File("F:\\Work\\selenium_3_Project\\screenshot\\webelementscreenshot.png"));
		
		driver.quit();
	}

}
