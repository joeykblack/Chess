/**
 * 
 */
package jkb.chess.model;

/**
 * This represents a certain type of piece and all the 
 * locations of that piece are represented by the bitboard
 * 
 * @author joeykblack
 *
 */
public class PieceSet extends BitBoard
{
	
	private PieceType type;
	
	/**
	 * Constructor
	 */
	public PieceSet()
	{
		super();
	}

	/**
	 * @param type
	 */
	public PieceSet(PieceType type)
	{
		super();
		this.type = type;
	}

	/**
	 * @param pieceSet
	 */
	public PieceSet(PieceSet pieceSet)
	{
		super(pieceSet);
		this.type = pieceSet.getType();
	}

	/**
	 * @return the type
	 */
	public PieceType getType()
	{
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(PieceType type)
	{
		this.type = type;
	}
}
