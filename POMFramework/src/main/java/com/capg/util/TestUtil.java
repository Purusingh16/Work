package com.capg.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;



public class TestUtil {
	
	public static Object[][] getData(String path,String sheetname)
	{
		FileInputStream fis=null;
		Object obj[][]=null;
		try
		{
			//fis=new FileInputStream(sheetname);
			Workbook book=WorkbookFactory.create(new File(path));
			Sheet sheet=book.getSheet(sheetname);
			obj=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for(int i=0;i<sheet.getLastRowNum();i++)
			{
				for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
				{
					obj[i][j]=sheet.getRow(i+1).getCell(j).toString();
				}
					
			}
			
		}
		catch (IOException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
	}

}
