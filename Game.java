/**
 * Zackery Thom
 */
//Creates a new game with a name and console
public class Game {
	private String name;
	private String console;
	public Game(String name, String console) {
		if(name != null)
			this.setName(name);
		if(console != null)
			this.setConsole(console);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name != null)
			this.name = name;
	}
	public String getConsole() {
		return console;
	}
	public void setConsole(String console) {
		if(console != null)
			this.console = console;
	}
	
}
