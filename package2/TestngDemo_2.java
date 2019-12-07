package package2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestngDemo_2 {
  @Test
  public void test1() {
	  System.out.println("from TestngDemo_2 class test1");
  }
  
  @Test
  public void test2() {
	  System.out.println("from TestngDemo_2 class test2");
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("beforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("afterClass");
  }
  
}
