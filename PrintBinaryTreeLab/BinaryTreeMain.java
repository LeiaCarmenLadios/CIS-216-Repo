package bnrytrarr;

import java.util.ArrayList;
import java.util.Scanner;

public class BinaryTreeMain {

	public static void main(String[] args) {
		
		
		boolean done = false;
		
		while(!done) {
			Scanner in = new Scanner(System.in);
			System.out.println("What would you like to do?");
			System.out.println("1) Start a tree");
			System.out.println("2) Exit");
			
			int firstChoice = in.nextInt();
			
			
			
			if (firstChoice == 1) {
				ArrayBinaryTree<Integer> biTree = new ArrayBinaryTree<Integer>();
				System.out.print("First, enter a number that will be the root: ");
				biTree.addRoot(in.nextInt());
				
				
				
				boolean doneTwo = false;
				while(!doneTwo) {
					
					System.out.println();
					System.out.println("What would you like to do next?");
					
					System.out.println("1) Add left node");
					System.out.println("2) Add right node");
					System.out.println("3) Print tree");
					System.out.println("4) Exit");
					
					int choiceTwo = in.nextInt();
					
					if(choiceTwo == 1) {
						System.out.println();
						System.out.print("Enter a number for the left node: ");
						int entry = in.nextInt();
						
						if(biTree.size() == 1) {
							biTree.addLeft(biTree.root(), entry);
						}
						else {
							System.out.println();
							System.out.print("Which element should it be attached to? ");
							int attachTo = in.nextInt();
							biTree.addLeft(attachTo, entry);
						}
					    
					}
					else if(choiceTwo == 2) {
						
					}
					else if(choiceTwo == 3) {
						
					}
					else if(choiceTwo == 4) {
						
					}
					else {
						doneTwo = true;
					}
				}
			}
			else if (firstChoice == 2) {
				done = true;
			}
			else {
				System.out.println("Invalid choice. Please try again.");
			}

		}
	}
}
 
