package excelFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) 
	{
		try {
			// Specify the path of file
			File file=new File("files//Book1.xlsx");
			// load file
			FileInputStream fis=new FileInputStream(file);
			// Load workbook
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			// Load sheet- Here we are loading first sheetonly
//			XSSFSheet xssfSheet=workbook.getSheetAt(0);
			XSSFSheet xssfSheet=workbook.getSheetAt(0);
			// getRow() specify which row we want to read.
			// and getCell() specify which column to read.
			// getStringCellValue() specify that we are reading String data.
			System.out.println(xssfSheet.getRow(0).getCell(0).getStringCellValue());
			System.out.println(xssfSheet.getRow(0).getCell(1).getStringCellValue());
			System.out.println(xssfSheet.getRow(1).getCell(0).getStringCellValue());
			System.out.println(xssfSheet.getRow(1).getCell(1).getStringCellValue());
			System.out.println(xssfSheet.getRow(2).getCell(0).getStringCellValue());
			System.out.println(xssfSheet.getRow(2).getCell(1).getStringCellValue());
			System.out.println(xssfSheet.getRow(3).getCell(0).getStringCellValue());
			System.out.println(xssfSheet.getRow(3).getCell(1).getStringCellValue());
			System.out.println(xssfSheet.getRow(4).getCell(0).getStringCellValue());
			System.out.println(xssfSheet.getRow(4).getCell(1).getStringCellValue());
			System.out.println(xssfSheet.getRow(5).getCell(0).getStringCellValue());			
			System.out.println(xssfSheet.getRow(5).getCell(1).getStringCellValue());
			
			xssfSheet.getRow(0).createCell(2).setCellValue("ByName");
			xssfSheet.getRow(1).createCell(2).setCellValue("Capital");
			xssfSheet.getRow(2).createCell(2).setCellValue("Bollywood");
			xssfSheet.getRow(3).createCell(2).setCellValue("TajMahal");
			xssfSheet.getRow(4).createCell(2).setCellValue("Bitch");
			xssfSheet.getRow(5).createCell(2).setCellValue("Famous Place");

			FileOutputStream fout=new FileOutputStream(new File("files//Book1.xlsx"));
			workbook.write(fout);
			fout.close();
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

}
