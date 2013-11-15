/**
 * 
 */
package jkb.chess.ai.agent.evaluation;

import jkb.chess.helper.Validator;
import jkb.chess.model.BoardState;
import jkb.chess.model.Move;
import jkb.chess.model.PieceType;
import jkb.chess.resources.BitBoardConst;

/**
 * @author joeykblack
 *
 */
public class Evaluator
{
	
	private static final int CENTER_PIECE_VALUE = 5;
	private static final int CHECK_VALUE = 300;
	private static final int CHECK_MATE_VALUE = Integer.MAX_VALUE;
	private static final int IN_CHECK_MATE_VALUE = Integer.MIN_VALUE;
	private static final int PIECE_MULTIPLIER = 100;
	
	/**
	 * Gets the value of doing move on boardState without
	 * looking ahead. Basically we see if we capture a piece
	 * and add the value of that piece.
	 * 
	 * @param move - the move
	 * @param boardState - board state move is done on
	 * @return value of move
	 */
	public static int evaluateMove(Move move, BoardState boardState)
	{
		int moveValue = 0;
		
		BoardState tempState = new BoardState(boardState);
		PieceType type = tempState.doMoveReturnCapture(move, false, false);
		if (type!=null)
		{
			moveValue += type.getPieceName().getValue() * PIECE_MULTIPLIER;
		}
		
		return moveValue;
	}

	/**
	 * Calculate value of being in this state.
	 * 
	 * @param boardState - current state
	 * @param isWhite - calculating for white?
	 * @return value of being in this board state
	 */
	public static int evaluateBoardState(BoardState boardState, boolean isWhite)
	{
		int boardValue = 0;
		
		// Players pieces in center of board
		long centerOccupied = boardState.getOccupied(isWhite).getBoard() & BitBoardConst.CENTER;
		boardValue += Long.bitCount(centerOccupied) * CENTER_PIECE_VALUE;

		// Opponents pieces in center of board
		long centerOccupiedOp = boardState.getOccupied(!isWhite).getBoard() & BitBoardConst.CENTER;
		boardValue -= Long.bitCount(centerOccupiedOp) * CENTER_PIECE_VALUE;

		// Check and checkmate values
		if (Validator.isCheck(boardState, isWhite))
		{
			boardValue -= CHECK_VALUE;
			if (Validator.isCheckmate(boardState, isWhite))
			{
				boardValue = IN_CHECK_MATE_VALUE;
			}
		}
		if (Validator.isCheck(boardState, !isWhite))
		{
			boardValue += CHECK_VALUE;
			if (Validator.isCheckmate(boardState, !isWhite))
			{
				boardValue = CHECK_MATE_VALUE;
			}
		}
		
		return boardValue;
	}
}
