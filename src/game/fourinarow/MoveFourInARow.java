package game.fourinarow;

import ai.move.IMove;

public class MoveFourInARow implements IMove {
	private int column;

	public MoveFourInARow(int column) {
		this.column = column;
	}

	public int getColumn() {
		return column;
	}
}