/**
 * 
 */
package jkb.chess.factory.test;

import static org.junit.Assert.assertEquals;
import jkb.chess.factory.BoardFactory;
import jkb.chess.factory.PieceMoveFactory;
import jkb.chess.helper.Converter;
import jkb.chess.helper.Mover;
import jkb.chess.model.BitBoard;
import jkb.chess.model.BoardState;
import jkb.chess.model.Move;
import jkb.chess.model.PieceType;
import jkb.chess.resources.BitBoardConst;

import org.junit.Before;
import org.junit.Test;

/**
 * @author joeykblack
 *
 */
public class PieceMoveFactoryTest 
{
	
	BitBoard bb;
	
	@Before
	public void setUp ()
	{
		bb = new BitBoard();
	}
	
	@Test
	public void testMovePawn1 ()
	{
		long move1 = BitBoardConst.make(	 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "1 0 0 0 0 0 0 0",
											 "1 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0");
		bb.setBit(1, 0, true);
		bb = PieceMoveFactory.movePawn(bb);
		assertEquals(move1, bb.getBoard());
	}
	
	@Test
	public void testMovePawn2 ()
	{
		long move2 = BitBoardConst.make(	 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 1 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0");
		bb.setBit(3, 1, true);
		bb = PieceMoveFactory.movePawn(bb);
		assertEquals(move2, bb.getBoard());
	}
	
	@Test
	public void testMoveNightCenter ()
	{
		long move1 = BitBoardConst.make(	 "0 1 0 1 0 0 0 0",
											 "1 0 0 0 1 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "1 0 0 0 1 0 0 0",
											 "0 1 0 1 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0");
		bb.setBit(5, 2, true);
		bb = PieceMoveFactory.moveNight(bb);
		assertEquals(move1, bb.getBoard());
	}
	
	@Test
	public void testMoveNightLeft1 ()
	{
		long move1 = BitBoardConst.make(	 "1 0 1 0 0 0 0 0",
											 "0 0 0 1 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 1 0 0 0 0",
											 "1 0 1 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0");
		bb.setBit(5, 1, true);
		bb = PieceMoveFactory.moveNight(bb);
		assertEquals(move1, bb.getBoard());
	}
	
	@Test
	public void testMoveNightLeft2 ()
	{
		long move1 = BitBoardConst.make(	 "0 1 0 0 0 0 0 0",
											 "0 0 1 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 1 0 0 0 0 0",
											 "0 1 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0");
		bb.setBit(5, 0, true);
		bb = PieceMoveFactory.moveNight(bb);
		assertEquals(move1, bb.getBoard());
	}
	
	@Test
	public void testMoveNightRight1 ()
	{
		long move1 = BitBoardConst.make(	 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 1 0 1",
											 "0 0 0 0 1 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 1 0 0 0",
											 "0 0 0 0 0 1 0 1");
		bb.setBit(2, 6, true);
		bb = PieceMoveFactory.moveNight(bb);
		assertEquals(move1, bb.getBoard());
	}
	
	@Test
	public void testMoveNightRight2 ()
	{
		long move1 = BitBoardConst.make(	 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 1 0",
											 "0 0 0 0 0 1 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 1 0 0",
											 "0 0 0 0 0 0 1 0");
		bb.setBit(2, 7, true);
		bb = PieceMoveFactory.moveNight(bb);
		assertEquals(move1, bb.getBoard());
	}
	
	@Test
	public void testMoveKing ()
	{
		long move1 = BitBoardConst.make(	 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "1 1 1 0 0 0 0 0",
											 "1 0 1 0 0 0 0 0",
											 "1 1 1 0 0 0 0 0");
		bb.setBit(1, 1, true);
		bb = PieceMoveFactory.moveKing(bb);
		assertEquals(move1, bb.getBoard());
	}
	
	@Test
	public void testMoveKingLeft ()
	{
		long move1 = BitBoardConst.make(	 "1 1 0 0 0 0 0 0",
											 "0 1 0 0 0 0 0 0",
											 "1 1 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0");
		bb.setBit(6, 0, true);
		bb = PieceMoveFactory.moveKing(bb);
		assertEquals(move1, bb.getBoard());
	}
	
	@Test
	public void testMoveKingRight ()
	{
		long move1 = BitBoardConst.make(	 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 1 1",
											 "0 0 0 0 0 0 1 0",
											 "0 0 0 0 0 0 1 1");
		bb.setBit(1, 7, true);
		bb = PieceMoveFactory.moveKing(bb);
		assertEquals(move1, bb.getBoard());
	}
	
	@Test
	public void testMoveRook ()
	{
		long move1 = BitBoardConst.make(	 "0 1 0 0 0 0 0 0",
											 "0 1 0 0 0 0 0 0",
											 "0 1 0 0 0 0 0 0",
											 "0 1 0 0 0 0 0 0",
											 "0 1 0 0 0 0 0 0",
											 "0 1 0 0 0 0 0 0",
											 "1 0 1 1 1 1 1 1",
											 "0 1 0 0 0 0 0 0");
		BoardState bs = BoardFactory.emptyBoard();
		int row = 1;
		int col = 1;
		Move move = new Move();
		move.setStartRow(row);
		move.setStartcol(col);
		move.setType(PieceType.WHITE_ROOK);
		bb.setBit(row, col, true);
		bb = PieceMoveFactory.moveRook(bb, bs, move.getPosition());
		assertEquals(move1, bb.getBoard());
	}
	
	@Test
	public void testMoveRookNewGame ()
	{
		long move1 = BitBoardConst.make(	 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0");
		BoardState bs = BoardFactory.newGame();
		int row = 0;
		int col = 0;
		Move move = new Move();
		move.setStartRow(row);
		move.setStartcol(col);
		move.setType(PieceType.WHITE_ROOK);
		bb.setBit(row, col, true);
		bb = PieceMoveFactory.moveRook(bb, bs, move.getPosition());
		assertEquals(move1, bb.getBoard());
	}
	
	@Test
	public void testMoveRookBlocked ()
	{
		long move1 = BitBoardConst.make(	 "0 0 0 0 0 0 0 0",
											 "0 0 0 1 0 0 0 0",
											 "0 0 0 1 0 0 0 0",
											 "0 0 0 1 0 0 0 0",
											 "0 1 1 0 1 1 1 0",
											 "0 0 0 1 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0");
		BoardState bs = BoardFactory.newGame();
		Mover.doMove(bs, Converter.notationToMove("ra1-d4"));
		Mover.doMove(bs, Converter.notationToMove("pa2-a4"));
		Move blackMove = Converter.notationToMove("pg7-g4");
		blackMove.setType(PieceType.BLACK_PAWN);
		Mover.doMove(bs, blackMove);
		int row = 3;
		int col = 3;
		Move move = new Move();
		move.setStartRow(row);
		move.setStartcol(col);
		move.setType(PieceType.WHITE_ROOK);
		bb.setBit(row, col, true);
		bb = PieceMoveFactory.moveRook(bb, bs, move.getPosition());
		assertEquals(move1, bb.getBoard());
	}
	
	@Test
	public void testMoveBishop ()
	{
		long move1 = BitBoardConst.make(	 "0 0 0 0 0 0 0 1",
											 "0 0 0 0 0 0 1 0",
											 "0 0 0 0 0 1 0 0",
											 "0 0 0 0 1 0 0 0",
											 "0 0 0 1 0 0 0 0",
											 "1 0 1 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "1 0 1 0 0 0 0 0");
		BoardState bs = BoardFactory.emptyBoard();
		int row = 1;
		int col = 1;
		Move move = new Move();
		move.setStartRow(row);
		move.setStartcol(col);
		move.setType(PieceType.WHITE_BISHOP);
		bb.setBit(row, col, true);
		bb = PieceMoveFactory.moveBishop(bb, bs, move.getPosition());
		assertEquals(move1, bb.getBoard());
	}
	
	@Test
	public void testMoveBishopNewGame ()
	{
		long move1 = BitBoardConst.make(	 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0");
		BoardState bs = BoardFactory.newGame();
		int row = 0;
		int col = 2;
		Move move = new Move();
		move.setStartRow(row);
		move.setStartcol(col);
		move.setType(PieceType.WHITE_BISHOP);
		bb.setBit(row, col, true);
		bb = PieceMoveFactory.moveBishop(bb, bs, move.getPosition());
		assertEquals(move1, bb.getBoard());
	}
	
	@Test
	public void testMoveBishopBlocked ()
	{
		long move1 = BitBoardConst.make(	 "0 0 0 0 0 0 0 0",
											 "1 0 0 0 0 0 1 0",
											 "0 1 0 0 0 1 0 0",
											 "0 0 1 0 1 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 1 0 1 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0");
		BoardState bs = BoardFactory.newGame();
		Mover.doMove(bs, Converter.notationToMove("bc1-d4"));
		int row = 3;
		int col = 3;
		Move move = new Move();
		move.setStartRow(row);
		move.setStartcol(col);
		move.setType(PieceType.WHITE_BISHOP);
		bb.setBit(row, col, true);
		bb = PieceMoveFactory.moveBishop(bb, bs, move.getPosition());
		assertEquals(move1, bb.getBoard());
	}
	
	@Test
	public void testMoveQueen ()
	{
		long move1 = BitBoardConst.make(	 "0 1 0 0 0 0 0 1",
											 "0 1 0 0 0 0 1 0",
											 "0 1 0 0 0 1 0 0",
											 "0 1 0 0 1 0 0 0",
											 "0 1 0 1 0 0 0 0",
											 "1 1 1 0 0 0 0 0",
											 "1 0 1 1 1 1 1 1",
											 "1 1 1 0 0 0 0 0");
		BoardState bs = BoardFactory.emptyBoard();
		int row = 1;
		int col = 1;
		Move move = new Move();
		move.setStartRow(row);
		move.setStartcol(col);
		move.setType(PieceType.WHITE_QUEEN);
		bb.setBit(row, col, true);
		bb = PieceMoveFactory.moveQueen(bb, bs, move.getPosition());
		assertEquals(move1, bb.getBoard());
	}
	
	@Test
	public void testMoveQueenNewGame ()
	{
		long move1 = BitBoardConst.make(	 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0");
		BoardState bs = BoardFactory.newGame();
		int row = 0;
		int col = 2;
		Move move = new Move();
		move.setStartRow(row);
		move.setStartcol(col);
		move.setType(PieceType.WHITE_QUEEN);
		bb.setBit(row, col, true);
		bb = PieceMoveFactory.moveQueen(bb, bs, move.getPosition());
		assertEquals(move1, bb.getBoard());
	}
	
	@Test
	public void testMoveQueenBlocked ()
	{
		long move1 = BitBoardConst.make(	 "0 0 0 0 0 0 0 0",
											 "1 0 0 1 0 0 1 0",
											 "0 1 0 1 0 1 0 0",
											 "0 0 1 1 1 0 0 0",
											 "1 1 1 0 1 1 1 1",
											 "0 0 1 1 1 0 0 0",
											 "0 0 0 0 0 0 0 0",
											 "0 0 0 0 0 0 0 0");
		BoardState bs = BoardFactory.newGame();
		Mover.doMove(bs, Converter.notationToMove("bc1-d4"));
		int row = 3;
		int col = 3;
		Move move = new Move();
		move.setStartRow(row);
		move.setStartcol(col);
		move.setType(PieceType.WHITE_QUEEN);
		bb.setBit(row, col, true);
		bb = PieceMoveFactory.moveQueen(bb, bs, move.getPosition());
		assertEquals(move1, bb.getBoard());
	}

}
