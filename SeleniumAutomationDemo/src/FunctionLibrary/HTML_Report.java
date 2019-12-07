package FunctionLibrary;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class HTML_Report {
	public WebDriver webdriver ;
	public static String mstrAppendString;
	public int mintSummaryCount=0;
	public int mintDetailCount=0,mintSubStepNo=0,mintPassed=0,mintFailed=0,mintWarnings=0,mintStepNo=0;
	static FileWriter mObjFW0;
	public static ArrayList<String> mlistTC_Seq=new ArrayList<String>();
	public int ic=0;
	static DateFormat mObjDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Calendar mstrCalender_strt = Calendar.getInstance();
	String mstrStartTime=mObjDateFormat.format(mstrCalender_strt.getTime());
	static Date mDateToday=new Date();
	static String gstrAssignedTo="Preeti Malkar";
	static String gstrCountryName="Singapore";

	public static String strt_tym;
	public String mstrTC_Name;
	public String mstrTC_Desc;
	public String mstrModuleName;
	int mintMasterStepNo=0;
	public String detail_strt_tym;
	public static Calendar cal_strt;
	public static Calendar cal_end;
	public static int mintstarttimecounter=0;

	public HTML_Report(WebDriver webdriver) {
		this.webdriver=webdriver;
	}

	public void init_detail_TC_report(String Test_Case,String TC_Desc) throws Exception {

		int i,flag=0;

		for(i=0;i<mlistTC_Seq.size();i++)
		{
			if(mlistTC_Seq.get(i).equals(this.mstrTC_Name))
			{
				flag=1;

			}

		}
		if(flag==0)
			mlistTC_Seq.add(this.mstrTC_Name);


		Calendar cal_strt = Calendar.getInstance();
		detail_strt_tym=mObjDateFormat.format(cal_strt.getTime());
		CSS_StyleSheet.write_StyleSheet(Global.gstrResultPath+this.mstrModuleName+"/"+this.mstrTC_Name+".html");
		FileWriter f1;
		f1=new FileWriter(Global.gstrResultPath+this.mstrModuleName+"/"+this.mstrTC_Name+".html",true);

//		String mstrTop_img="\n</head><table align=center width=900px><tr><td width=900px><img src=\"../Images/Top_Logo.GIF\" style='width: -moz-available; height: 50px;'></td></tr></table>";
		String mstrTop_img="<div class='container'> <table align=center><tr><td ><img src=\"./../Images/top.png\" class='img-responsive img-rounded'> </td></tr></table>";
		f1.append(mstrTop_img);

		String detail_header="<title>PlatformX Solutions --> Detail Test Case Report</title><header> "
				+ "<div class='row container' align=center> <div class='row' align=center>"
				+ "<div class='col-md-12'> <h2>PlatformX Solutions --> Detail Test Case Report</h2> </div>"
				+ "</div></header>";
		
		f1.append(detail_header);
		String mstrBottom_img="<table align=center><tr><td ><img src=\"./../Images/bottom.png\" class='img-responsive img-rounded'> </td></tr></table> </div><BR>>";

		f1.append(mstrBottom_img);

		String detail_hd_table="<div class='container'><table align=center class='table table-curved'>"
				+ "<tr><th class='tblrow'>Test Case: </th><th> "+Test_Case+"</th>"
				+ "<th class='tblrow'>Test Description: </th><th>"+TC_Desc+"</th>"
				+ "</tr></table></div><BR>";

		f1.append(detail_hd_table);

		mstrAppendString="<div class='container'>"
				+ "<table class='tblrow table-curved' style='height:40px; width:230px;' >"
				+ "<tr><td align=center><a class='pltfontclr' href='../Automation_summary.html'>"
				+ "<b>Back to Automation Summary</a></tr></td></table></div>";
		
//		mstrAppendString="<button class='btn tblrow'><a href=\"../Automation_summary.html\"><b>Back to Automation Summary</a></button><br>";
		f1.append(mstrAppendString);

		mstrAppendString="<br><div class='container'>"
				+ "<table class='table table-curved table-striped'>"
				+ "<tr class='tblrow table-curved'>"
				+ "<th class='tblrow'>Step#</th>"
				+ "<th class='tblrow'>Step Descritption</th>"
				+ "<th class='tblrow'>Expected Result</th>"
				+ "<th class='tblrow'>Actual Result</th>"
				+ "<th class='tblrow'>Status</th>"
				+ "<th class='tblrow'>Screen Shot</th></tr>";
		f1.append(mstrAppendString);

		f1.close();
	}	
	public String createTimeStampStr() throws Exception {
		Calendar mycalendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_hhmmss");
		String timeStamp = formatter.format(mycalendar.getTime());

		return timeStamp;

	}
	public void details_append(String step_desc,String Exp_Res,String Act_Res,String Status) throws Exception
	{
		///*************************************************
		//Captures screenshot for calling step
		//*************************************************
		Thread.sleep(2000);

		String imgPath = "ScreeenShots/"+this.mstrModuleName+"/"+this.mstrTC_Name+"_"+ createTimeStampStr() + ".jpg";
		String screenShotPath=Global.gstrResultPath+imgPath;
		//String screenShotPath="C:\\Users\\A635175\\workspace\\AppiumDemo\\src\\Result\\"+imgPath;
		File srcFile=((RemoteWebDriver) webdriver).getScreenshotAs(OutputType.FILE);
	    String filename=UUID.randomUUID().toString(); 
	    //File targetFile=new File(screenShotPath + filename +".jpg");
	    File targetFile=new File(screenShotPath);
	    FileUtils.copyFile(srcFile,targetFile);
		//==================================================
		FileWriter f1;
		mintDetailCount++; //Counts the call to this function frmo individual test case

		f1=new FileWriter(Global.gstrResultPath+this.mstrModuleName+"/"+this.mstrTC_Name+".html",true);

		if(mintDetailCount==1){

			init_detail_TC_report(this.mstrTC_Name,mstrTC_Desc);
		}

		if(Act_Res.equals("")&& Status.equals(""))
		{
			mintStepNo++;
			mintMasterStepNo=0;
			mintSubStepNo=0;
			mstrAppendString="<tr><td>"+mintStepNo+"</td>"
					+ "<td>"+step_desc+"</td>"
					+ "<td>"+Exp_Res+"</td><td></td><td><b><font size = 2 color = green></td><td></td></tr>";
			f1.append("\n"+mstrAppendString);
		}

		else
		{
			mintSubStepNo++;

			if(Status.equalsIgnoreCase("PASS"))
			{

				//				mstrAppendString="<script>var txt='<tr><td width=70px class=tsindlevel2>"+mintStepNo+"."+mintSubStepNo+"</td><td width=300px class=tsgen>"+step_desc+"</td><td width=70px class=tsgen>"+Exp_Res+"</td><td width=70px class=tsgen>"+Act_Res+"</td><td width=70px align=center class=tsgen><b><font size = 2 color = green>"+Status+"</td><td class=tsind width=50px><a target=_blank class=anibutton href=\"file:///"+screenShotPath+"\"><img class=screen src=\"file:///"+Global.gstrResultPath+"Images/img.png\"></a></td></tr>'; document.write(txt);</script>";
				mstrAppendString="<tr><td>"+mintStepNo+"."+mintSubStepNo+"</td>"
						+ "<td>"+step_desc+"</td>"
						+ "<td>"+Exp_Res+"</td>"
						+ "<td>"+Act_Res+"</td>"
						+ "<td><b><font size = 2 color = green>"+Status+"</td>"
						+ "<td><a target=_blank href=\"../"+imgPath+"\">"
						+ "<img class='img-responsive' style='width: 25px' src=\"../Images/img.png\"></a></td></tr>";

			}
			else if(Status.equalsIgnoreCase("FAIL"))
			{
				if(mintMasterStepNo==0){
					mintFailed++;
					mintMasterStepNo++;
				}
				//				mstrAppendString="<script>var txt='<tr><td width=70px class=tsindlevel2>"+mintStepNo+"."+mintSubStepNo+"</td><td width=300px class=tsgen>"+step_desc+"</td><td width=70px class=tsgen>"+Exp_Res+"</td><td width=70px class=tsgen>"+Act_Res+"</td><td width=70px align=center class=tsgen><b><font size = 2 color = red>"+Status+"</td><td class=tsind width=50px><a target=_blank class=anibutton href=\"file:///"+screenShotPath+"\"><img class=screen src=\"file:///"+Global.gstrResultPath+"Images/img.png\"></a></td></tr>'; document.write(txt);</script>";
				mstrAppendString="<tr><td>"+mintStepNo+"."+mintSubStepNo+"</td>"
						+ "<td>"+step_desc+"</td>"
						+ "<td>"+Exp_Res+"</td><td>"+Act_Res+"</td>"
						+ "<td><b><font size = 2 color = red>"+Status+"</td>"
						+ "<td><a target=_blank class='img-responsive' style='width: 50px' href=\"../"+imgPath+"\">"
						+ "<img class='img-responsive' style='width: 25px' src=\"../Images/img.png\"></a></td></tr>";

			}
			else if(Status.equalsIgnoreCase("Interrupted"))
			{
				if(mintMasterStepNo==0){
					mintFailed++;
					mintMasterStepNo++;
				}
				mstrAppendString="<tr><td></td><td><b><font size = 2 color = Brown>"+step_desc+"</td>"
						+ "<td></td><td></td><td><b><font size = 2 color = Brown>"+Status+"</td>"
						+ "<td><a target=_blank class='img-responsive' style='width: 50px' href=\"file:///"+screenShotPath+"\">"
						+ "<img class='img-responsive' style='width: 25px' src=\"file:///"+Global.gstrResultPath+"Images/img.png\"></a></td></tr>";
			}
			f1.append("\n"+mstrAppendString);

		}


		f1.close();
		if(mintFailed==0)
		{
			mintPassed=mintStepNo;
			this.Summary(this.mstrTC_Name,mstrModuleName, mstrTC_Desc, String.valueOf(mintStepNo), String.valueOf(mintPassed), String.valueOf(mintFailed), String.valueOf(mintWarnings), "PASS");
		}
		else
		{
			mintPassed=mintStepNo-mintFailed;
			this.Summary(this.mstrTC_Name,mstrModuleName, mstrTC_Desc, String.valueOf(mintStepNo), String.valueOf(mintPassed), String.valueOf(mintFailed), String.valueOf(mintWarnings), "FAIL");
		}

	}
	public void Summary(String Test_Case,String Module,String Description,String Steps,String Passed,String Failed,String Warnings,String Status) throws Exception{

		//*************************************************************
		//		File f1=new File(Global.gstrResultPath+"Dump");
		//		f1.mkdir();
		//		
		String str=Global.gstrResultPath+"Dump/"+Test_Case+".txt";

		try{mObjFW0=new FileWriter(str);}catch(Exception e){e.printStackTrace();}

		//**********************************************************************************************
		if(Status.equalsIgnoreCase("PASS")){


			String summary="<tr><td><a href=\"./"+this.mstrModuleName+"/"+this.mstrTC_Name+".html\">"+Test_Case+"</a></td>"
					+ "<td>"+Module+"</td>"
					+ "<td>"+Description+"</td>"
					+ "<td>"+Steps+"</td>"
					+ "<td>"+Passed+"</td>"
					+ "<td>"+Failed+"</td>"
					+ "<td>"+Warnings+"</td>"
					+ "<td><b><font size = 2 color = green>"+Status+"</td></tr>";
			mObjFW0.write(summary);
		}//file:/
		//+Global.gstrResultPath
		else if(Status.equalsIgnoreCase("FAIL")){

			String summary="<tr><td><a class=tcindex href=\"./"+this.mstrModuleName+"/"+this.mstrTC_Name+".html\">"+Test_Case+"</a></td>"
					+ "<td>"+Module+"</td>"
					+ "<td>"+Description+"</td>"
					+ "<td>"+Steps+"</td>"
					+ "<td>"+Passed+"</td>"
					+ "<td>"+Failed+"</td>"
					+ "<td>"+Warnings+"</td>"
					+ "<td><b><font size = 2 color = red>"+Status+"</td></tr>";
			
			mObjFW0.write(summary);
		}

		mObjFW0.close();
	}//end of summary


	public void end_Report() throws Exception
	{
		//		Thread.sleep(5000);
		mObjFW0=new FileWriter(Global.gstrResultPath+this.mstrModuleName+"/"+this.mstrTC_Name+".html",true);

		Calendar cal_end = Calendar.getInstance();
		String end_tym=mObjDateFormat.format(cal_end.getTime());


		Date date1 = mObjDateFormat.parse(detail_strt_tym);
		Date date2 = mObjDateFormat.parse(end_tym);
		long difference = date2.getTime() - date1.getTime();

		long var1=difference%1000;
		difference=(difference/1000);
		String Duration1=difference+"."+var1;

/*		String summary3="\n <button type='button' class='btn btn-danger'>Danger</button>" ;
		mObjFW0.append(summary3);
*/
		String summary1="</table><div class='container'><div class='row' ><div class='col-md-6' ><br><br>"
				+ "<table class='table table-curved table-striped'"
				+ "<tr class='table-curved'> <th class='tblrow' colspan=2>Execution Time</th></tr>"
				+ "<tr><th>Start Time</th><td>"+detail_strt_tym+"</td></tr>"
				+ "<tr><th>End Time</th><td>"+end_tym+"</td></tr>"
				+ "<tr><th>Duration</th><td>"+Duration1+" secs</td></tr>"
				+ "</table></div><div class='col-md-6'> </div></div></div></html>";
		mObjFW0.append(summary1);
		
		
		mObjFW0.close();
		HTML_Report.build_Automation_Summary();

	}



	public static void build_Automation_Summary() throws Exception
	{
		//*******************************************
		// Initially writes a schema for automation summary report
		//*******************************************

		CSS_StyleSheet.write_StyleSheet(Global.gstrResultPath+"Automation_summary.html");

		mObjFW0=new FileWriter(Global.gstrResultPath+"Automation_summary.html",true);


		String mstrTop_img="<div class='container'><table align=center><tr><td ><img src=\"./Images/top.png\" class='img-responsive img-rounded'> </td></tr></table>";
		mObjFW0.append(mstrTop_img);
		
		mstrAppendString="<title>Automation summary</title><header> "
				+ "<div class='row container' align=center> <div class='row' align=center>"
				+ "<div class='col-md-8'> <h2> PlatformX Solutions Pvt Ltd </h2> </div>"
				+ "<div class='col-md-4' ><h2> Singapore </h2></div>"
				+ "</div></header>";

		mObjFW0.append(mstrAppendString);

		String mstrBottom_img="<table align=center><tr><td ><img src=\"./Images/bottom.png\" class='img-responsive img-rounded'> </td></tr></table></div>";
		mObjFW0.append(mstrBottom_img);

		String summary="\n<BR><BR><div class='container'>"
				+ "<table align=center id='summary_table' class='table table-curved table-striped'>"
					+ "<tr class='tblrow table-curved'> "
						+ "<th class='tblrow' >Test_Case</th>"
						+ "<th class='tblrow'>Module</th>"
						+ "<th class='tblrow'>Description</th>   "
						+ "<th class='tblrow'>Steps</th>   "
						+ "<th class='tblrow'>Passed</th>   "
						+ "<th class='tblrow'>Failed</th>   "
						+ "<th class='tblrow'>Warnings</th>   "
						+ "<th class='tblrow'>Status</th>"
					+ "</tr>" ;

		mObjFW0.append(summary);


		//*****************************************
		BufferedReader br;
		for(int i=0;i<mlistTC_Seq.size();i++)
		{

			String str=Global.gstrResultPath+"Dump/"+mlistTC_Seq.get(i)+".txt";
			File f=new File(str);
			FileReader fr=new FileReader(f);
			br = new BufferedReader(fr);

			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				mObjFW0.append(line);
				mObjFW0.append("\n");
				line = br.readLine();

			}

			br.close();
			fr.close();

			f.deleteOnExit();
		}

		Calendar cal_end1 = Calendar.getInstance();
		String end_tym1=mObjDateFormat.format(cal_end1.getTime());
		Date date3 = mObjDateFormat.parse(Global.gstrStart_time);
		Date date4 = mObjDateFormat.parse(end_tym1);
		long difference1 = date4.getTime() - date3.getTime();
		long var=difference1%1000;
		difference1=(difference1/1000);
		String Duration=difference1+"."+var;


		//String summary3="\n<script>var txt='<table width=600px align=right class=\"pfsummary\"><tr><td colspan=2 class=\"tsheader\">Test Case Summary</td></tr><tr><td class=\"pfhead\" width=200px>Total Steps</td><td class=\"pfind\" width=50px>8</td></tr><tr><td class=\"pfhead\" width=200px>Steps Passed</td><td class=\"pfind\" width=50px>8</td></tr><tr><td class=\"pfhead\" width=200px>Warnings</td><td class=\"pfind\" width=50px>0</td></tr><tr><td class=\"pfhead\" width=200px>Steps Failed</td><td class=\"pfind\" width=50px>0</td></tr></table>'; document.write(txt);</script>";
		//mObjFW0.append(summary3);<table width=700></table>


		//String summary2="\n<script>var txt='</table><br><br><table width=900px align=center><tr><td width=650px></td><td colspan=2 class=tsheader>Execution Time</td></tr><tr><td width=650px></td><td class=pfhead width=120px>Start Time</td><td class=pfind width=130px>"+Global.gstrStart_time+"</td></tr><tr><td width=650px></td><td class=pfhead width=120px>End Time</td><td class=pfind width=130px>"+end_tym1+"</td></tr><tr><td width=650px></td><td class=pfhead width=120px>Duration</td><td class=pfind width=130px>"+Duration+" secs</td></tr></table></html>'; document.write(txt);</script>";
		String summary2="</table><div class='container'><div class='row' ><div class='col-md-6' ><br><br>"
				+ "<table class='table table-curved table-striped'>"
				+ "<tr class='table-curved'> <th class='tblrow' colspan=2>Execution Time</th></tr>"
					+ "<tr><th>Start Time</th><td>"+Global.gstrStart_time+"</td></tr>"
					+ "<tr><th>End Time</th><td>"+end_tym1+"</td></tr>"
					+ "<tr><th>Duration</th><td>"+Duration+" secs</td></tr>"
				+ "</table></div><div class='col-md-6'> </div></div></div></html>";
		mObjFW0.append(summary2);

		//		String mstrBottom2_img="\n<br><br><br><br><table align=center width=900px><tr><td width=900px><img src=\"file:///"+Global.gstrResultPath+"Images/Bottom.GIF\"></td></tr></table>";
		//		mObjFW0.append(mstrBottom2_img);

		mObjFW0.close();

	}
}
