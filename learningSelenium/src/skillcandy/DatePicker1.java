package skillcandy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DatePicker1 {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://demo.automationtesting.in/Datepicker.html");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		/*JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("document.getElementById('datepicker1').value='06/21/2017'");*/
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("document.querySelector('#datepicker1').value='06/21/2017'");
		
		
	}

}
