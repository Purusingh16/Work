package FunctionLibrary;
import java.io.IOException;
import java.util.Map;


public class TestCaseReader {
	public String mstrTest_Desc;
	//public String mstrModuleName;
	
	public void getInfo(String mstrTestCaseName) throws IOException
	{
		String name;
		ExcelDataPoolManager oExcelFile = new ExcelDataPoolManager();
		Map rowData = null;
		int rowcount =oExcelFile.rowCount(Global.gstrModuleSuitFilePath+Global.gstrModuleName+".xls","Config File");
		for(int i=0;i<rowcount;i++)
		{
			rowData = oExcelFile.readExcelByRow(Global.gstrModuleSuitFilePath+Global.gstrModuleName+".xls","Config File" , i);
			name=rowData.get("TestCase").toString();
			if(name.equalsIgnoreCase(mstrTestCaseName))
			{
				mstrTest_Desc=rowData.get("TestCaseDescription").toString();
				//mstrModuleName=rowData.get("ModuleName").toString();
			}
		}
	}
}
