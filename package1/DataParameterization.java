package package1;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataParameterization {
  @Test(enabled=false)
  @Parameters({"browserName","url"})
  public void test(String browserName, String url) {
	  System.out.println(browserName);
	  System.out.println(url);
  }
  

}
