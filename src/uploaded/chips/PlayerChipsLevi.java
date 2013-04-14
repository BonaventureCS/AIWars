package uploaded.chips;

import game.chips.BoardChips;
import game.chips.MoveChips;
import game.chips.PlayerChips;

public class PlayerChipsLevi extends PlayerChips {
	public PlayerChipsLevi() {
		super("Levi Lewis");
	}

	public MoveChips makeMove(BoardChips board) {
		int chipsLeft = board.getChipsLeft();
		int maxChipsToTake = board.getMaxChipsToTake();
		int chipsLeftToFive = board.getChipsLeft() - 5;
		int move = maxChipsToTake;

		if (chipsLeftToFive <= maxChipsToTake && 3 * chipsLeftToFive < chipsLeft && chipsLeftToFive > 0) {
			return new MoveChips(chipsLeftToFive);
		}
		if (chipsLeftToFive <= maxChipsToTake && 3 * chipsLeftToFive >= chipsLeft && chipsLeftToFive > 0) {
			while (3 * move >= chipsLeftToFive) {
				move--;
				if (move == 0) {
					return new MoveChips(1);
				}
			}
			return new MoveChips(move);
		}
		if (chipsLeftToFive > maxChipsToTake) {
			while (3 * move >= chipsLeftToFive) {
				move--;
				if (move == 0) {
					return new MoveChips(1);
				}
			}
			return new MoveChips(move);
		}
		if (chipsLeft == 4) {
			return new MoveChips(1);
		}
		if (maxChipsToTake >= chipsLeft) {
			return new MoveChips(chipsLeft);
		}
		return new MoveChips(1);
	}
}