package FunctionLibrary;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;


public class Global {
	public static String gstrConfigFilesPath=null;
	public static String gstrDriverPath=null;
	public static String gstrFunctionLibraryPath=null;
	public static String gstrModuleFunctionLibraryPath=null;
	public static String gstrSuitFilePath=null;
	public static String gstrModuleSuitFilePath=null;
	public static String gstrModuleTestScriptPath=null;	
	public static String gstrModuleTestDataPath=null;	
	public static String gstrResultPath=null;
	public static String gstrTestCaseEditorPath=null;	
	public static String gstrRecoveryManagerPath=null;
	public static String gstrModuleRecoveryPath=null;
	public static String gstrRootPath=null;	
	public static String gstrModuleRootPath=null;
	public static String gstrModuleTestCasePath=null;
	public static int gintRowCount=0;
	public static int gintStepCount=0;
	public static List<String> gstrMachineIp=new ArrayList<String>();
	public static List<String> gstrBrowser=new ArrayList<String>();

	public static int gintMachineCount=0;	
	public static String gstrName,gstrProxy="localhost, 127.0.0.1";
	public static String gstrModuleName=null;
	public static int gintsummaryFlag=0;
	public static Calendar gCalenderCal_start; 
	public static String gstrStart_time;
	public static String gstrCompatibility;
	static DateFormat mObjDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	
	public static void cfnRootPath() throws Exception 
	{			
		File fs=new File("");
		String a=fs.getCanonicalPath();
		gstrRootPath=a;
		gstrRootPath=gstrRootPath+"/src";
	
		
		gstrRootPath=gstrRootPath.replace("\\", "/")+"/";
		gstrModuleRootPath=gstrRootPath+"Modules/";
		
		
		gstrConfigFilesPath =gstrRootPath+"ConfigFiles/";
	
		
		gstrDriverPath =gstrRootPath+"Driver/";
		
		
		gstrFunctionLibraryPath =gstrRootPath+"FunctionLibrary/";
	

		
		gstrSuitFilePath =gstrRootPath+"SuitFile/";
	
		gstrResultPath=gstrRootPath+"Result/";
	
		
		gstrTestCaseEditorPath=gstrRootPath+"TestCaseEditor/";
			
		
		gstrRecoveryManagerPath=gstrRootPath+"RecoveryManager/";
		gstrStart_time = mObjDateFormat.format(Calendar.getInstance().getTime());

	}

	
	
	public void cfnModuleRootPath() throws IOException 
	{	
		//System.out.println(gstrModuleRootPath);
		File f1=new File(Global.gstrResultPath+gstrModuleName);
		f1.mkdir();
		f1.setWritable(true);
		gstrModuleFunctionLibraryPath=gstrModuleRootPath+gstrModuleName+"/FunctionLibrary/";		
		
		gstrModuleSuitFilePath =gstrModuleRootPath+gstrModuleName+"/SuitFile/";	
		
		gstrModuleTestScriptPath =gstrModuleRootPath+gstrModuleName+"/TestScript/";	
		
		gstrModuleTestDataPath=gstrModuleRootPath+gstrModuleName+"/TestData/";				
		
		gstrModuleTestCasePath=gstrModuleRootPath+gstrModuleName+"/TestCase/";	

		gstrModuleRecoveryPath=gstrModuleRootPath+gstrModuleName+"/Recovery/";	
	

	}
	

	public void cfnConfigDeclaration() throws Exception
	{
		cfnRootPath();
		String mstrValName="";String mstrValValue="";
		String mstrValBrowser;
		try {

			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse (new File(gstrConfigFilesPath+"\\Config.xml"));

			// normalize text representation
			doc.getDocumentElement ().normalize ();

			NodeList listOfNodes = doc.getElementsByTagName("variable");
			for(int i=0; i<listOfNodes.getLength() ; i++){
				Node firstNode = listOfNodes.item(i);
				if (firstNode.getNodeType() == Node.ELEMENT_NODE) 
				{						 
					Element firstElement = (Element)firstNode;
					mstrValName = firstElement.getElementsByTagName("name").item(0).getTextContent(); 
					mstrValValue  = firstElement.getElementsByTagName("value").item(0).getTextContent();

					if(mstrValName.equalsIgnoreCase("Name"))
					{
						gstrName=mstrValValue;
					}
					else if(mstrValName.equalsIgnoreCase("Machine"))
					{
						gstrMachineIp.add(mstrValValue);
						gintMachineCount=gintMachineCount+1;
						mstrValBrowser = firstElement.getElementsByTagName("Browser").item(0).getTextContent(); 
						gstrBrowser.add(mstrValBrowser);
												
					}
					else if(mstrValName.equalsIgnoreCase("proxy"))
					{
						gstrProxy=mstrValValue;
					}
				}					
			}
		}catch (SAXParseException err) {
			System.out.println ("** Parsing error" + ", line " 
					+ err.getLineNumber () + ", uri " + err.getSystemId ());
			System.out.println(" " + err.getMessage ());

		}catch (SAXException e) {
			Exception x = e.getException ();
			((x == null) ? e : x).printStackTrace ();
		}catch (Throwable t) {
			t.printStackTrace ();
		}	
	}	
}
