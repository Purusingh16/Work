package selenium_Scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class ExcelReader
{
	public static void main(String[] args) throws IOException 
	{
		FileInputStream file;
		try {
			 file=new FileInputStream("files/User.xls");
			HSSFWorkbook workbook=new HSSFWorkbook(file);
			HSSFSheet sheet=workbook.getSheet("Sheet1");
			HSSFRow row=sheet.getRow(0);
			HSSFCell cell=row.getCell(0);
			System.out.println(cell.getStringCellValue());
			cell=row.getCell(1);
			System.out.println(cell.getStringCellValue());
			row=sheet.getRow(1);
			cell=row.getCell(0);
			System.out.println(cell.getStringCellValue());
			cell=row.getCell(1);
			System.out.println(cell.getStringCellValue());
			
			row=sheet.getRow(2);
			cell=row.getCell(1);
//			if(cell.getCellComment()==Cell.CELL_TYPE_STRING)
				
			System.out.println(cell.getNumericCellValue());
			
			
			/*FileOutputStream out=new FileOutputStream("files/User.xls");
			sheet=workbook.createSheet("login1");
			row=sheet.createRow(0);
			cell=row.createCell(0);
			cell.setCellValue("LoginName");
			
			cell=row.createCell(1);
			cell.setCellValue(10);
			
			sheet.autoSizeColumn(0);
			sheet.autoSizeColumn(1);
			
			
			workbook.write(out);
			out.close();
			workbook.close();*/
			
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}

	public Object[][] readData(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}

	
}


