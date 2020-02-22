package selenium.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTourWebsiteDemo {

	public static void main(String[] args) {
		//Setup the chromedriver path
		System.setProperty("webdriver.chrome.driver", "/Users/mrityunjaykumarranjan/Downloads/chromedriver");
		//Launch Chrome driver
		WebDriver driver=new ChromeDriver();
		//Navigate to the site
		String url="https://www.amazon.com/";
		driver.get(url);
		//Get the title of website
		System.out.println(driver.getTitle());
		//Click on menu button
		driver.findElement(By.id("nav-hamburger-menu")).click();
		//Click on Hello Sign in button
		driver.findElement(By.id("hmenu-customer-name")).click();
	}

}
