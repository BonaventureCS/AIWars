package gamerunner;

import game.chips.GameChips;
import gamemanager.AIWars;

import java.util.ArrayList;

import tictactoe.GameTicTacToe;
import ai.player.Player;

public class Snippet {
	public static void main(String[] args) {
		Class c = GameChips.class;
		ArrayList<Player> players = AIWars.getBots(c);
		// Player p1 = new PlayerTicTacToeEasy();
		// Player p2 = new PlayerTicTacToeEasy();
		//
		// getBots(GameTicTacToe.class);
		//
		// p1.setID(1);
		// p1.setName("Player 1");
		// p2.setID(2);
		// p2.setName("Player 2");

		// players.add(p1);
		// players.add(p2);
		GameRunnerRoundRobbin runner = new GameRunnerRoundRobbin(players, c, false);

		System.out.println(runner.getWinners());
	}
}
