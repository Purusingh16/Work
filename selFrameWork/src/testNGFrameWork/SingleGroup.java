package testNGFrameWork;

import org.testng.annotations.Test;

public class SingleGroup 
{
	@Test(dependsOnGroups={"frstGroup","singleGroup"})
	public void testOne()
	{
		System.out.println("This is the actual test case to be excuted");
	}
	@Test(groups={"frstGroup"})
	public void testTwo()
	{
		System.out.println("This test belongs to singleGroup");
		
	}
	@Test(groups={"singleGroup"})
	public void testThree()
	{
		System.out.println("This test belongs to singleGroup-testThree");
		
	}

}
