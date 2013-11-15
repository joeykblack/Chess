/**
 * 
 */
package jkb.chess.ai.agent.search;

import jkb.chess.model.BoardState;
import jkb.chess.model.Move;

/**
 * Move searching interface
 * 
 * @author joeykblack
 *
 */
public interface MoveSearcher
{
	
	public Move findBestMove(BoardState boardState, boolean isWhite);

}
