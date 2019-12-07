package testNGFrameWork;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ExecuteOnlyFailedTests 
{
	@Test
	public void testOne()
	{
		Assert.assertTrue(true);
		System.out.println("testOne passed as the assert true");
	}
	@Test
	public void testTwo()
	{
		Assert.assertTrue(false);
		System.out.println("testTwo passed as 1 is greater then 0");
	}
	@Test
	public void testThree()
	{
		Assert.assertTrue(true);
		System.out.println("testThree failed as the assert false");
	}
	@Test
	public void testFour()
	{
		Assert.assertTrue(1<0);
		System.out.println("testFour failed as 1 is NOT less then 0");
	}
	
}
