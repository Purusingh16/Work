package selenium_Scripts;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewWindowDemo {

	
	public static void main(String[] args) throws Exception
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.way2automation.com/demo.html");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		String parentWindow=driver.getWindowHandle();
		
		WebElement element=driver.findElement(By.linkText("Alert"));
		
		/*JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid blue'",element);*/
		
		element.click();
		
		Set<String> windows=driver.getWindowHandles();
		
		for (String window : windows)
		{
			if(window.equalsIgnoreCase(parentWindow))
			{
			continue;
			}
			driver.switchTo().window(window);
		}
		Thread.sleep(5000);
		element=driver.findElement(By.xpath("//a[contains(text(),'Signin')]"));
		element.click();
		Thread.sleep(5000);
		
		element=driver.findElement
				(By.xpath("//form[@class='ajaxlogin']/fieldset/input[@name='username']"));
				element.sendKeys("test123");
				
		element=driver.findElement
						(By.xpath("//form[@class='ajaxlogin']/fieldset/input[@name='password']"));
						element.sendKeys("test123");
						
		element=driver.findElement(By.xpath("//form[@class='ajaxlogin']//input[@type='submit']"));
				
		element.click();
								
//		Thread.sleep(5000);
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		element=driver.findElement(By.linkText("Alert"));
		element.click();
		Thread.sleep(3000);
		
		element=driver.findElement(By.xpath("//div[@id='example-1-tab-1']//iframe[@class='demo-frame']"));
		
		driver.switchTo().frame(element);
				
		element=driver.findElement(By.xpath("//button[contains(text(),'Click the button to display an alert box:')]"));
		element.click();
		
		Thread.sleep(5000);
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		
		
		alert.accept();
		driver.switchTo().defaultContent();
		
		Thread.sleep(5000);
		Actions actions=new Actions(driver);
		WebElement mainMenu=driver.findElement(By.linkText("Interaction"));
		actions.moveToElement(mainMenu).build().perform();
		
		WebElement subMenu=driver.findElement(By.linkText("Droppable"));
		actions.moveToElement(subMenu);
		actions.click().build().perform();
		Thread.sleep(5000);
		
		
		
		element=driver.findElement(By.xpath("//div[@id='example-1-tab-1']//iframe[@class='demo-frame']"));
		
		driver.switchTo().frame(element);
//		Thread.sleep(5000);
		WebElement elementToDrop=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement target=driver.findElement(By.xpath("//div[@id='droppable']"));
		actions.dragAndDrop(elementToDrop,target).build().perform();
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		
		try{
			FileUtils.copyFile(src,new File("files/screen.png"));
		}catch(IOException e)
		
		{
			e.printStackTrace();
		}
		
	}

}
