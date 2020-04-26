package selenium.java;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DemoTestcase {
	String originalData="somedataitshoudshow";
	
	
	
	 WebDriver driver;
	  @BeforeTest
	  public void beforeTest() {
		  
		  if(ConfigurationManager.getBundle().getProperty(originalData) instanceof HashMap){
			//some code  
		  }
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  WebDriver driver=new ChromeDriver();
		  driver.get("https://letskodeit.teachable.com/p/practice");
		  List<WebElement> allPayment = driver.findElements(By.xpath("//td[3]/button/span"));
		  List<String> allPaymentLink = new ArrayList<String>();
		  for(WebElement p:allPayment) {
			  String temp=p.getText();
			  allPaymentLink.add(temp);
			  System.out.println(temp);
		  }
		  
	  }
	  
	  
  @Test
  public void firstTestcase() {
	  driver.findElement(By.xpath(".//input[@id='bmwradio']")).click();
	  //WebElement select=
  }


  @AfterTest
  public void afterTest() {
	  
	 
  }

}
