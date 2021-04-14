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
		
		biTree.addLeft(2, new String("9"));
		
		biTree.addRight(2, new String("10"));
		
		
		System.out.println(biTree);
		
		
		boolean done = false;
		
		Scanner in = new Scanner(System.in);
		while(!done) {
			
			System.out.println("\nWhat kind of traversal would you like to do?");
			System.out.println("1) Pre-order");
			System.out.println("2) Post-order");
			System.out.println("3) In-order");
			System.out.println("4) Exit");
			
			int firstChoice = in.nextInt();
			
			if(firstChoice == 1) {
				ArrayList<String> preOrderedList = biTree.positions();
				ArrayBinaryTree<String> preOrderTree = new ArrayBinaryTree<String>(preOrderedList);
				
				Iterator it = preOrderTree.iterator();
				
				System.out.println();
				while(it.hasNext()) {	
					System.out.print(it.next() + "  ");
				}
				
			}
			else if(firstChoice == 2) {
				ArrayList<String> postOrderedList = biTree.postOrder();
				ArrayBinaryTree<String> postOrderTree = new ArrayBinaryTree<String>(postOrderedList);
				
				Iterator it = postOrderTree.iterator();
				
				System.out.println();
				while(it.hasNext()) {
					System.out.print(it.next() + "  ");
				}
				
			}   
			else if(firstChoice == 3) {
				ArrayList<String> inOrderList = biTree.inorder();
				ArrayBinaryTree<String> inOrderTree = new ArrayBinaryTree<String>(inOrderList);
				
				Iterator it = inOrderTree.iterator();
				
				System.out.println();
				while(it.hasNext()) {
					System.out.print(it.next() + "  ");
				}
			}
			else if(firstChoice == 4) {
				done = true;
			}
		}
		
		
	}
}
 
