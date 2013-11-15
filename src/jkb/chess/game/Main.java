/**
 * 
 */
package jkb.chess.game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;

import jkb.chess.ai.agent.ChessAgent;
import jkb.chess.factory.BoardFactory;
import jkb.chess.helper.Converter;
import jkb.chess.model.BoardState;
import jkb.chess.model.Move;
import jkb.chess.out.Out;

/**
 * @author joeykblack
 *
 */
public class Main 
{
	
	private static Collection<String> exit = Arrays.asList("exit", "quit", "q");

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean play = true;
		String command;
		BoardState boardState = BoardFactory.newGame();
		ChessAgent ai = new ChessAgent(false);
//		ChessAgent ai0 = new ChessAgent(true);
		
		Out.println("Min-max Chess");
		Out.println("Joey K. Black");
		Out.println();
		Out.println("Move example: pd2-d3");
		Out.println(" will move white's pawn at d2 to d3.");
		Out.println("Move example: pd4xc5");
		Out.println(" will move white's pawn at d2 to capture");
		Out.println(" black's piece at c5.");
		Out.println("p=pawn, r=rook, n=night, q=queen, k=king");

		try
		{
		
			exit:
			while (play)
			{
				// Print board
				Out.println();
				Out.println(boardState.toString());
				
				// Human move
				Move humanMove = null;
				boolean valid = false;
				do
				{
					// get move
					Out.print("Your move: ");
					command = br.readLine();
					if (testExit(command)) break exit;
					humanMove = Converter.notationToMove(command);
					
//					humanMove = ai0.play(boardState);
//					command = Converter.moveToNotation(humanMove);
//					Out.println("Your move: " + command);
					
					// move if valid
					valid = boardState.doMove(humanMove, true, true);
					if (!valid)
					{
						Out.println(command + " is not a valid move");
					}
					
				} while (!valid);

				// Print board
				Out.println();
				Out.println(boardState.toString());
				
				// is game over
				if (boardState.isGameOver()) break;
				if (boardState.isCheck())
				{
					Out.println();
					Out.println(boardState.getGameStateString());
				}
				
				// AI move
				Move aiMove = ai.play(boardState);
				boardState.doMove(aiMove, false, true);
				Out.println();
				Out.println("Computer move: " + Converter.moveToNotation(aiMove));
				
				// is game over
				if (boardState.isGameOver()) break;
				if (boardState.isCheck())
				{
					Out.println();
					Out.println(boardState.getGameStateString());
				}
				
			}

			// Print board
			Out.println();
			Out.println(boardState.toString());
			// print reuslts
			Out.println();
			Out.println("Game results:");
			Out.println(boardState.getGameStateString());
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		Out.println();
		Out.println("Exiting");
	} // end main

	/**
	 * @param command
	 * @return
	 */
	private static boolean testExit(String command)
	{
		return exit.contains(command);
	}

} // end Main class
