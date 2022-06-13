package com.salesforce.automation;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.salesforce.methods.ForceMethods;

public class UserMenuDropDown extends ForceMethods {
	
	@BeforeMethod
	public void setupUserMenu() throws InterruptedException {
		getUsername();
		getPassword();
		getLoginbutton();
		//Thread.sleep(10000);
		//getLightningPopup();
		getUserMenu();
		
	}
	
	@Test
	public static void UserMenu() throws InterruptedException {
//		setup();
//		Thread.sleep(10000);
//		getLightningPopup();
//		getUserMenu();	
		
		report.logTestpassed();
	}

	@Test(enabled = true)
	public static void MyProfile() throws InterruptedException {
//		setup();
//		Thread.sleep(10000);
//		getLightningPopup();
//		getUserMenu();
		
		driver.findElement(By.xpath("//a[contains(text(),'My Profile')]")).click();
	
		//changing last name
		driver.navigate().refresh();
		Thread.sleep(5000);
		WebElement edit = driver.findElement(By.xpath("//div/div/h3/div/div/a[contains(@class,'contactInfoLaunch editLink')]"));
		mouseOver(edit, "edit");
		clickElement(edit, "edit");
		//driver.findElement(By.xpath("//a[contains(@class,'contactInfoLaunch editLink')]")).click();
		Thread.sleep(10000);		
		driver.switchTo().frame("contactInfoContentId");		
		By aboutlocator = By.xpath("//a[contains(text(),'About')]");
		WebElement about = driver.findElement(aboutlocator);
		waitUntilElementToBeClickable(aboutlocator, "about");
		mouseOver(about, "about");
		about.click();
		WebElement lastname = driver.findElement(By.xpath("//input[@id='lastName']"));
		clickElement(lastname, "lastname");
		lastname.clear();
		lastname.sendKeys("Abcd");
		driver.findElement(By.xpath("//div//input[@value='Save All']")).click();

		//posting a text
		
	    driver.findElement(By.xpath("//*[@id=\"publisherAttachTextPost\"]/span[1]")).click();
	    driver.switchTo().frame(0);
	    driver.findElement(By.xpath("/html/body")).sendKeys("Have a good day");
	    driver.switchTo().parentFrame();
	    By locator = By.id("publishersharebutton");
        WebElement submit = driver.findElement(locator);
        waitUntilElementToBeClickable(locator,"locator");
        clickElement(submit, "submit");
 
 
		//uploading a file
		
		driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'File')]")).click();
		driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']")).click();
		WebElement fileupload = driver.findElement(By.id("chatterFile"));
		fileupload.sendKeys("C:\\Users\\deepi\\OneDrive\\Desktop\\Salesforce\\File.jpg");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='publishersharebutton']")).click();
        
        //adding profile pic
			
		WebElement addphoto = driver.findElement(By.xpath("//a[@id='uploadLink']"));
		waitUntilVisible(addphoto, "add photo");
		mouseOver(addphoto, "add photo");
		addphoto.click();
		driver.switchTo().frame("uploadPhotoContentId");
		Thread.sleep(5000);
		//as we are uploading a file from window based pop
		// we shouldn't give mouse over, wait and click method. 
		//we should directly give the path in sendkeys method.
		WebElement picupload = driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadInputFile']"));
		picupload.sendKeys("C:\\Users\\deepi\\OneDrive\\Desktop\\Salesforce\\profilepic.jpg");
		Thread.sleep(5000);
		WebElement savebutton = driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadBtn']"));
		Thread.sleep(5000);
		//JAVASCRIPT EXECUTOR
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", savebutton);
		Thread.sleep(10000);
		WebElement finalsave = driver.findElement(By.xpath("//*[@id=\"j_id0:j_id7:save\"]"));
		//JAVASCRIPT EXECUTOR
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", finalsave);
		Thread.sleep(10000);
		report.logTestpassed();

	}

	@Test
	public static void MySettings() throws InterruptedException {
//		setup();
//		Thread.sleep(10000);
//		getLightningPopup();
//		getUserMenu();
		driver.findElement(By.xpath("//a[contains(text(),'My Settings')]")).click();
		//personal link
		driver.navigate().refresh();
		WebElement personalinfo = driver.findElement(By.xpath("//div[@id='PersonalInfo']//a[@class='header setupFolder']"));
		mouseOver(personalinfo, "personal info");
		clickElement(personalinfo, "personal info");
		driver.findElement(By.xpath("//a[@id='LoginHistory_font']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Download login history for last six months, includ')]")).click();
		//display & layout link
		driver.findElement(By.xpath(" //span[@id='DisplayAndLayout_font']")).click();
		driver.findElement(By.xpath("//a[@id='CustomizeTabs_font']")).click();
		WebElement customdropdown = driver.findElement(By.xpath("//select[@id='p4']"));
		Select customapp = new Select(customdropdown);
		customapp.selectByVisibleText("Salesforce Chatter");
		driver.findElement(By.xpath("//option[contains(@value,'report')]")).click();
		driver.findElement(By.xpath("//img[contains(@class,'rightArrowIcon')]")).click();
		//email link
		driver.findElement(By.xpath("//div[@id='EmailSetup']//a[@class='header setupFolder']")).click();
		driver.findElement(By.xpath("//a[@id='EmailSettings_font']")).click();
		//driver.findElement(By.xpath("//input[@id='use_external_email0']")).click();
		driver.navigate().refresh();
		WebElement save = driver.findElement(By.xpath("//td//input[@value=' Save ']"));
		mouseOver(save, "save");
		clickElement(save, "save");
		//calendar & reminder link
		driver.findElement(By.xpath("//span[@id='CalendarAndReminders_font']")).click();
		driver.findElement(By.xpath("//span[@id='Reminders_font']")).click();
		driver.navigate().refresh();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
		driver.findElement(By.xpath("//input[@id='testbtn']")).click();
		report.logTestpassed();

	}

	@Test
	public static void DevelopersConsole() throws InterruptedException {
//		setup();
//		Thread.sleep(20000);
//		getLightningPopup();
//		getUserMenu();
		By developerconsoleLocator = By.xpath("//a[@class='debugLogLink menuButtonMenuLink']");
		waitUntilElementToBeClickable(developerconsoleLocator, "developer console");
		WebElement developerConsoleWindow = driver.findElement(developerconsoleLocator);
		clickElement(developerConsoleWindow, "developer console");

		String baseWindowHandle = driver.getWindowHandle();
		System.out.println("value of base window handle=" + baseWindowHandle);
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!handle.equalsIgnoreCase(baseWindowHandle)) {
				driver.switchTo().window(handle);
				driver.close();
				break;
			}
		}
		report.logTestpassed();
	}

	@Test
	public static void LogoutUserMenu() throws InterruptedException {
//		setup();
//		Thread.sleep(10000);
//		getLightningPopup();
//		getUserMenu();
//		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		Logout();
		report.logTestpassed();
		
	
	}

}
