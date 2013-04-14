package uploaded.tictactoe;

import java.util.Random;

import tictactoe.BoardTicTacToe;
import tictactoe.MoveTicTacToe;
import tictactoe.PlayerTicTacToe;

public class PlayerTicTacToeMedium extends PlayerTicTacToe {
	public PlayerTicTacToeMedium() {
		super("Medium");
	}

	public MoveTicTacToe makeMove(BoardTicTacToe board) {
		// horizontal checkers
		// row1
		if (board.isMe(0, 0) && board.isMe(0, 1) && board.isEmpty(0, 2)) {
			return new MoveTicTacToe(0, 2);
		}
		if (board.isMe(0, 0) && board.isMe(0, 2) && board.isEmpty(0, 1)) {
			return new MoveTicTacToe(0, 1);
		}
		if (board.isMe(0, 1) && board.isMe(0, 2) && board.isEmpty(0, 0)) {
			return new MoveTicTacToe(0, 0);
		}

		// row2
		else if (board.isMe(1, 0) && board.isMe(1, 1) && board.isEmpty(1, 2)) {
			return new MoveTicTacToe(1, 2);
		} else if (board.isMe(1, 0) && board.isMe(1, 2) && board.isEmpty(1, 1)) {
			return new MoveTicTacToe(1, 1);
		} else if (board.isMe(1, 1) && board.isMe(1, 2) && board.isEmpty(1, 0)) {
			return new MoveTicTacToe(1, 0);
		}

		// row3
		else if (board.isMe(2, 0) && board.isMe(2, 1) && board.isEmpty(2, 2)) {
			return new MoveTicTacToe(2, 2);
		} else if (board.isMe(2, 0) && board.isMe(2, 2) && board.isEmpty(2, 1)) {
			return new MoveTicTacToe(2, 1);
		} else if (board.isMe(2, 1) && board.isMe(2, 2) && board.isEmpty(2, 0)) {
			return new MoveTicTacToe(2, 0);
		}

		// vertical checkers
		// column1
		else if (board.isMe(0, 0) && board.isMe(1, 0) && board.isEmpty(2, 0)) {
			return new MoveTicTacToe(2, 0);
		} else if (board.isMe(0, 0) && board.isMe(2, 0) && board.isEmpty(1, 0)) {
			return new MoveTicTacToe(1, 0);
		}

		else if (board.isMe(1, 0) && board.isMe(2, 0) && board.isEmpty(0, 0)) {
			return new MoveTicTacToe(0, 0);
		}

		// column2
		else if (board.isMe(0, 1) && board.isMe(1, 1) && board.isEmpty(2, 1)) {
			return new MoveTicTacToe(2, 1);
		} else if (board.isMe(0, 1) && board.isMe(2, 1) && board.isEmpty(1, 1)) {
			return new MoveTicTacToe(1, 1);
		} else if (board.isMe(1, 1) && board.isMe(2, 1) && board.isEmpty(0, 1)) {
			return new MoveTicTacToe(0, 1);
		}

		// column3
		else if (board.isMe(0, 2) && board.isMe(1, 2) && board.isEmpty(2, 2)) {
			return new MoveTicTacToe(2, 2);
		} else if (board.isMe(0, 2) && board.isMe(2, 2) && board.isEmpty(1, 2)) {
			return new MoveTicTacToe(1, 2);
		} else if (board.isMe(1, 2) && board.isMe(2, 2) && board.isEmpty(0, 2)) {
			return new MoveTicTacToe(0, 2);
		}

		// block
		// row1
		if (board.isOpponent(0, 0) && board.isOpponent(0, 1) && board.isEmpty(0, 2)) {
			return new MoveTicTacToe(0, 2);
		}
		if (board.isOpponent(0, 0) && board.isOpponent(0, 2) && board.isEmpty(0, 1)) {
			return new MoveTicTacToe(0, 1);
		}
		if (board.isOpponent(0, 1) && board.isOpponent(0, 2) && board.isEmpty(0, 0)) {
			return new MoveTicTacToe(0, 0);
		}

		// row2
		else if (board.isOpponent(1, 0) && board.isOpponent(1, 1) && board.isEmpty(1, 2)) {
			return new MoveTicTacToe(1, 2);
		} else if (board.isOpponent(1, 0) && board.isOpponent(1, 2) && board.isEmpty(1, 1)) {
			return new MoveTicTacToe(1, 1);
		} else if (board.isOpponent(1, 1) && board.isOpponent(1, 2) && board.isEmpty(1, 0)) {
			return new MoveTicTacToe(1, 0);
		}

		// row3
		else if (board.isOpponent(2, 0) && board.isOpponent(2, 1) && board.isEmpty(2, 2)) {
			return new MoveTicTacToe(2, 2);
		} else if (board.isOpponent(2, 0) && board.isOpponent(2, 2) && board.isEmpty(2, 1)) {
			return new MoveTicTacToe(2, 1);
		} else if (board.isOpponent(2, 1) && board.isOpponent(2, 2) && board.isEmpty(2, 0)) {
			return new MoveTicTacToe(2, 0);
		}

		// vertical blockers
		// column1
		else if (board.isOpponent(0, 0) && board.isOpponent(1, 0) && board.isEmpty(2, 0)) {
			return new MoveTicTacToe(2, 0);
		} else if (board.isOpponent(0, 0) && board.isOpponent(2, 0) && board.isEmpty(1, 0)) {
			return new MoveTicTacToe(1, 0);
		}

		else if (board.isOpponent(1, 0) && board.isOpponent(2, 0) && board.isEmpty(0, 0)) {
			return new MoveTicTacToe(0, 0);
		}

		// column2
		else if (board.isOpponent(0, 1) && board.isOpponent(1, 1) && board.isEmpty(2, 1)) {
			return new MoveTicTacToe(2, 1);
		} else if (board.isOpponent(0, 1) && board.isOpponent(2, 1) && board.isEmpty(1, 1)) {
			return new MoveTicTacToe(1, 1);
		} else if (board.isOpponent(1, 1) && board.isOpponent(2, 1) && board.isEmpty(0, 1)) {
			return new MoveTicTacToe(0, 1);
		}

		// column3
		else if (board.isOpponent(0, 2) && board.isOpponent(1, 2) && board.isEmpty(2, 2)) {
			return new MoveTicTacToe(2, 2);
		} else if (board.isOpponent(0, 2) && board.isOpponent(2, 2) && board.isEmpty(1, 2)) {
			return new MoveTicTacToe(1, 2);
		} else if (board.isOpponent(1, 2) && board.isOpponent(2, 2) && board.isEmpty(0, 2)) {
			return new MoveTicTacToe(0, 2);
		}

		if (board.isEmpty(1, 1)) {
			return new MoveTicTacToe(1, 1);
		} else {

			while (true) {
				Random r = new Random();
				int ran = r.nextInt(3);
				int ran2 = r.nextInt(3);
				if (board.isEmpty(ran, ran2)) {
					return new MoveTicTacToe(ran, ran2);
				}
			}

		}
	}
}
