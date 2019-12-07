package keyWordDrivenFrameWork;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonFunctions 
{

	public static String navigate_to(WebDriver driver,String url)
	{
		//set implicit and page load time outs
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get(url);
		driver.manage().window().maximize();
		return null;
	}
	public static String sendKeys(WebDriver webdriver, String strLocType,String strLocValue,String Param1) throws InterruptedException
	{
		switch (strLocType) 
		{
		case "id":
			webdriver.findElement(By.id(strLocValue)).sendKeys(Param1);
			break;
		case "xpath":
			webdriver.findElement(By.xpath(strLocValue)).sendKeys(Param1);
			break;
		case "linkText":
			webdriver.findElement(By.linkText(strLocValue)).sendKeys(Param1);
			break;
		
			default:
			break;
		}
		Thread.sleep(5000);
		return null;
	}
	public static String click_element(WebDriver webdriver, String strLocType,String strLocValue) throws InterruptedException
	{
		switch (strLocType) 
		{
		case "id":
			webdriver.findElement(By.id(strLocValue)).click();
			break;
		case "xpath":
			webdriver.findElement(By.xpath(strLocValue)).click();
			break;
		case "linkText":
			webdriver.findElement(By.linkText(strLocValue)).click();
			break;
		
			default:
			break;
		}
		Thread.sleep(5000);
		return null;
	}
	public static void quite_driver(WebDriver webdriver)
	{
		webdriver.quit();
	}
	public static String[][] FetchDataFromExcel(String path) throws Exception
	{
		File file=new File("F:\\Work\\java\\selenium_Learning\\TestData\\blablablacar for keydriven.xlsx");
		FileInputStream fileInputStream=new FileInputStream(file);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet xssfSheet=xssfWorkbook.getSheet("Sheet1");
		int rowNum=xssfSheet.getLastRowNum()+1;
		int colNum=xssfSheet.getRow(0).getLastCellNum();
		String[][] data=new String[rowNum][colNum];
		for (int i = 0; i < rowNum; i++)
		{
			XSSFRow row=xssfSheet.getRow(i);
			for (int j = 0; j < colNum; j++)
			{
				XSSFCell cell=row.getCell(j);
				String value=cellToString(cell);
				data[i][j]=value;
//				System.out.println(value);
			}
		
		}
		xssfWorkbook.close();
		fileInputStream.close();
		return data;
	}
	private static String cellToString(XSSFCell cell)
	{
		Object result;
		String strReturn=null;
		if (cell==null)
		{
			strReturn="";
		}
		else 
		{
			switch (cell.getCellType()) 
			{
			case Cell.CELL_TYPE_NUMERIC:
				result=(int)cell.getNumericCellValue();
				strReturn=result.toString();
				break;
			case Cell.CELL_TYPE_STRING:
				result=cell.getStringCellValue();
				strReturn=result.toString();
				break;

			default:
				strReturn=null;
			}
		}
		return strReturn;
	}
	

}
