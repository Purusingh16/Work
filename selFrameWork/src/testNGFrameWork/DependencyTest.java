package testNGFrameWork;

import org.testng.annotations.Test;

public class DependencyTest 
{
	@Test(dependsOnMethods={"pqr","abc"})
	public void efg()
	{
		System.out.println("This method is dependent on pqr and abc");
	}
	@Test
	public void abc()
	{
		System.out.println("This actual test");
	}
	@Test
	public void pqr()
	{
		System.out.println("This method is base for efg");
	}
	
	

}
