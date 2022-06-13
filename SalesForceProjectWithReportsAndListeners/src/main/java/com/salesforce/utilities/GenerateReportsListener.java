package com.salesforce.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class GenerateReportsListener implements ITestListener {
	ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;

	public void onStart(ITestContext context) {
		System.out.println("Inside GenerateReportListener onstart() method creating report");
		htmlReporter = new ExtentHtmlReporter(ForceConstants.GENERATE_REPORT_PATH);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Salesforce");
		extent.setSystemInfo("Environment", "Automation Testing");
		extent.setSystemInfo("User Name", "Deepika");

		htmlReporter.config().setDocumentTitle("Test Execution Report");
		htmlReporter.config().setReportName("Salesforce regression tests");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);

	}

	public void onTestStart(ITestResult result) {
		System.out.println("Inside GenerateReportListener onTeststart() method creating report");
		logger = extent.createTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		logger.log(Status.PASS,
				MarkupHelper.createLabel(result.getMethod().getMethodName() + "passed the Test", ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		logger.log(Status.FAIL,
				MarkupHelper.createLabel(result.getMethod().getMethodName() + "passed the Test", ExtentColor.RED));
		

	}

	public void onTestSkipped(ITestResult result) {
		logger.log(Status.SKIP,
				MarkupHelper.createLabel(result.getMethod().getMethodName() + "skipped the Test", ExtentColor.YELLOW));

	}

	public void onFinish(ITestContext context) {
		extent.flush();

	}

	public static void logTestInfo(String message) {
		logger.log(Status.INFO, message);
	}

}
