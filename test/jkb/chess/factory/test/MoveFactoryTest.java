/**
 * 
 */
package jkb.chess.factory.test;

import java.util.List;

import jkb.chess.factory.BoardFactory;
import jkb.chess.factory.MoveFactory;
import jkb.chess.helper.Validator;
import jkb.chess.model.BoardState;
import jkb.chess.model.Move;

import org.junit.Before;
import org.junit.Test;

/**
 * @author joeykblack
 *
 */
public class MoveFactoryTest
{

	BoardState bs;
	
	@Before
	public void setUp ()
	{
		bs = BoardFactory.newGame();
	}
	
	@Test
	public void testSpeedOneDeep()
	{
		MoveFactory.findAllMoves(bs, true);
	}
	
	@Test
	public void testSpeedTwoDeep()
	{
		List<Move> moves = MoveFactory.findAllMoves(bs, true);
		recursiveMoveGenerator(bs, moves, true, 1);
	}
	
	@Test
	public void testSpeedThreeDeep()
	{
		List<Move> moves = MoveFactory.findAllMoves(bs, true);
		recursiveMoveGenerator(bs, moves, true, 2);
	}
	
	@Test
	public void testSpeedFourDeep()
	{
		List<Move> moves = MoveFactory.findAllMoves(bs, true);
		recursiveMoveGenerator(bs, moves, true, 3);
	}
	
	@Test
	public void testSpeedFiveDeep()
	{
		List<Move> moves = MoveFactory.findAllMoves(bs, true);
		recursiveMoveGenerator(bs, moves, true, 4);
	}
	
//	@Test
//	public void testSpeedSixDeep()
//	{
//		List<Move> moves = MoveFactory.findAllMoves(bs, true);
//		recursiveMoveGenerator(bs, moves, true, 5);
//	}
	
	private void recursiveMoveGenerator(BoardState bs, List<Move> moves, boolean isWhite, int level)
	{
		if (level>0)
		{
			int limit = moves.size(); //(moves.size()>=8) ? 8 : moves.size();
			for (int i=0; i<limit; i++)
			{
				Move move = moves.get(i);
				if (!Validator.movingIntoCheck(bs, move))
				{
					BoardState tempState = new BoardState(bs);
					tempState.doMove(move, false, true);
					List<Move> movesNextLevel = MoveFactory.findAllMoves(tempState, !isWhite);
					recursiveMoveGenerator(tempState, movesNextLevel, !isWhite, level-1);
				}
			}
		}
	}
}
