/**
 * Zackery Thom
 */
import java.util.Scanner;
import java.io.*;
public class GameManager {
	static GenLL<Game> gameList;
	//Reads the file
	public static void readFile(String fileName) {
		gameList = new GenLL<>();
		gameList.reset();
		try {
			Scanner scanner = new Scanner(new File(fileName));
			while(scanner.hasNextLine()) {
				String[] splitLine = scanner.nextLine().split("\t");
				String gameName = splitLine[0];
				String gameConsole = splitLine[1];
				Game game = new Game(gameName, gameConsole);
				if(splitLine.length == 2)
					gameList.add(game);
			}
			scanner.close();
		}catch(IOException e) {
			System.out.println(e);
		}
	}
	//Searches the file that user chooses, with the given title and console
	public static GenLL<Game> searchGames(String fileName, String title, String console) {
		readFile(fileName);
        GenLL<Game> results = new GenLL<>();
        while(gameList.hasMore()) {
        	//If the title and console are equal to the integers title and console, or if title/ console are '*' it adds to the gameList generic linked list
        	if((title.equals("*") || gameList.getCurrent().getName().toLowerCase().contains(title.toLowerCase())) &&
                    (console.equals("*") || gameList.getCurrent().getConsole().toLowerCase().contains(console.toLowerCase()))) {
        		results.add(gameList.getCurrent());
        	}
        	gameList.gotoNext();
        }
        return results;
    }
}