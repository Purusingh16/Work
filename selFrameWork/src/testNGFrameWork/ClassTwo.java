package testNGFrameWork;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClassTwo 
{
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("I am in beforeMethod-classTwo");
	}
	@Test
	public void testOne()
	{
		System.out.println("i am in testOne-classTwo");
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("i am in afterMethod-classTwo");
	}

}
