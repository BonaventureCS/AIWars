package tictactoe;

import ai.move.IMove;

public class MoveTicTacToe implements IMove {
	private int row, column;

	public MoveTicTacToe(int row, int column) {
		this.column = column;
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}
}