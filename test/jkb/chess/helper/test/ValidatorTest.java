/**
 * 
 */
package jkb.chess.helper.test;

import static org.junit.Assert.*;
import jkb.chess.factory.BoardFactory;
import jkb.chess.helper.Validator;
import jkb.chess.model.BoardState;
import jkb.chess.model.Move;
import jkb.chess.model.PieceType;

import org.junit.Before;
import org.junit.Test;

/**
 * @author joeykblack
 *
 */
public class ValidatorTest
{

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
	}

	/**
	 * Test method for {@link jkb.chess.helper.Validator#validateMove(jkb.chess.model.BoardState, jkb.chess.model.Move)}.
	 */
	@Test
	public void testValidateMove()
	{
		Move move = new Move(PieceType.WHITE_PAWN, 1, 0, 2, 0);
		assertTrue(!Validator.validateMove(getWhiteInCheckmate(), move));
		
		move = new Move(PieceType.WHITE_KING, 0, 4, 1, 5);
		assertTrue(!Validator.validateMove(getWhiteInCheck(), move));
	}

	/**
	 * Test method for {@link jkb.chess.helper.Validator#movingIntoCheck(jkb.chess.model.BoardState, jkb.chess.model.Move)}.
	 */
	@Test
	public void testMovingIntoCheck()
	{
		Move move = new Move(PieceType.WHITE_PAWN, 1, 0, 2, 0);
		assertTrue(Validator.movingIntoCheck(getWhiteInCheckmate(), move));
	}

	/**
	 * Test method for {@link jkb.chess.helper.Validator#isCheck(jkb.chess.model.BoardState, boolean)}.
	 */
	@Test
	public void testIsCheck()
	{
		assertTrue(Validator.isCheck(getWhiteInCheck(), true));
		assertTrue(Validator.isCheck(getWhiteInCheckmate(), true));
	}

	/**
	 * Test method for {@link jkb.chess.helper.Validator#isCheckmate(jkb.chess.model.BoardState, boolean)}.
	 */
	@Test
	public void testIsCheckmate()
	{
		assertTrue(!Validator.isCheckmate(getWhiteInCheck(), true));
		assertTrue(Validator.isCheckmate(getWhiteInCheckmate(), true));
	}
	
	
	private BoardState getWhiteInCheck ()
	{
		BoardState bs = BoardFactory.newGame();

		Move bq = new Move(PieceType.BLACK_QUEEN, 7, 3, 1, 5);
		bs.doMove(bq, false, false);
		
		return bs;
	}
	
	private BoardState getWhiteInCheckmate()
	{
		BoardState bs = BoardFactory.newGame();
		
		Move bq = new Move(PieceType.BLACK_QUEEN, 7, 3, 1, 5);
		bs.doMove(bq, false, false);
		Move br = new Move(PieceType.BLACK_ROOK, 7, 0, 3, 5);
		bs.doMove(br, false, false);
		
		return bs;
	}

}
