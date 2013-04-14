package tictactoe;

import ai.game.Game;
import ai.player.Player;

public class GameTicTacToe extends Game {
	private int[][] board;

	public GameTicTacToe() {
		this(3, 3);
	}

	public GameTicTacToe(int row, int column) {
		super("Tic-Tac-Toe");
		this.board = new int[row][column];
	}

	@Override
	public void play() throws Throwable {
		PlayerTicTacToe p1 = (PlayerTicTacToe) players.get(0);
		PlayerTicTacToe p2 = (PlayerTicTacToe) players.get(1);
		while (!gameWon()) {
			// System.err.println(1);
			movePlayer(p1);
			if (gameTie()) {
				winner = null;
				break;
			}
			if (gameWon()) {
				winner = p1;
				break;
			}
			// System.err.println(2);
			movePlayer(p2);
			if (gameTie()) {
				winner = null;
				break;
			}
			if (gameWon()) {
				winner = p2;
				break;
			}
		}
	}

	private void movePlayer(PlayerTicTacToe player) throws Throwable {
		MoveTicTacToe move = player.makeMove(getBoard(player));
		if (moveIsLegal(move)) {
			place(player.getID(), move);
			verbose(player.getName() + " marked row(" + move.getRow() + "), column(" + move.getColumn() + ").");
		}
	}

	private void place(int id, MoveTicTacToe move) {
		board[move.getRow()][move.getColumn()] = id;
	}

	private BoardTicTacToe getBoard(PlayerTicTacToe player) {
		return new BoardTicTacToe(board, player.getID());
	}

	private boolean moveIsLegal(MoveTicTacToe move) throws Throwable {
		int c = move.getColumn();
		int r = move.getRow();
		// out of bounds
		if (r < 0 || r >= board.length) {
			throw new Throwable("Illegal Move!");
		}
		if (c < 0 || c >= board[0].length) {
			throw new Throwable("Illegal Move!");
		}
		if (board[r][c] == 0) {
			return true;
		}
		// already moved there
		throw new Throwable("Illegal Move!");
	}

	private boolean gameWon() {
		for (Player player : players) {
			if (checkWin((PlayerTicTacToe) player)) {
				return true;
			}
		}
		return false;
	}

	private boolean gameTie() {
		for (Player player : players) {
			if (checkTie((PlayerTicTacToe) player)) {
				return true;
			}
		}
		return false;
	}

	private boolean checkTie(PlayerTicTacToe Player) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean checkWin(PlayerTicTacToe player) {
		int conRow = 0;
		int conCol = 0;
		int i = 0, j = 0;
		for (i = 0; i < board.length; i++) {
			if (board[i][j] == player.getID()) {
				conRow++;
				if (conRow == 3) {
					return true;
				}
			} else {
				conRow = 0;
			}
			for (j = 0; j < board[0].length; j++) {
				if (board[i][j] == player.getID()) {
					conCol++;
					if (conCol == 3) {
						return true;
					}
				} else {
					conCol = 0;
				}
			}
			if (j == board[0].length) {
				j = 0;
			}
		}
		return false;
	}

	public void verbose(String print) {
		if (verbose) {
			System.out.println(print);
			output.add(print);
		}
	}
}