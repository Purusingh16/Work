package vigoReport;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VigoReportDemo 
{
	@Test
	public void firstTest()
	{
		Assert.assertEquals("dipu", "singh","Assert as both the values are NOT equal");
	}
	@Test
	public void secondTest()
	{
		Assert.assertEquals("dipu","dipu");
	}
	@Test
	public void thirdTest()
	{
		Assert.assertTrue(1 > 0);
	}
	@Test
	public void fourthTest()
	{
		Assert.assertTrue(1 < 0,"Assert failed as the condition is false");
	}



}
