package package1;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestngDemo_1 {
	@Test
	  public void test1() {
		  System.out.println("from TestngDemo_1 class test1");
		  Assert.assertEquals(true, false);
	  }
	  
	  @Test
	  public void test2() {
		  System.out.println("from TestngDemo_1 class test2");
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("beforeMethod");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("afterMethod");
	  }
}
