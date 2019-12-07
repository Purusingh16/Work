package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	public static void main(String[] args) throws IOException 
	{
		FileInputStream fiS=new FileInputStream("F:\\Work\\DemoSeleniumCG\\fixture\\FirstExcel.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fiS);
		int sheet=workbook.getNumberOfSheets();
		for (int i = 0; i < sheet; i++) {
			
			if(workbook.getSheetName(i).equalsIgnoreCase("Dummy"))
					{
						XSSFSheet sheetIndex=workbook.getSheetAt(i);
					}
			
			
		}
		
	}

}
