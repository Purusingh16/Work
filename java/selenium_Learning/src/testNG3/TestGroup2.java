package testNG3;

import org.testng.annotations.Test;

public class TestGroup2 
{
	@Test(groups={"regression"})
	  public void tc_4()
	  {
		  System.out.println("regression fourth test cases");
	  }
	  @Test(groups={"regression"})
	  public void tc_5()
	  {
		  System.out.println("regression fifth test cases");
	  }
	  @Test(groups={"smoke"})
	  public void tc_6()
	  {
		  System.out.println("smoke sixth test cases");
	  }

}
