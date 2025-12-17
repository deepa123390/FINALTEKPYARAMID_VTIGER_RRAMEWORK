package com.comcast.crm.utility.baseclass;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.Status;
import com.generic.fileutilty.ExcelUtility;
import com.generic.fileutilty.FileUtility;
import com.generic.webdriverutilty.JavaUtility;
import com.generic.webdriverutilty.UtilityClassObject;
import com.generic.webdriverutilty.WebDriverUtility;
import com.vtiger.objectRepository.CreatingNewOrganisationPage;
import com.vtiger.objectRepository.Homepage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.OrganizationInformation;
import com.vtiger.objectRepository.Organizations;

public class BaseClass {
	public  WebDriver driver;
	public  FileUtility fil=new FileUtility();
	public  ExcelUtility eil=new ExcelUtility();
	public static  WebDriver sdriver=null;
	
	
	public  WebDriverUtility wlib = new WebDriverUtility();
	public JavaUtility jlib=new JavaUtility();
	
	 
	@BeforeSuite(groups= {"smoke","regression"})
	public void configBS() {
		UtilityClassObject.getTest().log(Status.INFO, "DATABASE CONNECTION");
	}
	//@Parameters("browser")
	@BeforeClass(groups= {"smoke","regression"})
	public void configBC() throws IOException {
		
		//String BROWSER=browser;
		
		String BROWSER=fil.getDatafromPropertiesFile("browser");
		if(BROWSER.equals("chrome"))
		driver=new ChromeDriver();
		else if(BROWSER.equals("edge"))
			driver=new EdgeDriver();
		else if(BROWSER.equals("firefox"))
			driver=new FirefoxDriver();
		else
			driver=new ChromeDriver();
		driver.manage().window().maximize();
		sdriver =driver;
		UtilityClassObject.setWebdriver(driver);
		
		
	}
	@BeforeMethod(groups= {"smoke","regression"})
	public void configBM() throws IOException {
		wlib.waitForPagetoLoad(driver);
		String URL=	fil.getDatafromPropertiesFile("url");
		String USERNAME=fil.getDatafromPropertiesFile("username");
		String PASSWORD=fil.getDatafromPropertiesFile("password");

		driver.get(URL);
		 LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME,PASSWORD);
		
	}
	@AfterMethod(groups= {"smoke","regression"})
	public void configAM() {
		UtilityClassObject.getTest().log(Status.INFO, "LOGOUT APPLICATION");
		Homepage hp=new Homepage(driver);
		 hp.logout();
	}
	@AfterClass(groups= {"smoke","regression"})
	public void configAC() {
		UtilityClassObject.getTest().log(Status.INFO, "CLOSE BROWSER");
		driver.close();
	}
	@AfterSuite(groups= {"smoke","regression"})
	public void configAS() {
		UtilityClassObject.getTest().log(Status.INFO, "DB CONNECTION CLOSE,REPORT BACKUP");

}}
