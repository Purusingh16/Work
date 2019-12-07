package testNGFrameWork;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidertInSameClass 
{
	@Test(dataProvider="Puru-Singh")
	public void setMethod(String param)
	{
		System.out.println(param);
	}
	@DataProvider(name="Puru-Singh")
	public Object[][] dataProviderMethod()
	{
		return new Object[][]
				{
					{"first set of data"},
					{"second set of data"}
				};
	}

}
