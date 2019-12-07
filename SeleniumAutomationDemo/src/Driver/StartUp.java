//------------Package Name----------------//
package Driver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

import FunctionLibrary.ExcelDataPoolManager;
import FunctionLibrary.Global;
import FunctionLibrary.HTML_Report;


//-------------MachineThread class---------------//
/**
 * The Class is built to create multiple threads to execute various testcases on multiple machine.
 * One Object owns one DriverClass Object
 * @author 
 */



class MachineThread extends Thread 
{
	String mstrTestCaseName;
	String mstrMachineAddress;
	String mstrBrowser;
	String mstrCompatibility;
	MachineThread(String TestCasename, String MachineIp,String Browser,String Compatibility)
	{
		mstrTestCaseName=TestCasename;
		mstrMachineAddress=MachineIp;
		mstrBrowser=Browser;
		mstrCompatibility=Compatibility;
	}


	/**
	 * The Funtion is built to Start threads to execute various testcases on multiple machine.
	 * @author 
	 */	



	public void run() 
	{
		try
		{
			//--------------------Assigning Driver to respective TestCase and Machine  
			StartUp.DriverObject[StartUp.mintAssigned]=new Driver();
			if(mstrCompatibility.equalsIgnoreCase("run"))
			{
				StartUp.DriverObject[StartUp.mintAssigned].cfnDriverCompatibility(mstrTestCaseName,mstrMachineAddress,mstrBrowser);
			}
			else
			{
				StartUp.DriverObject[StartUp.mintAssigned].cfnDriver(mstrTestCaseName,mstrMachineAddress,mstrBrowser);
			}
		}
		catch(Exception e)
		{
			//System.out.println("Error Occured");
			e.printStackTrace();
		}
	}
}








//-------------StartUp class---------------//
/**
 * The Class is built to start execution of Selenium Automation Framework 
 * this class reads .xls files and execute respective testcases 
 * @author 
 */


public class StartUp 
{	
	static String mstrTestCase;
	static int mintAssigned;
	static Driver[] DriverObject;
	static ExcelDataPoolManager oExcelFile = new ExcelDataPoolManager();
	static MachineThread[] gThrmachine;
	static DateFormat mObjDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	/**
	 * This function Initiate the execution of Frame work
	 * 
	 * 
	 */


	public static void main(String[] args) throws Exception {
		//------------- Declaration of Global Variable ------------
		Global obj=new Global();
		//------------- Declaration Of Global Variable in Config File-----------
		obj.cfnConfigDeclaration();
		Global.gCalenderCal_start= Calendar.getInstance();
		Global.gstrStart_time=mObjDateFormat.format(Global.gCalenderCal_start.getTime());

		int rowcount =oExcelFile.rowCount(Global.gstrSuitFilePath+"SuitFile.xls","Config File");
		Map rowData =null;
		int j;
		for (j=1; j<rowcount; j++)
		{
			//----------  Reading Excel Module Suit File On the Basis of Run Flag -------------
			rowData = oExcelFile.readExcelByRow(Global.gstrSuitFilePath+"SuitFile.xls","Config File" , j);
			String mstrRunFlag=rowData.get("RunStatus").toString();
			if(mstrRunFlag.equalsIgnoreCase("run"))
			{
				Global.gstrModuleName=rowData.get("ModuleName").toString();
				obj.cfnModuleRootPath();
				// Initiating The Batching Of Test scripts		
				StartUp obj2=new StartUp();
				obj2.cfnCallModule(Global.gstrModuleName);
			}

		}
		int stop=0;
		while(stop!=Global.gintMachineCount)
			for(int i=0;i<Global.gintMachineCount;i++)
			{
				if (gThrmachine[i].isAlive()==false)//all thread killed then
				{
					stop+=1;
					if(stop==Global.gintMachineCount)
					{
						//////////////////////////////CODE TO OPEN HTML FILE AT THE END OF EXECUTION
						HTML_Report.build_Automation_Summary();
						String mstrAutoSummPath=Global.gstrResultPath+"/Automation_summary.html";
						String cmds[] = new String[] {"cmd", "/c",mstrAutoSummPath};  
						Runtime.getRuntime().exec(cmds); 	break;
					}

				}
				else
					stop=0;
			}
		//HTML_Report.Clean_Record();
	}



	//------------cfnCallModule() function----------------//
	/**
	 * The aim of function is to read TestCase name from specific module and assign to restive Machine Thread 
	 * @param gstrModuleName Name Of the Module with respect to path has to be searched
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public  void cfnCallModule(String gstrModuleName) throws Exception 
	{
		//------------- Declaration Of Different Machine/ System For Parallel Execution-----------
		gThrmachine=new MachineThread[Global.gintMachineCount];
		//------------- Creation of Individual Driver For Each Machine------------
		DriverObject=new Driver[Global.gintMachineCount];
		//------------- Importing Suit File For Batch Execution ---------------
		ExcelDataPoolManager oExcelFile = new ExcelDataPoolManager();
		Map rowData = null;
		int rowcount =oExcelFile.rowCount(Global.gstrModuleSuitFilePath+Global.gstrModuleName+".xls","Config File");
		for (int i = 0; i < Global.gintMachineCount; i++)
		{
			gThrmachine[i]=new MachineThread("","","",""); // Intilaize Machine Thread With Default Value.  
		}		
		for (int j=1; j<rowcount; j++)
		{

			//----------  Reading Excel Suit File On the Basis of Run Flag -------------
			rowData = oExcelFile.readExcelByRow(Global.gstrModuleSuitFilePath+Global.gstrModuleName+".xls","Config File" , j);
			String mstrRunFlag=rowData.get("RunFlag").toString();
			String mstrComatibilityRunFlag=rowData.get("CompatibilityFlag").toString();
			mstrTestCase=rowData.get("TestCase").toString();
			if (mstrRunFlag.equalsIgnoreCase("run"))
			{
				Global.gintRowCount++;
				try
				{	mintAssigned=0;				
				while(true)
				{	
					if(gThrmachine[mintAssigned].isAlive()==false)
					{	
						if(mstrComatibilityRunFlag.equalsIgnoreCase("run"))
						{
							System.out.println("Thread "+(mintAssigned+1)+" is Executing on Machine "+Global.gstrMachineIp.get(mintAssigned)+" For test Case "+mstrTestCase);

							//--------------------Assigning task to thread if it is ideal 
							gThrmachine[mintAssigned]=new MachineThread(mstrTestCase,Global.gstrMachineIp.get(mintAssigned),Global.gstrBrowser.get(mintAssigned),"run");
							gThrmachine[mintAssigned].start();							
							break;	
						}
						else
						{
							System.out.println("Thread "+(mintAssigned+1)+" is Executing on Machine "+Global.gstrMachineIp.get(mintAssigned)+" For test Case "+mstrTestCase);

							//--------------------Assigning task to thread if it is ideal 
							gThrmachine[mintAssigned]=new MachineThread(mstrTestCase,Global.gstrMachineIp.get(mintAssigned),Global.gstrBrowser.get(mintAssigned),"NO");
							gThrmachine[mintAssigned].start();							
							break;

						}
					}						
					else
						mintAssigned++;

					if(mintAssigned == Global.gintMachineCount)
					{
						mintAssigned=0;
					}
				}				
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}	
		}

		//This loop will stop execution of new module before previous module Completed
		int stop=0;
		while(stop!=Global.gintMachineCount)
			for(int i=0;i<Global.gintMachineCount;i++)
			{
				if (gThrmachine[i].isAlive()==false)//all thread killed then
				{
					stop+=1;
					if(stop==Global.gintMachineCount)
					{
						//System.out.println("Wait for module to end");
						//wait till all thread of module complete there task
						break;
					}

				}
				else
					stop=0;
			}
	}
}//End Of StartUp Class
