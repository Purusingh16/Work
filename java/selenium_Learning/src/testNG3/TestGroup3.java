package testNG3;

import org.testng.annotations.Test;

public class TestGroup3 
{

	@Test(groups={"regression"})
	  public void tc_7()
	  {
		  System.out.println("regression seventh test cases");
	  }
	  @Test(groups={"regression"})
	  public void tc_8()
	  {
		  System.out.println("regression eight test cases");
	  }
	  @Test(groups={"smoke"})
	  public void tc_9()
	  {
		  System.out.println("smoke ninth test cases");
	  }

}
