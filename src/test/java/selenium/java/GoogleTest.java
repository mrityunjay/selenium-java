package selenium.java;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class GoogleTest {
	
	ExtentTest test;
	ExtentReports report;
	//logging
	private final static Logger LOGGER =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	
	
  @Test(dataProvider="googleSearchData")
  public void googleSearch(String data) throws SecurityException, IOException {
	  
	  //Logging in java
	  	FileHandler fh=new FileHandler("app.log");
		SimpleFormatter formatter = new SimpleFormatter();  
		fh.setFormatter(formatter); 
		LOGGER.addHandler(fh);
		
		
		LOGGER.log(Level.WARNING, "Before starting the chrome browser");
	
	  test=report.startTest("Perform the search on google.com with data "+data);
	  WebDriver driver=Library.launchChrome("https://www.google.com");
	  test.log(LogStatus.PASS, "Chrome browser got lauched successfully");
	  
	  LOGGER.log(Level.INFO, "After starting the chrome browser");
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  
	  driver.findElement(By.name("q")).sendKeys(data+Keys.ENTER);
	  
	  TakesScreenshot screen = (TakesScreenshot) driver;
	  File file=screen.getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(file, new File("Google"+data+".png"));
	  
	  test.log(LogStatus.FAIL, "Search is working as expected");
	  Assert.assertTrue(driver.getTitle().contains(data));
	  driver.close();
	  test.log(LogStatus.PASS, "closed the browser");
	  LOGGER.log(Level.INFO, "Test completed");
	  
	  
  }
 
  @DataProvider(name="googleSearchData")
  public String[][] dataProvider(){
	  String [][] data=  {{"java"},{"selenium"},{"testNG"}};
	  
	  return data;
	  
  }
  
  
  @BeforeTest
  public void beforeTest() {
	  report= new ExtentReports("report.html");
	  
  }

  @AfterTest
  public void afterTest() {
	  report.endTest(test);
	  report.flush();
  }

}
