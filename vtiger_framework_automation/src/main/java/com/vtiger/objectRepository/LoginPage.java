package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements( driver,this);
	}
	
@FindBy(name="user_name")
	private WebElement username;
	
@FindBy(name="user_password")
	private WebElement password;
	
@FindBy(id="submitButton")
	private WebElement loginbtn;
	
	public  WebElement getUsername() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
	
public WebElement getLoginbtn() {
	return loginbtn;
}

public void login(String username1,String password1) {
	username.sendKeys(username1);
	password.sendKeys(password1);
	loginbtn.click();
}









}
