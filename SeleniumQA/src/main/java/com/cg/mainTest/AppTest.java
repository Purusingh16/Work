package com.cg.mainTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AppTest 
{
	@BeforeClass
    public static void setUpTestEnv()
    {
    	System.out.println("setUpTestEnv");
    }
	@Before
	public void setMockTest()
	{
		System.out.println("setMockTest");
	}
	@Test
	public void test1()
	{
		String string1="Hello World";
		String string2="Hello World";
		
		Assert.assertEquals(string1, string2);
		System.out.println("test1");
	}
	@Test
	public void test2()
	{
		System.out.println("test2");
	}
	@After
	public void tearDownMockTest()
	{
		System.out.println("tearDownMockTest");
	}
	@AfterClass
	public static void tearDownTestEnv()
	{
		System.out.println("tearDownTestEnv");
	}
}
