package com.vtiger.objectRepository;

import java.net.http.WebSocket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations {
	
	WebDriver driver;
	  public Organizations(WebDriver driver) {
	  this.driver=driver;
	  PageFactory.initElements(driver,this);
	  }
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement plusImage;
	
	
	public WebElement getPlusImg() {
		return plusImage;
	}

}
