package testNG5;

public class ReadExcelData 
{
	public static void main(String[] args) 
	{
		ExcelDataConfig excelDataConfig=new ExcelDataConfig("files/ExcelReadData.xlsx");
		
		System.out.println(excelDataConfig.getData(0, 0, 1));

	}

}
