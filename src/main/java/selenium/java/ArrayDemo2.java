package selenium.java;

import java.util.*;

public class ArrayDemo2 {

	public static void main(String[] args) {
		//int arr[]=new int[5];
		ArrayList<Integer> arr=new ArrayList<Integer>();
		Scanner sc=new Scanner(System.in);
		
		for(int i=0;;i++) {
			
			System.out.println("Enter a number to store in array, enter 0 to exit:");
			int userNumber=sc.nextInt();
			if(userNumber==0)
				break;
			
			//arr[i]=userNumber;
			arr.add(userNumber);
			
		}
		System.out.println("You have entered:");
		for(int i=0;i<arr.size();i++)
			System.out.print(arr.get(i)+", ");

	}

}
