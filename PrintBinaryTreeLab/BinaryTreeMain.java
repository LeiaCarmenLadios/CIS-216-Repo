package bnrytrarr;

import java.util.ArrayList;
import java.util.Scanner;

public class BinaryTreeMain {

	public static void main(String[] args) {
		ArrayBinaryTree<String> biTree = new ArrayBinaryTree<String>();
		
		biTree.addRoot(new String ("4"));
		
		biTree.addLeft(0, new String("5"));
	    
		biTree.addRight(0, new String("6"));
		
		biTree.addLeft(1, new String("7"));
		
		biTree.addRight(1, new String("8"));
		
//		biTree.addLeft(2, new String("9"));
		
		biTree.addRight(2, new String("10"));
		
		
		System.out.println(biTree);
		
		
		boolean done = false;
		
		Scanner in = new Scanner(System.in);
		while(!done) {
			
			System.out.println("\nWhat kind of traversal would you like to do?");
			System.out.println("1) Print Tree");
			System.out.println("2) Exit");
			
			int firstChoice = in.nextInt();
			
			if(firstChoice == 1) {
				
				
			}
			else if(firstChoice == 2) {
				done = true;
			}
			else {
				System.out.println("Invalid choice. Please try again.");
			}
			
		}
		
		
	}
}
 
