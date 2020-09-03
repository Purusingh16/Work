package com.github.project.pagebeans;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class LogingPageBean {								
	
	@FindBy(how=How.NAME,name="login")	
	private WebElement login ;
	
	@FindBy(how=How.NAME,name="password")	
	private WebElement password;
	
	@FindBy(how=How.NAME,name="commit")	
	private WebElement signIn;
	
	@FindBy(how=How.XPATH,xpath="/html/body/div[3]/main/div/form/div[2]/div/div")	
	private WebElement actualErrorMessage;

	
	public String  getLogin() {
		return login.getText();
	}

	public void setLogin(String login) {
		this.login.sendKeys(login);
	}

	public String  getPassword() {
		return password.getText(); 
	}

	public void setPassword(String password) {
		this.password.sendKeys(password);;
	}

	public String getActualErrorMessage() {
		return actualErrorMessage.getText();
	}

	public void signIn() {
		signIn.submit();
	}


	


}