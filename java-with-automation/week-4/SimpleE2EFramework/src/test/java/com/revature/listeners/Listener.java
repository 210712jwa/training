package com.revature.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.revature.utils.ExtentReporterNG;

public class Listener implements ITestListener {

	private static Logger logger = LoggerFactory.getLogger(Listener.class);
	
	private ExtentReports extent = ExtentReporterNG.getExtentObject();
	private ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
		
		logger.info("Test '" + result.getName() + "' STARTED");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Successful");
		
		logger.info("Test '" + result.getName() + "' PASSED");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Failure");
		
		logger.error("Test '" + result.getName() + "' FAILED");
		
		// If we want to take screenshots on a test failure, the tricky part is gaining access
		// to the WebDriver object from our Test class
		// But, we can use an API that is part of Java known as the Reflection API to help us out
		
		try {
			WebDriver driver = (WebDriver) result.getTestClass().getRealClass().getSuperclass().getDeclaredField("driver").get(result.getInstance());
		
			takeAndSaveScreenshot(result.getName(), driver);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}

	}
	
	private void takeAndSaveScreenshot(String name, WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + name + "-" + System.currentTimeMillis() + ".png";
		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
