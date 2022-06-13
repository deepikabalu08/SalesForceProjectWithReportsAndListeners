package com.salesforce.automation;


import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.salesforce.methods.ForceMethods;


//Firefox Browser
//@Listeners(com.salesforce.utilities.GenerateReportsListener.class)
public class SDFCLogin extends ForceMethods {
	
	@Test
	public static void LoginErrorMessage() {
	
		getUsername();
		getPassword();
		getLoginbutton();
		report.logTestpassed();

	}

	@Test
	public static void LoginToSalesForce() throws IOException {
		getUsername();
		getPassword();
		getLoginbutton();
		//getLightningPopup();
		
		//SCREENSHOT FOR FAILED TESTCASE
//		TakesScreenshot ob = (TakesScreenshot)driver; //type-casting driver to screenshot 
//		Date date = new Date();
//		String filename = date.toString().replace(":", "-").replace(" ", "_")+"SDFCLoginToSalesForce.jpg";
//		File sourcepath = ob.getScreenshotAs(OutputType.FILE);
//		String path = ForceConstants.SCREENSHOT_PATH+filename;
//		File Destinationpath = new File(path);
//		FileUtils.copyFile(sourcepath, Destinationpath);	
		
		takesScreenShot("SDFCloginToSalesForce.PNG");
		report.attachScreeshot("/SeleniumAutomationAssignment/screenshots/Sat_May_21_13-56-55_PDT_2022SDFCloginToSalesForce.PNG");
		report.logTestFailed();
		

	}

	@Test
	public static void CheckRememberMe() throws InterruptedException {
		getUsername();
		getPassword();
		driver.findElement(By.id("rememberUn")).click();
		getLoginbutton();
		//Thread.sleep(10000);
		//getLightningPopup();
		getUserMenu();
		Logout();
		report.logTestpassed();
	

	}

	@Test
	public static void ForgetPasswordA() {
		driver.findElement(By.id("forgot_password_link")).click();
		report.logTestInfo("forgot password link clicked");
		WebElement username = driver.findElement(By.xpath("//input[@id='un']"));
		username.sendKeys("deepikabalusamy-e5pl@force.com");
		report.logTestInfo("Username provided in forget password page");
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		report.logTestInfo("Continue button clicked");		
		report.logTestpassed();
		
	}

	@Test
	public static void ForgetPasswordB() {
		WebElement login1 = driver.findElement(By.id("username"));
		waitUntilVisible(login1, "login");
		login1.sendKeys("123");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("22131");
		driver.findElement(By.id("Login")).click();
		report.logTestpassed();
		
	}

}
