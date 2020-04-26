package selenium.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ExceptionDemo {

	public static void main(String[] args) {
		
		//doSomeCalculation();
		readTextFile();
		System.out.println("Thank you for using my software");
	}

	public static void doSomeCalculation() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter two numbers for divison operation:");
		int x = sc.nextInt();
		int y= sc.nextInt();
		
		try {
			// Exception handling
				int res= x/y;
			 System.out.println("Division of two number = "+res);
			 
		}catch(Exception ex) {
			System.out.println("You can not divide any number with 0");
		}
	}
	
	public static void readTextFile() {
		
		File f = new File("/Users/mrityunjaykumarranjan/eclipse-saluja/java/DemoFile.txt");
		try {
			FileInputStream fs=new FileInputStream(f);
			char c;
			while((c=(char)fs.read())!=-1)
				System.out.print(c);
			
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
		catch(IOException ex) {
			System.out.println("Error while reading the file");
		}
		
	}
	
}
