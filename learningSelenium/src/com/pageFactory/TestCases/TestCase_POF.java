package com.pageFactory.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TestCase_POF
{
	
	static WebDriver driver;
	@FindBy(how=How.XPATH, using=".//*[@id='account']/a/span[1]")
	static WebElement lnk_MyAccount;
	@FindBy(how=How.ID, using="log")
	static WebElement txtbx_Username;
	@FindBy(how=How.ID, using="pwd")
	static WebElement txtbx_Password;
	@FindBy(how=How.NAME, using="submit")
	static WebElement btn_Login;
//	@FindBy(how=How.NAME, using="submit")
//	static WebElement btn_Logout;
	
	public static void main(String[] args)
	{
		System.setProperty("webdriver.gecko.driver", "gekodriver\\geckodriver.exe");
		driver=new FirefoxDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://store.demoqa.com/");
		driver.manage().window().maximize();
		
		PageFactory.initElements(driver, TestCase_POF.class);
		lnk_MyAccount.click();
		txtbx_Username.sendKeys("Purushottam");
		txtbx_Password.sendKeys("Purusingh@16");
		System.out.println("login success");
		btn_Login.click();
		
		
	}

}
