package testNGFramework;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Check {
  @Test
  public void checkTest() 
  {
	  System.out.println("test case pass");
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("before method pass");
  }

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("after method pass");
  }

  @BeforeClass
  public void beforeClass() 
  {
	  System.out.println("before class pass");
  }

  @AfterClass
  public void afterClass() 
  {
	  System.out.println("after class pass");
  }

}
