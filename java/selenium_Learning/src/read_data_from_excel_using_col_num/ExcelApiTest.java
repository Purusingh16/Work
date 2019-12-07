package read_data_from_excel_using_col_num;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

public class ExcelApiTest 
{
	public FileInputStream fis=null;
	public XSSFWorkbook workbook=null;
	public XSSFSheet sheet=null;
	public XSSFRow row=null;
	public XSSFCell cell=null;
	
	public ExcelApiTest(String xlfilepath) throws Exception
	{
		fis=new FileInputStream(xlfilepath);
		workbook=new XSSFWorkbook(fis);
		fis.close();
	}
	public String getCellData(String sheetName,int colNum,int rowNum)
	{
		
		
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		cell=row.getCell(colNum);
		
		
//		if (cell.getCellType()-)
//			return cell.getStringCellValue();
		return sheetName;
		
		
		
		
	}

}
