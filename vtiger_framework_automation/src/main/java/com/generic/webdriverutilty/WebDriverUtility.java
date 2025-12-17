package com.generic.webdriverutilty;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void waitForPagetoLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	public void waitForElementPrsent(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void switchToBrowserTab(WebDriver driver,String partialurl) {
		Set<String> set=driver.getWindowHandles();
		Iterator<String>itr=set.iterator();
		 while(itr.hasNext()) {
			 String windowID=itr.next();
			 driver.switchTo().window(windowID);
			 driver.getCurrentUrl();
		 }
		
	}
	public void select(WebElement element,String text) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	public void handleAlertAceept(WebDriver driver) {
	Alert ale=	driver.switchTo().alert();
	ale.accept();
	}
	public void handleAlertDismiss(WebDriver driver) {
		Alert ale=	driver.switchTo().alert();
		ale.dismiss();
		}


}
