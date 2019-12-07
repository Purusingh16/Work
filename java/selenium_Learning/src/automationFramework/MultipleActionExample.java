package automationFramework;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MultipleActionExample
{

	public static void main(String[] args)
	{
	      WebDriver driver = new FirefoxDriver();
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      driver.get("http://www.facebook.com/");
	      driver.manage().window().maximize();
	 
	      WebElement userName = driver.findElement(By.id("email"));
	 
	      Actions act = new Actions(driver);
	      Action seriesOfActions = act.moveToElement(userName).click().keyDown(userName, Keys.SHIFT)
	            .sendKeys(userName, "hello").keyUp(userName, Keys.SHIFT).doubleClick(userName).contextClick().build();
	      seriesOfActions.perform();
	 
//	      driver.close();
	}

}
