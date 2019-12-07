package selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class HandlingDatePicker 
{
	public static void main(String[] args) 
	{
//		System.setProperty("webdriver.gecko.driver", "D:\\selenium-jar\\geckodriver-v0.11.1-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		
		driver.navigate().to("http://demo.automationtesting.in/Datepicker.html");
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('datepicker1').value='11/09/2016'");
		
		
	}

}
