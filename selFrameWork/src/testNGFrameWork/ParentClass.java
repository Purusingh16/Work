package testNGFrameWork;

import org.testng.annotations.Test;

public class ParentClass 
{
	@Test
	public void parentAbc()
	{
		System.out.println("parent abc method");
	}
	@Test(dependsOnMethods={"efg"})
	public void parentEfg()
	{
		System.out.println("efg");
	}

}
