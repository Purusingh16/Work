package com.cg.project.test;
import java.io.File;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"features"},
		glue= {"com.cg.project.stepdef"},
		/*plugin="html:reports"

		plugin="json:reports/ConferenceRoomBookingReport.json"
	 
		plugin="junit:reports/ConferenceRoomBookingReport.xml"*/

		plugin=	"com.cucumber.listener.ExtentCucumberFormatter:reports/ConferenceRoomBookingReport.html"

		)
public class TestRunner {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("./config/report.xml"));  
	}					
}