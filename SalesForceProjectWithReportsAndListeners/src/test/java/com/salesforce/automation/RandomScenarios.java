package com.salesforce.automation;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.salesforce.methods.ForceMethods;

public class RandomScenarios extends ForceMethods {
	@BeforeMethod
	public void setupRandomScenarios() throws InterruptedException {
		getUsername();
		getPassword();
		getLoginbutton();
//		Thread.sleep(10000);
//		getLightningPopup();
	}
	@Test
	public static void VerifyFirstNameAndLastName() throws InterruptedException {
//		setup();
//		Thread.sleep(10000);
//		getLightningPopup();	
		getHomeTab();
		Thread.sleep(10000);
		getLightningPopup();
		driver.findElement(By.linkText("Deepika Abcd")).click();
		report.logTestpassed();
	}
	@Test
	public static void VerifyEditedLastName() throws InterruptedException {
//		setup();
//		Thread.sleep(10000);
//		getLightningPopup();	
		getHomeTab();
		Thread.sleep(10000);
		getLightningPopup();
		driver.findElement(By.linkText("Deepika Abcd")).click();
		driver.findElement(By.xpath("//a/img[@title='Edit Profile']")).click();
		WebElement switchtoframe =driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']"));
		driver.switchTo().frame(switchtoframe);
		WebElement about =driver.findElement(By.xpath("//a[contains(text(),'About')]"));
		waitUntilVisible(about, "about");
		mouseOver(about, "about");
		about.click();
		
		WebElement lastname = driver.findElement(By.xpath("//input[@id='lastName']"));
		clearElement(lastname, "last name");
		lastname.sendKeys("Abcd");
		driver.findElement(By.xpath("//form/div/input[@value='Save All']")).click();		
		report.logTestpassed();
	}
	@Test
	public static void VerifyTabCustomization() throws InterruptedException {
//		setup();
//		Thread.sleep(10000);
//		getLightningPopup();
		driver.findElement(By.xpath("//li[@id='AllTab_Tab']")).click();
		driver.navigate().refresh();
//		driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[3]/div[1]/table/tbody/tr/td[2]/input")).click();
		WebElement customize = driver.findElement(By.xpath("//tr/td[2]/input[@class='btnImportant' and @name='customize']"));
		waitUntilVisible(customize, "customize");
		mouseOver(customize, "customize");
		clickElement(customize, "customize");
		driver.navigate().refresh();
		WebElement ideas = driver.findElement(By.xpath("//select/option[text()='Ideas']"));
		mouseOver(ideas, "ideas");
		clickElement(ideas, "ideas");
		driver.findElement(By.xpath("//img[contains(@class,'leftArrowIcon')]")).click();
		driver.findElement(By.xpath("//tbody/tr/td[2]/input[@name='save']")).click();
		
		getUserMenu();
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();	
		closeDriver();
		getDriver();
		windowMaximize();
		driver.get("https://login.salesforce.com/");	
		getUsername();
		getPassword();
		getLoginbutton();
//		Thread.sleep(20000);
//		getLightningPopup();		
		report.logTestpassed();	
	}
	@Test
	public static void BlockingAnEventInCalendar() throws InterruptedException {
//	    setup();
//		Thread.sleep(10000);
//		getLightningPopup();
		getHomeTab();
		Thread.sleep(10000);
		getLightningPopup();
		driver.findElement(By.xpath("//span[@class='pageDescription']//a")).click();
        driver.findElement(By.xpath("//a[contains(text(),'8:00 PM')]")).click();

        By subjectLocator = By.xpath("//a[@title='Combo (New Window)']//img");
        waitUntilElementToBeClickable(subjectLocator, "subject");
        WebElement comboBoxWindow = driver.findElement(subjectLocator);
        clickElement(comboBoxWindow, "combo box");
        
        String baseWindowHandle = driver.getWindowHandle();
		System.out.println("value of base window handle=" + baseWindowHandle);
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!handle.equalsIgnoreCase(baseWindowHandle)) {
				driver.switchTo().window(handle);		
				break;
			}
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'Other')]")).click();
		driver.switchTo().window(baseWindowHandle);
		driver.findElement(By.xpath("//input[@id='EndDateTime_time']")).click();
		driver.findElement(By.xpath("//div[@id='timePickerItem_42']")).click();
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/input[1][@title='Save']")).click();
		report.logTestpassed();
            
	}
	@Test
	public static void WeeklyReccurance() throws InterruptedException {
//		setup();
//		Thread.sleep(10000);
//		getLightningPopup();
		
		getHomeTab();
		Thread.sleep(10000);
		getLightningPopup();
		driver.findElement(By.cssSelector(".pageDescription > a:nth-child(1)")).click();
		driver.findElement(By.xpath("//a[contains(text(),'4:00 PM')]")).click();
		 By subjectLocator = By.xpath("//a[@title='Combo (New Window)']//img");
	        waitUntilElementToBeClickable(subjectLocator, "subject");
	        WebElement comboBoxWindow = driver.findElement(subjectLocator);
	        clickElement(comboBoxWindow, "combo box");
	        
	        String baseWindowHandle = driver.getWindowHandle();
			System.out.println("value of base window handle=" + baseWindowHandle);
			Set<String> allWindowHandles = driver.getWindowHandles();
			for (String handle : allWindowHandles) {
				if (!handle.equalsIgnoreCase(baseWindowHandle)) {
					driver.switchTo().window(handle);		
					break;
				}
			}
			Thread.sleep(5000);
			driver.findElement(By.xpath("//a[contains(text(),'Other')]")).click();
			driver.switchTo().window(baseWindowHandle);
			driver.findElement(By.xpath("//input[@id='EndDateTime_time']")).click();
			driver.findElement(By.xpath("//div[@id='timePickerItem_38']")).click();
			driver.findElement(By.xpath("//input[@id='IsRecurrence']")).click();
			driver.findElement(By.xpath("//input[@id='rectypeftw']")).click();
			driver.findElement(By.xpath("//input[@id='wi']"));
			driver.findElement(By.xpath("//input[@id='RecurrenceEndDateOnly']"));
			//calculating 2 weeks from now	
			Date date = new Date(); 
			Calendar calendar = Calendar.getInstance(); 
			calendar.setTime(date); 
			calendar.add(Calendar.DATE, 14);  //adding 14 days to the calendar
			date = calendar.getTime(); 
			 			 
			String twoweeksdate = new SimpleDateFormat("MM/dd/yyyy").format(date); 
			 
			//enter two week's date from now in the field 
			WebElement twoweeks = driver.findElement(By.xpath("//input[@id='RecurrenceEndDateOnly']")); 
			twoweeks.sendKeys(twoweeksdate);
			
			driver.findElement(By.xpath("//td[contains(text(),'Reminder')]")).click();
			//to avoid the popup - (doing this for my convenience - setting 2 weeks in a reminder)
			WebElement reminder = driver.findElement(By.xpath("//select[@id='reminder_lt']"));
			waitUntilVisible(reminder, "reminder");
			Select view = new Select(reminder);
			view.selectByVisibleText("2 weeks");
			
			driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@name='save']")).click();
			driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[2]/span[2]/a[3]/img[1]")).click();
			report.logTestpassed();
			

	}
	

}
