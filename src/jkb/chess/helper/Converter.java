/**
 * 
 */
package jkb.chess.helper;

import jkb.chess.model.Move;
import jkb.chess.model.PieceType;

/**
 * Some conversion utilities
 * 
 * @author joeykblack
 *
 */
public class Converter
{
	
	public static Move notationToMove (String notation)
	{
		Move move = new Move(notation);
		
		if (notation.length()!=6)
		{
			move.setValid(false);
		}
		else
		{
			notation = notation.toLowerCase();
			char type = notation.charAt(0);
			char startCol = notation.charAt(1);
			char startRow = notation.charAt(2);
			boolean isCapture = (notation.charAt(3)=='x');
			char endCol = notation.charAt(4);
			char endRow = notation.charAt(5);
			
			move.setType(charToType(type));
			move.setCapture(isCapture);
			move.setStartcol(startCol-97);
			move.setStartRow(startRow-48-1);
			move.setEndCol(endCol-97);
			move.setEndRow(endRow-48-1);
			move.setValid(true);
		}
		
		return move;
	}
	
	public static String moveToNotation (Move move)
	{
		String notation = "";
		
		notation += typeToChar(move.getType()); 
		notation += (char)(move.getStartcol()+97);
		notation += (move.getStartRow()+1);
		notation += (move.isCapture()) ? 'x' : '-';
		notation += (char)(move.getEndCol()+97);
		notation += (move.getEndRow()+1);
		
		return notation;
	}
	
	public static PieceType charToType (char c)
	{
		PieceType type;
		
		switch (c)
		{
		case 'p':
			type = PieceType.WHITE_PAWN;
			break;
		case 'n':
			type = PieceType.WHITE_NIGHT;
			break;
		case 'b':
			type = PieceType.WHITE_BISHOP;
			break;
		case 'r':
			type = PieceType.WHITE_ROOK;
			break;
		case 'q':
			type = PieceType.WHITE_QUEEN;
			break;
		case 'k':
			type = PieceType.WHITE_KING;
			break;
		default:
			type = null;
		}
		
		return type;
	}
	
	public static char typeToChar (PieceType type)
	{
		return type.getPieceSymbol().toLowerCase().charAt(1);
	}

}
