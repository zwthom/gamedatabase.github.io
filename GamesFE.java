/**
 * Zackery Thom
 */
import java.io.*;
import java.util.Scanner;
public class GamesFE {
	public static void main(String[] args) {
		GenLL<Game> finalList = new GenLL<>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the Video Game Database!\n");
		String fileName = "fileName";
        while (true) {
        	System.out.println();
            System.out.println("Enter 1 to load the video game database");
            System.out.println("Enter 2 to search the database");
            System.out.println("Enter 3 to print current results to the console");
            System.out.println("Enter 4 to print current results to file");
            System.out.println("Enter 0 to quit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            //If they choose to input 1, it loads the game database with the file name that the user picks
            if(choice == 1) {
            	System.out.println("Enter the file name:");
            	fileName = scanner.nextLine();
            	GameManager.readFile(fileName);
            }
            //If they choose to input 2, it searches the database with the name and console that the user picks
            if(choice == 2) {
            	finalList.clear();
            	System.out.println("Enter the name of the game or '*' for all:");
                String gameName = scanner.nextLine();
                System.out.println("Enter the name of the console or '*' for all:");
                String consoleName = scanner.nextLine();
                finalList = GameManager.searchGames(fileName, gameName, consoleName);
                while(finalList.hasMore()) {
                	System.out.println(finalList.getCurrent().getName() + " " + finalList.getCurrent().getConsole());
                	finalList.gotoNext();
                }
            }
            //If they choose to input 3, it prints the results to console
            if(choice == 3) {
            	finalList.reset();
            	while(finalList.hasMore()) {
                	System.out.println(finalList.getCurrent().getName() + " " + finalList.getCurrent().getConsole());
                	finalList.gotoNext();
                }
            }
          //If they choose to input 4, it prints the results to a file of the user's choice
            if(choice == 4) {
            	finalList.reset();
            	System.out.println("Enter the file name:");
                String filename = scanner.nextLine();
                System.out.println("Would you like to append? True or false?");
                boolean append = scanner.nextBoolean();
                try {
                	FileWriter fw = new FileWriter(filename, append);
					while(finalList.hasMore()) {
						fw.write(finalList.getCurrent().getName() + " " + finalList.getCurrent().getConsole() +"\n");
						finalList.gotoNext();
					}
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
					
				}
            }
            //If they choose to input 0, it quits
            if(choice == 0) {
            	System.out.println("Goodbye!");
            	break;
            }
        }
    	scanner.close();
	}
}
