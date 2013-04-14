package ai.referee;

import ai.game.IGame;
import ai.player.Player;

public class Referee {
	public Referee(IGame game) {
		try {
			game.play();
			Player winner = game.getWinner();
			if (winner != null) {
				System.out.println("Winner was " + winner.getName());
			} else {
				System.out.println("No winner found.");
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}