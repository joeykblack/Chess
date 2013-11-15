/**
 * 
 */
package jkb.chess.model;

/**
 * @author joeykblack
 *
 */
public enum PieceName 
{
	PAWN('P', 0, 1),NIGHT('N', 1, 3),BISHOP('B', 2, 3),ROOK('R', 3, 5),QUEEN('Q', 4, 9),KING('K', 5, 200);
	
	private final char symbol;
	private final int index;
	private final int value;

	/**
	 * @param symbol
	 */
	private PieceName(char symbol, int index, int value)
	{
		this.symbol = symbol;
		this.index = index;
		this.value = value;
	}

	/**
	 * @return the symbol
	 */
	public char getSymbol()
	{
		return symbol;
	}

	/**
	 * @return the index
	 */
	public int getIndex()
	{
		return index;
	}

	/**
	 * @return the value
	 */
	public int getValue()
	{
		return value;
	}
}
