package testNGFrameWork;

import org.testng.annotations.DataProvider;

public class DataProviderClass 
{
	@DataProvider(name="Puru-Singh")
	public static Object[][] dataProviderMethod()
	{
		return new Object[][]
				{
					{"first set of data"},
					{"second set of data"}
				};

	}
}
