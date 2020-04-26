package selenium.java;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class ASUHomePage {

	WebDriver driver;
	public ASUHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);//constructor initialized POM
	}
	@FindBy(how=How.XPATH, using = "//ul/a[text()='Request info']")
	private WebElement linkRequestInfo;
	//Let me know if everyone is available to start
	public GetStarted clickOnRequestInfo() {
		linkRequestInfo.click();
		//this is abstraction. make var as private and expose it as method.
		return new GetStarted(driver);
	}
}
