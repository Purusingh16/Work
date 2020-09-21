package com.cg.test;

import java.io.File;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class UtilClass {
	
	public static Object[][] getData()
	{
		// C:\Users\richeriy
		// Workbook-->File
		//Sheet----> Excel sheet
		//Rows-----> a row in a sheet
		//Cells---->Columns in rows
		try {
			Workbook file=WorkbookFactory.create(new File("C:\\Work\\TestNGRestAssuredFrameWork\\fixture\\worksheet.xlsx"));
			Sheet sheet=file.getSheetAt(1);
			int rowCount=sheet.getLastRowNum();
			int colCount=sheet.getRow(0).getLastCellNum();
			Object[][]obj=new Object[rowCount][colCount];
			for(int i=0;i<rowCount;i++){
				for(int j=0;j<colCount;j++)
				{
					obj[i][j]=sheet.getRow(i+1).getCell(j).toString();
				}
			}
			
			return obj;
			
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
