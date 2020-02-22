package selenium.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AutomateMortgageCalculator {

	public static void main(String[] args) {
		WebDriver driver=Library.launchChrome("https://www.mortgagecalculator.org/");
		
		driver.findElement(By.xpath("//label[text()=' Home Value: ']/following-sibling::input")).clear();
		driver.findElement(By.xpath("//label[text()=' Home Value: ']/following-sibling::input")).sendKeys("10000");
		
		driver.findElement(By.id("downpayment")).sendKeys("1500");
		
		//Loan Amount
		driver.findElement(By.name("param[principal]")).clear();
		driver.findElement(By.name("param[principal]")).sendKeys("5000");
		
		//Interest Rate
		driver.findElement(By.xpath("(.//input[@class='right-cell'])[4]")).sendKeys("4.1");
		//Loan Term
		driver.findElement(By.xpath("(.//input[@class='right-cell'])[5]")).sendKeys("15");
		
		WebElement startMonth=driver.findElement(By.name("param[start_month]"));
		Select selectStartMonth=new Select(startMonth);
		selectStartMonth.selectByVisibleText("Mar");
		
		WebElement year=driver.findElement(By.id("start_year"));
		year.sendKeys("2021");
		
		WebElement pTax=driver.findElement(By.id("pptytax"));
		pTax.sendKeys("100");
		
		WebElement pmi=driver.findElement(By.id("pmi"));
		pmi.clear();
		pmi.sendKeys("0.6");
		
		WebElement homeIns=driver.findElement(By.id("hoi"));
		homeIns.sendKeys("200");
		
		/*WebElement loanType=driver.findElement(By.name("param[milserve]"));
		Select selectLoanType=new Select(loanType);
		selectLoanType.selectByIndex(1);*/
		
		new Select(driver.findElement(By.name("param[milserve]"))).selectByIndex(1);
		
		//selectLoanType.selectByVisibleText("FHA");
		//selectLoanType.selectByValue("2");
		
		WebElement buy=driver.findElement(By.name("param[refiorbuy]"));
		Select selectBuy=new Select(buy);
		selectBuy.selectByVisibleText("Buy");
		
		WebElement credit_rating=driver.findElement(By.id("credit_rating"));
		Select select_credit_rating=new Select(credit_rating);
		select_credit_rating.selectByIndex(1);

		WebElement calcButton=driver.findElement(By.xpath("//input[@name='cal']"));
		calcButton.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement monthlyPayment=driver.findElement(By.xpath("//div[@class='repayment-block']//h3"));
		String mPay=monthlyPayment.getText();
		System.out.println("Your monthly payment is: "+mPay);
	}

}
