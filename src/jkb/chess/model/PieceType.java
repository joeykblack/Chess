/**
 * 
 */
package jkb.chess.model;

/**
 * @author joeykblack
 *
 */
public enum PieceType 
{
	WHITE_PAWN(true, PieceName.PAWN),WHITE_NIGHT(true, PieceName.NIGHT),WHITE_BISHOP(true, PieceName.BISHOP),
	WHITE_ROOK(true, PieceName.ROOK),WHITE_QUEEN(true, PieceName.QUEEN),WHITE_KING(true, PieceName.KING),
	BLACK_PAWN(false, PieceName.PAWN),BLACK_NIGHT(false, PieceName.NIGHT),BLACK_BISHOP(false, PieceName.BISHOP),
	BLACK_ROOK(false, PieceName.ROOK),BLACK_QUEEN(false, PieceName.QUEEN),BLACK_KING(false, PieceName.KING);
	
	private final int index;
	private final boolean isWhite;
	private final PieceName pieceName;
	
	/**
	 * Constructor 
	 */
	private PieceType(boolean isWhite, PieceName pieceName)
	{
		this.index = pieceName.getIndex() + ((isWhite) ? 0 : 6);
		this.isWhite = isWhite;
		this.pieceName = pieceName;
	}

	/**
	 * @return the index
	 */
	public int getIndex()
	{
		return index;
	}

	/**
	 * @return the isWhite
	 */
	public boolean isWhite()
	{
		return isWhite;
	}

	/**
	 * @return the pieceName
	 */
	public PieceName getPieceName()
	{
		return pieceName;
	}

	/**
	 * @return the piece symbol
	 */
	public String getPieceSymbol()
	{
		return ((isWhite) ? "W" : "B") + pieceName.getSymbol();
	}
}
