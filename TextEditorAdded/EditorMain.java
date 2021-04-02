package txteditr;

import java.util.Scanner;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
public class EditorMain {

   public static void main(String[] args) {
	   
	   
      PositionalList<Character> list = new DoublyLinkedList<Character>();
      
      Scanner in = new Scanner(System.in);
      boolean done = false;
      
      while(!done) {
    	  System.out.println("What would you like to do?");
    	  System.out.println("1) Insert New Line");
    	  System.out.println("2) Remove Line");
    	  System.out.println("3) Edit Line");
    	  System.out.println("4) Save text");
    	  System.out.println("5) Load text");
    	  System.out.println("6) Exit");
    	  
    	  int firstChoice = in.nextInt();
    	  in.nextLine();//dummy read
    	  
    	  if(firstChoice == 1) {
    		
    		  System.out.print("Please enter a line: ");
    		  String insertLine = in.nextLine();
    		  if(list.isEmpty()) {
	    		  
	    		  System.out.println();
	    		  
	    		  for(int i = 0; i < insertLine.length(); i++) {
	    			  list.addLast(insertLine.charAt(i));
	    			  //System.out.print(list.last().getElement()); //PRINT
	    		  }
	    		  list.addLast('|'); //cursor;
	    		  System.out.print(list);
	    		  System.out.println("\n");
    		  }
    		  else {
    			  
    			  //add
    			  for(int i = 0; i < insertLine.length(); i++) {
	    			  list.addLast(insertLine.charAt(i));
	    			  //System.out.print(list.last().getElement()); //PRINT
	    		  }
    			  
	    		  list.moveCursorToEnd();//cursor;
	    		  System.out.print("\n" + list);
	    		  System.out.println("\n");
    		  }
    	  }
    	  else if(firstChoice == 2) {
    		  if(list.isEmpty()) {
    			  System.out.println("\nThere is nothing to remove. Please try again.\n");
    		  }
    		  else {
    			  Position<Character> current = list.last();
    			  int temp = list.size();
    			  for(int i = 0; i < temp; i++) {
    				  list.remove(current);
    				 // System.out.println(current.getElement());
    				  current = list.before(current);
    			  }
    			  
    			  System.out.println("\n" + "The line has been removed.");
    			  System.out.println();
    			  
    		  }
    		  
    	  }
    	  else if(firstChoice == 3) {
    		  
			  if(list.isEmpty()) {
				  System.out.println("\nThere is nothng to edit. Please try again.\n");
			  }
			  else {
				  System.out.println(list + "\n");
				  list.editLine();
			  }
    	  }
    	  else if(firstChoice == 4) {
    		  try {
    			  File writeToFile = new File("writtenText.txt");
    			  FileWriter writer = new FileWriter(writeToFile);
    			  
    			  int holderSize = list.size();
    			  for(int i = 0; i < holderSize; i++) {
    				  Position<Character> current = list.first();
    				  if(current.getElement() != '|')
    					  writer.write(current.getElement());
    				  
    				  list.remove(current);
    				  
    			  }
    			  writer.close();
    		  }
    		  catch(IOException e) {
    			  System.out.println(e.getMessage());
    		  }
    		  
    	  }
    	  else if(firstChoice == 5) {
    		  System.out.println("From what file would you like to read from?");
    		  String fileName = in.nextLine();
    		  File readFile = new File(fileName);
    		  try {
	    		  Scanner readFromFile = new Scanner(readFile);
	    		  
	    		  String readLine = readFromFile.nextLine();
	    		  if(list.isEmpty()) {
		    		  
		    		  System.out.println();
		    		  
		    		  for(int i = 0; i < readLine.length(); i++) {
		    			  list.addLast(readLine.charAt(i));
		    			  //System.out.print(list.last().getElement()); //PRINT
		    		  }
		    		  list.addLast('|'); //cursor;
		    		  System.out.print(list);
		    		  System.out.println("\n");
	    		  }
	    		  else {
	    			  
	    			  //add
	    			  for(int i = 0; i < readLine.length(); i++) {
		    			  list.addLast(readLine.charAt(i));
		    			  //System.out.print(list.last().getElement()); //PRINT
		    		  }
	    			  
		    		  list.moveCursorToEnd();//cursor;
		    		  System.out.print("\n" + list);
		    		  System.out.println("\n");
	    		  }
    		  }
    		  catch(FileNotFoundException e) {
    			  System.out.println(e.getMessage());
    		  }
    	  }
    	  else if(firstChoice == 6) {
    		  done = true; 
    	  }
    	  else {
    		  System.out.print("Invalid option. Would you like to try again? (Y/N) ");
    		  String secondChoice = in.next();
    		  if(secondChoice.toLowerCase().equals("n")) {
    			  done = true;
    		  }
    		 
    		  System.out.println("\n");
    	  }
      }
   }

}
