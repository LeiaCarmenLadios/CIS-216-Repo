package matrixlab;

import java.util.Scanner;

// Main method
public class MatrixMain {
	public static void main(String args[]) {
		
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Make your first matrix!");
		System.out.print("Rows: ");
		int rows = in.nextInt();
		
		System.out.print("Columns: ");
		int cols = in.nextInt();
		
		Matrix first = new Matrix (rows, cols);
		
		first.getInput();
		
		
		System.out.println("Make another Matrix to Add/Multiply!");

		System.out.print("Rows: ");
		int rowsTwo = in.nextInt();
		
		System.out.print("Columns: ");
		int colsTwo = in.nextInt();
		
		Matrix second = new Matrix (rowsTwo, colsTwo);
		
		second.getInput();
		
		boolean done = false;
		while(!done) {
			System.out.println("Actions: 1) Add Matrices \n\t 2) Multiply Matrices (Please Enter 1 or 2)");
			int choice = in.nextInt();
			
			if(choice == 1) {
				Matrix status  = first.add(second);
				
				if(status == null) {
					System.out.println("You can't add these matrices.");
				}
				else{
					System.out.println("\n" + status);
				}
				
				System.out.println("Would you like to perform another operation? (Y/N)");
				String goAgain = in.next();
				
				if(goAgain.equalsIgnoreCase("Y")){
					done = false;
				}
				else {
					done = true;
				}
				
			}
			else if(choice == 2) {
				Matrix status  = first.multiply(second);
				
				if(status == null) {
					System.out.println("You can't multiply these matrices.");
				}
				else{
					System.out.println("\n" + status);
				}
				
				System.out.println("Would you like to perform another operation? (Y/N)");
				String goAgain = in.next();
				
				if(goAgain.equalsIgnoreCase("Y")){
					done = false;
				}
				else {
					done = true;
				}
			}
			else{
				System.out.println("You entered an invalid choice.");
				
				System.out.println("Would you like to perform a different operation? (Y/N)");
				String goAgain = in.next();
				
				if(goAgain.equalsIgnoreCase("Y")){
					done = false;
				}
				else {
					done = true;
				}
			}
		
		}
		
	}
	
}




