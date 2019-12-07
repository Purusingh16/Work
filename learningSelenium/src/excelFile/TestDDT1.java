package excelFile;

import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDDT1
{
	 
	WebDriver driver;
	Workbook wb;
	Sheet sh1;
	int numrow;
	String username;
	String password;
	 
	@BeforeTest
	public void Setup()
	{
	System.setProperty("webdriver.gecko.driver", "gekodriver\\geckodriver.exe");

	driver=new FirefoxDriver();
	driver.get("http://www.facebook.com");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	}
	
	@Test(dataProvider="testdata")
	public void TestFireFox(String uname,String password1)
	 
	{
	 
	driver.findElement(By.id("email")).clear();
	driver.findElement(By.id("email")).sendKeys(uname);
	driver.findElement(By.id("pass")).clear();
	driver.findElement(By.id("pass")).sendKeys(password1);
	}

  @DataProvider(name="testdata")
  public Object[][] TestDataFeed() 
  {
	  return null;
  }
}
