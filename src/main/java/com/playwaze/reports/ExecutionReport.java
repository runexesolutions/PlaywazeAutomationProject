package com.playwaze.reports;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExecutionReport {

	public static String ClassName = null;
	public static File reportname = new File(System.getProperty("user.dir")+"/Reports/"+ClassName+".html");
	
	
	
	
	
	public static void CreateReportFile() throws IOException {
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(reportname));
        bw.write("<html><body><h1>Blah, Blah!</h1>");
	}
}
