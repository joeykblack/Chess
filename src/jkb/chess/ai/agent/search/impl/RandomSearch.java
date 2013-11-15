/**
 * 
 */
package jkb.chess.ai.agent.search.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;

import jkb.chess.ai.agent.search.MoveSearcher;
import jkb.chess.factory.MoveFactory;
import jkb.chess.helper.Validator;
import jkb.chess.model.BoardState;
import jkb.chess.model.Move;
import jkb.chess.out.Out;

/**
 * @author joeykblack
 *
 */
public class RandomSearch implements MoveSearcher
{

	/* (non-Javadoc)
	 * @see jkb.chess.ai.agent.search.MoveSearcher#findBestMove(jkb.chess.model.BoardState, boolean)
	 */
	@Override
	public Move findBestMove(BoardState boardState, boolean isWhite)
	{

		// Generate valid moves
		List<Move> moves = MoveFactory.findAllMoves(boardState, isWhite);

		// Select random move that does not put me in check
		Random rand = new Random(new Date().getTime());
		int r = rand.nextInt(moves.size());
		Move randomMove = moves.get(r);
		if (Validator.movingIntoCheck(boardState, randomMove))
		{
			for (Move move : moves)
			{
				if (!Validator.movingIntoCheck(boardState, move))
				{
					randomMove = move;
					break;
				}
			}
		}
		if (Validator.movingIntoCheck(boardState, randomMove))
		{
			Out.println("Unable to find move that does not result in check!?!");
		}
		Out.println();
		
		// Analyze moves
		// select move
		return randomMove;
	}

}
