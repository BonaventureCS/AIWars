package gamerunner;

import java.util.ArrayList;

import ai.game.Game;
import ai.player.Player;
import ai.referee.Referee;

public class GameRunnerExhibition extends GameRunner {

	public GameRunnerExhibition(ArrayList<Player> players, Class<Game> gameClass, boolean verbose) {
		super(players, gameClass, verbose);
		run();
	}

	private void run() {
		Game game = buildGame();
		games.add(game);

		Player p1 = players.get(0);
		Player p2 = players.get(1);
		if (p1 != p2) {
			p1.setID(1);
			p1.setName("Player 1");
			p2.setID(2);
			p2.setName("Player 2");

			ArrayList<Player> players = new ArrayList<Player>();
			players.add(p1);
			players.add(p2);
			game.setPlayers(players);
			Referee referee = new Referee(game);
			this.winners.add(game.getWinner());
		}
	}

	public Player getWinner() {
		return null;
	}
}