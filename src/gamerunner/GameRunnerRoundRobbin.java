package gamerunner;

import java.util.ArrayList;
import java.util.HashMap;

import ai.game.Game;
import ai.player.Player;
import ai.referee.Referee;

public class GameRunnerRoundRobbin extends GameRunner {

	HashMap<Player, Integer> scores = new HashMap<Player, Integer>();

	public GameRunnerRoundRobbin(ArrayList<Player> players, Class<?> gameClass, boolean verbose) {
		super(players, gameClass, verbose);
		for (Player player : players) {
			scores.put(player, Integer.valueOf(0));
		}

		run();
	}

	private void run() {
		for (Player p1 : players) {
			for (Player p2 : players) {
				if (p1 != p2) {
					Game game = buildGame();
					games.add(game);

					ArrayList<Player> players = new ArrayList<Player>();
					players.add(p1);
					players.add(p2);
					game.setPlayers(players);
					Referee referee = new Referee(game);
					Player win = game.getWinner();
					if (win != null) {
						scores.put(win, Integer.valueOf(((Integer) scores.get(win)).intValue() + 1));
					}
				}
			}
		}
	}

	public ArrayList<Player> getWinners() {
		ArrayList<Player> wins = new ArrayList<Player>();
		int max = 0;
		for (Player player : players) {
			int m = scores.get(player).intValue();
			if (m > max) {
				max = m;
			}
		}
		for (Player player : players) {
			if (scores.get(player).intValue() == max) {
				wins.add(player);
			}
		}
		return wins;
	}
}