package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformation {
	WebDriver driver;
	public ContactInformation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	@FindBy(id="mouseArea_Last Name")
	private WebElement lastnameinfo;
	
	@FindBy(id="mouseArea_Support Start Date")
	private WebElement actualStartDateInfo;
	
	@FindBy(id="mouseArea_Support End Date")
	private WebElement actualEndDateInfo;
	
	public WebElement getlastnameinfo() {
		return lastnameinfo;
	}
	public WebElement getactualStartDateInfo() {
		return actualStartDateInfo;
	}
	public WebElement getactualEndDateInfo() {
		return actualEndDateInfo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
