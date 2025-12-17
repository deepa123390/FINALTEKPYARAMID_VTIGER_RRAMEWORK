package com.comcast.Listener_utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.utility.baseclass.BaseClass;
import com.generic.webdriverutilty.UtilityClassObject;
import com.google.common.io.Files;

public class ListenerImplementation implements ITestListener, ISuiteListener {
	public  ExtentReports report;
	public static ExtentTest test;
	String time = new Date().toString().replace(" ", "_").replace(":", "_");
	public void onStart(ISuite suite) {
		
		
		/* SET REPORT CONFIGURATION */
		
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report"+time+".html");
		spark.config().setDocumentTitle("CRM REPORT");
		spark.config().setReportName("CRM ADVANCE REPORT");
		spark.config().setTheme(Theme.DARK);
		/* SET SYSTEM INFORMATION AND ATTACH REPORT */
		report = new ExtentReports();
		report.attachReporter(spark);

		report.setSystemInfo("OS", "WINDOWS11");

	}

	public void onFinish(ISuite suite) {
		test.log(Status.INFO, "Report Backup");
		report.flush();
	}

	public void onTestStart(ITestResult result) {

		test = report.createTest(result.getMethod().getMethodName() + "  started");
		UtilityClassObject.setExtentTest(test);
		UtilityClassObject.getTest().log(Status.INFO, result.getMethod().getMethodName() + "  started");
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.INFO, "" + result.getMethod().getMethodName() + "  Passed");
		test.log(Status.FAIL,"passed");
	}

	public void onTestFailure(ITestResult result) {

		
		String testName = (result.getMethod().getMethodName() + "  Failed");
		TakesScreenshot tks = (TakesScreenshot) UtilityClassObject.getDriver();
		String filepath = tks.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filepath,testName+"+time+");
		test.log(Status.FAIL, "failed");
		

		

	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.INFO, result.getMethod().getMethodName() + "  Skipped");
		test.log(Status.SKIP, "skipped");
	}

}
