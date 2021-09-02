package com.playwaze.reports;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.playwaze.util.SetUpClass;


public class ExtentManager {

	public static ExtentReports extent;
	public static  ExtentTest test;
	
	public static void createInstance() {
		String filename = GetReportName();
		String directory = System.getProperty("user.dir")+"/Reports/";
		new File(directory).mkdirs();
		String path = directory+filename;
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation Reports");
		htmlReporter.config().setReportName("Autmation Test Result");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent=new ExtentReports();
		extent.setSystemInfo("Organization", "Let's Kode it");
		extent.setSystemInfo("Browser", "Chrome");
		extent.attachReporter(htmlReporter);
		
		//return extent;
	}
	
	public static void CreateTest(String testname) {
		test = extent.createTest(testname);
	}
	
	public static void UpdatePass(String description) {
		test.log(Status.PASS, description);
	}
	
	public static void UpdateFail(String description, String Exception) throws Exception {
		test.log(Status.FAIL, description);
		//test.log(Status.FAIL, description, captureScreenShot(SetUpClass.getDriver(), "Testscreenshot"));
		test.addScreenCaptureFromPath(captureScreenShot(SetUpClass.getDriver(), "Testscreenshot"));
		
	}
	
	
	public static void testStepUpdate(String Tc, String teststatus, WebDriver driver, ExtentTest extenttest, Throwable throwable) {
		switch (teststatus) {
		case "FAIL":
			extenttest.fail(MarkupHelper.createLabel("TestCase Failed : ", ExtentColor.RED));
			extenttest.error(throwable.fillInStackTrace());
			
			try {
				extenttest.addScreenCaptureFromPath(captureScreenShot(driver, Tc));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			break;
		case "PASS":
			extenttest.pass(MarkupHelper.createLabel("Testcase Passed", ExtentColor.GREEN));
			try {
				extenttest.addScreenCaptureFromPath(captureScreenShot(driver, Tc));
			} catch (IOException e) {
				e.printStackTrace();
			}
		default:
			break;
		}
	}
	
	public static String GetReportName() {
		Date d = new Date();
		String fileName = ExecutionReport.ClassName+"_"+d.toString().replace(":", "").replace(" ", "")+".html";
		return fileName;
	}
	
	public static String captureScreenShot(WebDriver driver, String Tc) throws IOException {
		Date d = new Date();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"/Reports/Screenshots/"+Tc+d.toString().replace(":", "").replace(" ", "")+".png";
		File Target = new File(dest);
		FileUtils.copyFile(src, Target);
		return dest;
	}
}
