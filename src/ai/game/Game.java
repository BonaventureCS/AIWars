package ai.game;

import java.util.ArrayList;

import ai.player.Player;

public class Game implements IGame {
	private String title;
	protected ArrayList<Player> players;
	protected boolean verbose;
	protected ArrayList<String> output;

	public Game(String title) {
		this.title = title;
		verbose = false;
		output = new ArrayList<String>();
	}

	protected Player winner;

	@Override
	public void play() throws Throwable {

	}

	@Override
	public Player getWinner() {
		return winner;
	}

	public String getTitle() {
		return title;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public void setVerbose(boolean verbose) {
		this.verbose = verbose;
	}

	public boolean isVerbose() {
		return verbose;
	}

	public ArrayList<String> getOutput() {
		return output;
	}
}