/**
 * 
 */
package jkb.chess.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A node in a tree of nodes representing
 * possible moves.
 * 
 * @author joeykblack
 *
 */
public class MoveNode
{
	
	private MoveNode parent;
	private Move move;
	private List<MoveNode> children = new ArrayList<MoveNode>();
	private int value = Integer.MIN_VALUE;
	
	/**
	 * 
	 */
	public MoveNode()
	{
		super();
	}

	/**
	 * @return the parent
	 */
	public MoveNode getParent()
	{
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(MoveNode parent)
	{
		this.parent = parent;
	}

	/**
	 * @return the children
	 */
	public List<MoveNode> getChildren()
	{
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(List<MoveNode> children)
	{
		this.children = children;
	}

	/**
	 * @return the value
	 */
	public int getValue()
	{
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value)
	{
		this.value = value;
	}

	/**
	 * @param e
	 * @return
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean addChildMove(MoveNode e)
	{
		return children.add(e);
	}

	/**
	 * @param index
	 * @return
	 * @see java.util.List#get(int)
	 */
	public MoveNode getChildMove(int index)
	{
		return children.get(index);
	}

	public Move getMove() {
		return move;
	}

	public void setMove(Move move) {
		this.move = move;
	}
	
	

}
