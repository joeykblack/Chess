/**
 * 
 */
package jkb.chess.factory;

import jkb.chess.helper.BitUtil;
import jkb.chess.model.PieceSet;
import jkb.chess.model.PieceType;
import jkb.chess.resources.BitBoardConst;

/**
 * @author joeykblack
 *
 */
public class PieceSetFactory
{
	
	/**
	 * Creates a set of pieces in initial position
	 * 
	 * @param type
	 * @return
	 */
	public static PieceSet createInitialPieceSet(PieceType type)
	{
		PieceSet pieceSet = new PieceSet(type);
		
		switch (type.getPieceName())
		{
		case PAWN:
			pieceSet.setBoard(BitBoardConst.PAWN_INITIAL);
			break;
		case NIGHT:
			pieceSet.setBoard(BitBoardConst.NIGHT_INITIAL);
			break;
		case BISHOP:
			pieceSet.setBoard(BitBoardConst.BISHOP_INITIAL);
			break;
		case ROOK:
			pieceSet.setBoard(BitBoardConst.ROOK_INITIAL);
			break;
		case QUEEN:
			pieceSet.setBoard(BitBoardConst.QUEEN_INITIAL);
			break;
		case KING:
			pieceSet.setBoard(BitBoardConst.KING_INITIAL);
			break;
		}
		
		if ( !type.isWhite() )
		{
			pieceSet.setBoard(BitUtil.verticalFlip(pieceSet.getBoard()));
		}
		
		return pieceSet;
	}

}
