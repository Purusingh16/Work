package assertionDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionDemo
{
	 int c=0;
//	test script
	@Test
	public void testAddition()
	{
		c=addition(4,5);
		Assert.assertEquals(c, 9);
	}
//	method we are going to test
	private int addition(int a,int b)
	{
		return a+b;
	}
//	if testAddition method passed then this method will execute otherwise
//	this method will be skipped
	@Test(dependsOnMethods={"testAddition"})
	public void testDivision()
	{
		Assert.assertEquals(division(18), 2);
	}
	private int division(int a)
	{
		return a/c;
	}

}
