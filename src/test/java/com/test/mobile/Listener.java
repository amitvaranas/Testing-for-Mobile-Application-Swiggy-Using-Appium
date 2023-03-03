package com.test.mobile;

import org.bson.ByteBufNIO;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Listener implements ITestListener {
	TimeData printTime = new TimeData();
	ExtentReports extent;
	ExtentTest test;

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName() + " Test PAssed");
		test.log(Status.PASS, result.getName());
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName() + " test FAiled");
		test.log(Status.FAIL, result.getName());
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		String currenttime = printTime.getcurrentTime();
		System.out.println(context.getName() + " started");
		String ptReport = System.getProperty("user.dir") + "\\Reports";
		String rName = "Execution_" + currenttime + ".html";
		String fName = ptReport + rName;
		System.out.println(fName);
		ExtentHtmlReporter html = new ExtentHtmlReporter(fName);
		extent = new ExtentReports();
		extent.attachReporter(html);

	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName() + " Starting");
		test = extent.createTest(result.getName());
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println(context.getName() + " Finished");
		extent.flush();
	}

}