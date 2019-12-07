package read_data_from_excel_using_col_num;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData
{

	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis;
		try {
			fis = new FileInputStream("TestData/TestData.xlsx");
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			XSSFSheet sheet=workbook.getSheet("Credential");
			XSSFRow row=sheet.getRow(0);
//			XSSFCell cell=row.getCell(3);
			
			XSSFCell cell=null;
			
			int colNum=-1;
			
			for(int i=0; i<row.getFirstCellNum();i++)
			{
				if(row.getCell(i).getStringCellValue().trim().equals("PassWord"));
				colNum=i;
			}
			row=sheet.getRow(1);
			cell=row.getCell(colNum);
			String PassWord=String.valueOf(cell.getStringCellValue());
//			String value=String.valueOf(cell.getStringCellValue());
//			String value=String.valueOf(cell.getNumericCellValue());
			System.out.println("Value of the Excel cell is:"+PassWord);
			
		} catch (FileNotFoundException e) 
		{
			
		// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		
	}

}
