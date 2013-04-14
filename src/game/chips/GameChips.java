package game.chips;

import ai.game.Game;

public class GameChips extends Game {
	private int chipsLeft;
	private int maxChipsToTake;

	// private ArrayList<PlayerChips> players;

	public GameChips() {
		this(21);
	}

	public GameChips(int chipsLeft) {
		super("Chips");
		this.chipsLeft = chipsLeft;
		maxChipsToTake = chipsLeft / 2;
	}

	@Override
	public void play() throws Throwable {
		PlayerChips p1 = (PlayerChips) players.get(0);
		PlayerChips p2 = (PlayerChips) players.get(1);
		System.out.println("\t" + p1.getName() + " vs. " + p2.getName());

		while (chipsLeft > 0) {
			movePlayer(p1);
			if (gameWon()) {
				winner = p1;
				break;
			}
			movePlayer(p2);
			if (gameWon()) {
				winner = p2;
				break;
			}
		}

	}

	private void movePlayer(PlayerChips player) throws Throwable {
		verbose("There are " + chipsLeft + " chips left.");
		verbose(player.getName() + " may take " + maxChipsToTake + " chips.");
		MoveChips move = player.makeMove(getBoard());
		verbose(player.getName() + " took " + move.getAmount() + ".");
		if (moveIsLegal(move)) {
			chipsLeft -= move.getAmount();
			maxChipsToTake = move.getAmount() * 2;
		} else {
			throw new Throwable("Illegal Move!");
		}
	}

	private BoardChips getBoard() {
		return new BoardChips(chipsLeft, maxChipsToTake);
	}

	private boolean moveIsLegal(MoveChips move) {
		return move.getAmount() > 0 && move.getAmount() <= maxChipsToTake;
	}

	private boolean gameWon() {
		return chipsLeft <= 0;
	}

	public void verbose(String print) {
		if (verbose) {
			System.out.println(print);
			output.add(print);
		}
	}
}