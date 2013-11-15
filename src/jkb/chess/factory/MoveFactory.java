/**
 * 
 */
package jkb.chess.factory;

import java.util.ArrayList;
import java.util.List;

import jkb.chess.helper.Converter;
import jkb.chess.model.BitBoard;
import jkb.chess.model.BoardState;
import jkb.chess.model.Move;
import jkb.chess.model.MoveMap;
import jkb.chess.model.PiecePosition;
import jkb.chess.model.PieceSet;
import jkb.chess.model.PieceType;

/**
 * Factory to create groups of moves
 * 
 * @author joeykblack
 *
 */
public class MoveFactory
{

	/**
	 * Finds all legal moves (not checking moves into check)
	 * for player
	 * 
	 * @param boardState - current state of board
	 * @param isWhite - looking for white's moves
	 * @return list of moves
	 */
	public static List<Move> findAllMoves(BoardState boardState, boolean isWhite)
	{
		List<PiecePosition> pieces = findPieces(boardState, isWhite);
		List<MoveMap> moveMaps = createMoveMaps(pieces, boardState);
		
		List<Move> moves = new ArrayList<Move>();
		
		for (MoveMap moveMap : moveMaps)
		{
			for (int row = 0; row < 8; row++)
			{
				for (int col = 0; col < 8; col++)
				{
					if (moveMap.getBit(row, col))
					{
						Move move = new Move();
						move.setPosition(moveMap.getPosition());
						move.setEndCol(col);
						move.setEndRow(row);
						move.setValid(true);
						move.setNotation(Converter.moveToNotation(move));
						moves.add(move);
					}
				}
			}
		}
		
		return moves;
	}

	/**
	 * @param boardState
	 * @param isWhite
	 * @return all legal moves for player combined into one BitBoard
	 */
	public static BitBoard findMapOfAllMoves(BoardState boardState, boolean isWhite)
	{
		List<PiecePosition> pieces = findPieces(boardState, isWhite);
		List<MoveMap> moveMaps = createMoveMaps(pieces, boardState);
		long board = 0l;
		for (MoveMap moveMap : moveMaps)
		{
			board |= moveMap.getBoard();
		}
		
		return new BitBoard(board);
	}

	/**
	 * Given position of all pieces and board state
	 * then find all moves for each piece
	 * 
	 * @param piecePositions - position of each piece
	 * @param boardState - current state of board
	 * @return All legal moves for given pieces
	 */
	private static List<MoveMap> createMoveMaps(List<PiecePosition> piecePositions, BoardState boardState)
	{
		List<MoveMap> moveMap = new ArrayList<MoveMap>();
		
		for (PiecePosition position : piecePositions)
		{
			moveMap.add(PieceMoveFactory.generateMoves(boardState, position));
		}
		
		return moveMap;
	}

	/**
	 * Find all my pieces on the board
	 * 
	 * @param boardState
	 * @param isWhite
	 */
	private static List<PiecePosition> findPieces(BoardState boardState, boolean isWhite)
	{
		List<PiecePosition> pieces = new ArrayList<PiecePosition>();
		for (PieceType type : PieceType.values())
		{
			if (type.isWhite() ==  isWhite)
			{
				PieceSet set = boardState.getPieceSet(type);
				for (int row = 0; row < 8; row++)
				{
					for (int col = 0; col < 8; col++)
					{
						if (set.getBit(row, col))
						{
							pieces.add(new PiecePosition(type, row, col));
						}
					}
				}
			}
		}
		return pieces;
	}
}
