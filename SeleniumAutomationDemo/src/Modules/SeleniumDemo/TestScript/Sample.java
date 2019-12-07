package Modules.SeleniumDemo.TestScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sample {
	private WebDriver driver;

	@BeforeTest
	public void beforeTest() {		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");	
	}

	@Test
	public void f() {
	}

	@AfterTest
	public void afterTest() {
	}

}
