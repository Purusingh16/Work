package com.github.reg.pagebeans;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPageBean {
	
	@FindBy(how=How.ID,id="user_login")
	private WebElement username;
	
	@FindBy(how=How.ID,id="user_email")
	private WebElement useremail;
	
	@FindBy(how=How.ID,id="user_password")
	private WebElement userpassword;
	
	@FindBy(how=How.ID,id="signup_button")
	private WebElement signinbtn;
	
	public String getUsername() {
		return username.getText();
	}
	
	public void setUsername(String username) {
		this.username.sendKeys(username);;
	}
	
	public String getUseremail() {
		return useremail.getText();
	}
	
	public void setUseremail(String useremail) {
		this.useremail.sendKeys(useremail);;
	}
	
	public String getUserpassword() {
		return userpassword.getText();
	}
	
	public void setUserpassword(String userpassword) {
		this.userpassword.sendKeys(userpassword);;
	}
	
	public void signIn() {
		signinbtn.submit();
	}


	/*public WebElement getUsername() {
		return username.getText();
	}

	public void setUsername(WebElement username) {
		this.username = username;
	}

	public WebElement getUseremail() {
		return useremail;
	}

	public void setUseremail(WebElement useremail) {
		this.useremail = useremail;
	}

	public WebElement getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(WebElement userpassword) {
		this.userpassword = userpassword;
	}

	public WebElement getSigninbtn() {
		return signinbtn;
	}

	public void setSigninbtn(WebElement signinbtn) {
		this.signinbtn = signinbtn;
	}*/
	
	
	

}
