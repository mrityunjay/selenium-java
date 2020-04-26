package selenium.java;

//import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import selenium.java.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.junit.Test;
//import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class FirstTest {
	
	// x=30;
	 static int x;
	 
	static ExtentTest test;
	static ExtentReports report;
	 private final static Logger LOGGER =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	//this function run before all the testcase start running
	@BeforeTest
	public void beforeTest() {
		System.out.println("I am running before test");
		System.out.println("I want to add this line to git");
		
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		test = report.startTest("ExtentDemo");
	}
	
	//global variable
	WebDriver xyz;
	
	@Test
	public void myfirstTestcase() throws SecurityException, IOException {
		System.out.println("My First Testcase is running");
		FileHandler fh=new FileHandler("app.log");
		SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter); 
		LOGGER.addHandler(fh);
		
		
		LOGGER.log(Level.INFO, "Before starting the chrome browser"); 
		xyz=Library.launchChrome("https://letskodeit.teachable.com/p/practice");
		test.log(LogStatus.PASS, "Launched the Chrome Navigated to the specified URL");
		xyz.findElement(By.id("bmwradio")).click();
		test.log(LogStatus.PASS, "Clicked on bmw radio");
		new Select(xyz.findElement(By.id("carselect"))).selectByIndex(1);
		test.log(LogStatus.PASS, "Selected bmw from car select combo box");
		new Select(xyz.findElement(By.id("multiple-select-example"))).selectByIndex(1);
		test.log(LogStatus.PASS, "Multiple select worked as expected");
		xyz.findElement(By.xpath("(//input[@name='cars' and @type='checkbox'])[1]")).click();
		xyz.findElement(By.xpath("(//input[@name='cars' and @type='checkbox'])[2]")).click();
		test.log(LogStatus.PASS, "Clicked on checkboxes");
		
	}

	//this function run after completion of all the testcases
	@AfterTest
	public void afterTest() {
		System.out.println("I am running after test");
		report.endTest(test);
		report.flush();
		//xyz.close();
	}

	//@Test
	public void mysecondTestcase() {
		System.out.println("My Second Testcase is running");
	}

	public void printMyName() {
		System.out.println("My name is Ranjan");
	}



}
