/**
 * 
 */
package jkb.chess.factory;

import jkb.chess.helper.BitUtil;
import jkb.chess.model.BitBoard;
import jkb.chess.model.BoardState;
import jkb.chess.model.MoveMap;
import jkb.chess.model.PiecePosition;
import jkb.chess.resources.BitBoardConst;

/**
 * Generate moves for individual pieces
 * 
 * @author joeykblack
 *
 */
public class PieceMoveFactory
{
	
	/**
	 * Generate all moves for a piece with its position
	 * 
	 * @param boardState - current state of board
	 * @param position - position of piece
	 * @return all legal moves for piece
	 */
	public static MoveMap generateMoves (BoardState boardState, PiecePosition position)
	{
		BitBoard bb = new BitBoard();
		bb.setBit(position.getRow(), position.getCol(), true);
		BitBoard result = new BitBoard();
		
		if (!position.getType().isWhite())
		{
			boardState.flipBoard();
			bb.setBoard(BitUtil.verticalFlip(bb.getBoard()));
			position.verticalFlip();
		}
		
		switch (position.getType().getPieceName())
		{
		case PAWN:
			BitBoard attacks = attackPawn(bb);
			attacks.setBoard(attacks.getBoard() 
					& boardState.getOccupied( !position.getType().isWhite() ).getBoard());
			result = movePawn(bb);
			result = cancelAllOccupied(result, boardState);
			result.setBoard(result.getBoard() | attacks.getBoard());
			break;
		case NIGHT:
			result = moveNight(bb);
			result = cancelAllFriedlyOccupied(result, boardState, position.getType().isWhite());
			break;
		case BISHOP:
			result = moveBishop(bb, boardState, position);
			break;
		case ROOK:
			result = moveRook(bb, boardState, position);
			break;
		case QUEEN:
			result = moveQueen(bb, boardState, position);
			break;
		case KING:
			result = moveKing(bb);
			result = cancelAllFriedlyOccupied(result, boardState, position.getType().isWhite());
			break;
		}

		if (!position.getType().isWhite())
		{
			boardState.flipBoard();
			bb.setBoard(BitUtil.verticalFlip(bb.getBoard()));
			result.setBoard(BitUtil.verticalFlip(result.getBoard()));
			position.verticalFlip();
		}
		
		return new MoveMap(position, result.getBoard());
	}
	
	/**
	 * @param bb
	 * @param boardState
	 * @return bitboard with occupied positions set to 0
	 */
	private static BitBoard cancelAllOccupied(BitBoard bb, BoardState boardState) 
	{
		long board = bb.getBoard();
		board &= ~boardState.getOccupied().getBoard();
		return new BitBoard(board);
	}
	
	/**
	 * @param bb
	 * @param boardState
	 * @param isWhite
	 * @return bitboard with friendly occupied positions set to 0
	 */
	private static BitBoard cancelAllFriedlyOccupied(BitBoard bb, BoardState boardState, boolean isWhite) 
	{
		long board = bb.getBoard();
		board &= ~boardState.getOccupied(isWhite).getBoard();
		return new BitBoard(board);
	}

	public static BitBoard moveNight(BitBoard bb) 
	{
		long board = bb.getBoard();
		
		board = ( (board << 6) & ~(BitBoardConst.FILE_H | BitBoardConst.FILE_G) ) | 
				( (board << 15) & ~BitBoardConst.FILE_H ) | 
				( (board >>> 10) & ~(BitBoardConst.FILE_H | BitBoardConst.FILE_G) ) | 
				( (board >>> 17) & ~BitBoardConst.FILE_H ) | 
				( (board << 10) & ~(BitBoardConst.FILE_A | BitBoardConst.FILE_B) ) | 
				( (board << 17) & ~BitBoardConst.FILE_A ) | 
				( (board >>> 6) & ~(BitBoardConst.FILE_A | BitBoardConst.FILE_B) ) | 
				( (board >>> 15) & ~BitBoardConst.FILE_A );

		return new BitBoard(board);
	}

	// TODO: pawns can jump
	public static BitBoard movePawn(BitBoard bb) 
	{
		long board = bb.getBoard();
		BitBoard result = new BitBoard();
		if ((bb.getBoard() & BitBoardConst.RANK_2) > 0l)
		{
			result.setBoard((board << 8) | (board << 16));
		}
		else
		{
			result.setBoard((board << 8));
		}
		return result;
	}

	public static BitBoard attackPawn(BitBoard bb) 
	{
		long board = bb.getBoard();
		return new BitBoard( ((board << 7) & ~BitBoardConst.FILE_H) | ((board << 9) & ~BitBoardConst.FILE_A));
	}
	
	/**
	 * @param bb
	 * @return
	 */
	public static BitBoard moveKing(BitBoard bb)
	{

		long board = bb.getBoard();
		
		board = (( (board << 7) | (board >>> 1) | (board >>> 9)  ) & ~BitBoardConst.FILE_H) |
				(( (board << 9) | (board << 1) | (board >>> 7)  ) & ~BitBoardConst.FILE_A) |
				( (board << 8) | (board >>> 8) );

		return new BitBoard(board);
	}
	
	/**
	 * @param bb
	 * @param boardState 
	 * @param row 
	 * @param col 
	 * @return
	 */
	public static BitBoard moveRook(BitBoard bb, BoardState boardState, PiecePosition position)
	{
		int row = position.getRow();
		int col = position.getCol();
		long board = bb.getBoard();
		long file = BitBoardConst.getFile(col);
		long rank = BitBoardConst.getRank(row);
		long friendly = boardState.getOccupied(position.getType().isWhite()).getBoard();
		long enemy = boardState.getOccupied(!position.getType().isWhite()).getBoard();
		
		long rightBoard = ((board << 1) | (board << 2) | (board << 3) | (board << 4) | (board << 5) | (board << 6) | (board << 7)) & rank;
		long leftBoard = ((board >>> 1) | (board >>> 2) | (board >>> 3) | (board >>> 4) | (board >>> 5) | (board >>> 6) | (board >>> 7)) & rank;
		long upBoard = ((board << 8) | (board << 16) | (board << 24) | (board << 32) | (board << 40) | (board << 48) | (board << 56)) & file;
		long downBoard = ((board >>> 8) | (board >>> 16) | (board >>> 24) | (board >>> 32) | (board >>> 40) | (board >>> 48) | (board >>> 56)) & file;
		
		long rightOccupiedFriendly = (rightBoard & friendly);
		long rightOccupiedEnemy = (rightBoard & enemy);
		long rightOccupied = (rightOccupiedFriendly | (rightOccupiedFriendly << 1) | (rightOccupiedFriendly << 2) | (rightOccupiedFriendly << 3) | (rightOccupiedFriendly << 4) |
						    (rightOccupiedFriendly << 5) | (rightOccupiedFriendly << 6)) |
						    ((rightOccupiedEnemy << 1) | (rightOccupiedEnemy << 2) | (rightOccupiedEnemy << 3) | (rightOccupiedEnemy << 4) |
							(rightOccupiedEnemy << 5) | (rightOccupiedEnemy << 6)) & rank;
		rightBoard &= ~rightOccupied;
		
		
		long leftOccupiedFriendly = (leftBoard & friendly);
		long leftOccupiedEnemy = (leftBoard & enemy);
		long leftOccupied = (leftOccupiedFriendly | (leftOccupiedFriendly >>> 1) | (leftOccupiedFriendly >>> 2) | (leftOccupiedFriendly >>> 3) | (leftOccupiedFriendly >>> 4) |
						    (leftOccupiedFriendly >>> 5) | (leftOccupiedFriendly >>> 6)) |
						    ((leftOccupiedEnemy >>> 1) | (leftOccupiedEnemy >>> 2) | (leftOccupiedEnemy >>> 3) | (leftOccupiedEnemy >>> 4) |
							(leftOccupiedEnemy >>> 5) | (leftOccupiedEnemy >>> 6)) & rank;
		leftBoard &= ~leftOccupied;

		long upOccupiedFriendly = (upBoard & friendly);
		long upOccupiedEnemy = (upBoard & enemy);
		long upOccupied = (upOccupiedFriendly | (upOccupiedFriendly << 8) | (upOccupiedFriendly << 16) | (upOccupiedFriendly << 24) | (upOccupiedFriendly << 32) |
					     (upOccupiedFriendly << 40) | (upOccupiedFriendly << 48)) |
					     ((upOccupiedEnemy << 8) | (upOccupiedEnemy << 16) | (upOccupiedEnemy << 24) | (upOccupiedEnemy << 32) |
						 (upOccupiedEnemy << 40) | (upOccupiedEnemy << 48)) & file;
		upBoard &= ~upOccupied;

		long downOccdowniedFriendly = (downBoard & friendly);
		long downOccdowniedEnemy = (downBoard & enemy);
		long downOccdownied = (downOccdowniedFriendly | (downOccdowniedFriendly >>> 8) | (downOccdowniedFriendly >>> 16) | (downOccdowniedFriendly >>> 24) | (downOccdowniedFriendly >>> 32) |
					     (downOccdowniedFriendly >>> 40) | (downOccdowniedFriendly >>> 48)) |
					     ((downOccdowniedEnemy >>> 8) | (downOccdowniedEnemy >>> 16) | (downOccdowniedEnemy >>> 24) | (downOccdowniedEnemy >>> 32) |
						 (downOccdowniedEnemy >>> 40) | (downOccdowniedEnemy >>> 48)) & file;
		downBoard &= ~downOccdownied;
		
		return new BitBoard(rightBoard | leftBoard | upBoard | downBoard);
	}


	/**
	 * @param bb
	 * @param boardState
	 * @param startRow
	 * @param startcol
	 * @return
	 */
	public static BitBoard moveBishop(BitBoard bb, BoardState boardState, PiecePosition position)
	{
		int row = position.getRow();
		int col = position.getCol();
		long board = bb.getBoard();
		long frontSlash = BitBoardConst.getForwardSlash(row, col);
		long backSlash = BitBoardConst.getBackSlash(row, col);
		long friendly = boardState.getOccupied(position.getType().isWhite()).getBoard();
		long enemy = boardState.getOccupied(!position.getType().isWhite()).getBoard();
		
		long neBoard = ((board << 9) | (board << 18) | (board << 27) | (board << 36) | (board << 45) | (board << 54) | (board << 63)) & backSlash;
		long swBoard = ((board >>> 9) | (board >>> 18) | (board >>> 27) | (board >>> 36) | (board >>> 45) | (board >>> 54) | (board >>> 63)) & backSlash;
		long nwBoard = ((board << 7) | (board << 14) | (board << 21) | (board << 28) | (board << 35) | (board << 42) | (board << 49)) & frontSlash;
		long seBoard = ((board >>> 7) | (board >>> 14) | (board >>> 21) | (board >>> 28) | (board >>> 35) | (board >>> 42) | (board >>> 49)) & frontSlash;

		long neOccupiedFriendly = (neBoard & friendly);
		long neOccupiedEnemy = (neBoard & enemy);
		long neOccupied = (neOccupiedFriendly | (neOccupiedFriendly << 9) | (neOccupiedFriendly << 18) | (neOccupiedFriendly << 27) | (neOccupiedFriendly << 36) |
					     (neOccupiedFriendly << 45) | (neOccupiedFriendly << 54)) |
					     ((neOccupiedEnemy << 9) | (neOccupiedEnemy << 18) | (neOccupiedEnemy << 27) | (neOccupiedEnemy << 36) |
					     (neOccupiedEnemy << 45) | (neOccupiedEnemy << 54)) & backSlash;
		neBoard &= ~neOccupied;
		
		long swOccupiedFriendly = (swBoard & friendly);
		long swOccupiedEnemy = (swBoard & enemy);
		long swOccupied = (swOccupiedFriendly | (swOccupiedFriendly >>> 9) | (swOccupiedFriendly >>> 18) | (swOccupiedFriendly >>> 27) | (swOccupiedFriendly >>> 36) |
					     (swOccupiedFriendly >>> 45) | (swOccupiedFriendly >>> 54)) |
					     ((swOccupiedEnemy >>> 9) | (swOccupiedEnemy >>> 18) | (swOccupiedEnemy >>> 27) | (swOccupiedEnemy >>> 36) |
					     (swOccupiedEnemy >>> 45) | (swOccupiedEnemy >>> 54)) & backSlash;
		swBoard &= ~swOccupied;

		long nwOccupiedFriendly = (nwBoard & friendly);
		long nwOccupiedEnemy = (nwBoard & enemy);
		long nwOccupied = (nwOccupiedFriendly | (nwOccupiedFriendly << 7) | (nwOccupiedFriendly << 14) | (nwOccupiedFriendly << 21) | (nwOccupiedFriendly << 28) |
					     (nwOccupiedFriendly << 35) | (nwOccupiedFriendly << 42)) |
					     ((nwOccupiedEnemy << 7) | (nwOccupiedEnemy << 14) | (nwOccupiedEnemy << 21) | (nwOccupiedEnemy << 28) |
					     (nwOccupiedEnemy << 35) | (nwOccupiedEnemy << 42)) & frontSlash;
		nwBoard &= ~nwOccupied;

		long seOccupiedFriendly = (seBoard & friendly);
		long seOccupiedEnemy = (seBoard & enemy);
		long seOccupied = (seOccupiedFriendly | (seOccupiedFriendly >>> 7) | (seOccupiedFriendly >>> 14) | (seOccupiedFriendly >>> 21) | (seOccupiedFriendly >>> 28) |
					     (seOccupiedFriendly >>> 35) | (seOccupiedFriendly >>> 42)) |
					     ((seOccupiedEnemy >>> 7) | (seOccupiedEnemy >>> 14) | (seOccupiedEnemy >>> 21) | (seOccupiedEnemy >>> 28) |
					     (seOccupiedEnemy >>> 35) | (seOccupiedEnemy >>> 42)) & frontSlash;
		seBoard &= ~seOccupied;
		
		return new BitBoard(neBoard | swBoard | nwBoard | seBoard);
	}

	/**
	 * @param bb
	 * @param boardState
	 * @param startRow
	 * @param startcol
	 * @return
	 */
	public static BitBoard moveQueen(BitBoard bb, BoardState boardState, PiecePosition position)
	{
		BitBoard rook = moveRook(bb, boardState, position);
		BitBoard bishop = moveBishop(bb, boardState, position);
		return new BitBoard(rook.getBoard() | bishop.getBoard());
	}

	
}
