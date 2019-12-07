package pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {
	
	WebDriver driver=null;
	
	private By TITLE_CSS=By.cssSelector("h1.page-heading.bottom-indent");
	private By EMAIL_ID=By.id("email");
	private By ID_ORDER_ID=By.id("id_order");
	private By FILEUPLOAD_ID=By.id("fileUpload");
	private By SUBMIT_MESSAGE_ID=By.id("submitMessage");
	private By MESSAGEBOX_ID=By.id("message");
	
	public ContactUsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getpageTitle(){
		return driver.findElement(TITLE_CSS).getText();
	}
	
	public void typeEmail(String email) {
		driver.findElement(EMAIL_ID).sendKeys(email);
	}
	
	public void typeOrderId(String orderID) {
		driver.findElement(ID_ORDER_ID).sendKeys(orderID);
	}
	
	public void typeMessage(String message) {
		driver.findElement(MESSAGEBOX_ID).sendKeys(message);
	}
	
	public void uploadFile(String fileName) {
		driver.findElement(FILEUPLOAD_ID).click();
		String filePath=getUploadFilePath(fileName);
		String autoitScriptPath=getAutoItScriptPath("Fileupload_2.exe");
		String command[]={autoitScriptPath,filePath};
		try {
			Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String getUploadFilePath(String fileName){
		
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("files/"+fileName).getFile());
		return file.getAbsolutePath();
	}
	
	private String getAutoItScriptPath(String fileName){
		
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("autoitScript/"+fileName).getFile());
		return file.getAbsolutePath();
	}
}
