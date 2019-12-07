package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseOverExample
{

	public static void main(String[] args) throws Exception 
	{
	      WebDriver driver = new FirefoxDriver();
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      driver.get("http://www.myntra.com/");
	   
	      driver.manage().window().maximize();
	 
	      Actions act = new Actions(driver);
	      By testlink = By.linkText("Men");
	      WebElement test = driver.findElement(testlink);
	      act.moveToElement(test).build().perform();
	 
	      driver.findElement(By.linkText("Bags & Backpacks")).click();
	 
	      driver.findElement(By.xpath("//*[text()='Categories']//following::li[1]/label")).click();
	      Thread.sleep(3000);
	      
	      WebDriverWait wait=new WebDriverWait(driver, 10);
	      Boolean bag=wait.until(ExpectedConditions.elementSelectionStateToBe(test, true));
	      System.out.println("bag to be selected!!!");
	      Actions sel = new Actions(driver);
	      sel.moveToElement(driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[5]/ul/li[1]/a/img"))).build().perform();
	 
	      driver.findElement(By.xpath(".//*[@id='mountRoot']/div/div/div[2]/div[2]/div[3]/button[2]")).click();
	 
	      Actions mov = new Actions(driver);
	      mov.moveToElement(driver.findElement(By.xpath("div/div/div"))).click().build().perform();
	 
	      driver.findElement(By.xpath("(//span[@data-hint='REMOVE FROM BAG'])[1]")).click();
	 
	      driver.close();
	}

}
