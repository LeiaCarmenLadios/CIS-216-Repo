package playerlab;

import java.util.Scanner;
public class PlayerListMain {

public static void main(String[] args) {
	// TODO Auto-generated method stub
	Scanner in = new Scanner(System.in);
	
	LinkedList<GameEntry> scoresList = new LinkedList<GameEntry>();
		
	
	scoresList.addEntry(new GameEntry("Carl", 78));
	scoresList.addEntry(new GameEntry("James", 80));
	scoresList.addEntry(new GameEntry("Marjorie", 92));
	scoresList.addEntry(new GameEntry("Mary", 90));
	scoresList.addEntry(new GameEntry("Kami", 121));
	scoresList.addEntry(new GameEntry("Clarie", 150));
	scoresList.addEntry(new GameEntry("Maybell", 139));
	scoresList.addEntry(new GameEntry("Timmy", 40));
	
	
	
	boolean goAgain = true;
	while(goAgain) {
		boolean done = false;
		System.out.println("\nWould you like to\n 1)add \n 2)remove a score?" +
				"\t(Please enter 1 or 2)");
		int choice = in.nextInt();
		
		while(!done) {
			if(choice == 1) {
				System.out.println("\nPlease enter a score");
				
				System.out.print("Enter Score: ");
				int score = in.nextInt();
				System.out.print("Enter Name: ");
				String name = in.next();
				scoresList.addEntry(new GameEntry(name, score));
				
				System.out.println("\nWould you like to add another score? (Y/N)");
				String keepGoing= in.next();
			
				if(keepGoing.equalsIgnoreCase("N")) {
					done = true;
				}
				else if(keepGoing.equalsIgnoreCase("Y")){
					done = false;
				}
				
			}
			else if(choice == 2) {
				
				System.out.println("\n" + scoresList);
				System.out.println("\nWhich entry would you like to remove? (Select a number)");
				
				scoresList.remove(in.nextInt());
				
				System.out.println("\nWould you like to remove another score? (Y/N)");
				String keepGoing= in.next();
			
				if(keepGoing.equalsIgnoreCase("N")) {
					done = true;
					System.out.println("\n" + scoresList);
				}
				else if(keepGoing.equalsIgnoreCase("Y")){
					done = false;
				}
	
			}
			
		}
		System.out.println("\nDo you want to \n1)remove/add another score \n2)exit ?" +
				"\t(Please enter 1 or 2)");

		int toGoAgain = in.nextInt();

		if(toGoAgain == 2) {
			goAgain = false;
		}	
	}
	
	System.out.println(scoresList);

	}

}

