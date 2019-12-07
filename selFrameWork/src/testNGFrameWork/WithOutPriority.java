package testNGFrameWork;

import org.testng.annotations.Test;

public class WithOutPriority 
{
	@Test(priority=3)
	public void secondTest()
	{
		System.out.println("I am in secondTest");
	}
	@Test(priority=3)
	public void thirdTest()
	{
		System.out.println("I am in thirdTest");
	}
	@Test(priority=3)
	public void forthTest()
	{
		System.out.println("I am in forthTest");
	}

}
