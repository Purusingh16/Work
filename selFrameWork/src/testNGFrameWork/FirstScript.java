package testNGFrameWork;

import org.testng.annotations.Test;

public class FirstScript {
  @Test
  public void firstTest() 
  {
	  System.out.println("i am in first test");
  }
  @Test
  public void secondTest() 
  {
	  System.out.println("i am in second test");
  }
  @Test(enabled=true)
  public void thirdTest() 
  {
	  System.out.println("i am in third test");
  }
}
