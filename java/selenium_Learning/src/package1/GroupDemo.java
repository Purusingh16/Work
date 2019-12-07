package package1;



import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDemo
{
  @Test(groups="Sanity")
  public void testOne() 
  {
	  System.out.println("from Sanity group testOne method");
  }
  
  @Test(groups="Regression")
  public void testTwo()
  {
	  System.out.println("from Sanity group testTwo method");
	  Assert.fail();
  }
  
  @Test(dependsOnMethods={"testTwo"}, groups="Regression")
  public void testThree() 
  {
	  System.out.println("from Regression group testThree method");
  }
  
  @Test(groups="Regression")
  public void testFour()
  {
	  System.out.println("from Regression group testFour method");
  }
  
  @Test(groups={"Regression","Sanity"})
  public void testFive()
  {
	  System.out.println("from Regression and sanity group testFive method");
  }
  
}
