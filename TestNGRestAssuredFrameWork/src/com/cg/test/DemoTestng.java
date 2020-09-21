package com.cg.test;

import org.testng.annotations.*;
import org.testng.annotations.Test;

public class DemoTestng {
	
	@BeforeSuite
	public void init()
	{
		System.out.println("Before Suite");
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Before Test");
	}
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Before Class!!!");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method");
	}
	
	@Test(priority=2,dependsOnMethods={"test2"},alwaysRun=true)
	public void test1()
	{
		System.out.println("Test-1");
	}
	
	@Test(priority=1,expectedExceptions=ArithmeticException.class)
	public void test2()
	{
		int a=10/0;
		System.out.println("Test-2");
	}

	
	@Test(priority=3,dataProvider="getData")
	public void test3(String name,String password)
	{
		System.out.println(name+"\t"+password);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object obj[][]=UtilClass.getData();
		return obj;
	}

}
