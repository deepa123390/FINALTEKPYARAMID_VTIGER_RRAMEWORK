package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
	WebDriver driver;
	public CreatingNewContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}

@FindBy(name="lastname")
private WebElement lastNameEdit;

@FindBy(xpath="//input[@value='  Save  ']")
private WebElement savebtn;
@FindBy(name="support_start_date")
private WebElement supportDateEdit;
@FindBy(id="jscal_field_support_end_date")
private WebElement endDateEdit;
@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
private WebElement lookUpIcon;



public WebElement getlastNameEdit() {
	return lastNameEdit;
}
public WebElement getlookUpIcon() {
	return lookUpIcon;
}
public WebElement getsavebtn() {
	return savebtn;
}
public WebElement getsupportDateEdit() {
	return supportDateEdit;
}
public WebElement getendDateEdit() {
	return endDateEdit;
}
}