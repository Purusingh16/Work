package com.github.naukri.pagebeans;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NaukriPageBean {
	
	@FindBy(how=How.ID,id="fname")	
	private WebElement firstname;
	
	@FindBy(how=How.ID,id="email")
	private WebElement emailID;
	
	@FindBy(how=How.XPATH,xpath="//*[@id=\"basicDetailForm\"]/div[3]/div[1]/div/input")
	private WebElement password;
	
	@FindBy(how=How.XPATH,xpath="//*[@id=\"basicDetailForm\"]/div[4]/div[1]/div/input[2]")
	private WebElement mobNumber;
	
	@FindBy(how=How.XPATH,xpath="//*[@id=\"basicDetailForm\"]/div[5]/div/div/div/button")
	private WebElement registerNow;

	public String getFirstname() {
		return firstname.getText();
	}

	public void setFirstname(String firstname) {
		this.firstname.sendKeys("firstname");;
	}

	public String getEmailID() {
		return emailID.getText();
	}

	public void setEmailID(String emailID) {
		this.emailID.sendKeys("emailID");;
	}

	public String getPassword() {
		return password.getText();
	}

	public void setPassword(String password) {
		this.password.sendKeys("password");
	}

	public String getMobNumber() {
		return mobNumber.getText();
	}

	public void setMobNumber(String mobNumber) {
		this.mobNumber.sendKeys("mobNumber");;
	}
	
	public void registerNow() {
		registerNow.submit();
	}

	/*public WebElement getRegisterNow() {
		return registerNow;
	}

	public void setRegisterNow(WebElement registerNow) {
		this.registerNow = registerNow;
	}*/
	
	

}
