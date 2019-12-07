package testNG3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestGroup1 
{
  @Test(groups={"smoke"})
  public void tc_1()
  {
	  System.out.println("smoke first test cases");
	  Assert.assertEquals("Test","Test123");
  }
  @Test(groups={"smoke"},dependsOnMethods={"tc_1"})
  public void tc_2()
  {
	  System.out.println("smoke second test cases");
  }
  @Test(groups={"smoke"},dependsOnMethods={"tc_1"})
  public void tc_3()
  {
	  System.out.println("smoke third test cases");
  }
}
