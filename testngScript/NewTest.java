package testngScript;

import org.testng.annotations.Test;

import fileHandling.ExcelReader;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import utilities.*;

public class NewTest {
	
 /* @Test(dataProvider="userData", dataProviderClass=DataProviderTestng.class)
  public void printExcelData(String first,String second) {
	  System.out.print(first+" "+second);
	  System.out.println();
  }*/
  
  @ExcelFilePath(path="dataFiles/Users.xls", sheetName="details",toRow=3)
  @Test(dataProvider="userData")
  public void printExcelData(String first,String second) {
	  System.out.print(first+" "+second);
	  System.out.println();
  }
  
 /*@BeforeMethod
 public void setDataRow()
 {
	 DataProviderTestng.indexFrom=1;
	 DataProviderTestng.indexTo=2;
 }*/
  

  @DataProvider(name="userData")
	public Object[][] getData(Method testMethod) {
	  ExcelFilePath parameters = testMethod.getAnnotation(ExcelFilePath.class);
	  String path=parameters.path();
	  String sheetName=parameters.sheetName();
	  int fromRow=parameters.fromRow();
	  int toRow=parameters.toRow();
	  ExcelReader reader=new ExcelReader();
		Object[][] arrayObject = reader.readData(path,sheetName);
		return java.util.Arrays.copyOfRange(arrayObject, fromRow, toRow);
		//return arrayObject;
	}

}
