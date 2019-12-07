package testNGFrameWork;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClassOne 
{
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("I am in beforeMethod-ClassOne");
	}
	@Test
	public void testOne()
	{
		System.out.println("i am in testOne-ClassOne");
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("i am in afterMethod-ClassOne");
	}

}
