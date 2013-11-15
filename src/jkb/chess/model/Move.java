/**
 * 
 */
package jkb.chess.model;

/**
 * @author joeykblack
 *
 */
public class Move
{
	
	private String notation;
	private int endRow;
	private int endCol;
	private boolean isCapture;
	private boolean valid;
	private PiecePosition position = new PiecePosition();

	/**
	 * 
	 */
	public Move()
	{
	}
	
	
	
	/**
	 * @param pieceType
	 * @param startRow
	 * @param startCol
	 * @param endRow
	 * @param endCol
	 */
	public Move(PieceType type, int startRow, int startCol, int endRow, int endCol)
	{
		super();
		this.endRow = endRow;
		this.endCol = endCol;
		this.position = new PiecePosition(type, startRow, startCol);
	}



	/**
	 * @param command 
	 * 
	 */
	public Move(String command)
	{
		this.notation = command;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return this.notation;
	}

	/**
	 * @return the position
	 */
	public PiecePosition getPosition()
	{
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(PiecePosition position)
	{
		this.position = position;
	}

	/**
	 * @return the notation
	 */
	public String getNotation()
	{
		return notation;
	}

	/**
	 * @param notation the notation to set
	 */
	public void setNotation(String notation)
	{
		this.notation = notation;
	}

	/**
	 * @return the startRow
	 */
	public int getStartRow()
	{
		return position.getRow();
	}

	/**
	 * @param startRow the startRow to set
	 */
	public void setStartRow(int startRow)
	{
		position.setRow(startRow);
	}

	/**
	 * @return the startcol
	 */
	public int getStartcol()
	{
		return position.getCol();
	}

	/**
	 * @param startcol the startcol to set
	 */
	public void setStartcol(int startcol)
	{
		position.setCol(startcol);
	}

	/**
	 * @return the endRow
	 */
	public int getEndRow()
	{
		return endRow;
	}

	/**
	 * @param endRow the endRow to set
	 */
	public void setEndRow(int endRow)
	{
		this.endRow = endRow;
	}

	/**
	 * @return the endCol
	 */
	public int getEndCol()
	{
		return endCol;
	}

	/**
	 * @param endCol the endCol to set
	 */
	public void setEndCol(int endCol)
	{
		this.endCol = endCol;
	}

	/**
	 * @return the isCaputre
	 */
	public boolean isCapture()
	{
		return isCapture;
	}

	/**
	 * @param isCapture the isCaputre to set
	 */
	public void setCapture(boolean isCapture)
	{
		this.isCapture = isCapture;
	}

	/**
	 * @return the type
	 */
	public PieceType getType()
	{
		return position.getType();
	}

	/**
	 * @param type the type to set
	 */
	public void setType(PieceType type)
	{
		position.setType(type);
	}

	/**
	 * @return the valid
	 */
	public boolean isValid()
	{
		return valid;
	}

	/**
	 * @param valid the valid to set
	 */
	public void setValid(boolean valid)
	{
		this.valid = valid;
	}
	
	
	
}
