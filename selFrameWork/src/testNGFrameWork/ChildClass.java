package testNGFrameWork;

import org.testng.annotations.Test;

public class ChildClass extends ParentClass
{
	@Test(dependsOnMethods={"parentAbc"})
	public void abc()
	{
		System.out.println("abc");
	}
	@Test
	public void efg()
	{
		System.out.println("efg");
	}

}
