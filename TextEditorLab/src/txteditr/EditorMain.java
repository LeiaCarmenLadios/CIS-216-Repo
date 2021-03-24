package txteditr;

import java.util.Scanner;
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
    	  System.out.println("4) Exit");
    	  
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
	    		  System.out.print("\n" + list);
	    		  System.out.println("\n");
    		  }
    		  else {
    			  
    			  //remove
    			  
//    			  for(int i = list.size(); i > 0; i--) {
//    				  list.remove(list.first());
//    				  
//    			  }
    			  
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
    		  
    	  }
    	  else if(firstChoice == 3) {
    		  System.out.println(list + "\n");
			 //Move cursor
    		  list.editLine();
    		  
    	  }
    	  else if(firstChoice == 4) {
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
