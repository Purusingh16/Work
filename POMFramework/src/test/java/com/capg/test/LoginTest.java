package com.capg.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.capg.base.TestBase;
import com.capg.pages.LoginPage;
import com.capg.util.TestUtil;

public class LoginTest extends TestBase{
	LoginPage login;
	@BeforeTest
	public void init()
	{
		
		
	}
	
	@BeforeMethod
	public void openBrowser()
	{
		login=new LoginPage();
		super.openBrowser();
	}
	
	@Test(dataProvider="getData")
	public void checkLogin(String un,String pw)
	{
		String title=login.checkLogin(un, pw);
		Assert.assertEquals(title, "Login");
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] o=TestUtil.getData("C:\\Users\\richeriy\\FirstExcel.xlsx", "Dummy");
		return o;
	}
	
	@AfterMethod
	public void quit()
	{
		driver.quit();
	}
	
	

}
