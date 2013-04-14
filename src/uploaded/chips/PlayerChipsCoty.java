package uploaded.chips;

import game.chips.BoardChips;
import game.chips.MoveChips;
import game.chips.PlayerChips;

import java.util.ArrayList;

public class PlayerChipsCoty extends PlayerChips {

	public PlayerChipsCoty() {
		super("Coty Collins");
		this.otherPlayerMoves = new ArrayList<Integer>();
	}

	private ArrayList<Integer> otherPlayerMoves;
	private boolean began = false;

	public MoveChips makeMove(BoardChips board) {
		int chipsLeft = board.getChipsLeft();
		int maxChipsToTake = board.getMaxChipsToTake();

		recordMove(maxChipsToTake);
		if (chipsLeft <= maxChipsToTake) {
			return new MoveChips(chipsLeft);
		}
		if ((!this.began) || (chipsLeft == 3)) {
			return new MoveChips(1);
		}
		for (int i = 5; i < chipsLeft; i += 3) {
			if (chipsLeft == i + 1)
				return new MoveChips(1);
			if (chipsLeft == i + 2) {
				return new MoveChips(2);
			}
		}
		return new MoveChips(1);
	}

	private void recordMove(int k) {
		if (this.otherPlayerMoves.size() == 0) {
			this.began = true;
		}
		if ((this.otherPlayerMoves.size() != 0) || (k != 10))
			this.otherPlayerMoves.add(Integer.valueOf(k / 2));
	}

	public void setup() {
		this.otherPlayerMoves = new ArrayList();
		this.began = false;
	}
}
