package com.generic.webdriverutilty;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject {
	public static ThreadLocal<ExtentTest> test=new ThreadLocal();
	public static ThreadLocal<WebDriver> driver= new ThreadLocal();
    
    public static ExtentTest getTest() {
    	return test.get();
    }
    
    public static WebDriver getDriver() {
    	return driver.get();
    }
    
    public static void setExtentTest(ExtentTest actualTest) {
    	test.set(actualTest);
    	
    }
    public static void setWebdriver(WebDriver actualDriver) {
    	driver.set(actualDriver);
    }
    
}
