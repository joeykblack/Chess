/**
 * 
 */
package jkb.chess.helper.test;

import static org.junit.Assert.assertEquals;
import jkb.chess.helper.BitUtil;
import jkb.chess.model.BitBoard;
import jkb.chess.resources.BitBoardConst;

import org.junit.Before;
import org.junit.Test;

/**
 * @author joeykblack
 *
 */
public class TestBitUtil
{
	
	BitBoard bb;
	
	@Before
	public void setUp ()
	{
		bb = new BitBoard();
	}
	
	@Test
	public void testVerticalFlip ()
	{
		bb.setBoard(BitBoardConst.RANK_1);
		bb.setBoard(BitUtil.verticalFlip(bb.getBoard()));
		assertEquals(BitBoardConst.RANK_8, bb.getBoard());

		bb.setBoard(BitBoardConst.RANK_2);
		bb.setBoard(BitUtil.verticalFlip(bb.getBoard()));
		assertEquals(BitBoardConst.RANK_7, bb.getBoard());

		bb.setBoard(BitBoardConst.RANK_3);
		bb.setBoard(BitUtil.verticalFlip(bb.getBoard()));
		assertEquals(BitBoardConst.RANK_6, bb.getBoard());

		bb.setBoard(BitBoardConst.RANK_4);
		bb.setBoard(BitUtil.verticalFlip(bb.getBoard()));
		assertEquals(BitBoardConst.RANK_5, bb.getBoard());

		bb.setBoard(BitBoardConst.RANK_5);
		bb.setBoard(BitUtil.verticalFlip(bb.getBoard()));
		assertEquals(BitBoardConst.RANK_4, bb.getBoard());

		bb.setBoard(BitBoardConst.RANK_6);
		bb.setBoard(BitUtil.verticalFlip(bb.getBoard()));
		assertEquals(BitBoardConst.RANK_3, bb.getBoard());

		bb.setBoard(BitBoardConst.RANK_7);
		bb.setBoard(BitUtil.verticalFlip(bb.getBoard()));
		assertEquals(BitBoardConst.RANK_2, bb.getBoard());

		bb.setBoard(BitBoardConst.RANK_8);
		bb.setBoard(BitUtil.verticalFlip(bb.getBoard()));
		assertEquals(BitBoardConst.RANK_1, bb.getBoard());
	}

	@Test
	public void testRotate270 ()
	{
		bb.setBoard(BitBoardConst.RANK_1);
		bb.setBoard(BitUtil.rotate270(bb.getBoard()));
		assertEquals(BitBoardConst.FILE_H, bb.getBoard());
		
		bb.setBoard(BitBoardConst.RANK_2);
		bb.setBoard(BitUtil.rotate270(bb.getBoard()));
		assertEquals(BitBoardConst.FILE_G, bb.getBoard());
		
		bb.setBoard(BitBoardConst.RANK_3);
		bb.setBoard(BitUtil.rotate270(bb.getBoard()));
		assertEquals(BitBoardConst.FILE_F, bb.getBoard());
		
		bb.setBoard(BitBoardConst.RANK_4);
		bb.setBoard(BitUtil.rotate270(bb.getBoard()));
		assertEquals(BitBoardConst.FILE_E, bb.getBoard());
		
		bb.setBoard(BitBoardConst.RANK_5);
		bb.setBoard(BitUtil.rotate270(bb.getBoard()));
		assertEquals(BitBoardConst.FILE_D, bb.getBoard());
		
		bb.setBoard(BitBoardConst.RANK_6);
		bb.setBoard(BitUtil.rotate270(bb.getBoard()));
		assertEquals(BitBoardConst.FILE_C, bb.getBoard());
		
		bb.setBoard(BitBoardConst.RANK_7);
		bb.setBoard(BitUtil.rotate270(bb.getBoard()));
		assertEquals(BitBoardConst.FILE_B, bb.getBoard());
		
		bb.setBoard(BitBoardConst.RANK_8);
		bb.setBoard(BitUtil.rotate270(bb.getBoard()));
		assertEquals(BitBoardConst.FILE_A, bb.getBoard());
	}

	@Test
	public void testRotate90 ()
	{
		bb.setBoard(BitBoardConst.RANK_1);
		bb.setBoard(BitUtil.rotate90(bb.getBoard()));
		assertEquals(BitBoardConst.FILE_A, bb.getBoard());
		
		bb.setBoard(BitBoardConst.RANK_2);
		bb.setBoard(BitUtil.rotate90(bb.getBoard()));
		assertEquals(BitBoardConst.FILE_B, bb.getBoard());
		
		bb.setBoard(BitBoardConst.RANK_3);
		bb.setBoard(BitUtil.rotate90(bb.getBoard()));
		assertEquals(BitBoardConst.FILE_C, bb.getBoard());
		
		bb.setBoard(BitBoardConst.RANK_4);
		bb.setBoard(BitUtil.rotate90(bb.getBoard()));
		assertEquals(BitBoardConst.FILE_D, bb.getBoard());
		
		bb.setBoard(BitBoardConst.RANK_5);
		bb.setBoard(BitUtil.rotate90(bb.getBoard()));
		assertEquals(BitBoardConst.FILE_E, bb.getBoard());
		
		bb.setBoard(BitBoardConst.RANK_6);
		bb.setBoard(BitUtil.rotate90(bb.getBoard()));
		assertEquals(BitBoardConst.FILE_F, bb.getBoard());
		
		bb.setBoard(BitBoardConst.RANK_7);
		bb.setBoard(BitUtil.rotate90(bb.getBoard()));
		assertEquals(BitBoardConst.FILE_G, bb.getBoard());
		
		bb.setBoard(BitBoardConst.RANK_8);
		bb.setBoard(BitUtil.rotate90(bb.getBoard()));
		assertEquals(BitBoardConst.FILE_H, bb.getBoard());
	}

}
