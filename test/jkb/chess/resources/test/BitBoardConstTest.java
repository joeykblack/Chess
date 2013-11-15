/**
 * 
 */
package jkb.chess.resources.test;

import static org.junit.Assert.assertNotNull;
import jkb.chess.model.BitBoard;
import jkb.chess.resources.BitBoardConst;

import org.junit.Before;
import org.junit.Test;

/**
 * @author joeykblack
 *
 */
public class BitBoardConstTest
{
	
	BitBoard bb;
	
	@Before
	public void setUp ()
	{
		bb = new BitBoard();
	}
	
	@Test
	public void testRow ()
	{
		bb.setBoard(BitBoardConst.RANK_1);
		bb.setBoard(BitBoardConst.RANK_2);
		bb.setBoard(BitBoardConst.RANK_7);
		bb.setBoard(BitBoardConst.RANK_8);
		assertNotNull(bb);
	}
	
	@Test
	public void testFile ()
	{
		bb.setBoard(BitBoardConst.FILE_A);
		bb.setBoard(BitBoardConst.FILE_B);
		bb.setBoard(BitBoardConst.FILE_G);
		bb.setBoard(BitBoardConst.FILE_H);
		assertNotNull(bb);
	}

}
