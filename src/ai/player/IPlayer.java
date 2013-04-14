package ai.player;
import ai.game.IGame;
import ai.move.IMove;

public interface IPlayer {
	public IMove makeMove(IGame board);
}