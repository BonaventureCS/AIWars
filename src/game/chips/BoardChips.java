package game.chips;

import ai.board.Board;

public class BoardChips extends Board {
	private int chipsLeft, maxChipsToTake;

	public BoardChips(int chipsLeft, int maxChipsToTake) {
		this.chipsLeft = chipsLeft;
		this.maxChipsToTake = maxChipsToTake;
	}

	public int getChipsLeft() {
		return chipsLeft;
	}

	public int getMaxChipsToTake() {
		return maxChipsToTake;
	}
}