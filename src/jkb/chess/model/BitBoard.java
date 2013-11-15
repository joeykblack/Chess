/**
 * 
 */
package jkb.chess.model;

/**
 * This is the basic structure used to represent positions
 * on the board. It basically is just wrapping a long primitive.
 * 
 * The binary representation of a long looks something like:
 * 19 in binary is 000...0001011
 * The long contains a total of 64 bits (1 or 0)
 * A chess board contains a total of 64 squares (8 x 8)
 * 
 * So, a bit board is a long that is used to represent a chess
 * board. Each bit represents a square being occupied (1) or
 * empty (0). You have 12 diffent types of pieces in chess
 * (white pawn, black pawn, white knight...) so with 12 different
 * bit boards you can represent all of the pieces in the game.
 * 
 * The bits are mapped to the board as follows:
 * Bits:   0  0  0  0  0  0  0  0  ... 0  0  0  0  0  0  0  0 
 * Squres: h8 g8 f8 e8 d8 c8 b8 a8 ... h1 g1 f1 e1 d1 c1 b1 a1
 * 
 * The lowest bit is the bottom left and the highest bit is the top
 * right. Every 8 bits represents one row. 
 * 
 * @author joeykblack
 *
 */
public class BitBoard 
{
	
	private long board;
	
	/**
	 * Constructor
	 */
	public BitBoard()
	{
		board = 0l;
	}
	
	/**
	 * @param board2
	 */
	public BitBoard(long board)
	{
		this.board = board;
	}

	/**
	 * @param pieceSet
	 */
	public BitBoard(BitBoard bb)
	{
		this.board = bb.getBoard();
	}

	/**
	 * @param row: 0-7
	 * @param col: 0-7
	 * @return board[row][col]
	 */
	public boolean getBit (int row, int col)
	{
		return (board & (1l << ((row*8)+col))) != 0;
	}
	
	/**
	 * Sets board[row][col] = true
	 * @param row: 0-7
	 * @param col: 0-7
	 */
	public void on (int row, int col)
	{
		board |= (1l << ((row*8)+col));
	}
	
	/**
	 * Sets board[row][col] = false
	 * @param row: 0-7
	 * @param col: 0-7
	 */
	public void off (int row, int col)
	{
		board &= ~(1l << ((row*8)+col));
	}
	
	/**
	 * Sets board[row][col] = true
	 * @param row: 0-7
	 * @param col: 0-7
	 */
	public void setBit (int row, int col, boolean value)
	{
		if (value) {
			on(row, col);
		}
		else {
			off(row, col);
		}
	}

	/**
	 * @return the board
	 */
	public long getBoard()
	{
		return board;
	}

	/**
	 * @param board the board to set
	 */
	public void setBoard(long board)
	{
		this.board = board;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		String s = "";
		for (int row = 7; row >= 0; row--)
		{
			s += (row+1) + " ";
			for (int col = 0; col < 8; col++)
			{
				s += (getBit(row, col)) ? " X " : "|_ ";
			}
			s += '\n';
		}
		s += "   a  b  c  d  e  f  g  h";
		return s;
	}
}
