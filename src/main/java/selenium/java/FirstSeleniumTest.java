package selenium.java;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTest {

	public static void main(String[] args) {
		/* Automate google search page to verify the search functionality
		 *  1. Open the chrome browser
		 *  2. Go to google.com
		 *  3. Type "Hello World" in google search textbox
		 *  4. Click on search button
		 *  5. Verify the search result page
		 *  6. Close the chrome browser
		 */
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "/Users/mrityunjaykumarranjan/Downloads/chromedriver");
		//1
		ChromeDriver driver=new ChromeDriver();
		//2
		driver.get("https://www.google.com");
		//3 & 4th steps
		driver.findElement(By.name("q")).sendKeys("Hello world"+Keys.ENTER);
		//driver.findElementByName("q").sendKeys("Hello World");
		//5
		String title=driver.getTitle();
		System.out.println("Title of search page: "+title);
		
		//6
		driver.close();
		driver.quit();
		
		/*
		 * Click
		 * Type
		 * Verify
		 * 
		 * Write a selenium test that should navigate to http://newtours.demoaut.com/ and print title
		 */
	}

}
/*Locators
 * 9 type of locators
 * 
 */
