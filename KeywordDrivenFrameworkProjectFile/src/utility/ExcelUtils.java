package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import config.Constants;
import executionEngine.DriverScript;

public class ExcelUtils {
    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static org.apache.poi.ss.usermodel.Cell Cell;
    private static XSSFRow Row;
    //private static XSSFRow Row;

public static void setExcelFile(String Path) throws Exception {
	try {
        FileInputStream ExcelFile = new FileInputStream(Path);
        ExcelWBook = new XSSFWorkbook(ExcelFile);
        System.out.println("saaa.."+ExcelWBook);
	} catch (Exception e){
		Log.error("Class Utils | Method setExcelFile | Exception desc : "+e.getMessage());
		DriverScript.bResult = false;
    	}
	}

public static String getCellData(int RowNum, int ColNum, String SheetName ) throws Exception{
    try{
    	ExcelWSheet = ExcelWBook.getSheet(SheetName);
       	Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
       
        String CellData = Cell.getStringCellValue();
    	System.out.println("Cell value"+CellData);
        return CellData;
     }catch (Exception e){
         Log.error("Class Utils | Method getCellData | Exception desc : "+e.getMessage());
         DriverScript.bResult = false;
         return"";
         }
     }

public static int getRowCount(String SheetName){
	int iNumber=0;
	try {
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		iNumber=ExcelWSheet.getLastRowNum()+1;
		System.out.println("Rows...."+iNumber);
	} catch (Exception e){
		Log.error("Class Utils | Method getRowCount | Exception desc : "+e.getMessage());
		DriverScript.bResult = false;
		}
	return iNumber;
	}

public static int getRowContains(String sTestCaseName, int colNum,String SheetName) throws Exception{
	int iRowNum=0;	
	try {
	    ExcelWSheet = ExcelWBook.getSheet(SheetName);
		int rowCount = ExcelUtils.getRowCount(SheetName);
		for (iRowNum=0; iRowNum<rowCount; iRowNum++){
			
			System.out.println("RowCounts==="+rowCount);
			if  (ExcelUtils.getCellData(iRowNum,colNum,SheetName).equalsIgnoreCase(sTestCaseName)){
				break;
			}
		}       			
	} catch (Exception e){
		Log.error("Class Utils | Method getRowContains | Exception desc : "+e.getMessage());
		DriverScript.bResult = false;
		}
	return iRowNum;
	}

public static int getTestStepsCount(String SheetName, String sTestCaseID, int iTestCaseStart) throws Exception{
	try {
		for(int i=iTestCaseStart;i<=ExcelUtils.getRowCount(SheetName);i++){
			System.out.println("adsfegfygaew"+iTestCaseStart);
			if(!sTestCaseID.equals(ExcelUtils.getCellData(i, Constants.Col_TestCaseID, SheetName))){
			
				int number = i;
				System.out.println("not required"+number);
				return number;      				
				}
			}
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		int number=ExcelWSheet.getLastRowNum()+1;
		
		System.out.println("preeeee=="+number);
		return number;
	} catch (Exception e){
		Log.error("Class Utils | Method getRowContains | Exception desc : "+e.getMessage());
		DriverScript.bResult = false;
		return 0;
    }
}

@SuppressWarnings("static-access")
public static void setCellData(String Result,  int RowNum, int ColNum, String SheetName) throws Exception    {
       try{

    	   ExcelWSheet = ExcelWBook.getSheet(SheetName);
           Row  = ExcelWSheet.getRow(RowNum);
           Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
           System.out.println("Cell-------------"+Cell);
           if (Cell == null) {
        	   Cell = Row.createCell(ColNum);
        	   Cell.setCellValue(Result);
        	   System.out.println("Cell of values-0-0-0-"+Cell);
            } else {
                Cell.setCellValue(Result);
            }
             FileOutputStream fileOut = new FileOutputStream(Constants.Path_TestData);
             ExcelWBook.write(fileOut);
             System.out.println("File data"+fileOut);
             //fileOut.flush();
             fileOut.close();
             ExcelWBook = new XSSFWorkbook(new FileInputStream(Constants.Path_TestData));
         }catch(Exception e){
        	 DriverScript.bResult = false;

         }
    }

}