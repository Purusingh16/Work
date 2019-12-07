package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelReader
{
	private HSSFWorkbook workbook=null;

	
	public String[][] readData(String filePath, String sheetName)
	{
		String data[][]=null;
		openFile(filePath);
		HSSFSheet sheet=getSheet(sheetName);
		int rowCount=getRowCount(sheet);
		
		int colCount=0;
		HSSFRow row=null;
		
		row=getRow(sheet, 0);
		colCount=getColumnCount(row);
		data=new String[rowCount][colCount];
		
		for(int rowIndex=0;rowIndex<rowCount;rowIndex++)
		{
			row=getRow(sheet, rowIndex);
			colCount=getColumnCount(row);
			
			for(int colIndex=0;colIndex<colCount;colIndex++)
			{
				data[rowIndex][colIndex]=getColumnValue(row, colIndex);
			}
		}
		
		closeFile();
		return data;
	}
	
	private void openFile(String filePath)
	{
		FileInputStream file;
		try 
		{
			file = new FileInputStream(filePath);
			workbook=new HSSFWorkbook(file);
			
		}
		catch (FileNotFoundException e)
		{
			
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
	}
	private void closeFile()
	{
		try 
		{
			workbook.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	 private HSSFSheet getSheet(String sheetName) 
	 {
		 return workbook.getSheet(sheetName);
	 }
	private int getRowCount(HSSFSheet sheet)
	{
		return sheet.getPhysicalNumberOfRows();
	}
	
	private HSSFRow getRow(HSSFSheet sheet,int index)
	{
		return sheet.getRow(index);
	}
	
	private String getColumnValue(HSSFRow row, int colIndex)
	{
		
		if( row.getCell(colIndex).getCellType()==HSSFCell.CELL_TYPE_NUMERIC)
			return row.getCell(colIndex).getNumericCellValue()+"";
		else if(row.getCell(colIndex).getCellType()==HSSFCell.CELL_TYPE_BOOLEAN)
			return row.getCell(colIndex).getBooleanCellValue()+"";
		else if(row.getCell(colIndex).getCellType()==HSSFCell.CELL_TYPE_STRING)
			return row.getCell(colIndex).getStringCellValue();
		else
			return "";
	}
	
	private int getColumnCount(HSSFRow row)
	{
		return row.getPhysicalNumberOfCells();
	}
	
	public static void main(String[] args)
	{
		/*ExcelReader reader=new ExcelReader();
		String st[][]=reader.readData("dataFiles/Users.xls");
		for (String[] rows : st) {
			for (String col : rows) {
				System.out.println(col);
			}
		}*/
	}

}
