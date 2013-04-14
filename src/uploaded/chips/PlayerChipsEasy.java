package uploaded.chips;

import game.chips.BoardChips;
import game.chips.MoveChips;
import game.chips.PlayerChips;

import java.util.Random;

public class PlayerChipsEasy extends PlayerChips {
	public PlayerChipsEasy() {
		super("Easy");
		// TODO Auto-generated constructor stub
	}

	public MoveChips makeMove(BoardChips board) {
		int chipsLeft = board.getChipsLeft();
		int maxChipsToTake = board.getMaxChipsToTake();
		// if(chipsLeft < maxChipsToTake)
		// {
		// return new MoveChips(chipsLeft);
		// }
		if (chipsLeft > 7) {

			Random r = new Random();
			int move = r.nextInt(maxChipsToTake) + 1;
			return new MoveChips(move);
		}

		if (chipsLeft == 2) {
			return new MoveChips(2);
		}

		return new MoveChips(1);
	}
}