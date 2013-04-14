package containers;

import java.util.ArrayList;

public class Bots {
	
	private ArrayList<String> botList;
	
	public Bots() {
		botList = new ArrayList<String>();
	}
	
	public void addBot(String bot) {
		botList.add(bot);
	}
	
	public ArrayList<String> dumpBots() {
		return botList;
	}

}
