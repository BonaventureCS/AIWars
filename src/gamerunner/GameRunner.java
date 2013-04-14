package gamerunner;

import java.util.ArrayList;

import ai.game.Game;
import ai.player.Player;

public class GameRunner implements IGameRunner {
	protected ArrayList<Player> players;
	protected ArrayList<Game> games;
	protected Class<?> gameClass;
	protected boolean verbose;
	protected ArrayList<Player> winners;

	public GameRunner(ArrayList<Player> players, Class<?> gameClass, boolean verbose) {
		this.players = players;
		this.gameClass = gameClass;
		this.verbose = verbose;
		this.games = new ArrayList<Game>();
		for (int i = 0; i < players.size(); i++) {
			players.get(i).setID(i + 1);
		}
		run();
	}

	private void run() {

	}

	public Class<?> getGameClass() {
		return gameClass;
	}

	public Game buildGame() {
		Game game = null;
		try {
			game = (Game) gameClass.newInstance();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		game.setVerbose(verbose);
		return game;
	}

	public ArrayList<Player> getWinners() {
		return null;
	}

	public ArrayList<Game> getGames() {
		return games;
	}
}