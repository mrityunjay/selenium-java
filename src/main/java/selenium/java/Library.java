package selenium.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Library {
	
	public static WebDriver launchChrome() {
		System.setProperty("webdriver.chrome.driver", "/Users/mrityunjaykumarranjan/Downloads/chromedriver");
		WebDriver driver=new ChromeDriver();
		return driver;
	}
	
	public static WebDriver launchChrome(String url) {
		System.setProperty("webdriver.chrome.driver", "/Users/mrityunjaykumarranjan/Downloads/chromedriver");
		WebDriver temp=new ChromeDriver();
		temp.get(url);
		return temp;
	}

	public static void clearAndTypeValue(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
}
