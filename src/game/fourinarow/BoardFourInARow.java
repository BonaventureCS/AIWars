package game.fourinarow;

import ai.board.Board;

public class BoardFourInARow extends Board {
	private int[][] board;
	private int playerID;

	public BoardFourInARow(int[][] board, int playerID) {
		this.board = board;
		this.playerID = playerID;
	}

	public int getRowCount() {
		return board.length;
	}

	public int getColumnCount() {
		return board[0].length;
	}

	public boolean isEmpty(int row, int column) {
		return board[row][column] == 0;
	}

	public boolean isMe(int row, int column) {
		return board[row][column] == playerID;
	}

	public boolean isOpponent(int row, int column) {
		return !isEmpty(row, column) && !isMe(row, column);
	}
}