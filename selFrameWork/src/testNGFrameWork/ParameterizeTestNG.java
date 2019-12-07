package testNGFrameWork;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizeTestNG 
{
	@Parameters({"suite-level-param"})
	@Test
	public void firstTest(String param)
	{
		System.out.println(param);
	}
	@Parameters({"test-level-param"})
	@Test
	public void secondTest(String param)
	{
		System.out.println(param);
	}
	@Parameters({"suite-level-param","test-level-param1"})
	@Test
	public void thirdTest(String suiteParam,String testParam)
	{
		System.out.println(suiteParam+" *** "+testParam);
	}

}
