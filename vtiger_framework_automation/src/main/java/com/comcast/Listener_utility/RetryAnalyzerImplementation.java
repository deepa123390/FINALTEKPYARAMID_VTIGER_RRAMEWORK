package com.comcast.Listener_utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementation implements IRetryAnalyzer {
	
	public boolean retry(ITestResult result) {
		int count=0;
		int limitCount=5;
				while(count<limitCount) {
					count++;
					}
				return true;
	}

}
