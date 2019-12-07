package testNG5;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;

public class verifyAlert 
{
	public WebDriver driver;
	
  @Test
  public void f() throws Exception 
  {
	  driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
	  driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
//	  Thread.sleep(5000);
	  driver.findElement(By.linkText("Pune (PNQ)")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.linkText("Delhi (DEL)")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.linkText("30")).click();
	  
	new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult"))).selectByVisibleText("1 Adult");
	new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child"))).selectByVisibleText("2 Children");
	new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Infant"))).selectByVisibleText("1 Infant");
	
	driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
  }
	/*@Test
	public void verifyAlerts()
	{
		String str=driver.switchTo().alert().getText();
		System.out.println(str);
		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
  	}*/
  @Test
  public void verify_PopUp()
  {
	  driver.findElement(By.linkText("Currency Converter")).click();
	  String str;
	  str=driver.getWindowHandle();
//	  driver.switchTo().window("window name");
	  driver.switchTo().window("converter");
	  new Select(driver.findElement(By.id("CurrencyConverterCurrencyConverterView_DropDownListBaseCurrency"))).selectByVisibleText("US Dollar(USD)");
	  new Select(driver.findElement(By.id("CurrencyConverterCurrencyConverterView_DropDownListConversionCurrency"))).selectByVisibleText("Indian Rupee(INR)");
	  driver.findElement(By.id("CurrencyConverterCurrencyConverterView_TextBoxAmount")).sendKeys("1000");
	  driver.findElement(By.id("CurrencyConverterCurrencyConverterView_ButtonConvert")).click();
	  driver.findElement(By.id("ButtonCloseWindow")).click();
	  driver.switchTo().window(str);
	  
	  new Select(driver.findElement(By.id("AvailabilitySearchInputSelectViewdestinationStation1"))).selectByVisibleText("Bengaluru (BLR)");
	}
  
@BeforeTest
  public void beforeTest()  
  {
	 driver=new FirefoxDriver();
	 driver.get("http://spicejet.com");
	 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	 driver.manage().window().maximize();
	  
  }

}
