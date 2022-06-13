package com.salesforce.automation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.salesforce.methods.ForceMethods;


public class Contacts extends ForceMethods {
	@BeforeMethod
	public void setupContacts() throws InterruptedException {
		getUsername();
		getPassword();
		getLoginbutton();
//		Thread.sleep(10000);
//		getLightningPopup();
		getContactsTab();	
		Thread.sleep(10000);
		getLightningPopup();
	}
	
	@Test
	public static void CreateNewContact() throws InterruptedException {

//	    setup();
//		Thread.sleep(10000);
//		getLightningPopup();
//		getContactsTab();
		WebElement newbuton = driver.findElement(By.xpath("//td[@class='pbButton']//input[@type='button']"));
		waitUntilVisible(newbuton, "new button");
		mouseOver(newbuton, "new button");
		newbuton.click();
		

		WebElement lastname = driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
		lastname.sendKeys("Kavya");

		WebElement accname = driver.findElement(By.xpath("//input[@id='con4']"));
		accname.sendKeys("Global Media");

		driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@title='Save']")).click();
		report.logTestpassed();

	}

	@Test
	public static void CreateNewView() throws InterruptedException {
//		setup();
//		Thread.sleep(10000);
//		getLightningPopup();
//		getContactsTab();
		
		driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
		WebElement viewname = driver.findElement(By.xpath("//input[@id='fname']"));		
		viewname.sendKeys("View 11");
		driver.findElement(By.xpath("//input[@id='devname']")).click();
		driver.findElement(By.xpath("//td[@class='pbButtonb']//input[@data-uidsfdc='4']")).click();
		report.logTestpassed();

	}

	@Test
	public static void CheckRecentlyCreatedContact() throws InterruptedException {
//		setup();
//		Thread.sleep(10000);
//		getLightningPopup();
//		getContactsTab();
        driver.findElement(By.xpath("//select[@id='hotlist_mode']")).click();
        driver.findElement(By.xpath("//option[@value='2']")).click();
		report.logTestpassed();
	}

	@Test
	public static void MyContactsView() throws InterruptedException {

//		setup();
//		Thread.sleep(10000);
//		getLightningPopup();
//		getContactsTab();

		WebElement dropdown = driver.findElement(By.xpath("//select[@id='fcf']"));
		Thread.sleep(5000);
		Select mycontact = new Select(dropdown);
		mycontact.selectByVisibleText("My Contacts");
		report.logTestpassed();

	}
    @Test
	public static void ViewAContact() throws InterruptedException {
//		setup();
//		Thread.sleep(10000);
//		getLightningPopup();
//		getContactsTab();
		WebElement recent = driver.findElement(By.id("hotlist_mode"));
		Select create = new Select(recent);
		create.selectByVisibleText("Recently Created");
		report.logTestpassed();
	}

	@Test
	public static void CheckErrorMessage() throws InterruptedException, IOException {
//		setup();
//		Thread.sleep(10000);
//		getLightningPopup();
//		getContactsTab();

		driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();

		WebElement uniquename = driver.findElement(By.xpath("//input[@id='devname']"));
		uniquename.sendKeys("EFGH");
		driver.findElement(By.xpath("//td[@class='pbButtonb']//input[@data-uidsfdc='4']")).click();
		takesScreenShot("CONTACTSerrormessage.PNG");
		report.attachScreeshot("/SeleniumAutomationAssignment/screenshots/Sat_May_21_13-52-30_PDT_2022CONTACTSerrormessage.PNG");
		report.logTestpassed();
	}

	@Test
	public static void CheckCancelbutton() throws InterruptedException {
//		setup();
//		Thread.sleep(10000);
//		getLightningPopup();
//		getContactsTab();
        WebElement createnewview = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
        waitUntilVisible(createnewview, "create new view");
        mouseOver(createnewview, "create new view");
        createnewview.click();
		WebElement viewname = driver.findElement(By.xpath("//input[@id='fname']"));
		viewname.sendKeys("ABCD");

		WebElement uniquename = driver.findElement(By.xpath("//input[@id='devname']"));
		clearElement(uniquename, "unique name");
		uniquename.sendKeys("EFGH");
		driver.findElement(By.xpath("//div/table/tbody/tr/td[2]/input[2]")).click();
		report.logTestpassed();
	}

	@Test
	public static void CheckSaveAndNewButton() throws InterruptedException {
//		setup();
//		Thread.sleep(10000);
//		getLightningPopup();
//		driver.findElement(By.xpath("//li[@id='Contact_Tab']")).click();
		
		driver.findElement(By.xpath("//td[@class='pbButton']//input[@type='button']")).click();
		WebElement lastname = driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
		lastname.sendKeys("Indian");
		WebElement accname = driver.findElement(By.xpath("//input[@id='con4']"));
		accname.sendKeys("Global Media");
		driver.findElement(By.xpath("//input[2][@value='Save & New']")).click();	
		report.logTestpassed();
	}

}
