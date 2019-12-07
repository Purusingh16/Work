package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionScript1 
{
  @Test
  public void f() 
  {
	  String str="purusingh";
	  Assert.assertTrue(str.contains("dipusingh"),"name are not matching");
  }
  @Test
  public void f1() 
  {
	  Assert.assertTrue(false);
  }
}
