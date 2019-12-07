package testNG5;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class WordPressLoginExcel
{
	public WebDriver driver;
	
  @Test(dataProvider="wordpressData")
  public void loginToWordPress(String username,String password)
  {
	  driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys(username);
	  driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys(password);
	  driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
	  
//	  System.out.println(driver.getTitle());
	  Assert.assertTrue(driver.getTitle().contains("Dashboard"),"User is not able to login-Invalid Credentials");
	  System.out.println("Page Title Verified User is able to login Successfully");
	  
//	  driver.quit();
  } 
  @DataProvider(name="wordpressData") 
  public Object[][] passData()
  {
	  ExcelDataConfig excelDataConfig=new ExcelDataConfig("F:\\Work\\java\\selenium_Learning\\TestData\\InputData.xlsx");
	  int rows=excelDataConfig.getRowCount(0);
	  Object[][] data=new Object[rows][2];
	  
	  for (int i = 0; i < rows; i++) 
	  {
		data[i][0]=excelDataConfig.getData(0, i, 0);
		data[i][1]=excelDataConfig.getData(0, i, 1);
	  }
	return data;
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  driver=new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.get("http://demosite.center/wordpress/wp-login.php");
  }
  @AfterMethod
  public void tearDown()
  {
	  driver.quit();
  }
  
}
