package testNGFrameWork;

import org.testng.annotations.Test;

public class TestBelongsToSingleGroup
{
	@Test(groups={"sanity-groups"})
	public void testOne()
	{
		System.out.println("This is belongs to sanity Group");
	}
	@Test(groups={"sanity-groups","regression-groups"})
	public void testTwo()
	{
		System.out.println("This is belongs to sanity Group and Regression group");
	}
	@Test(groups={"sanity-groups"})
	public void testThree()
	{
		System.out.println("This is belongs to sanity Group");
	}

}
