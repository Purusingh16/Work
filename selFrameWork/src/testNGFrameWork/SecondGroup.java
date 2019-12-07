package testNGFrameWork;

import org.testng.annotations.Test;

public class SecondGroup
{
	@Test(groups={"otherClassGroup"})
	public void testOne()
	{
		System.out.println("This is from other class in the same package");
	}
}
