package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsLookUpWindow {
	WebDriver driver;
	  public OrganizationsLookUpWindow(WebDriver driver) {
	  this.driver=driver;
	  PageFactory.initElements(driver,this);
	  }
	  
	  @FindBy(id="search_txt")
	  private WebElement serachEdit;
	  
	  
	  @FindBy(name="search")
	  private WebElement serachbtn;
	  
	 public WebElement getserachEdit() {
		 return serachEdit;
	 }
	 public WebElement getserachbtn() {
		 return serachbtn;
	 }
}
