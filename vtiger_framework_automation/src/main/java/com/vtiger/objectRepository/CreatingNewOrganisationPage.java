package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganisationPage {
	WebDriver driver;
	public CreatingNewOrganisationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	@FindBy(name="accountname")
	private WebElement orgNameEdit;
	
	@FindBy(xpath="//textarea[@name='ship_street']")
	private WebElement shippAddrsEdit;
	
	@FindBy(id="phone")
	private WebElement phoneNumberEdit;
	
	@FindBy(xpath="//input[@value='  Save  ']")
	private WebElement savebtn;
	
	@FindBy(name="industry")
	private WebElement industrydd;
	
	@FindBy(name="accounttype")
	private WebElement typedd;
	
	public WebElement getOrgName() {
		return orgNameEdit;
	}
	public WebElement getShippingAdrs() {
		return  shippAddrsEdit;
	}
	public WebElement getPhoneNumberEdit() {
		return phoneNumberEdit;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	public WebElement getindustrydd() {
		return industrydd;
	}
	public WebElement gettypedd() {
		return typedd;
	}
}
