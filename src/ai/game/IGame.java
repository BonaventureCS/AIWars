package ai.game;

import ai.player.Player;

public interface IGame {
	public void play() throws Throwable;

	public Player getWinner();
}