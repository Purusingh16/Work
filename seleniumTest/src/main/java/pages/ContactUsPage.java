package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {

	WebDriver driver=null;
	
//	private String SUBJECT_ID="id_contact";
//	private String EMAIL_ADDR_ID="email";
//	private String ORDERREF_ID="id_order";
//	private String ATTACHFILE_ID="fileUpload";
//	private String SEND_ID="submitMessage";
//	private String MSG_ID="message";
//	private String TITLE_XPATH="//h1[@class='page-heading bottom-indent']";
	
//	private By SUBJECT_ID=By.id("id_contact");
//	private By EMAIL_ADDR_ID=By.id("email");
//	private By ORDERREF_ID=By.id("id_order");
//	private By ATTACHFILE_ID=By.id("fileUpload");
//	private By SEND_ID=By.id("submitMessage");
//	private By MSG_ID=By.id("message");
//	private By TITLE_XPATH=By.xpath("//h1[@class='page-heading bottom-indent']");
	
	@FindBy(id="id_contact")
	WebElement SUBJECT_ID;

	@FindBy(id="email")
	WebElement EMAIL_ADDR_ID;
	
	@FindBy(id="id_order")
	WebElement ORDERREF_ID;
	
	@FindBy(id="fileUpload")
	WebElement ATTACHFILE_ID;
	
	@FindBy(id="submitMessage")
	WebElement SEND_ID;
	
	@FindBy(id="message")
	WebElement MSG_ID;
	
	@FindBy(xpath="//h1[@class='page-heading bottom-indent']")
	WebElement TITLE_XPATH;
	
	public ContactUsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectSubjectHeading(String subheading)
	{
//		WebElement element=driver.findElement(By.id(SUBJECT_ID));
//		Select select=new Select(element);
//		select.selectByVisibleText(subheading);
//		WebElement element=driver.findElement(SUBJECT_ID);
//		Select select=new Select(element);
//		select.selectByVisibleText(subheading);
		WebElement element=SUBJECT_ID;
		Select select=new Select(element);
		select.selectByVisibleText(subheading);
	}
	
	public void typeEmail(String email)
	{
//		driver.findElement(By.id(EMAIL_ADDR_ID)).sendKeys(email);
//		driver.findElement(EMAIL_ADDR_ID).sendKeys(email);
		EMAIL_ADDR_ID.sendKeys(email);
	}
	
	public void typeOrderId(String refrences)
	{
//		driver.findElement(By.id(ORDERREF_ID)).sendKeys(refrences);
//		driver.findElement(ORDERREF_ID).sendKeys(refrences);
		ORDERREF_ID.sendKeys(refrences);
	}
	
	public void uploadFile()
	{
		String command[]={"autoitScript/FileUpload.exe","D:\\Rishi.jpg"};
//		driver.findElement(By.id(ATTACHFILE_ID)).click();
		ATTACHFILE_ID.click();
		//driver.findElement(ATTACHFILE_ID).click();
		try {
			Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public void clickOnSend()
	{
//		driver.findElement(By.id(SEND_ID)).click();
//		driver.findElement(SEND_ID).click();
		SEND_ID.click();
	}
	
	public void typeMessage(String msg)
	{
//		driver.findElement(By.id(MSG_ID)).sendKeys(msg);
//		driver.findElement(MSG_ID).sendKeys(msg);
		MSG_ID.sendKeys("msg");
	}
	
	public boolean isPageDisplayed()
	{
//		return driver.findElement(By.xpath(TITLE_XPATH)).isDisplayed();
//		return driver.findElement(TITLE_XPATH).isDisplayed();
		return TITLE_XPATH.isDisplayed();
	}

	
}

