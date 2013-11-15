/**
 * 
 */
package jkb.chess.model;

/**
 * This represent all the locations a piece at a certain
 * position can move to. The position is represented by
 * a PiecePosition and the destinations are represented
 * by the BitBoard (parent class)
 * 
 * @author joeykblack
 *
 */
public class MoveMap extends BitBoard
{
	
	private PiecePosition position;
	
	/**
	 * 
	 */
	public MoveMap()
	{
		super();
	}

	/**
	 * @param board
	 */
	public MoveMap(long board)
	{
		super(board);
	}
	
	/**
	 * @param position
	 */
	public MoveMap(PiecePosition position)
	{
		super();
		this.position = position;
	}
	
	/**
	 * @param board
	 */
	public MoveMap(PiecePosition position, long board)
	{
		super(board);
		this.position = position;
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
	
	

}
