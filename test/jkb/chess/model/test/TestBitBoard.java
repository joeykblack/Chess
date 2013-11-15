/**
 * 
 */
package jkb.chess.model.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import jkb.chess.model.BitBoard;

import org.junit.Before;
import org.junit.Test;

/**
 * @author joeykblack
 *
 */
public class TestBitBoard
{
	private BitBoard bb;
	
	@Before
	public void setUp ()
	{
		bb = new BitBoard();
	}
	
	@Test
	public void testGetBit ()
	{
		bb.setBoard(1l << 9);
		assertTrue(bb.getBit(1, 1));
		assertTrue(!bb.getBit(1, 2));
	}
	
	@Test
	public void testOn ()
	{
		bb.on(1, 1);
		assertEquals(1l << 9, bb.getBoard());	
	}
	
	@Test
	public void testOff ()
	{
		bb.setBoard(-1l);
		bb.off(1, 1);
		
		long expected = ~(1l << 9);
		assertEquals(expected, bb.getBoard());	
	}

}
