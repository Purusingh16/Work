package testScripts;

import org.testng.annotations.Test;

import utils.ExcelReader;

import org.testng.annotations.DataProvider;

public class NewTest {
  @Test(dataProvider = "getData")
  public void f(String username, String password) {
	  System.out.println("username"+username+"password"+password);
  }

  @DataProvider
  public Object[][] getData() {
	  ExcelReader reader=new ExcelReader();
	  Object[][] data=reader.readData("F:\\Work\\seleniumTest_2\\src\\test\\resources\\dataFiles\\Users.xls", "details");
	  return data;
  }
}
