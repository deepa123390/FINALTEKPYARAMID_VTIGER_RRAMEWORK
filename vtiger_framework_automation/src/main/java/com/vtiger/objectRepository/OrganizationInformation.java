package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformation {
	WebDriver driver;
	public OrganizationInformation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(id="mouseArea_Phone")
	private WebElement phoneNumberINFO;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerInfo;
	@FindBy(id="mouseArea_Organization Name")
	private WebElement actualOrgNameInfo;
	@FindBy(id="mouseArea_Industry")
	private WebElement industryInfo;
	@FindBy(id="mouseArea_Type")
		private WebElement typeInfo;
	
	
	public WebElement getphoneNumberINFO() {
		return phoneNumberINFO;
	}
	public WebElement getheaderInfo() {
		return headerInfo;
	}
	public WebElement getactualOrgNameInfo() {
		return actualOrgNameInfo;
	}
	public WebElement getindustryInfo() {
		return industryInfo;
	}
	public WebElement gettypeInfo() {
		return typeInfo;
	}
}
