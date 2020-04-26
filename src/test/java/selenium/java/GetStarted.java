package selenium.java;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
public class GetStarted {
	public GetStarted(WebDriver driver) {
		PageFactory.initElements(driver, this);//constructor initialized POM
	}
	@FindBy(how=How.ID, using="degree-type")
	private WebElement selectDegree;
	@FindBy(how=How.ID, using="interest-area")
	private WebElement selectInterestArea;
	@FindBy(how=How.ID, using="program")
	private WebElement selectProgram;
	@FindBy(how=How.XPATH, using="//button[@type='submit']")
	private WebElement continueButton;
	@FindBy(how=How.XPATH, using="//a[text()='I agree']")
	private WebElement agreeButton;
	String degree;
	public void selectDegreeType() {
		Select select=new Select(selectDegree);
		select.selectByIndex(2);
		degree=select.getFirstSelectedOption().getText();
	}
	String interest;
	public void selectAreaInterest() {
		new Select(selectInterestArea).selectByIndex(2);
		interest=new Select(selectInterestArea).getFirstSelectedOption().getText();
	}
	String program;
	public void selectProgramType() {
		new Select(selectProgram).selectByIndex(2);
		program=new Select(selectProgram).getFirstSelectedOption().getText();
	}
	public void clickOnContinueButton() {
		try {
			agreeButton.click();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		continueButton.click();
	}
	public void writeDataToExcel1() {
		XSSFWorkbook  workbook = new XSSFWorkbook();
		XSSFSheet sh =workbook.createSheet("Request Info");
		Row row=sh.createRow(0);
		row.createCell(0).setCellValue("Degree");
		row.createCell(1).setCellValue("Interest");
		row.createCell(2).setCellValue("Program");
		row=sh.createRow(1);
		Cell cell1=row.createCell(0);
		cell1.setCellValue(degree);
		row.createCell(1).setCellValue(interest);
		row.createCell(2).setCellValue(program);
		File file=new File("RequestInfo.xlsx");
		try {
			FileOutputStream stream = new FileOutputStream(file);
			workbook.write(stream);
			stream.close();
			System.out.println("File saved!");
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void writeDataToExcel() {
		try {
		FileInputStream fs = new FileInputStream("RequestInfo.xlsx");
		//File f = new File("RequestInfo.xlsx");
		Workbook  workbook = WorkbookFactory.create(fs); //new XSSFWorkbook();
		//XSSFSheet sh =workbook.createSheet("Request Info");
		Sheet sh =workbook.getSheet("Request Info");
		//Writing the header
		/*Row row=sh.createRow(0);
		row.createCell(0).setCellValue("Degree");
		row.createCell(1).setCellValue("Interest");
		row.createCell(2).setCellValue("Program");*/
		int lastRow = sh.getLastRowNum();
		Row row=sh.createRow(++lastRow);
		Cell cell1=row.createCell(0);
		cell1.setCellValue(degree);
		row.createCell(1).setCellValue(interest);
		row.createCell(2).setCellValue(program);
		File file=new File("RequestInfo.xlsx");
			FileOutputStream stream = new FileOutputStream(file);
			workbook.write(stream);
			stream.close();
			System.out.println("File saved!");
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}