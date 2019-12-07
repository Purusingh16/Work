package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionScript 
{
  @Test
  public void f() 
  {
	  
	  Assert.assertEquals(12, 13);
  }
  
  @Test
  public void f1() 
  {
	  System.out.println("test case 2 started");
	  Assert.assertEquals(12, 13,"dropdown count does not match please check with developer");
	  System.out.println("test case 2 comlited");
  }
  
  @Test
  public void f2() 
  {
	  System.out.println("test case 3 started");
	  Assert.assertEquals(12, 12,"word does not match please the bug");
	  System.out.println("test case 3 complited");
  }
  
}
