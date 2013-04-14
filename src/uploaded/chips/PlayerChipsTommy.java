package uploaded.chips;

import game.chips.BoardChips;
import game.chips.MoveChips;
import game.chips.PlayerChips;

public class PlayerChipsTommy extends PlayerChips {
	public PlayerChipsTommy() {
		super("Tommy Bartlett");
	}

	public MoveChips makeMove(BoardChips board) {
		int chipsLeft = board.getChipsLeft();
		int maxChipsToTake = board.getMaxChipsToTake();

		if (chipsLeft <= maxChipsToTake) {
			return new MoveChips(chipsLeft);
		}

		if (chipsLeft > 13) {
			if (chipsLeft - maxChipsToTake <= 13 && (3 * maxChipsToTake < chipsLeft)) {
				return new MoveChips(chipsLeft - 13);
			}
		} else if (chipsLeft > 5) {
			if (chipsLeft - maxChipsToTake <= 5 && (3 * maxChipsToTake) < chipsLeft) {
				return new MoveChips(chipsLeft - 5);
			}
		}

		else if (chipsLeft > 3) {
			if (chipsLeft - maxChipsToTake <= 3 && (3 * maxChipsToTake) < chipsLeft) {
				return new MoveChips(chipsLeft - 3);
			}
		}

		else {
			if (maxChipsToTake / 3 - 1 <= 0) {
				return new MoveChips(1);
			}
			return new MoveChips(maxChipsToTake / 3);

		}

		return new MoveChips(1);
	}
}
