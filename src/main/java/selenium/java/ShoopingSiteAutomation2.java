package selenium.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoopingSiteAutomation2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Retrieve the Address , Telephone and Email ID from toolqa shopping site
		String url="http://shop.demoqa.com/";
		System.setProperty("webdriver.chrome.driver", "/Users/mrityunjaykumarranjan/Downloads/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		
		String address= driver.findElement(By.tagName("address")).getText();
		String telephone= driver.findElement(By.xpath(".//span[text()='T']//following-sibling::a")).getText();
		String mailID= driver.findElement(By.xpath(".//a[@class='phone-text']")).getText();
		
		System.out.println("Address="+address);
		System.out.println("Telephone="+telephone);
		System.out.println("Mail ID: "+mailID);
		
		driver.close();
	}
}
