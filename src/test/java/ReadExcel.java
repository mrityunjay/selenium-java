import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import selenium.java.AutomationSteps;

public class ReadExcel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
			new ReadExcel().keywordsExecutionDriver();
	}
	
	public void keywordsExecutionDriver() throws Exception {
		String fileName = "/Users/mrityunjaykumarranjan/Downloads/Testcase.xlsx";
		FileInputStream fis = new FileInputStream(fileName);
		Workbook workbook = new XSSFWorkbook(fis);
		
		Sheet sheet = workbook.getSheetAt(0);
		
		for(int r=1;r<5;r++) { 
				Cell cell= sheet.getRow(r).getCell(1);
				//To check the null value
				
				if(cell !=null && cell.getCellType() != Cell.CELL_TYPE_BLANK) {
					String data=cell.getStringCellValue();
					System.out.println(data+"\t");
					
					// Java reflection
					AutomationSteps steps=new AutomationSteps();
					
					Class c = AutomationSteps.class;
					
					Method m = c.getMethod(data);
					
					m.invoke(steps);
					
					//steps.launchChrome();
					
				}
			
		}
		}

	
	public void readExcelFile() throws IOException {
		String fileName = "/Users/mrityunjaykumarranjan/Downloads/Testcase.xlsx";
		FileInputStream fis = new FileInputStream(fileName);
		Workbook workbook = new XSSFWorkbook(fis);
		
		int totalworkSheet = workbook.getNumberOfSheets();
		String sheetname = workbook.getSheetName(0);
		Sheet sheet = workbook.getSheetAt(0);
		for(int r=0;r<9;r++) { //number of rows
			for(int i=0;i<3;i++) { // number of columns
				Cell cell= sheet.getRow(r).getCell(i);
				//To check the null value
				
				if(cell !=null && cell.getCellType() != Cell.CELL_TYPE_BLANK) {
					String data=cell.getStringCellValue();
					System.out.print(data+"\t");
				}
			}
			System.out.println();
		}
		
		/*for(int i=0;i<3;i++) {
			String data=sheet.getRow(1).getCell(i).getStringCellValue();
			System.out.print(data+"\t");
		}
		
		System.out.println();
		for(int i=0;i<3;i++) {
			String data=sheet.getRow(2).getCell(i).getStringCellValue();
			System.out.print(data+"\t");
		}*/
		
		//System.out.println("\n\nTotal number of work sheets are:"+totalworkSheet);
		//System.out.println("Name of the work sheet:" +sheetname);
		
	}

}
