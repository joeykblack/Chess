/**
 * 
 */
package jkb.chess.helper;

import jkb.chess.model.BoardState;
import jkb.chess.model.Move;
import jkb.chess.model.PieceSet;

/**
 * @author joeykblack
 *
 */
public class Mover
{
	
	/**
	 * Performs move on board state
	 * 
	 * @param boardState
	 * @param move
	 */
	public static void doMove(BoardState boardState, Move move)
	{
		// do move
		PieceSet ps = boardState.getPieceSet(move.getType());
		ps.setBit(move.getStartRow(), move.getStartcol(), false);
		ps.setBit(move.getEndRow(), move.getEndCol(), true);
		boardState.setPieceSet(ps);
	}

}
