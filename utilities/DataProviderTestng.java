package utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import fileHandling.ExcelReader;

public class DataProviderTestng {
	private static int indexFrom=0;
    private static int indexTo=1;
    
    @DataProvider(name = "userData")
    public static Object[][] userData(Method testMethod) {
    	
    	ExcelReader reader=new ExcelReader();
		Object[][] arrayObject = reader.readData("dataFiles/Users.xls","details");
		String methodName=testMethod.getName();
		if(methodName.equalsIgnoreCase("printExcelData"))
			{
				System.out.println(methodName);
				indexFrom=0;
				indexTo=1;
			}
		return java.util.Arrays.copyOfRange(arrayObject, indexFrom, indexTo);
    }

    
}
