package game.fourinarow;

import ai.game.Game;
import ai.player.Player;

public class GameFourInARow extends Game {
	private int[][] board;

	public GameFourInARow() {
		this(6, 7);
	}

	public GameFourInARow(int row, int column) {
		super("Four In A Row");
		this.board = new int[row][column];
	}

	@Override
	public void play() throws Throwable {
		PlayerFourInARow p1 = (PlayerFourInARow) players.get(0);
		PlayerFourInARow p2 = (PlayerFourInARow) players.get(1);
		while (!gameWon()) {
			movePlayer(p1);
			if (gameWon()) {
				winner = p1;
				break;
			}
			movePlayer(p2);
			if (gameWon()) {
				winner = p2;
				break;
			}
		}
	}

	private void movePlayer(PlayerFourInARow player) throws Throwable {
		MoveFourInARow move = player.makeMove(getBoard(player));
		if (moveIsLegal(move)) {
			drop(player.getID(), move.getColumn());
		}
	}

	private void drop(int id, int column) {
		for (int i = board[0].length - 1; i >= 0; i--) {
			if (board[i][column] == 0) {
				board[i][column] = id;
				return;
			}
		}
	}

	private BoardFourInARow getBoard(PlayerFourInARow player) {
		return new BoardFourInARow(board, player.getID());
	}

	private boolean moveIsLegal(MoveFourInARow move) throws Throwable {
		int c = move.getColumn();
		// out of bounds
		if (c < 0 || c >= board[0].length) {
			throw new Throwable("Illegal Move!");
		}
		// full slot
		if (board[0][c] != 0) {
			throw new Throwable("Illegal Move!");
		}
		return true;
	}

	private boolean gameWon() {
		for (Player player : players) {
			if (checkWin((PlayerFourInARow) player)) {
				return true;
			}
		}
		return false;
	}

	private boolean checkWin(PlayerFourInARow player) {
		int MAXROW = board.length;
		int MAXCOL = board[0].length;
		for (int row = 0; row < MAXROW; row++) {
			for (int col = 0; col < MAXCOL - 3; col++) {
				if (board[row][col] > 0 && board[row][col] == board[row][col + 1] && board[row][col] == board[row][col + 2] && board[row][col] == board[row][col + 3]) {
					return true;
				}
			}
		}
		// vertical columns
		for (int col = 0; col < MAXCOL; col++) {
			for (int row = 0; row < MAXROW - 3; row++) {
				if (board[row][col] > 0 && board[row][col] == board[row + 1][col] && board[row][col] == board[row + 2][col] && board[row][col] == board[row + 3][col]) {
					return true;
				}
			}
		}
		// diagonal lower left to upper right
		for (int row = 0; row < MAXROW - 3; row++) {
			for (int col = 0; col < MAXCOL - 3; col++) {
				if (board[row][col] > 0 && board[row][col] == board[row + 1][col + 1] && board[row][col] == board[row + 2][col + 2] && board[row][col] == board[row + 3][col + 3]) {
					return true;
				}
			}
		}
		// diagonal upper left to lower right
		for (int row = MAXROW - 1; row >= 3; row--) {
			for (int col = 0; col < MAXCOL - 3; col++) {
				if (board[row][col] > 0 && board[row][col] == board[row - 1][col + 1] && board[row][col] == board[row - 2][col + 2] && board[row][col] == board[row - 3][col + 3]) {
					return true;
				}
			}
		}
		return false;
	}
}