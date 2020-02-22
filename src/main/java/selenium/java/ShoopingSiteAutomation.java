package selenium.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoopingSiteAutomation {

	public static void main(String[] args) {
		String url="http://shop.demoqa.com/";
		System.setProperty("webdriver.chrome.driver", "/Users/mrityunjaykumarranjan/Downloads/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		WebElement message=driver.findElement(By.xpath("/html/body/p"));
		
		System.out.println(message.getText());
		//Xpath Locator
		driver.findElement(By.xpath("/html/body/p/a")).click();
		
		//Class Name
		driver.findElement(By.className("woocommerce-store-notice__dismiss-link")).click();
		
		//LinkText
		driver.findElement(By.linkText("Dismiss")).click();
		
		//Partical Link Text
		driver.findElement(By.partialLinkText("miss")).click();
		
		//Tag Nage
		driver.findElement(By.tagName("a")).click();
	}
	// Relative XPATH-> //*[@id="slide-6-layer-9"]
	// Absolute XPATH -> /html/body/div[1]/div[2]/div[1]/div/div/div/div/div/div/div[1]/div/ul/li/div[6]/div/div/div
	// Relative XPATH -> //div[text()='SHOP NOW > ']
}
