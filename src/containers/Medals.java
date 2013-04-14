package containers;

import java.util.ArrayList;

public class Medals {

	private ArrayList<String> medals;
	
	public Medals() {
		medals = new ArrayList<String>();
	}
	
	public void addMedal(String medal) {
		medals.add(medal);
	}
	
	public ArrayList<String> dumpMedals() {
		return medals;
	}
	
}
