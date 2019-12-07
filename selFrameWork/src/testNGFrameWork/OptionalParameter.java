package testNGFrameWork;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OptionalParameter 
{
	@Parameters({"Optional value"})
	@Test
	public void optinalParameterTesting(@Optional("learning testng framework")String param)
	{
		System.out.println(param);
	}

}
