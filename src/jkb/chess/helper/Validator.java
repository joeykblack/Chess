/**
 * 
 */
package jkb.chess.helper;

import java.util.List;

import jkb.chess.factory.MoveFactory;
import jkb.chess.factory.PieceMoveFactory;
import jkb.chess.model.BitBoard;
import jkb.chess.model.BoardState;
import jkb.chess.model.Move;
import jkb.chess.model.PieceSet;
import jkb.chess.model.PieceType;

/**
 * @author joeykblack
 *
 */
public class Validator
{
	
	/**
	 * @param boardState
	 * @param move
	 * @return is move legal
	 */
	public static boolean validateMove (BoardState boardState, Move move)
	{
		boolean valid = move.isValid();
		
		if (valid)
		{
			PieceSet ps = boardState.getPieceSet(move.getType());
			valid = ps.getBit(move.getStartRow(), move.getStartcol());
		}
		
		if (valid)
		{
			BitBoard moveMap = PieceMoveFactory.generateMoves(boardState, move.getPosition());
			valid = moveMap.getBit(move.getEndRow(), move.getEndCol());
		}
		
		if (valid)
		{
			valid = !movingIntoCheck(boardState, move);
		}
		
		return valid;
	}
	
	/**
	 * @param boardState
	 * @param move
	 * @return does move put player in check
	 */
	public static boolean movingIntoCheck(BoardState boardState, Move move)
	{
		BoardState tempState = new BoardState(boardState);
		tempState.doMove(move, false, false);
		return isCheck(tempState, move.getType().isWhite());
	}
	
	/**
	 * @param boardState
	 * @param isWhite
	 * @return is player in check
	 */
	public static boolean isCheck (BoardState boardState, boolean isWhite)
	{
		// find all moves for the other guy
		BitBoard mapOfAllMoves = MoveFactory.findMapOfAllMoves(boardState, !isWhite);
		
		// find my king
		PieceSet king;
		if (isWhite)
		{
			king = boardState.getPieceSet(PieceType.WHITE_KING);
		}
		else
		{
			king = boardState.getPieceSet(PieceType.BLACK_KING);
		}
		
		return (mapOfAllMoves.getBoard() & king.getBoard()) > 0;
	}
	
	/**
	 * @param boardState
	 * @param isWhite
	 * @return is player in checkmate
	 */
	public static boolean isCheckmate (BoardState boardState, boolean isWhite)
	{
		boolean isCheckMate = true;
		// find all my moves
		List<Move> moves = MoveFactory.findAllMoves(boardState, isWhite);
		
		// see if one of my moves removes check
		for (Move move : moves)
		{
			// did i get out of check
			if (!movingIntoCheck(boardState, move))
			{
				isCheckMate = false;
				break;
			}
		}
		
		return isCheckMate;
	}

}
