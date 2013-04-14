package uploaded.chips;

import game.chips.BoardChips;
import game.chips.MoveChips;
import game.chips.PlayerChips;

public class PlayerChipsBrandon extends PlayerChips {

	public PlayerChipsBrandon() {
		super("Brandon Kowalski");
	}

	public MoveChips makeMove(BoardChips board) {
		int chipsLeft = board.getChipsLeft();
		int maxChipsToTake = board.getMaxChipsToTake();
		int third = chipsLeft / 3;
		int move;
		if (maxChipsToTake >= chipsLeft) {
			move = maxChipsToTake;
		} else {
			if (chipsLeft == 5) {
				move = 2;
			} else {
				if (third * 2 >= maxChipsToTake) {
					move = third - 1;
				} else
					move = 1;
			}
		}
		return new MoveChips(move);
	}
}
