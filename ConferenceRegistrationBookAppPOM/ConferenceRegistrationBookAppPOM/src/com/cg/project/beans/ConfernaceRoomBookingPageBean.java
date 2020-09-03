package com.cg.project.beans;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
public class ConfernaceRoomBookingPageBean {
	
	@FindBy(how=How.ID,id="txtFirstName")
	private WebElement firstName;																												
																																															
	@FindBy(how=How.ID,id="txtLastName")																								
	private WebElement lastName;
																																												
	@FindBy(how=How.ID,id="txtEmail")																													
	private WebElement email;																														
	@FindBy(how=How.ID, id="txtPhone")																							
	private WebElement contactNo;
	
	@FindBy(how=How.NAME,name="size")
	private WebElement noOfPerson;
	
	@FindBy(how=How.ID,id="txtAddress1")
	private WebElement buildingAndRoomNo;
	
	@FindBy(how=How.ID,id="txtAddress2")
	private WebElement areaName;
	
	@FindBy(how=How.NAME,name="city")
	private WebElement city;
	
	@FindBy(how=How.NAME,name="state")
	private WebElement state;
	
	
	@FindBy(how=How.NAME , name="memberStatus")
	private List<WebElement> memberStatus;
	
	
	@FindBy(how=How.LINK_TEXT,linkText="Next")
	private WebElement nextLink;
	
	public String getFirstName() {
		return firstName.getAttribute("value");
	}

	public void setFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
	}

	public String getLastName() {
		return lastName.getAttribute("value");
	}

	public void setLastName(String lastName) {
		this.lastName.sendKeys(lastName);
	}
	public String getEmail() {
		return email.getAttribute("value");
	}

	public void setEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}

	public String getContactNo() {
		return contactNo.getAttribute("value");
	}

	public void setContactNo(String contactNo) {
		this.contactNo.clear(); 
		this.contactNo.sendKeys(contactNo);
	}
	public int getNoOfPerson() {
		Select select = new Select(this.noOfPerson);
		
		String selectedNo =select.getFirstSelectedOption().getText();
		return Integer.parseInt(selectedNo);
	}
	public void setNoOfPerson(String noOfPerson) {							
		Select select = new Select(this.noOfPerson);
		select.selectByVisibleText("3");

	}

	public String getBuildingAndRoomNo() {
		return this.buildingAndRoomNo.getAttribute("value");
	}

	public void setBuildingAndRoomNo(String buildingAndRoomNo) {
		this.buildingAndRoomNo.sendKeys(buildingAndRoomNo);
	}

	public String getAreaName() {
		return areaName.getAttribute("value");
	}

	public void setAreaName(String areaName) {
		this.areaName.sendKeys(areaName);
	}

	public String getCity() {
		return new Select(this.city).getFirstSelectedOption().getText();
	}

	public void setCity(String city) {
		new Select(this.city).selectByVisibleText(city);
	}
	public String getState() {
		return new Select(this.state).getFirstSelectedOption().getText();
	}

	public void setState(String state) {
		new Select(this.state).selectByVisibleText(state);
	}

	public String  getMemberStatus() {
		for (WebElement webElement : memberStatus) 
			if(webElement.isSelected())
				return webElement.getAttribute("value");
			return null;
	}

	public void setMemberStatus(String memberStatus) {
		if(memberStatus.equals("member"))
			this.memberStatus.get(0).click();
		else if(memberStatus.equals("non-member"))
			this.memberStatus.get(1).click();
	}

	
	public void clickNextPageLink() {
		nextLink.click();
	}
	
	
		
}
