/**
 * 
 */
package jkb.chess.factory;

import jkb.chess.model.BoardState;
import jkb.chess.model.PieceSet;
import jkb.chess.model.PieceType;

/**
 * Factory to set up board
 * 
 * @author joeykblack
 *
 */
public class BoardFactory extends BoardState
{
	/**
	 * Constructor: just call super
	 */
	public BoardFactory()
	{
		super();
	}
	
	/**
	 * @return BoardState in initial state
	 */
	public static BoardState newGame ()
	{
		BoardState boardState = new BoardFactory();
		boardState.setGameOver(false);
		boardState.setGameStateString("setup");
		
		for (PieceType type : PieceType.values())
		{
			boardState.setPieceSet(PieceSetFactory.createInitialPieceSet(type));
		}
		
		return boardState;
	}
	
	/**
	 * @return empty board
	 */
	public static BoardState emptyBoard ()
	{
		BoardState boardState = new BoardFactory();
		boardState.setGameOver(false);
		boardState.setGameStateString("empty");
		
		for (PieceType type : PieceType.values())
		{
			PieceSet ps = new PieceSet(type);
			ps.setBoard(0l);
			boardState.setPieceSet(ps);
		}
		
		return boardState;
	}

}
