package testNGFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BeforeAndAfterClass 
{
	 @BeforeSuite
	  public void beforeSuite() 
	  {
		  System.out.println("In before suite method");
	  }

	  @AfterSuite
	  public void afterSuite()
	  {
		  System.out.println("In after suite method");
	  }
	  @BeforeTest
	  public void beforeTest()
	  {
		  System.out.println("In Before test method");
	  }

	  @AfterTest
	  public void afterTest() 
	  {
		  System.out.println("In After test method");
	  }
	  @BeforeClass
	  public void beforeClass()
	  {
		  System.out.println("In Before class method");
	  }

	  @AfterClass
	  public void afterClass() 
	  {
		  System.out.println("In After class method");
	  }
	  @BeforeGroups(groups={"firstGroup"})
	  public void beforeFirstGroup()
	  {
		  System.out.println("In Before First Group Method");
	  }
	  @AfterGroups(groups={"firstGroup"})
	  public void afterFirstGroup()
	  {
		  System.out.println("In After First Group Method");
	  }
	  @BeforeGroups(groups={"secondGroup"})
	  public void beforeSecondGroup()
	  {
		  System.out.println("In Before Second Group Method");
	  }
	  @AfterGroups(groups={"secondGroup"})
	  public void afterSecondGroup()
	  {
		  System.out.println("In After Second Group Method");
	  }
	  @BeforeMethod
	  public void beforeMethod()
	  {
		  System.out.println("In BeforeMethod Method");
	  }

	  @AfterMethod
	  public void afterMethod() 
	  {
		  System.out.println("in AfterMethod Method");
	  }
	  
	  @Test(groups={"firstGroup"})
	  public void firstGroupMethodOne()
	  {
		  System.out.println("In Test method one of firstGroup");
	  }
	  @Test(groups={"firstGroup"})
	  public void firstGroupMethodTwo()
	  {
		  System.out.println("In Test method two of firstGroup");
	  }
	  @Test(groups={"secondtGroup"})
	  public void secondGroupMethodOne()
	  {
		  System.out.println("In Test method one of secondGroup");
	  }
	  @Test(groups={"secondGroup"})
	  public void secondGroupMethodTwo()
	  {
		  System.out.println("In Test method two of secondGroup");
	  }
}