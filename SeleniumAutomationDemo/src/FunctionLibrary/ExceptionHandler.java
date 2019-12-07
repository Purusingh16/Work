package FunctionLibrary;
import org.openqa.selenium.WebDriver;


public class ExceptionHandler {

	Exception ex;
	WebDriver driver;
	HTML_Report report;
	public ExceptionHandler(Exception ex, WebDriver driver, HTML_Report obj1) {
		//super();
		this.ex = ex;
		this.driver = driver;
		this.report=obj1;
	}

	
	public void evalException() throws Exception
	{
	
		
		
		//System.out.println("*************In Exception Handling Class*************"+ex.getClass());
		//ex.printStackTrace();
		//report.details_append( "Execution Interrupted because of exception" , "" , "", "Interrupted");
		
		String exClass=ex.getClass().toString();
		//ex.printStackTrace();
		if(exClass.contains("StaleElementReferenceException"))
		{
			//System.out.println("Identified specific exception "+exClass);
			//System.out.println();
			report.details_append( "Execution Interrupted because of StaleElementReferenceException" , "" , "", "Interrupted");
		}
		else if(exClass.contains("NoSuchElementException"))
		{
			report.details_append( "Execution Interrupted because of NoSuchElementException" , "" , "", "Interrupted");
			//System.out.println("Identified specific exception "+exClass);
		}
		else if(exClass.contains("InvalidElementStateException"))
		{
			report.details_append( "Execution Interrupted because of InvalidElementStateException" , "" , "", "Interrupted");
			//System.out.println("Identified specific exception "+exClass);
		}
		else if(exClass.contains("ElementNotVisibleException"))
		{
			report.details_append( "Execution Interrupted because of ElementNotVisibleException" , "" , "", "Interrupted");
			//System.out.println("Identified specific exception "+exClass);
		}
		else if(exClass.contains("ErrorInResponseException"))
		{
			report.details_append( "Execution Interrupted because of ErrorInResponseException" , "" , "", "Interrupted");	
			//System.out.println("Identified specific exception "+exClass);
		}
		else if(exClass.contains("InvalidSwitchToTargetException"))
		{
			report.details_append( "Execution Interrupted because of InvalidSwitchToTargetException" , "" , "", "Interrupted");	
			//System.out.println("Identified specific exception "+exClass);
		}
		else if(exClass.contains("NoSuchFrameException"))
		{
			report.details_append( "Execution Interrupted because of NoSuchFrameException" , "" , "", "Interrupted");	
			//System.out.println("Identified specific exception "+exClass);
		}
		else if(exClass.contains("NoSuchWindowException"))
		{
			report.details_append( "Execution Interrupted because of NoSuchWindowException" , "" , "", "Interrupted");	
			//System.out.println("Identified specific exception "+exClass);
		}
		else if(exClass.contains("NoSuchAttributeException"))
		{
			report.details_append( "Execution Interrupted because of NoSuchAttributeException" , "" , "", "Interrupted");	
			//System.out.println("Identified specific exception "+exClass);
		}
		else if(exClass.contains("NoAlertPresentException"))
		{
			report.details_append( "Execution Interrupted because of NoAlertPresentException" , "" , "", "Interrupted");
			//System.out.println("Identified specific exception "+exClass);
		}
		else if(exClass.contains("ElementNotSelectableException"))
		{
			report.details_append( "Execution Interrupted because of ElementNotSelectableException" , "" , "", "Interrupted");
			//System.out.println("Identified specific exception "+exClass);
		}
		else if(exClass.contains("InvalidCookieDomainException"))
		{
			report.details_append( "Execution Interrupted because of InvalidCookieDomainException" , "" , "", "Interrupted");
			//System.out.println("Identified specific exception "+exClass);
		}
		else if(exClass.contains("UnableToSetCookieException"))
		{
			report.details_append( "Execution Interrupted because of UnableToSetCookieException" , "" , "", "Interrupted");
			//System.out.println("Identified specific exception "+exClass);
		}
		else if(exClass.contains("RemoteDriverServerException"))
		{
			report.details_append( "Execution Interrupted because of RemoteDriverServerException" , "" , "", "Interrupted");	
			//System.out.println("Identified specific exception "+exClass);
		}
		else if(exClass.contains("TimeoutException"))
		{
		
			report.details_append( "Execution Interrupted because of TimeoutException" , "" , "", "Interrupted");	
		//System.out.println("Identified specific exception "+exClass);
		}
		else if(exClass.contains("MoveTargetOutOfBoundsException"))
		{
			report.details_append( "Execution Interrupted because of MoveTargetOutOfBoundsException" , "" , "", "Interrupted");
			//System.out.println("Identified specific exception "+exClass);
		}
		else if(exClass.contains("UnexpectedTagNameException"))
		{
			report.details_append( "Execution Interrupted because of UnexpectedTagNameException" , "" , "", "Interrupted");	
			//System.out.println("Identified specific exception "+exClass);
		}
		else if(exClass.contains("InvalidSelectorException"))
		{
			report.details_append( "Execution Interrupted because of InvalidSelectorException" , "" , "", "Interrupted");
			//System.out.println("Identified specific exception "+exClass);
		}
		else if(exClass.contains("ImeNotAvailableException"))
		{
			report.details_append( "Execution Interrupted because of ImeNotAvailableException" , "" , "", "Interrupted");
			//System.out.println("Identified specific exception "+exClass);
		}
		else if(exClass.contains("ImeActivationFailedException"))
		{
			report.details_append( "Execution Interrupted because of ImeActivationFailedException" , "" , "", "Interrupted");	
			//System.out.println("Identified specific exception "+exClass);
		}
		else if(exClass.contains("UnhandledAlertException"))
		{
			report.details_append( "Execution Interrupted because of Unhandled message ALERT" , "" , "", "Interrupted");
			Thread.sleep(3000);
			//System.out.println("Identified specific exception "+exClass);
			
//			Alert alert = null;
//			try {
//				//System.out.println("Alert found"+((TargetLocator) driver).alert().getText());
//				alert = driver.switchTo().alert();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block	
//				e.printStackTrace();
//				System.out.println("Alert found"+alert.getText());
//				
//				
//			}
//			// Get the text of the alert or prompt
//			 
//			//System.out.println("Alert found");
//			
//			
//			// And acknowledge the alert (equivalent to clicking "OK")
//			alert.accept();

			
		}

		
	}
	
	
	
}
