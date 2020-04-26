package selenium.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class UniversityStepDef {
	String url;
	WebDriver driver;
	ASUHomePage homePage;
	GetStarted getStarted;
	@Given("the university site url {string}")
	public void the_university_site_url(String url) {
		System.setProperty("webdriver.chrome.driver", "/Users/shashank/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		this.url= url;
	}
	@When("I open the website")
	public void i_open_the_website() {
		driver.get(url);
	}
	@When("Click on Request Info button")
	public void click_on_Request_Info_button() {
	    homePage = new ASUhomePage(driver);
	    getStarted = homePage.clickOnRequestInfo();
	}
	@Then("it move to next page.")
	public void it_move_to_next_page() {
	}
	@Then("Fill up the Get Started Today section")
	public void fill_up_the_Get_Started_Today_section() {
		getStarted.selectDegreeType();
		getStarted.selectAreaInterest();
		getStarted.selectProgramType();
	}
	@Then("Click on Continue button")
	public void click_on_Continue_button() {
	    getStarted.clickOnContinueButton();
	}
	@Then("Save the form data to excelFile")
	public void saveFIle() {
		getStarted.writeDataToExcel();
	}
}