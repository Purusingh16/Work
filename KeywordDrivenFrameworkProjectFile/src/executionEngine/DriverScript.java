package executionEngine;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;

import config.ActionKeywords;
import config.Constants;
import utility.ExcelUtils;
import utility.Log;

public class DriverScript {
	
	public static Properties OR;
	public static ActionKeywords actionKeywords;
	public static String sActionKeyword;
	public static String sPageObject;
	public static Method method[];
	
	public static int iTestStep;
	public static int iTestLastStep;
	public static String sTestCaseID;
	public static String sRunMode;	
	public static String sData;
	public static boolean bResult;
	
	private WebDriver driver;
	
	public DriverScript() throws NoSuchMethodException, SecurityException
	{

		actionKeywords=new ActionKeywords();
		method=actionKeywords.getClass().getMethods();	
	}
	
    public static void main(String args[]) throws Exception
    {
	 String Path_DataEngine =Constants.Path_TestData;
	  
	  ExcelUtils.setExcelFile(Constants.Path_TestData);
	  
	  DOMConfigurator.configure("log4j.xml");
	  
	  String Path_OR=Constants.Path_OR;
	  
	  FileInputStream fis=new FileInputStream(Path_OR);

	  OR=new Properties(System.getProperties());
	  
	  OR.load(fis);
	  
	  DriverScript startEngine=new DriverScript();
	  startEngine.excute_TestCase();
    }
    
    public void excute_TestCase() throws Exception {
    	
    	int iTotalTestCases=ExcelUtils.getRowCount(Constants.Sheet_TestSteps);
    	System.out.println("iTotalTestCases "+iTotalTestCases);
    	
    	for(int iTestCase=1;iTestCase<=iTotalTestCases;iTestCase++)
    	{
    		System.out.println("Values,.,,,.");
    		bResult=true;
    		sTestCaseID=ExcelUtils.getCellData(iTestCase, Constants.Col_TestCaseID, Constants.Sheet_TestCases);
    		System.out.println("TestCases----"+sTestCaseID);

    		sRunMode=ExcelUtils.getCellData(iTestCase, Constants.Col_RunMode, Constants.Sheet_TestCases);
    		System.out.println("RunMode Values+++"+sRunMode);
    		if(sRunMode.equals("Yes"))
    		{
                System.out.println("Yes Mode");
    			iTestStep=ExcelUtils.getRowContains(sTestCaseID, Constants.Col_TestCaseID, Constants.Sheet_TestSteps);
    			 System.out.println("Data...."+iTestStep);
    		    iTestLastStep=ExcelUtils.getTestStepsCount(Constants.Sheet_TestSteps, sTestCaseID, iTestStep);
    		    System.out.println("Data.1414"+ iTestLastStep);
    		    Log.startTestCase(sTestCaseID);
    		    bResult=true;
    		    for(iTestStep=1;iTestStep<=iTestLastStep;iTestStep++)
    		    {
    		    	//System.out.println("TestStep Data");
    		    	sActionKeyword=ExcelUtils.getCellData(iTestStep, Constants.Col_ActionKeyword, Constants.Sheet_TestSteps);
    		    	//  System.out.println("Data"+sActionKeyword);
    		    	sPageObject=ExcelUtils.getCellData(iTestStep, Constants.Col_PageObject, Constants.Sheet_TestSteps);
    		    	  //System.out.println("Data"+ sPageObject);
    		    	
    		    	excute_Actions();
    		    	
    		    	if(bResult==false)
    		    	{
    		    		System.out.println("Result Data");
    		    		ExcelUtils.setCellData(Constants.KEYWORD_FAIL,iTestCase, Constants.Col_Result, Constants.Sheet_TestCases);
    		    		System.out.println("Result Data");
    		    		Log.endTestCase(sTestCaseID);
    		    		break;
    		    	}
    		    }
    		    if(bResult==true)
    		    {
    		    	
    		    ExcelUtils.setCellData(Constants.KEYWORD_PASS, iTestCase, Constants.Col_Result, Constants.Sheet_TestCases);
    		    System.out.println("sassad");
    		    Log.endTestCase(sTestCaseID);
    		}
    		    
    		}

    		
    	}
		
	}

	public static void excute_Actions() throws Exception
    {
    	for(int j=0;j<method.length;j++)
    	{
    	  
    		if(method[j].getName().equals(sActionKeyword))
    		{
    			
    			method[j].invoke(actionKeywords,sPageObject,sData);
    			System.out.println("Method");
    			
    			if(bResult==true)
    			{
    				 System.out.println("Daaa");
    				ExcelUtils.setCellData(Constants.KEYWORD_PASS, iTestStep, Constants.Col_TestStepResult,Constants.Sheet_TestSteps);
    				System.out.println("Data of Result");
    				break;
    			}
    			else
    			{
    			  ExcelUtils.setCellData(Constants.KEYWORD_FAIL, iTestStep, Constants.Col_TestStepResult, Constants.Sheet_TestSteps);
    				System.out.println("Methd------");
    			  ActionKeywords.closeBrowser("", "");
    			break;
    			}
    		}
	  }
    }
		
}