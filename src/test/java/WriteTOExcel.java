import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteTOExcel {

	public static void main(String[] args) {
		new WriteTOExcel().writeExcelFile();
		new WriteTOExcel().updateExcelFile();
		new WriteTOExcel().readExcelData();
	}
	
	
	public void writeExcelFile() {
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Java Books");
         
        Object[][] bookData = {
                {"Head First Java", "Kathy Serria", 79},
                {"Effective Java", "Joshua Bloch", 36},
                {"Clean Code", "Robert martin", 42},
                {"Thinking in Java", "Bruce Eckel", 35},
        };
 
        int rowCount = 0;
         
        for (Object[] aBook : bookData) {
            Row row = sheet.createRow(rowCount++);
             
            int columnCount = 0;
             
            for (Object field : aBook) {
                Cell cell = row.createCell(columnCount++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
             
        }
         
         
        try {
        	FileOutputStream outputStream = new FileOutputStream("JavaBooks.xlsx"); 
        	workbook.write(outputStream);
        	outputStream.close();
        }catch(Exception e) {
        	e.printStackTrace();
            
        }
	}
	 public void updateExcelFile() {
	        String excelFilePath = "JavaBooks.xlsx";
	         
	        try {
	            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	            Workbook workbook = WorkbookFactory.create(inputStream);
	 
	            Sheet sheet = workbook.getSheetAt(0);
	 
	            Object[][] bookData = {
	                    {"The Passionate Programmer", "Chad Fowler", 16},
	                    {"Software Craftmanship", "Pete McBreen", 26},
	                    {"The Art of Agile Development", "James Shore", 32},
	                    {"Continuous Delivery", "Jez Humble", 41},
	            };
	 
	            int rowCount = sheet.getLastRowNum();
	 
	            for (Object[] aBook : bookData) {
	                Row row = sheet.createRow(rowCount++);
	 
	                int columnCount = 0;
	                 
	                Cell cell = row.createCell(columnCount);
	                cell.setCellValue(rowCount);
	                 
	                for (Object field : aBook) {
	                    cell = row.createCell(columnCount++);
	                    if (field instanceof String) {
	                        cell.setCellValue((String) field);
	                    } else if (field instanceof Integer) {
	                        cell.setCellValue((Integer) field);
	                    }
	                }
	 
	            }
	 
	            inputStream.close();
	 
	            FileOutputStream outputStream = new FileOutputStream("JavaBooks.xlsx");
	            workbook.write(outputStream);
	            //workbook.close();
	            outputStream.close();
	             
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
	    }
	 
	 public void readExcelData() {
		 String excelFilePath = "JavaBooks.xlsx";
         try {
		  FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
          Workbook workbook = WorkbookFactory.create(inputStream);

          Sheet sheet = workbook.getSheetAt(0);
          for(int i=0;i<sheet.getLastRowNum();i++) {
        	  Row row=sheet.getRow(i);
        	  for(int j=0;j<row.getLastCellNum(); j++) {
        		  Cell cell=row.getCell(j);
        		  if(cell==null || cell.getCellType()==Cell.CELL_TYPE_BLANK)
        		  System.out.println("NULL Value");
        			  else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
        			  System.out.print(cell.getNumericCellValue());
        		  else if(cell.getCellType()==Cell.CELL_TYPE_STRING)  
        			  System.out.print(cell.getStringCellValue());
        	  }
        	  System.out.println();
          }
          inputStream.close();
         }catch(Exception e) {
        	 e.printStackTrace();
         }
	 }

}
