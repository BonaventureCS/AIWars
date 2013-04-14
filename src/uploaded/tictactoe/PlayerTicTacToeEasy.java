package uploaded.tictactoe;

import java.util.Random;

import tictactoe.BoardTicTacToe;
import tictactoe.MoveTicTacToe;
import tictactoe.PlayerTicTacToe;

public class PlayerTicTacToeEasy extends PlayerTicTacToe {
	public PlayerTicTacToeEasy() {
		super("Easy");
	}

	public MoveTicTacToe makeMove(BoardTicTacToe board) {
		Random r = new Random();
		while (true) {
			int ran = r.nextInt(board.getColumnCount());
			int ran2 = r.nextInt(board.getRowCount());
			if (board.isEmpty(ran, ran2)) {
				return new MoveTicTacToe(ran, ran2);
			}
		}

	}
}
