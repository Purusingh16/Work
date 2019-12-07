package testNGFrameWork;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertion 
{
	@Test
	public void testOne()
	{
//		Assert.assertFalse(1>0,"somr common error");
		String name="dipu";
		String name1="dipu";
//		Assert.assertNull(name,"some common error");
		Assert.assertNotEquals(name, name1, "some common error");
	}

}
