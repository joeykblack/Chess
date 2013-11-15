/**
 * 
 */
package jkb.chess.ai.agent.search.impl;

import java.util.List;

import jkb.chess.ai.agent.evaluation.Evaluator;
import jkb.chess.ai.agent.search.MoveSearcher;
import jkb.chess.factory.MoveFactory;
import jkb.chess.helper.Converter;
import jkb.chess.helper.Validator;
import jkb.chess.model.BoardState;
import jkb.chess.model.Move;
import jkb.chess.model.MoveNode;
import jkb.chess.out.Out;

/**
 * 
 * This is a basic implementation of the Minmax algorithm.
 * There is a lot that could be done to improve it, but
 * all the basic functionality is here.
 * 
 * Improvements to be done:
 * - Add en passant and castling
 * - Refactor recursive calls to loops
 * - Implement Alpha-beta pruning to reduce number of nodes
 *   that must be searched.
 * - Opening library, end game database
 * 
 * @author joeykblack
 *
 */
public class Minimax implements MoveSearcher
{
	private int depth;
	
	/**
	 * @param depth
	 */
	public Minimax(int depth)
	{
		super();
		this.depth = depth;
	}

	/**
	 * Finds the best move finding move with highest value
	 */
	/* (non-Javadoc)
	 * @see jkb.chess.ai.agent.search.MoveSearcher#findBestMove(jkb.chess.model.BoardState, boolean)
	 */
	@Override
	public Move findBestMove(BoardState boardState, boolean isWhite)
	{
		MoveNode bestMove = new MoveNode();
		
		// For each move that could be made
		List<Move> moves = MoveFactory.findAllMoves(boardState, isWhite);
		for (Move move : moves)
		{
			// Is the move valid
			if (!Validator.movingIntoCheck(boardState, move))
			{
				// Get move value
				MoveNode moveNode = calcMiniMaxOnMove(move, boardState, depth);
				
				// Do we have a new best move?
				if (moveNode.getValue() > bestMove.getValue())
				{
					bestMove = moveNode;
				}
			}
		}
		
		// Print best moves
		Out.println();
		MoveNode current = bestMove;
		String s = "";
		Out.println( ( (bestMove.getMove().getType().isWhite()) ? "White " : "Black " ) + Converter.moveToNotation(bestMove.getMove()) + " " + bestMove.getValue());
		while (current.getChildren().size()>0)
		{
			current = current.getChildMove(0);
			s += " ";
			Out.println(s + ( (current.getMove().getType().isWhite()) ? "White " : "Black " ) + Converter.moveToNotation(current.getMove()) + " " + current.getValue());
		}
		
		return bestMove.getMove();
	}

	/**
	 * Method that calculates the value of a move by calculating value of
	 * the move by itself and then finding the highest valued opponent move
	 * and subtracting the result.
	 * 
	 * @param move - move to calculate value for
	 * @param boardState - board state that move is done in
	 * @param curDepth - current depth into the recursive calls
	 * @return value of doing this move
	 */
	private MoveNode calcMiniMaxOnMove(Move move, BoardState boardState, int curDepth)
	{
		int moveValue = Evaluator.evaluateMove(move, boardState);
		MoveNode returnMoveNode = new MoveNode();
		returnMoveNode.setMove(move);

		// Do move
		BoardState nextState = new BoardState(boardState);
		nextState.doMove(move, false, false);
		
		// at leaf
		if (curDepth == 0)
		{
			// Add value of being in this board state
			moveValue += Evaluator.evaluateBoardState(nextState, move.getType().isWhite());
		}
		// Recursively evaluate move based on minimax algorithm
		else
		{
			// For each opponent move
			List<Move> opMoves = MoveFactory.findAllMoves(nextState, !move.getType().isWhite());
			MoveNode bestCounterMove = new MoveNode();
			for (Move opMove : opMoves)
			{
				// Recursive calculation
				MoveNode counterMove = calcMiniMaxOnMove(opMove, nextState, curDepth-1);
				
				// New best opponent move
				if (counterMove.getValue() > bestCounterMove.getValue())
				{
					bestCounterMove = counterMove;
				}
			}
			
			// Set parent and child values
			bestCounterMove.setParent(returnMoveNode);
			returnMoveNode.addChildMove(bestCounterMove);
			
			// Subtract opponent's best move value from my move value
			moveValue -= bestCounterMove.getValue();
		}

		// Set my move value and return
		returnMoveNode.setValue(moveValue);
		return returnMoveNode;
	}

}
