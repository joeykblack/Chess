/**
 * 
 */
package jkb.chess.ai.agent;

import jkb.chess.ai.agent.search.impl.Minimax;
import jkb.chess.model.BoardState;
import jkb.chess.model.Move;

/**
 * 
 * This is the intelligent agent that plays for the computer.
 * 
 * The only function of significance here is play.
 * 
 * @author joeykblack
 *
 */
public class ChessAgent
{
	private boolean isWhite;
	
	/**
	 * @param isWhite
	 */
	public ChessAgent(boolean isWhite)
	{
		super();
		this.isWhite = isWhite;
	}

	/**
	 * 
	 */
	public ChessAgent()
	{
	}
	
	/**
	 * @param boardState - the current state of the game
	 * @return the best move given the current state
	 */
	public Move play(BoardState boardState)
	{
		return new Minimax(2).findBestMove(boardState, isWhite);
	}


}
