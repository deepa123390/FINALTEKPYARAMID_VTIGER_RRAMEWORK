package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact {
	WebDriver driver;
	public Contact(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}

	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement plusicon;
	
	
	public WebElement getplusicon() {
		return plusicon;
	}
}

