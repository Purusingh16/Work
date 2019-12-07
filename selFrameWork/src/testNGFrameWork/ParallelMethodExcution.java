package testNGFrameWork;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelMethodExcution 
{
	/*@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("i am in beforeMethod");
	}*/
	@Test
	public void testOne()
	{
		for (int i = 0; i <=10; i++)
		{
			System.out.println("testOne I Values:"+i);
		}
		
	}
	@Test
	public void testTwo()
	{
		for (int i =100; i <=110; i++)
		{
			System.out.println("testTwo I Values:"+i);
		}
	
	}
	/*@AfterMethod
	public void afterMethod()
	{
		System.out.println("i am in afterMethod");
	}*/
}
