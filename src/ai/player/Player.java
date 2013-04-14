package ai.player;

import ai.game.IGame;
import ai.move.IMove;

public class Player implements IPlayer {
	protected int id;
	private String name;

	public Player() {
		this("Unknown");
	}

	public Player(String name) {
		this.name = name;
	}

	@Override
	public IMove makeMove(IGame board) {
		return null;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}