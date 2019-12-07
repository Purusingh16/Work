package testNGFrameWork;

import org.testng.annotations.Test;

public class DataProviderInOtherClass 
{
	@Test(dataProvider="Puru-Singh",dataProviderClass=DataProviderClass.class)
	public void setMethod(String param)
	{
		System.out.println(param);
	}

}
