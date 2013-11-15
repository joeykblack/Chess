/**
 * 
 */
package jkb.chess.model;

/**
 * @author joeykblack
 *
 */
public class PiecePosition
{
	private PieceType type;
	private int row;
	private int col;
	
	/**
	 * 
	 */
	public PiecePosition()
	{
	}
	
	/**
	 * @param type
	 * @param row
	 * @param col
	 */
	public PiecePosition(PieceType type, int row, int col)
	{
		super();
		this.type = type;
		this.row = row;
		this.col = col;
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
	/**
	 * @return the row
	 */
	public int getRow()
	{
		return row;
	}
	/**
	 * @param row the row to set
	 */
	public void setRow(int row)
	{
		this.row = row;
	}
	/**
	 * @return the col
	 */
	public int getCol()
	{
		return col;
	}
	/**
	 * @param col the col to set
	 */
	public void setCol(int col)
	{
		this.col = col;
	}

	/**
	 * 
	 */
	public void verticalFlip()
	{
		row = 7 - row;
	}
}
