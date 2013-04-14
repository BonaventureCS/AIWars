package game.chips;

import ai.move.IMove;

public class MoveChips implements IMove {
	private int amount;

	public MoveChips(int n) {
		amount = n;
	}

	public int getAmount() {
		return amount;
	}
}