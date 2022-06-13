package com.salesforce.methods;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.salesforce.utilities.ForceCommonUtilities;
import com.salesforce.utilities.ForceConstants;
import com.salesforce.utilities.GenerateReports;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ForceMethods {

	protected static WebDriver driver;
	protected static WebDriverWait wait;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest Logger;
	public static GenerateReports report;

	@BeforeTest
	public static void initialSetUp() {
		System.out.println("BeforeTest execution started");
		report = GenerateReports.getInstance();
		report.startExtentReport();
	}

	@BeforeMethod
	public static void setup(Method method){
		System.out.println("BeforeMethod execution started");
		report.startSingleTestReport(method.getName());
		String url = ForceCommonUtilities.getApplicationProperty("url");
		getDriver();
		windowMaximize();
		gotoUrl(url);
	}

	@AfterMethod
	public static void tearDown() {
		System.out.println("AfterMethod execution started");
		closeAllDriver();
	}

	@AfterTest
	public static void finalTearDown() {
		System.out.println("AfterTest execution started");
		report.endReport();
	}

	public static void getDriver() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("Driver instance created");
		report.logTestInfo("Driver instance created");

	}


//	public static void getDriver(String browserName) {
//		if (browserName.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//			System.out.println("Firefox driver instance created");
//			report.logTestInfo("Firefox driver instance created");
//		} else if (browserName.equalsIgnoreCase("Chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			System.out.println("Chrome driver instance created");
//			report.logTestInfo("Chrome driver instance created");
//		} else if (browserName.equalsIgnoreCase("edge")) {
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//			System.out.println("Edge driver instance created");
//			report.logTestInfo("Edge driver instance created");
//
//		} 
//	}

	public static void windowMaximize() {
		driver.manage().window().maximize();
	}

	public static void gotoUrl(String url) {
		driver.get(url);
		System.out.println("url entered is:" + url);
		report.logTestInfo("url entered is:" + url);
	}

	public static void getUsername() {
		String userName = ForceCommonUtilities.getApplicationProperty("username");
		WebElement username = driver.findElement(By.id("username"));
		waitUntilVisible(username, "user name");
		enterText(username, userName, "user name");
		report.logTestInfo("Username entered");
	}

	public static void getPassword() {
		String password = ForceCommonUtilities.getApplicationProperty("password");
		WebElement pswd = driver.findElement(By.id("password"));
		clearElement(pswd, password);
		enterText(pswd, password, "password");
		report.logTestInfo("Password entered");
	}

	public static void getLoginbutton() {
		WebElement login = driver.findElement(By.id("Login"));
		clickElement(login, "login button");
		report.logTestInfo("Login button clicked");
	}

	public static void getLightningPopup() {
		 
		// WebElement lightning = driver.findElement(By.id("tryLexDialog"));
		//WebElement lightning = driver.findElement(By.xpath("//*[@id=\"ext-gen16\"]"));
		WebElement lightning = driver.findElement(By.linkText("Close"));
		 waitUntilVisible(lightning, "lightning");
			mouseOver(lightning, "lightning");
		clickElement(lightning, "lightning popup");
	}

	public static void Logout() {
		WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		clickElement(logout, "logout");
	}

	public static void closeDriver() {
		driver.close(); // to close the current window browser in focus
	}

	public static void closeAllDriver() {
		driver.quit(); // to close all the opened window browser (whole browsers)
	}

	public static void enterText(WebElement element, String text, String objName) {
		if (element.isDisplayed()) {
			clearElement(element, objName);
			element.sendKeys(text);
			System.out.println("pass: " + objName + " text entered");
			report.logTestInfo("Text entered in " + objName + " field");
		} else {
			System.out.println("fail: " + objName + " element not displayed");
			report.logTestInfo("Text not entered in " + objName + " field");
		}
	}

	public static void clickElement(WebElement element, String objName) {
		if (element.isDisplayed()) {
			element.click();
			System.out.println("pass: " + objName + " element clicked");
			report.logTestInfo("Element " + objName + " is clicked");
		} else {
			System.out.println("fail: " + objName + " element not displayed");
			report.logTestInfo("Element " + objName + " is not displayed");
		}
	}

	public static void clearElement(WebElement element, String objName) {
		if (element.isDisplayed()) {
			element.clear();
			System.out.println("pass: " + objName + " element cleared");
			report.logTestInfo("Element " + objName + " is cleared");
		} else {
			System.out.println("fail: " + objName + " element not displayed");
			report.logTestInfo("Element " + objName + " is not cleared");
		}

	}

	public static void waitUntilVisible(WebElement element, String objName) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitUntilVisiblityOfElementLocated(By locator, String objName) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void waitUntilAlertIsPresent() {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public static void waitUntilElementToBeClickable(By locator, String objname) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static void mouseOver(WebElement element, String objName) {
		waitUntilVisible(element, objName);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public static void switchToOneWindow(String mainWindowHandle) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!mainWindowHandle.equalsIgnoreCase(handle))
				driver.switchTo().window(handle);
		}
	}

	public static void getUserMenu() {
		driver.findElement(By.xpath("//div[@id='userNav-arrow']")).click();

	}

	public static void getAccountsTab() {
		WebElement accounts = driver.findElement(By.xpath("//li[@id='Account_Tab']"));
		waitUntilVisible(accounts, "accounts");
		mouseOver(accounts, "accounts");
		accounts.click();
	}

	public static void getOpportunitiesTab() {
		WebElement opportunities = driver.findElement(By.xpath("//li[@id='Opportunity_Tab']"));
		waitUntilVisible(opportunities, "opportunities");
		mouseOver(opportunities, "opportunities");
		opportunities.click();
	}

	public static void getLeadsTab() {
		driver.findElement(By.xpath("//li[@id='Lead_Tab']")).click();

	}

	public static void getContactsTab() {
		driver.findElement(By.xpath("//li[@id='Contact_Tab']")).click();
	}

	public static void getHomeTab() {
		driver.findElement(By.xpath("//li[@id='home_Tab']")).click();
	}

	public static void takesScreenShot(String filename) throws IOException {
		TakesScreenshot ob = (TakesScreenshot) driver; // type-casting driver to screenshot
		Date date = new Date();
		String file = date.toString().replace(":", "-").replace(" ", "_") + filename;
		File sourcepath = ob.getScreenshotAs(OutputType.FILE);
		report.logTestInfo("Screen shot captured");
		String path = ForceConstants.SCREENSHOT_PATH + file;
		File Destinationpath = new File(path);
		FileUtils.copyFile(sourcepath, Destinationpath);
	}

}
