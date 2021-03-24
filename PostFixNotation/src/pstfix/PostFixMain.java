package pstfix;


import java.util.Scanner;
public class PostFixMain {

   public static void main(String[] args) {
       
      boolean done = false;
      Scanner in = new Scanner(System.in);
      
      
      while(!done) {
         System.out.println("Would you like to enter a postfix expression? (Y/N)");
         String answer = in.next();
         in.nextLine();
         
         if(answer.toLowerCase().equals("y")) {
            System.out.print("Please enter a postfix expression: ");
            String postFix = in.nextLine();
            System.out.println();
           
            ArrayStack<Integer> arrStack = new ArrayStack<Integer>(postFix.length());
            System.out.println("Result: " + arrStack.evaluate(postFix) + "\n");
         }
         else {
            done = true;
         }
         
      }

   }

}
