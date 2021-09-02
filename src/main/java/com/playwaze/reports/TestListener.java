package com.playwaze.reports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestListener extends ExtentManager implements ITestListener {
	
	//private static ExtentReports extent = ExtentManager.createInstance();
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	 public void onTestStart(ITestResult result) {
//		  ExtentTest test = extent.createTest(ExecutionReport.ClassName);
//		  extentTest.set(test);
		 System.out.println("TestStarted");
	 }
	 
	 public void onTestSuccess(ITestResult result) {
		 //String logText = "<b>TestStep"+"Successful</b>";
		 System.out.println("Test Success");
	 }
	 
	 public void onTestFailure(ITestResult result) {
		 System.out.println("Test Failed");
	 }
	 
	 public void onTestSkipped(ITestResult result) {
	 
	 }
	 public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		 
	 }
	 
	 public void onTestFailedWithTimeout(ITestResult result) {
		 
	 }
	 
	 public void onStart(ITestContext context) {
	 }
	 
	 public void onFinish(ITestContext context) {
		 System.out.println("Execution Completed");
		 System.out.println("Report Generated");
		 
	 }

}
