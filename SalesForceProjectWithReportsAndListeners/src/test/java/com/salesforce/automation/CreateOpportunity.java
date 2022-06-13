package com.salesforce.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.salesforce.methods.ForceMethods;

public class CreateOpportunity extends ForceMethods {
	@BeforeMethod
	public void setupCreateOpportunity() throws InterruptedException {
		getUsername();
		getPassword();
		getLoginbutton();
		//Thread.sleep(10000);
		//getLightningPopup();
		getOpportunitiesTab();
		Thread.sleep(10000);
		getLightningPopup();
	}
	
	@Test
	public static void UserMenuDropDown(){
//		setup();
//		Thread.sleep(10000);
//		getLightningPopup();	
//		getOpportunitiesTab();
		WebElement myopportunities = driver.findElement(By.xpath("//select[@id='fcf']"));
		waitUntilVisible(myopportunities, "my opportunities");
		mouseOver(myopportunities, "my opportunities");
		myopportunities.click();
		report.logTestpassed();
		
	}
	@Test 
	public static void CreateNewOpportunity() throws InterruptedException {
		
//		setup();
//		Thread.sleep(10000);
//		getLightningPopup();		
//		getOpportunitiesTab();		
		WebElement newbutton = driver.findElement(By.xpath("//td[@class='pbButton']//input[@type='button']"));
		waitUntilVisible(newbutton, "new button");
		mouseOver(newbutton, "new button");
		newbutton.click();
		
		
		WebElement oname = driver.findElement(By.xpath("//input[@id='opp3']"));
		oname.sendKeys("Page-100 Widgets");
		WebElement accname = driver.findElement(By.xpath("//input[@id='opp4']"));
		accname.sendKeys("Prathi");
		driver.findElement(By.xpath("//input[@id='opp9']"));
		driver.findElement(By.xpath(" //span[@class='dateFormat']")).click();
		WebElement stage = driver.findElement(By.xpath("//select[@id='opp11']"));
		Select selectstage = new Select(stage);
		selectstage.selectByVisibleText("Proposal/Price Quote");
		WebElement probability = driver.findElement(By.xpath("//input[@id='opp12']"));
		clearElement(probability, "probability");
		probability.sendKeys("75");
		WebElement campaign = driver.findElement(By.xpath("//input[@id='opp17']"));
		campaign.sendKeys("");
		WebElement leadsource = driver.findElement(By.xpath("//select[@id='opp6']"));
		Select selectlead = new Select(leadsource);
		selectlead.selectByVisibleText("Partner Referral");
		driver.findElement(By.xpath("//td[@class='pbButtonb']//input[@title='Save']")).click();
		report.logTestpassed();
	}
	@Test
	public static void TestOpportunityPipelineReport() throws InterruptedException {
//		setup();
//		Thread.sleep(10000);
//		getLightningPopup();
//		getOpportunitiesTab();
		driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]")).click();
		report.logTestpassed();
	}
	@Test
	public static void TestStuckOpportunitiesReport() throws InterruptedException {
//		setup();
//		Thread.sleep(10000);
//		getLightningPopup();	
//		getOpportunitiesTab();
		driver.findElement(By.xpath("//a[contains(text(),'Stuck Opportunities')]")).click();
		report.logTestpassed();
	}
	@Test
	public static void TestQuaterlySummaryReport() throws InterruptedException {
//		setup();
//		Thread.sleep(10000);
//		getLightningPopup();	
//		getOpportunitiesTab();
		driver.findElement(By.xpath("//select[@id='quarter_q']")).click();
		driver.findElement(By.xpath("//option[contains(@value,'curnext1')]")).click();
		driver.findElement(By.xpath("//select[@id='open']")).click();
		driver.findElement(By.xpath("//option[contains(text(),'Closed Opportunities')]")).click();
		driver.findElement(By.xpath("//table[contains(@class,'opportunitySummary')]//tbody//tr//td//input[contains(@type,'submit')]")).click();		
		report.logTestpassed();
	}

}
