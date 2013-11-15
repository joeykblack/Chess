/**
 * 
 */
package jkb.chess.model;

import java.util.ArrayList;
import java.util.List;

import jkb.chess.helper.BitUtil;
import jkb.chess.helper.Mover;
import jkb.chess.helper.Validator;

/**
 * 12 but boards are used to represent the 12
 * different types of pieces and their positions
 * 
 * @author joeykblack
 *
 */
public class BoardState 
{
	private PieceSet[] pieces ;
	
	private boolean gameOver;
	private boolean check;

	private String gameStateString;
	
	private List<PieceType> whiteCaptured = new ArrayList<PieceType>();
	private List<PieceType> blackCaptured = new ArrayList<PieceType>();
	
	/**
	 * Constructor
	 */
	protected BoardState()
	{
		pieces = new PieceSet[12];
	}

	/**
	 * Copy constructor
	 * 
	 * @param boardState
	 */
	public BoardState(BoardState boardState)
	{
		this.gameOver = boardState.isGameOver();
		this.check = boardState.isCheck();
		this.gameStateString = boardState.getGameStateString();
		this.whiteCaptured = new ArrayList<PieceType>(boardState.getWhiteCaptured());
		this.blackCaptured = new ArrayList<PieceType>(boardState.getBlackCaptured());
		pieces = new PieceSet[12];
		for (PieceType type : PieceType.values())
		{
			setPieceSet(new PieceSet(boardState.getPieceSet(type)));
		}
	}

	/**
	 * @return the isEndGame
	 */
	public boolean isGameOver()
	{
		return gameOver;
	}

	/**
	 * @param gameOver the isEndGame to set
	 */
	public void setGameOver(boolean gameOver)
	{
		this.gameOver = gameOver;
	}

	/**
	 * @return the gameResult
	 */
	public String getGameStateString()
	{
		return gameStateString;
	}

	/**
	 * @param gameResult the gameResult to set
	 */
	public void setGameStateString(String gameResult)
	{
		this.gameStateString = gameResult;
	}

	/**
	 * @return the pieces
	 */
	public PieceSet[] getPieces()
	{
		return pieces;
	}

	/**
	 * @param pieces the pieces to set
	 */
	public void setPieces(PieceSet[] pieces)
	{
		this.pieces = pieces;
	}

	/**
	 * @return the piece
	 */
	public PieceSet getPieceSet(PieceType type)
	{
		return pieces[type.getIndex()];
	}

	/**
	 * @param pieces the pieces to set
	 */
	public void setPieceSet(PieceSet piece)
	{
		int index = piece.getType().getIndex();
		this.pieces[index] = piece;
	}
	
	/**
	 * @return the check
	 */
	public boolean isCheck()
	{
		return check;
	}

	/**
	 * @param check the check to set
	 */
	public void setCheck(boolean check)
	{
		this.check = check;
	}
	
	
	
	
	/**
	 * @return the whiteCaptured
	 */
	public List<PieceType> getWhiteCaptured()
	{
		return whiteCaptured;
	}

	/**
	 * @param whiteCaptured the whiteCaptured to set
	 */
	public void setWhiteCaptured(List<PieceType> whiteCaptured)
	{
		this.whiteCaptured = whiteCaptured;
	}

	/**
	 * @return the blackCaptured
	 */
	public List<PieceType> getBlackCaptured()
	{
		return blackCaptured;
	}

	/**
	 * @param blackCaptured the blackCaptured to set
	 */
	public void setBlackCaptured(List<PieceType> blackCaptured)
	{
		this.blackCaptured = blackCaptured;
	}

	public void flipBoard()
	{
		for (PieceType type : PieceType.values()) {
			PieceSet set = getPieceSet(type);
			set.setBoard(BitUtil.verticalFlip(set.getBoard()));
			setPieceSet(set);
		}
	}
	
	
	
	public void rotate45()
	{
		for (PieceType type : PieceType.values()) {
			PieceSet set = getPieceSet(type);
			set.setBoard(BitUtil.xrotate45(set.getBoard()));
			setPieceSet(set);
		}
	}
	public void rotate315()
	{
		for (PieceType type : PieceType.values()) {
			PieceSet set = getPieceSet(type);
			set.setBoard(BitUtil.xrotate315(set.getBoard()));
			setPieceSet(set);
		}
	}
	
	public BitBoard getOccupied ()
	{
		BitBoard bb = new BitBoard();
		
		for (PieceType type : PieceType.values())
		{
			bb.setBoard(bb.getBoard() | getPieceSet(type).getBoard());
		}
		
		return bb;
	}
	
	public BitBoard getOccupied (boolean isWhite)
	{
		BitBoard bb = new BitBoard();
		
		for (PieceType type : PieceType.values())
		{
			if (type.isWhite() == isWhite)
			{
				bb.setBoard(bb.getBoard() | getPieceSet(type).getBoard());
			}
		}
		
		return bb;
	}
	
	

	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		for (int row = 7; row >= 0; row--)
		{
			sb.append((row+1) + " ");
			
			for (int col = 0; col < 8; col++)
			{
				boolean empty = true;
				types:
				for (PieceType type : PieceType.values())
				{
					PieceSet pieceSet = getPieceSet(type);
					boolean occupied = pieceSet.getBit(row, col);
					if (occupied)
					{
						sb.append(type.getPieceSymbol() + " ");
						empty = false;
						break types;
					}
				}
				if (empty)
				{
					sb.append("|_ ");
				}
			}
			
			sb.append('\n');
		}
		sb.append("   a  b  c  d  e  f  g  h\n");
		sb.append("White Captured: ");
		for (PieceType type : whiteCaptured)
		{
			sb.append(type.getPieceSymbol() + " ");
		}
		sb.append("\n");
		sb.append("Black Captured: ");
		for (PieceType type : blackCaptured)
		{
			sb.append(type.getPieceSymbol() + " ");
		}
		sb.append("\n");
		
		return sb.toString();
	}
	

	public String toString2()
	{
		StringBuilder sb = new StringBuilder();
		String b = String.valueOf((char)177);
		
		sb.append("  |");
		for (int col = 0; col < 8; col++) {
			sb.append("----|");
		}
		sb.append('\n');
		
		for (int row = 7; row >= 0; row--)
		{
			sb.append((row+1) + " |");
			
			for (int col = 0; col < 8; col++)
			{
				String borw = (((col-row+8)%2)==0) ? b : " ";
				boolean empty = true;
				types:
				for (PieceType type : PieceType.values())
				{
					PieceSet pieceSet = getPieceSet(type);
					boolean occupied = pieceSet.getBit(row, col);
					if (occupied)
					{
						sb.append(borw + type.getPieceSymbol() + borw + "|");
						empty = false;
						break types;
					}
				}
				if (empty)
				{
					sb.append(borw+borw+borw+borw+"|");
				}
			}
			sb.append('\n');

			sb.append("  |");
			for (int col = 0; col < 8; col++)
			{
				sb.append("----|");
			}
			sb.append('\n');
		}
		sb.append("    a    b    c    d    e    f    g    h\n");
		sb.append("White Captured: ");
		for (PieceType type : whiteCaptured)
		{
			sb.append(type.getPieceSymbol() + " ");
		}
		sb.append("\n");
		sb.append("Black Captured: ");
		for (PieceType type : blackCaptured)
		{
			sb.append(type.getPieceSymbol() + " ");
		}
		sb.append("\n");
		
		return sb.toString();
	}
	
	
	

	public boolean doMove(Move move, boolean doValidate, boolean doUpdate) 
	{
		boolean valid = (doValidate) ? Validator.validateMove(this, move) : true;

		if (valid)
		{
			capture(move);
			Mover.doMove(this, move);
			if (doUpdate)
			{
				updateState(move.getPosition().getType().isWhite());
			}
		}
		
		return valid;
	}

	public PieceType doMoveReturnCapture(Move move, boolean doValidate, boolean doUpdate) 
	{
		boolean valid = (doValidate) ? Validator.validateMove(this, move) : true;
		PieceType type = null;

		if (valid)
		{
			type = capture(move);
			Mover.doMove(this, move);
			if (doUpdate)
			{
				updateState(move.getPosition().getType().isWhite());
			}
		}
		
		return type;
	}

	/**
	 * Update isCheck and gameOver for other color
	 * 
	 * @param isWhite 
	 * 
	 */
	private void updateState(boolean isWhite)
	{
		if (Validator.isCheck(this, !isWhite))
		{
			gameStateString = ((!isWhite) ? "White" : "Black") + " is in check";
			check = true;
			if (Validator.isCheckmate(this, !isWhite))
			{
				gameStateString = ((!isWhite) ? "White" : "Black") + " is in check mate";
				gameOver = true;
			}
		}
		else
		{
			check = false;
		}
	}

	/**
	 * Capture any pieces at end location
	 * Assume move is valid
	 * 
	 * @param move
	 * @return 
	 */
	public PieceType capture(Move move)
	{
		PieceType captType = null;
		for (PieceType type : PieceType.values())
		{
			PieceSet set = getPieceSet(type);
			if (set.getBit(move.getEndRow(), move.getEndCol()))
			{
				if (type.isWhite())
				{
					whiteCaptured.add(type);
				}
				else
				{
					blackCaptured.add(type);
				}

				captType = type;
				set.setBit(move.getEndRow(), move.getEndCol(), false);
				setPieceSet(set);
				break;
			}
		}
		return captType;
	}
	
}
