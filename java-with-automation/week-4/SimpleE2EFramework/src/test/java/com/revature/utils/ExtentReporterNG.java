package com.revature.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	private static ExtentReports extent;
	
	public static ExtentReports getExtentObject() {
		if (extent == null) {
			generateExtentReport();
		}
		
		return extent;
	}
	
	private static void generateExtentReport() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html"; // specify the path for where the extentreport
		// should be saved
		
		// Instantiating and Configuring the Reporter Object
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation reports");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Bach");
	}
	
}
