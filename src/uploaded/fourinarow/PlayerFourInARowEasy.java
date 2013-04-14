package uploaded.fourinarow;

import game.fourinarow.BoardFourInARow;
import game.fourinarow.MoveFourInARow;
import game.fourinarow.PlayerFourInARow;

import java.util.Random;

public class PlayerFourInARowEasy extends PlayerFourInARow {
	public PlayerFourInARowEasy() {
		super("Easy");
	}

	public MoveFourInARow makeMove(BoardFourInARow board) {
		while (true) {
			Random r = new Random();
			int n = r.nextInt(board.getColumnCount());
			if (board.isEmpty(0, n)) {
				return new MoveFourInARow(n);
			}
		}
	}
}