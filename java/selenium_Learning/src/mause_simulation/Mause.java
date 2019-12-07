package mause_simulation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class Mause 
{

	public static void main(String[] args) 
	{
		WebDriver driver=new FirefoxDriver();
		
//		System.setProperty("webdriver.ie.driver","drivers/IEDriverServer.exe");
//		WebDriver driver=new InternetExplorerDriver();
//		driver.get("http://jqueryui.com/menu/");
		driver.get("http://jqueryui.com/droppable/");
		driver.get("http://jqueryui.com/slider/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
//		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0);
//		WebElement src=driver.findElement(By.id("draggable"));
//		WebElement dest=driver.findElement(By.id("droppable"));
		
		
		WebElement icon=driver.findElement(By.xpath(".//*[@id='slider']/span"));
		
//		System.out.println(driver.findElement(By.xpath(".//*[@id='droppable']/p")).getText());
		
		Actions act=new Actions(driver);
//		act.moveToElement(driver.findElement(By.id("ui-id-4"))).build().perform();
		
//		act.dragAndDrop(src, dest).build().perform();
		act.dragAndDropBy(icon, 75, 0).build().perform();
		
//		System.out.println(driver.findElement(By.xpath(".//*[@id='droppable']/p")).getText());

		
	}

}
