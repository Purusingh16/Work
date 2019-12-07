package testNGFrameWork;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoggingTest 
{	
	@Test
	public void testOne()
	{
		Assert.assertTrue(true);
	}
	@Test
	public void testTwo()
	{
		Assert.assertTrue(false);
	}

}
