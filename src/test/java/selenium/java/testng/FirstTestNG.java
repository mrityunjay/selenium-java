package selenium.java.testng;

import org.testng.annotations.Test;

import selenium.java.*;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class FirstTestNG {

	//this function run before all the testcaes start running
	@BeforeTest
	public void beforeTest() {
		System.out.println("I am running before test");
		System.out.println("I want to add this line to git");
	}
	
	//global variable
	WebDriver xyz;
	
	@Test
	public void myfirstTestcase() {
		System.out.println("My First Testcase is running");
		xyz=Library.launchChrome("https://letskodeit.teachable.com/p/practice");
		xyz.findElement(By.id("bmwradio")).click();
		
		new Select(xyz.findElement(By.id("carselect"))).selectByIndex(1);
		
		new Select(xyz.findElement(By.id("multiple-select-example"))).selectByIndex(1);

		xyz.findElement(By.xpath("(//input[@name='cars' and @type='checkbox'])[1]")).click();
		xyz.findElement(By.xpath("(//input[@name='cars' and @type='checkbox'])[2]")).click();
		
	}

	//this function run after completion of all the testcases
	@AfterTest
	public void afterTest() {
		System.out.println("I am running after test");
		//xyz.close();
	}

	@Test
	public void mysecondTestcase() {
		System.out.println("My Second Testcase is running");
	}

	public void printMyName() {
		System.out.println("My name is Ranjan");
	}



}
