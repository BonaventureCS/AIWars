package uploaded.fourinarow;

import game.fourinarow.BoardFourInARow;
import game.fourinarow.MoveFourInARow;
import game.fourinarow.PlayerFourInARow;

import java.util.Random;

public class PlayerFourInARowMedium extends PlayerFourInARow {
	public PlayerFourInARowMedium() {
		super("Medium");
	}

	public MoveFourInARow makeMove(BoardFourInARow board) {

		// horizontal
		for (int i = board.getRowCount() - 1; i >= 0; i--) {
			for (int j = 0; j < board.getColumnCount() - 3; j++) {
				if (board.isEmpty(i, j)) {
					j++;
				}
				if (j <= board.getColumnCount() - 4 && board.isMe(i, j) && board.isMe(i, j + 1) && board.isMe(i, j + 2) && board.isEmpty(i, j + 3)) {
					return new MoveFourInARow(j + 3);
				}
			}
		}

		for (int i = board.getRowCount() - 1; i >= 0; i--) {
			for (int j = 0; j < board.getColumnCount() - 3; j++) {
				if (board.isEmpty(i, j)) {
					j++;
				}
				if (j <= board.getColumnCount() - 4 && board.isMe(i, j + 1) && board.isMe(i, j + 2) && board.isMe(i, j + 3) && board.isEmpty(i, j)) {
					return new MoveFourInARow(j);
				}
			}
		}

		for (int i = board.getRowCount() - 1; i >= 0; i--) {
			for (int j = 0; j < board.getColumnCount() - 3; j++) {
				if (board.isEmpty(i, j)) {
					j++;
				}
				if (j <= board.getColumnCount() - 4 && board.isMe(i, j) && board.isMe(i, j + 2) && board.isMe(i, j + 3) && board.isEmpty(i, j + 1)) {
					return new MoveFourInARow(j + 1);
				}
			}
		}

		for (int i = board.getRowCount() - 1; i >= 0; i--) {
			for (int j = 0; j < board.getColumnCount() - 3; j++) {
				if (board.isEmpty(i, j)) {
					j++;
				}
				if (j <= board.getColumnCount() - 4 && board.isMe(i, j) && board.isMe(i, j + 1) && board.isMe(i, j + 3) && board.isEmpty(i, j + 2)) {
					return new MoveFourInARow(j + 2);
				}
			}
		}
		// vertical
		for (int i = board.getRowCount() - 1; i >= 3; i--) {
			for (int j = 0; j < board.getColumnCount(); j++) {
				if (board.isEmpty(i, j)) {
					j++;
				}
				if (j <= board.getRowCount() - 4 && board.isMe(i, j) && board.isMe(i - 1, j) && board.isMe(i - 2, j) && board.isEmpty(i - 3, j) && j <= board.getRowCount() - 4) {
					return new MoveFourInARow(j);
				}
			}
		}
		// increasing diagonal
		for (int i = board.getRowCount() - 1; i >= 3; i--) {
			for (int j = 0; j < board.getColumnCount() - 4; j++) {
				if (board.isEmpty(i, j)) {
					j++;
				}
				if (board.isMe(i, j) && board.isMe(i - 1, j + 1) && board.isMe(i - 2, j + 2) && board.isEmpty(i - 3, j + 3) && !board.isEmpty(i - 2, j + 3)) {
					return new MoveFourInARow(j + 3);
				}
			}
		}
		for (int i = board.getRowCount() - 1; i >= 3; i--) {
			for (int j = 0; j < board.getColumnCount() - 4; j++) {
				if (board.isEmpty(i, j)) {
					j++;
				}
				if (board.isMe(i - 1, j + 1) && board.isMe(i - 2, j + 2) && board.isMe(i - 3, j + 3) && board.isEmpty(i, j)) {
					return new MoveFourInARow(j);
				}
			}
		}
		for (int i = board.getRowCount() - 1; i >= 3; i--) {
			for (int j = 0; j < board.getColumnCount() - 4; j++) {
				if (board.isEmpty(i, j)) {
					j++;
				}
				if (board.isMe(i, j) && board.isMe(i - 2, j + 2) && board.isMe(i - 3, j + 3) && board.isEmpty(i - 1, j + 1) && !board.isEmpty(i, j + 1)) {
					return new MoveFourInARow(j + 1);
				}
			}
		}
		for (int i = board.getRowCount() - 1; i >= 3; i--) {
			for (int j = 0; j < board.getColumnCount() - 4; j++) {
				if (board.isEmpty(i, j)) {
					j++;
				}
				if (board.isMe(i - 1, j + 1) && board.isMe(i, j) && board.isMe(i - 3, j + 3) && board.isEmpty(i - 2, j + 2) && !board.isEmpty(i - 1, j + 2)) {
					return new MoveFourInARow(j + 2);
				}
			}
		}
		// decreasing diagonal
		for (int i = board.getRowCount() - 1; i >= 3; i--) {
			for (int j = board.getColumnCount() - 1; j >= 3; j--) {
				if (board.isEmpty(i, j)) {
					j--;
				}
				if (j >= 3 && board.isMe(i, j) && board.isMe(i - 1, j - 1) && board.isMe(i - 2, j - 2) && board.isEmpty(i - 3, j - 3) && !board.isEmpty(i - 2, j - 3)) {
					return new MoveFourInARow(j - 3);
				}
			}
		}
		for (int i = board.getRowCount() - 1; i >= 3; i--) {
			for (int j = board.getColumnCount() - 1; j >= 3; j--) {
				if (board.isEmpty(i, j)) {
					j--;
				}
				if (j >= 3 && board.isMe(i - 3, j - 3) && board.isMe(i - 1, j - 1) && board.isMe(i - 2, j - 2) && board.isEmpty(i, j) && j >= 3) {
					return new MoveFourInARow(j);
				}
			}
		}

		for (int i = board.getRowCount() - 1; i >= 3; i--) {
			for (int j = board.getColumnCount() - 1; j >= 3; j--) {
				if (board.isEmpty(i, j)) {
					j--;
				}
				if (j >= 3 && board.isMe(i, j) && board.isMe(i - 3, j - 3) && board.isMe(i - 2, j - 2) && board.isEmpty(i - 1, j - 1) && !board.isEmpty(i, j - 1)) {
					return new MoveFourInARow(j - 1);
				}
			}
		}
		for (int i = board.getRowCount() - 1; i >= 3; i--) {
			for (int j = board.getColumnCount() - 1; j >= 3; j--) {
				if (board.isEmpty(i, j)) {
					j--;
				}
				if (j >= 3 && board.isMe(i, j) && board.isMe(i - 3, j - 3) && board.isMe(i - 1, j - 1) && board.isEmpty(i - 2, j - 2) && !board.isEmpty(i - 1, j - 2)) {
					return new MoveFourInARow(j - 2);
				}
			}
		}

		// block
		// horizontal
		for (int i = board.getRowCount() - 1; i >= 0; i--) {
			for (int j = 0; j < board.getColumnCount() - 3; j++) {
				if (board.isOpponent(i, j)) {
					j++;
				}
				if (j <= board.getColumnCount() - 4 && board.isOpponent(i, j) && board.isOpponent(i, j + 1) && board.isOpponent(i, j + 2) && board.isEmpty(i, j + 3)) {
					return new MoveFourInARow(j + 3);
				}
			}
		}

		for (int i = board.getRowCount() - 1; i >= 0; i--) {
			for (int j = 0; j < board.getColumnCount() - 3; j++) {
				if (board.isOpponent(i, j)) {
					j++;
				}
				if (j <= board.getColumnCount() - 4 && board.isOpponent(i, j + 1) && board.isOpponent(i, j + 2) && board.isOpponent(i, j + 3) && board.isEmpty(i, j)) {
					return new MoveFourInARow(j);
				}
			}
		}

		for (int i = board.getRowCount() - 1; i >= 0; i--) {
			for (int j = 0; j < board.getColumnCount() - 3; j++) {
				if (board.isEmpty(i, j)) {
					j++;
				}
				if (j <= board.getColumnCount() - 4 && board.isOpponent(i, j) && board.isOpponent(i, j + 2) && board.isOpponent(i, j + 3) && board.isEmpty(i, j + 1)) {
					return new MoveFourInARow(j + 1);
				}
			}
		}

		for (int i = board.getRowCount() - 1; i >= 0; i--) {
			for (int j = 0; j < board.getColumnCount() - 3; j++) {
				if (board.isEmpty(i, j)) {
					j++;
				}
				if (j <= board.getColumnCount() - 4 && board.isOpponent(i, j) && board.isOpponent(i, j + 1) && board.isOpponent(i, j + 3) && board.isEmpty(i, j + 2)) {
					return new MoveFourInARow(j + 2);
				}
			}
		}

		// block vert
		for (int i = board.getRowCount() - 1; i >= 3; i--) {
			for (int j = 0; j < board.getColumnCount(); j++) {
				if (board.isEmpty(i, j)) {
					j++;
				}
				if (j <= board.getRowCount() - 4 && board.isOpponent(i, j) && board.isOpponent(i - 1, j) && board.isOpponent(i - 2, j) && board.isEmpty(i - 3, j)) {
					return new MoveFourInARow(j);
				}
			}
		}
		// block inc diagonal

		for (int i = board.getRowCount() - 1; i >= 3; i--) {
			for (int j = 0; j < board.getColumnCount() - 4; j++) {
				if (board.isEmpty(i, j)) {
					j++;
				}
				if (j <= board.getColumnCount() - 4 && board.isOpponent(i, j) && board.isOpponent(i - 1, j + 1) && board.isOpponent(i - 2, j + 2) && board.isEmpty(i - 3, j + 3)
						&& !board.isEmpty(i - 2, j + 3)) {
					return new MoveFourInARow(j + 3);
				}
			}
		}
		for (int i = board.getRowCount() - 1; i >= 3; i--) {
			for (int j = 0; j < board.getColumnCount() - 4; j++) {
				if (board.isEmpty(i, j)) {
					j++;
				}
				if (j <= board.getColumnCount() - 4 && board.isOpponent(i - 1, j + 1) && board.isOpponent(i - 2, j + 2) && board.isOpponent(i - 3, j + 3) && board.isEmpty(i, j)) {
					return new MoveFourInARow(j);
				}
			}
		}
		for (int i = board.getRowCount() - 1; i >= 3; i--) {
			for (int j = 0; j < board.getColumnCount() - 4; j++) {
				if (board.isEmpty(i, j)) {
					j++;
				}
				if (j <= board.getColumnCount() - 4 && board.isOpponent(i, j) && board.isOpponent(i - 2, j + 2) && board.isOpponent(i - 3, j + 3) && board.isEmpty(i - 1, j + 1)
						&& !board.isEmpty(i, j + 1)) {
					return new MoveFourInARow(j + 1);
				}
			}
		}
		for (int i = board.getRowCount() - 1; i >= 3; i--) {
			for (int j = 0; j < board.getColumnCount() - 4; j++) {
				if (board.isEmpty(i, j)) {
					j++;
				}
				if (j <= board.getColumnCount() - 4 && board.isOpponent(i - 1, j + 1) && board.isOpponent(i, j) && board.isOpponent(i - 3, j + 3) && board.isEmpty(i - 2, j + 2)
						&& !board.isEmpty(i - 1, j + 2)) {
					return new MoveFourInARow(j + 2);
				}
			}
		}

		// block dec diagonal
		for (int i = board.getRowCount() - 1; i >= 3; i--) {
			for (int j = board.getColumnCount() - 1; j >= 3; j--) {
				if (board.isEmpty(i, j)) {
					j--;
				}
				if (j >= 3 && board.isOpponent(i, j) && board.isOpponent(i - 1, j - 1) && board.isOpponent(i - 2, j - 2) && board.isEmpty(i - 3, j - 3) && !board.isEmpty(i - 2, j - 3)) {
					return new MoveFourInARow(j - 3);
				}
			}
		}
		for (int i = board.getRowCount() - 1; i >= 3; i--) {
			for (int j = board.getColumnCount() - 1; j >= 3; j--) {
				if (board.isEmpty(i, j)) {
					j--;
				}
				if (j >= 3 && board.isOpponent(i - 3, j - 3) && board.isOpponent(i - 1, j - 1) && board.isOpponent(i - 2, j - 2) && board.isEmpty(i, j)) {
					return new MoveFourInARow(j);
				}
			}
		}

		for (int i = board.getRowCount() - 1; i >= 3; i--) {
			for (int j = board.getColumnCount() - 1; j >= 3; j--) {
				if (board.isEmpty(i, j)) {
					j--;
				}
				if (j >= 3 && board.isOpponent(i, j) && board.isOpponent(i - 3, j - 3) && board.isOpponent(i - 2, j - 2) && board.isEmpty(i - 1, j - 1) && !board.isEmpty(i, j - 1)) {
					return new MoveFourInARow(j - 1);
				}
			}
		}
		for (int i = board.getRowCount() - 1; i >= 3; i--) {
			for (int j = board.getColumnCount() - 1; j >= 3; j--) {
				if (board.isEmpty(i, j)) {
					j--;
				}
				if (j >= 3 && board.isOpponent(i, j) && board.isOpponent(i - 3, j - 3) && board.isOpponent(i - 1, j - 1) && board.isEmpty(i - 2, j - 2) && !board.isEmpty(i - 1, j - 2)) {
					return new MoveFourInARow(j - 2);
				}
			}
		}

		while (true) {
			Random r = new Random();
			int ran = r.nextInt(board.getColumnCount() - 1);
			if (board.isEmpty(0, ran)) {
				return new MoveFourInARow(ran);
			}
		}

	}
}
