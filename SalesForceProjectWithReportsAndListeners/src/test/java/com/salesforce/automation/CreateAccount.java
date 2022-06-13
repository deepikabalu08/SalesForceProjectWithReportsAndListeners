package com.salesforce.automation;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.salesforce.methods.ForceMethods;

public class CreateAccount extends ForceMethods {
	@BeforeMethod
	public void setupCreateAccount() throws InterruptedException {
		getUsername();
		getPassword();
		getLoginbutton();
		//Thread.sleep(10000);
		//getLightningPopup();
		getAccountsTab();	
		Thread.sleep(10000);
		getLightningPopup();
	}

	@Test
	public static void CreateAnAccount() throws InterruptedException {
//		setup();
//		Thread.sleep(8000);
//		getLightningPopup();
//		getAccountsTab();
		driver.findElement(By.xpath("//td[contains(@class,'pbButton')]//input[contains(@type,'button')]")).click();
		WebElement accname = driver.findElement(By.xpath("//input[@id='acc2']"));
		accname.sendKeys("united corporation");
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/input[@value=' Save ']")).click();
		report.logTestpassed();

	}

	@Test
	public static void CreateNewView() throws InterruptedException {
//		setup();
//		Thread.sleep(10000);
//		getLightningPopup();
//		getAccountsTab();
		driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
		WebElement viewname = driver.findElement(By.xpath("//input[@id='fname']"));
		viewname.sendKeys("Apparent View");
		driver.findElement(By.xpath("//input[@id='devname']")).click();
//		WebElement uniquename = driver.findElement(By.xpath("//input[@id='devname']"));
//		uniquename.clear();
//		uniquename.sendKeys("Bazaar_voice");
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/input[@value=' Save ']")).click();
		report.logTestpassed();

	}

	@Test
	public static void EditView() throws InterruptedException {
//		setup();
//		Thread.sleep(10000);
//		getLightningPopup();
//		getAccountsTab();
		WebElement viewdropdown = driver.findElement(By.xpath("//select[@id='fcf']"));
		waitUntilVisible(viewdropdown, "view name");
		Select view = new Select(viewdropdown);
		view.selectByVisibleText("Apparent View");
		driver.findElement(By.linkText("Edit")).click();

		WebElement viewname = driver.findElement(By.xpath("//input[@id='fname']"));
		viewname.clear();
		viewname.sendKeys("Apparent New View");
		driver.findElement(By.xpath("//select[@id='fcol1']")).click();
		driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/select/option[text()='Account Name']")).click();
		driver.findElement(By.xpath("//select[@id='fop1']")).click();
		driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]/select/option[text()='contains']")).click();
		WebElement value = driver.findElement(By.xpath("//input[@id='fval1']"));
		value.sendKeys("a");
		driver.findElement(By.xpath(
				"//select[@id='colselector_select_0']//option[@value='ACCOUNT.LAST_ACTIVITY'][contains(text(),'Last Activity')]"))
				.click();
		driver.findElement(By.xpath("//img[@class='rightArrowIcon']")).click();
		driver.findElement(By.xpath("//td[@class='pbButtonb']//input[@value=' Save ']")).click();
		report.logTestpassed();
	}

	@Test(enabled = true)
	public static void MergeAccounts() throws InterruptedException {
//		setup();
//		Thread.sleep(10000);
//		getLightningPopup();
//		getAccountsTab();
		driver.findElement(By.linkText("Merge Accounts")).click();
		WebElement merge = driver.findElement(By.xpath("//input[@id='srch']"));
		merge.sendKeys("national");
		driver.findElement(By.xpath("//div[contains(@class,'pbWizardBody')]//input[contains(@type,'submit')]")).click();
		driver.findElement(By.xpath("//div[@class='pbBottomButtons']/input[@class='btn']")).click();
		By mergelocator = By.xpath("//input[@value=' Merge ']");
		waitUntilElementToBeClickable(mergelocator, "merge locator");
		WebElement mergeacc = driver.findElement(mergelocator);
	    //JAVASCRIPT EXECUTER
		JavascriptExecutor js = (JavascriptExecutor) driver; //converting driver to javascript executor
		js.executeScript("arguments[0].click();",mergeacc); // to click merge button
		// alert box popup
		Alert alert = driver.switchTo().alert();
		alert.accept();
		report.logTestpassed();

}
			

	@Test(enabled = true)
	public static void CreateAccountReport() throws InterruptedException, AWTException, IOException {

//		setup();
//		Thread.sleep(10000);
//		getLightningPopup();
//		getAccountsTab();
		driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]")).click();
		// created date
		driver.findElement(By.xpath("//img[@id='ext-gen148']")).click();
		WebElement createddate = driver.findElement(By.xpath("//div/div[3][text()='Created Date']"));
		waitUntilVisible(createddate, "created date");
		mouseOver(createddate, "created date");
		clickElement(createddate, "created date");

		//date-picker - from
	    driver.findElement(By.xpath("//img[@id='ext-gen152']")).click();
	    //todays date
	    WebElement todaybutton1 = driver.findElement(By.xpath("//button[contains(text(),'Today')]"));
	    clickElement(todaybutton1, "today button");
	    ////date-picker - to
	    driver.findElement(By.xpath("//img[@id='ext-gen154']")).click();
	    //todays date - selecting todays date using Robot class
	    Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_SPACE); //hitting the space-bar key selects Today's date
	    System.out.println("Today's date sent into date picker");
	    
	 	WebElement saveButton = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));	
	 	clickElement(saveButton, "Save button");	        	   	
		
		//to save and run report
	 	driver.findElement(By.xpath("//input[@id='saveReportDlg_reportNameField']")).sendKeys("Report No 13");
	 	driver.findElement(By.xpath("//input[@id='saveReportDlg_DeveloperName']")).click();
		Thread.sleep(10000);
		WebElement saveandrun = driver.findElement(By.xpath("//button[contains(text(),'Save and Run Report')]"));
		mouseOver(saveandrun, "save and run");	
		clickElement(saveandrun, "save and run button");
		takesScreenShot("CreateAccountReport.jpg");
		report.logTestpassed();
		
	}
}


