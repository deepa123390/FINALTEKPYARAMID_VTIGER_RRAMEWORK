package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	WebDriver driver;
	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement orgLink;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement ContactsLink;
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImage;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOutbtn;
	
	public WebElement getOrgLink() {
		return orgLink;
	}
	public WebElement getContactsLink() {
		return ContactsLink;
	}
	public WebElement getAdminImage() {
		return adminImage;
	}
	public WebElement getSignoutBtn() {
		return signOutbtn;
	}
	
	
	public void logout() {
		Actions act=new Actions(driver);
		act.moveToElement(adminImage).perform();;
	
		signOutbtn.click();
	}

}
