package com.salesforce.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.salesforce.methods.ForceMethods;

public class Leads extends ForceMethods {
	@BeforeMethod
	public void setupLeads() throws InterruptedException {
		getUsername();
		getPassword();
		getLoginbutton();
		//Thread.sleep(10000);
		//getLightningPopup();
		getLeadsTab();
		Thread.sleep(10000);
		getLightningPopup();
	}

	@Test
	public static void LeadsTab() throws InterruptedException {
//		setup();
//    	Thread.sleep(10000);
//		getLightningPopup();
//		getLeadsTab();
		getUserMenu();
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		report.logTestpassed();
	}

	@Test
	public static void LeadsSelectView() throws InterruptedException {
//		setup();
//		Thread.sleep(10000);
//		getLightningPopup();
//		getLeadsTab();		
		WebElement myleads = driver.findElement(By.xpath("//select[@id='fcf']"));
		waitUntilVisible(myleads, "my leads");
		mouseOver(myleads, "my leads");
		myleads.click();
		report.logTestpassed();
	}

	@Test
	public static void DefaultView() throws InterruptedException {
//		setup();
//		Thread.sleep(10000);
//		getLightningPopup();
//		getLeadsTab();
		WebElement myleads = driver.findElement(By.xpath("//select[@id='fcf']"));
		Select leads = new Select(myleads);
		leads.selectByVisibleText("Today's Leads");
		getUserMenu();
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		closeDriver();
		getDriver();
		windowMaximize();
		driver.get("https://login.salesforce.com/");
		getUsername();
		getPassword();
		getLoginbutton();
		getLeadsTab();
		Thread.sleep(5000);
		getLightningPopup();
		WebElement gobutton = driver
				.findElement(By.xpath("//span[contains(@class,'fBody')]//input[contains(@type,'button')]"));
		waitUntilVisible(gobutton, "Go button");
		mouseOver(gobutton, "Go button");
		gobutton.click();
		report.logTestpassed();
	}

	@Test
	public static void TodaysLeads() throws InterruptedException {
//		setup();
//		Thread.sleep(10000);
//		getLightningPopup();
//		getLeadsTab();		
		WebElement todaysleads = driver.findElement(By.xpath("//select[@id='fcf']"));
		Select leads = new Select(todaysleads);
		leads.selectByVisibleText("Today's Leads");
		report.logTestpassed();
	}

	@Test
	public static void NewButton() throws InterruptedException {
//		setup();
//		Thread.sleep(10000);
//		getLightningPopup();
//		getLeadsTab();
		driver.findElement(By.xpath("//td[@class='pbButton']//input[@type='button']")).click();
		WebElement lastname = driver.findElement(By.xpath("//input[@id='name_lastlea2']"));
		lastname.sendKeys("ABCD");
		WebElement companyname = driver.findElement(By.xpath("//input[@id='lea3']"));
		companyname.sendKeys("ABCD");
		driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@title='Save']")).click();
		report.logTestpassed();
	}

}
