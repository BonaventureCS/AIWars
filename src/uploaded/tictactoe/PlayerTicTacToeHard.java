package uploaded.tictactoe;

import java.awt.Point;
import java.util.ArrayList;

import tictactoe.PlayerTicTacToe;

public class PlayerTicTacToeHard extends PlayerTicTacToe {
	public PlayerTicTacToeHard() {
		super("Hard");
	}

	private int move = 1;
	private ArrayList<Point> opp = new ArrayList<Point>();
	//
	// public Point getLast(BoardTicTacToe board) {
	//
	// for (int i = 0; i < board.getColumnCount(); i++) {
	// for (int j = 0; j < board.getRowCount(); j++) {
	// if (!board.isEmpty(i, j)) {
	// if (!opp.contains(new Point(i, j))) {
	// Point pt = new Point(i, j);
	// opp.add(pt);
	// return pt;
	// }
	//
	// }
	// }
	// }
	// return null;
	// }
	//
	// public MoveTicTacToe hasAdj(BoardTicTacToe board) {
	// if ((opp.contains(new Point(0, 0)) && (opp.contains(new Point(2, 0)) &&
	// (!opp.contains(new Point(1, 0)))))) {
	// return new MoveTicTacToe(1, 0);
	// }
	// if ((opp.contains(new Point(0, 0)) && (opp.contains(new Point(0, 2)) &&
	// (!opp.contains(new Point(0, 1)))))) {
	// return new MoveTicTacToe(0, 1);
	// }
	// if ((opp.contains(new Point(0, 2)) && (opp.contains(new Point(2, 2)) &&
	// (!opp.contains(new Point(2, 1)))))) {
	// return new MoveTicTacToe(1, 2);
	// }
	// if ((opp.contains(new Point(2, 2)) && (opp.contains(new Point(2, 0)) &&
	// (!opp.contains(new Point(1, 2)))))) {
	// return new MoveTicTacToe(1, 2);
	// }
	// return null;
	// }
	//
	// public MoveTicTacToe makeMove(BoardTicTacToe board) {
	//
	// ArrayList<Point> edge = new ArrayList<Point>();
	// ArrayList<Point> corner = new ArrayList<Point>();
	// corner.add(new Point(0,0));
	// corner.add(new Point(0,2));
	// corner.add(new Point(2,0));
	// corner.add(new Point(2,2));
	// edge.add(new Point(0,1));
	// edge.add(new Point(1,0));
	// edge.add(new Point(2,1));
	// edge.add(new Point(1,2));
	//
	//
	// if(board.isFirst())
	// {
	// return new MoveTicTacToe(1,1);
	// }
	// if(board.moveNum() == 1)
	// {
	// if(edge.contains(getLast(board)))
	// {
	// return new MoveTicTacToe(1,1);
	// //edge.remove(getLast(board));
	// }
	// else if(corner.contains(getLast(board)))
	// {
	// return new MoveTicTacToe(1,1);
	// }
	// else if ((getLast(board) == new Point(1,1)))
	// {
	// return new MoveTicTacToe(0,2);
	// }
	// }
	// if(board.moveNum() == 2)
	// {
	// if(edge.contains(getLast(board)))
	// {
	// return new MoveTicTacToe(2,2);
	// //edge.remove(getLast(board));
	// }
	// else if(corner.get(0) == getLast(board))
	// {
	// return new MoveTicTacToe(2,2);
	// }
	// else if (corner.get(1) == getLast(board))
	// {
	// return new MoveTicTacToe(2,0);
	// }
	// else if (corner.get(2) == getLast(board))
	// {
	// return new MoveTicTacToe(0,2);
	// }
	// else if (corner.get(3) == getLast(board))
	// {
	// return new MoveTicTacToe(0,0);
	// }
	// }
	// if(board.moveNum() == 3)
	// {
	// if(opp.contains(new Point(1,1)) && opp.contains(corner.get(1)))
	// {
	// return new MoveTicTacToe(2,0);
	// }
	// else if(opp.contains(new Point(1,1)) && opp.contains(corner.get(2)))
	// {
	// return new MoveTicTacToe(0,2);
	// }
	// else if(opp.contains(new Point(1,1)) && opp.contains(edge.get(0)))
	// {
	// return new MoveTicTacToe(2,1);
	// }
	// else if(opp.contains(new Point(1,1)) && opp.contains(edge.get(1)))
	// {
	// return new MoveTicTacToe(1,2);
	// }
	// else if(opp.contains(new Point(1,1)) && opp.contains(edge.get(2)))
	// {
	// return new MoveTicTacToe(0,1);
	// }
	// else if(opp.contains(new Point(1,1)) && opp.contains(edge.get(3)))
	// {
	// return new MoveTicTacToe(1,0);
	// }
	//
	// hasAdj(board);
	// }
	//
	// opp.add(getLast(board));
	// if(opp.size() == 1)
	// {
	// if(opp.contains(new Point(1,1)))
	// {
	// return new MoveTicTacToe(0,2);
	// }
	// else if((opp.contains(new Point(0,0)) || opp.contains(new Point(2,0))) ||
	// opp.contains(new Point(0,2)) || opp.contains(new Point(2,2)))
	// {
	// if(board.isEmpty(1, 1))
	// {
	// return new MoveTicTacToe(1,1);
	// }
	// else{
	//
	// }
	//
	// }
	// }
	// if(opp.size() == 2)
	// {
	// if(opp.contains((new Point()))
	// }
	// return new MoveTicTacToe(2,1);
	// }
}
