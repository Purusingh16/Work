package package2;


import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameteriseDemo {
  @Parameters("browserName")
  @Test
  public void testOne(String browserName) {
	 /* WebDriver driver=null;
	  if(browserName.equalsIgnoreCase("Firefox"))
	   driver=new FirefoxDriver();*/
		System.out.println("browser name from method testOne:- "+browserName);
  }
  
  @Parameters("os name")
  @Test
  public void testTwo(@Optional("Windows") String osName) {
		System.out.println("osName name from method testOne:- "+osName);
  }
}
