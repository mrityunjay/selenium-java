package selenium.java;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

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
	
	public static WebDriver launchChromeRemote(String url) throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "/Users/mrityunjaykumarranjan/Downloads/chromedriver");
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		WebDriver temp = new RemoteWebDriver(new URL("http://192.168.29.75:4444/wd/hub"), capability);
		//WebDriver temp=new ChromeDriver();
		temp.get(url);
		return temp;
	}

	public static void clearAndTypeValue(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
}
