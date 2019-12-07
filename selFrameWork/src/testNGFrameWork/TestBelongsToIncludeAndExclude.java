package testNGFrameWork;

import org.testng.annotations.Test;

public class TestBelongsToIncludeAndExclude
{
	@Test(groups={"include-groups"})
	public void testOne()
	{
		System.out.println("This is belongs to sanity Group");
	}
	@Test(groups={"include-groups"})
	public void testTwo()
	{
		System.out.println("This is belongs to sanity Group and Regression group");
	}
	@Test(groups={"include-groups","exclude-groups"})
	public void testThree()
	{
		System.out.println("This is belongs to sanity Group");
	}

}
