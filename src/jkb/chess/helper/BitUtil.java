/**
 * 
 */
package jkb.chess.helper;

import jkb.chess.model.BitBoard;
import jkb.chess.resources.BitBoardConst;

/**
 * @author joeykblack
 *
 */
public class BitUtil
{
	
	/**
	 * Flips board. Very useful when performing opperations for black.
	 * Just flip board, do white opperations and flip back.
	 * 
	 * @param value
	 * @return flipped board
	 */
	public static long verticalFlip (long value)
	{
		return (BitBoardConst.RANK_8 & value) >>> 56 |
			   (BitBoardConst.RANK_7 & value) >>> 40 |
			   (BitBoardConst.RANK_6 & value) >>> 24 |
			   (BitBoardConst.RANK_5 & value) >>> 8 |
			   (BitBoardConst.RANK_4 & value) << 8 |
			   (BitBoardConst.RANK_3 & value) << 24 |
			   (BitBoardConst.RANK_2 & value) << 40 |
			   (BitBoardConst.RANK_1 & value) << 56;
	}
	
	
	
	
	/*
	 * The following are rotation operations. I did not end up
	 * using them, but have left them in for refference. 
	 */
	
	
	
	public static long rotate270 (long value)
	{
		return ((value &  1l      ) << 7 ) |
			   ((value & (1l << 1)) << 14) |
			   ((value & (1l << 2)) << 21) |
			   ((value & (1l << 3)) << 28) |
			   ((value & (1l << 4)) << 35) |
			   ((value & (1l << 5)) << 42) |
			   ((value & (1l << 6)) << 49) |
			   ((value & (1l << 7)) << 56) |
			   
			   ((value & (1l << 8 )) >>> 2 ) |
			   ((value & (1l << 9 )) << 5 ) |
			   ((value & (1l << 10)) << 12) |
			   ((value & (1l << 11)) << 19) |
			   ((value & (1l << 12)) << 26) |
			   ((value & (1l << 13)) << 33) |
			   ((value & (1l << 14)) << 40) |
			   ((value & (1l << 15)) << 47) |
			   
			   ((value & (1l << 16)) >>> 11) |
			   ((value & (1l << 17)) >>> 4 ) |
			   ((value & (1l << 18)) << 3 ) |
			   ((value & (1l << 19)) << 10) |
			   ((value & (1l << 20)) << 17) |
			   ((value & (1l << 21)) << 24) |
			   ((value & (1l << 22)) << 31) |
			   ((value & (1l << 23)) << 38) |
			   
			   ((value & (1l << 24)) >>> 20) |
			   ((value & (1l << 25)) >>> 13) |
			   ((value & (1l << 26)) >>> 6 ) |
			   ((value & (1l << 27)) << 1 ) |
			   ((value & (1l << 28)) << 8 ) |
			   ((value & (1l << 29)) << 15) |
			   ((value & (1l << 30)) << 22) |
			   ((value & (1l << 31)) << 29) |
			   
			   ((value & (1l << 32)) >>> 29) |
			   ((value & (1l << 33)) >>> 22) |
			   ((value & (1l << 34)) >>> 15) |
			   ((value & (1l << 35)) >>> 8 ) |
			   ((value & (1l << 36)) >>> 1 ) |
			   ((value & (1l << 37)) << 6 ) |
			   ((value & (1l << 38)) << 13) |
			   ((value & (1l << 39)) << 20) |
			   
			   ((value & (1l << 40)) >>> 38) |
			   ((value & (1l << 41)) >>> 31) |
			   ((value & (1l << 42)) >>> 24) |
			   ((value & (1l << 43)) >>> 17) |
			   ((value & (1l << 44)) >>> 10) |
			   ((value & (1l << 45)) >>> 3 ) |
			   ((value & (1l << 46)) << 4 ) |
			   ((value & (1l << 47)) << 11) |
			   
			   ((value & (1l << 48)) >>> 47) |
			   ((value & (1l << 49)) >>> 40) |
			   ((value & (1l << 50)) >>> 33) |
			   ((value & (1l << 51)) >>> 26) |
			   ((value & (1l << 52)) >>> 19) |
			   ((value & (1l << 53)) >>> 12) |
			   ((value & (1l << 54)) >>> 5 ) |
			   ((value & (1l << 55)) << 2 ) |
			   
			   ((value & (1l << 56)) >>> 56) |
			   ((value & (1l << 57)) >>> 49) |
			   ((value & (1l << 58)) >>> 42) |
			   ((value & (1l << 59)) >>> 35) |
			   ((value & (1l << 60)) >>> 28) |
			   ((value & (1l << 61)) >>> 21) |
			   ((value & (1l << 62)) >>> 14) |
			   ((value & (1l << 63)) >>> 7 );
	}
	
	public static long xrotate270 (long value)
	{
		   BitBoard bb = new BitBoard();
		   
		   bb.setBoard ((value & 1l) << 7 );
		   bb.setBoard( bb.getBoard() | ((value & (1l << 1)) << 14) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 2)) << 21) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 3)) << 28) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 4)) << 35) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 5)) << 42) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 6)) << 49) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 7)) << 56) );
		   
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 8 )) >>> 2 ) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 9 )) << 5 ) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 10)) << 12) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 11)) << 19) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 12)) << 26) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 13)) << 33) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 14)) << 40) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 15)) << 47) );
		   
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 16)) >>> 11) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 17)) >>> 4 ) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 18)) << 3 ) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 19)) << 10) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 20)) << 17) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 21)) << 24) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 22)) << 31) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 23)) << 38) );
		   
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 24)) >>> 20) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 25)) >>> 13) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 26)) >>> 6 ) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 27)) << 1 ) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 28)) << 8 ) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 29)) << 15) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 30)) << 22) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 31)) << 29) );
		   
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 32)) >>> 29) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 33)) >>> 22) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 34)) >>> 15) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 35)) >>> 8 ) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 36)) >>> 1 ) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 37)) << 6 ) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 38)) << 13) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 39)) << 20) );
		   
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 40)) >>> 38) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 41)) >>> 31) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 42)) >>> 24) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 43)) >>> 17) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 44)) >>> 10) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 45)) >>> 3 ) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 46)) << 4 ) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 47)) << 11) );
		   
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 48)) >>> 47) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 49)) >>> 40) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 50)) >>> 33) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 51)) >>> 26) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 52)) >>> 19) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 53)) >>> 12) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 54)) >>> 5 ) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 55)) << 2 ) );
		   
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 56)) >>> 56) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 57)) >>> 49) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 58)) >>> 42) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 59)) >>> 35) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 60)) >>> 28) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 61)) >>> 21) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 62)) >>> 14) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 63)) >>> 7 ) );
			   
		   return bb.getBoard();
	}
	
	public static long rotate90 (long value)
	{
		   return (value & 1l) << 56 |
		    ((value & (1l << 1)) << 47) |
		    ((value & (1l << 2)) << 38) |
		    ((value & (1l << 3)) << 29) |
		    ((value & (1l << 4)) << 20) |
		    ((value & (1l << 5)) << 11) |
		    ((value & (1l << 6)) << 2) |
		    ((value & (1l << 7)) >>> 7) |
		   
		    ((value & (1l << 8 )) << 49) |
		    ((value & (1l << 9 )) << 40 ) |
		    ((value & (1l << 10)) << 31) |
		    ((value & (1l << 11)) << 22) |
		    ((value & (1l << 12)) << 13) |
		    ((value & (1l << 13)) <<  4) |
		    ((value & (1l << 14)) >>>  5) |
		    ((value & (1l << 15)) >>> 14) |
		   
		    ((value & (1l << 16)) << 42) |
		    ((value & (1l << 17)) << 33) |
		    ((value & (1l << 18)) << 24) |
		    ((value & (1l << 19)) << 15) |
		    ((value & (1l << 20)) <<  6) |
		    ((value & (1l << 21)) >>>  3) |
		    ((value & (1l << 22)) >>> 12) |
		    ((value & (1l << 23)) >>> 21) |
		   
		    ((value & (1l << 24)) << 35) |
		    ((value & (1l << 25)) << 26) |
		    ((value & (1l << 26)) << 17) |
		    ((value & (1l << 27)) << 8 ) |
		    ((value & (1l << 28)) >>> 1) |
		    ((value & (1l << 29)) >>> 10) |
		    ((value & (1l << 30)) >>> 19) |
		    ((value & (1l << 31)) >>> 28) |
		   
		    ((value & (1l << 32)) << 28) |
		    ((value & (1l << 33)) << 19) |
		    ((value & (1l << 34)) << 10) |
		    ((value & (1l << 35)) << 1 ) |
		    ((value & (1l << 36)) >>> 8 ) |
		    ((value & (1l << 37)) >>> 17) |
		    ((value & (1l << 38)) >>> 26) |
		    ((value & (1l << 39)) >>> 35) |
		   
		    ((value & (1l << 40)) << 21) |
		    ((value & (1l << 41)) << 12) |
		    ((value & (1l << 42)) << 3 ) |
		    ((value & (1l << 43)) >>> 6 ) |
		    ((value & (1l << 44)) >>> 15) |
		    ((value & (1l << 45)) >>> 24) |
		    ((value & (1l << 46)) >>> 33) |
		    ((value & (1l << 47)) >>> 42) |
		   
		    ((value & (1l << 48)) << 14) |
		    ((value & (1l << 49)) << 5) |
		    ((value & (1l << 50)) >>> 4) |
		    ((value & (1l << 51)) >>> 13) |
		    ((value & (1l << 52)) >>> 22) |
		    ((value & (1l << 53)) >>> 31) |
		    ((value & (1l << 54)) >>> 40) |
		    ((value & (1l << 55)) >>> 49) |
		   
		    ((value & (1l << 56)) << 7) |
		    ((value & (1l << 57)) >>> 2) |
		    ((value & (1l << 58)) >>> 11) |
		    ((value & (1l << 59)) >>> 20) |
		    ((value & (1l << 60)) >>> 29) |
		    ((value & (1l << 61)) >>> 38) |
		    ((value & (1l << 62)) >>> 47) |
		    ((value & (1l << 63)) >>> 56);
	}
	
	public static long xrotate90 (long value)
	{
		   BitBoard valuebb = new BitBoard();
		   valuebb.setBoard(value);
		   BitBoard bb = new BitBoard();
		   
		   bb.setBoard ((value & 1l) << 56 );
		   bb.setBoard( bb.getBoard() | ((value & (1l << 1)) << 47) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 2)) << 38) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 3)) << 29) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 4)) << 20) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 5)) << 11) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 6)) << 2) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 7)) >>> 7) );
		   
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 8 )) << 49) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 9 )) << 40 ) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 10)) << 31) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 11)) << 22) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 12)) << 13) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 13)) <<  4) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 14)) >>>  5) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 15)) >>> 14) );
		   
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 16)) << 42) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 17)) << 33) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 18)) << 24) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 19)) << 15) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 20)) <<  6) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 21)) >>>  3) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 22)) >>> 12) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 23)) >>> 21) );
		   
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 24)) << 35) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 25)) << 26) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 26)) << 17) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 27)) << 8 ) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 28)) >>> 1) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 29)) >>> 10) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 30)) >>> 19) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 31)) >>> 28) );
		   
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 32)) << 28) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 33)) << 19) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 34)) << 10) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 35)) << 1 ) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 36)) >>> 8 ) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 37)) >>> 17) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 38)) >>> 26) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 39)) >>> 35) );
		   
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 40)) << 21) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 41)) << 12) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 42)) << 3 ) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 43)) >>> 6 ) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 44)) >>> 15) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 45)) >>> 24) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 46)) >>> 33) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 47)) >>> 42) );
		   
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 48)) << 14) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 49)) << 5) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 50)) >>> 4) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 51)) >>> 13) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 52)) >>> 22) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 53)) >>> 31) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 54)) >>> 40) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 55)) >>> 49) );
		   
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 56)) << 7) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 57)) >>> 2) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 58)) >>> 11) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 59)) >>> 20) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 60)) >>> 29) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 61)) >>> 38) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 62)) >>> 47) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 63)) >>> 56) );
			   
		   return bb.getBoard();
	}
	
	public static long rotate45 (long value)
	{
		   return (value & 1l) << 56 |
		    ((value & (1l << 1)) << 47) |
		    ((value & (1l << 2)) << 38) |
		    ((value & (1l << 3)) << 29) |
		    ((value & (1l << 4)) << 20) |
		    ((value & (1l << 5)) << 11) |
		    ((value & (1l << 6)) << 2) |
		    ((value & (1l << 7)) >>> 7) |
		   
		    ((value & (1l << 8 )) << 49) |
		    ((value & (1l << 9 )) << 40 ) |
		    ((value & (1l << 10)) << 31) |
		    ((value & (1l << 11)) << 22) |
		    ((value & (1l << 12)) << 13) |
		    ((value & (1l << 13)) <<  4) |
		    ((value & (1l << 14)) >>>  5) |
		    ((value & (1l << 15)) >>> 14) |
		   
		    ((value & (1l << 16)) << 42) |
		    ((value & (1l << 17)) << 33) |
		    ((value & (1l << 18)) << 24) |
		    ((value & (1l << 19)) << 15) |
		    ((value & (1l << 20)) <<  6) |
		    ((value & (1l << 21)) >>>  3) |
		    ((value & (1l << 22)) >>> 12) |
		    ((value & (1l << 23)) >>> 21) |
		   
		    ((value & (1l << 24)) << 35) |
		    ((value & (1l << 25)) << 26) |
		    ((value & (1l << 26)) << 17) |
		    ((value & (1l << 27)) << 8 ) |
		    ((value & (1l << 28)) >>> 1) |
		    ((value & (1l << 29)) >>> 10) |
		    ((value & (1l << 30)) >>> 19) |
		    ((value & (1l << 31)) >>> 28) |
		   
		    ((value & (1l << 32)) << 28) |
		    ((value & (1l << 33)) << 19) |
		    ((value & (1l << 34)) << 10) |
		    ((value & (1l << 35)) << 1 ) |
		    ((value & (1l << 36)) >>> 8 ) |
		    ((value & (1l << 37)) >>> 17) |
		    ((value & (1l << 38)) >>> 26) |
		    ((value & (1l << 39)) >>> 35) |
		   
		    ((value & (1l << 40)) << 21) |
		    ((value & (1l << 41)) << 12) |
		    ((value & (1l << 42)) << 3 ) |
		    ((value & (1l << 43)) >>> 6 ) |
		    ((value & (1l << 44)) >>> 15) |
		    ((value & (1l << 45)) >>> 24) |
		    ((value & (1l << 46)) >>> 33) |
		    ((value & (1l << 47)) >>> 42) |
		   
		    ((value & (1l << 48)) << 14) |
		    ((value & (1l << 49)) << 5) |
		    ((value & (1l << 50)) >>> 4) |
		    ((value & (1l << 51)) >>> 13) |
		    ((value & (1l << 52)) >>> 22) |
		    ((value & (1l << 53)) >>> 31) |
		    ((value & (1l << 54)) >>> 40) |
		    ((value & (1l << 55)) >>> 49) |
		   
		    ((value & (1l << 56)) << 7) |
		    ((value & (1l << 57)) >>> 2) |
		    ((value & (1l << 58)) >>> 11) |
		    ((value & (1l << 59)) >>> 20) |
		    ((value & (1l << 60)) >>> 29) |
		    ((value & (1l << 61)) >>> 38) |
		    ((value & (1l << 62)) >>> 47) |
		    ((value & (1l << 63)) >>> 56);
	}
	
	public static long xrotate45 (long value)
	{
		   BitBoard valuebb = new BitBoard();
		   valuebb.setBoard(value);
		   BitBoard bb = new BitBoard();
		   
		   bb.setBoard ((value & 1l) << 56 );
		   bb.setBoard( bb.getBoard() | ((value & (1l << 1)) << 47) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 2)) << 38) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 3)) << 29) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 4)) << 20) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 5)) << 11) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 6)) << 2) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 7)) >>> 7) );
		   
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 8 )) << 49) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 9 )) << 40 ) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 10)) << 31) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 11)) << 22) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 12)) << 13) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 13)) <<  4) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 14)) >>>  5) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 15)) >>> 14) );
		   
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 16)) << 42) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 17)) << 33) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 18)) << 24) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 19)) << 15) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 20)) <<  6) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 21)) >>>  3) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 22)) >>> 12) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 23)) >>> 21) );
		   
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 24)) << 35) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 25)) << 26) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 26)) << 17) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 27)) << 8 ) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 28)) >>> 1) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 29)) >>> 10) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 30)) >>> 19) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 31)) >>> 28) );
		   
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 32)) << 28) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 33)) << 19) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 34)) << 10) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 35)) << 1 ) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 36)) >>> 8 ) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 37)) >>> 17) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 38)) >>> 26) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 39)) >>> 35) );
		   
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 40)) << 21) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 41)) << 12) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 42)) << 3 ) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 43)) >>> 6 ) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 44)) >>> 15) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 45)) >>> 24) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 46)) >>> 33) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 47)) >>> 42) );
		   
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 48)) << 14) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 49)) << 5) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 50)) >>> 4) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 51)) >>> 13) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 52)) >>> 22) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 53)) >>> 31) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 54)) >>> 40) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 55)) >>> 49) );
		   
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 56)) << 7) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 57)) >>> 2) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 58)) >>> 11) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 59)) >>> 20) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 60)) >>> 29) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 61)) >>> 38) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 62)) >>> 47) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 63)) >>> 56) );
			   
		   return bb.getBoard();
	}
	
	public static long rotate315 (long value)
	{
		   return (value & 1l) << 56 |
		    ((value & (1l << 1)) << 47) |
		    ((value & (1l << 2)) << 38) |
		    ((value & (1l << 3)) << 29) |
		    ((value & (1l << 4)) << 20) |
		    ((value & (1l << 5)) << 11) |
		    ((value & (1l << 6)) << 2) |
		    ((value & (1l << 7)) >>> 7) |
		   
		    ((value & (1l << 8 )) << 49) |
		    ((value & (1l << 9 )) << 40 ) |
		    ((value & (1l << 10)) << 31) |
		    ((value & (1l << 11)) << 22) |
		    ((value & (1l << 12)) << 13) |
		    ((value & (1l << 13)) <<  4) |
		    ((value & (1l << 14)) >>>  5) |
		    ((value & (1l << 15)) >>> 14) |
		   
		    ((value & (1l << 16)) << 42) |
		    ((value & (1l << 17)) << 33) |
		    ((value & (1l << 18)) << 24) |
		    ((value & (1l << 19)) << 15) |
		    ((value & (1l << 20)) <<  6) |
		    ((value & (1l << 21)) >>>  3) |
		    ((value & (1l << 22)) >>> 12) |
		    ((value & (1l << 23)) >>> 21) |
		   
		    ((value & (1l << 24)) << 35) |
		    ((value & (1l << 25)) << 26) |
		    ((value & (1l << 26)) << 17) |
		    ((value & (1l << 27)) << 8 ) |
		    ((value & (1l << 28)) >>> 1) |
		    ((value & (1l << 29)) >>> 10) |
		    ((value & (1l << 30)) >>> 19) |
		    ((value & (1l << 31)) >>> 28) |
		   
		    ((value & (1l << 32)) << 28) |
		    ((value & (1l << 33)) << 19) |
		    ((value & (1l << 34)) << 10) |
		    ((value & (1l << 35)) << 1 ) |
		    ((value & (1l << 36)) >>> 8 ) |
		    ((value & (1l << 37)) >>> 17) |
		    ((value & (1l << 38)) >>> 26) |
		    ((value & (1l << 39)) >>> 35) |
		   
		    ((value & (1l << 40)) << 21) |
		    ((value & (1l << 41)) << 12) |
		    ((value & (1l << 42)) << 3 ) |
		    ((value & (1l << 43)) >>> 6 ) |
		    ((value & (1l << 44)) >>> 15) |
		    ((value & (1l << 45)) >>> 24) |
		    ((value & (1l << 46)) >>> 33) |
		    ((value & (1l << 47)) >>> 42) |
		   
		    ((value & (1l << 48)) << 14) |
		    ((value & (1l << 49)) << 5) |
		    ((value & (1l << 50)) >>> 4) |
		    ((value & (1l << 51)) >>> 13) |
		    ((value & (1l << 52)) >>> 22) |
		    ((value & (1l << 53)) >>> 31) |
		    ((value & (1l << 54)) >>> 40) |
		    ((value & (1l << 55)) >>> 49) |
		   
		    ((value & (1l << 56)) << 7) |
		    ((value & (1l << 57)) >>> 2) |
		    ((value & (1l << 58)) >>> 11) |
		    ((value & (1l << 59)) >>> 20) |
		    ((value & (1l << 60)) >>> 29) |
		    ((value & (1l << 61)) >>> 38) |
		    ((value & (1l << 62)) >>> 47) |
		    ((value & (1l << 63)) >>> 56);
	}
	
	public static long xrotate315 (long value)
	{
		   BitBoard valuebb = new BitBoard();
		   valuebb.setBoard(value);
		   BitBoard bb = new BitBoard();
		   
		   bb.setBoard ((value & 1l) << 56 );
		   bb.setBoard( bb.getBoard() | ((value & (1l << 1)) << 47) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 2)) << 38) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 3)) << 29) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 4)) << 20) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 5)) << 11) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 6)) << 2) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 7)) >>> 7) );
		   
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 8 )) << 49) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 9 )) << 40 ) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 10)) << 31) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 11)) << 22) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 12)) << 13) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 13)) <<  4) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 14)) >>>  5) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 15)) >>> 14) );
		   
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 16)) << 42) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 17)) << 33) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 18)) << 24) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 19)) << 15) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 20)) <<  6) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 21)) >>>  3) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 22)) >>> 12) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 23)) >>> 21) );
		   
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 24)) << 35) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 25)) << 26) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 26)) << 17) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 27)) << 8 ) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 28)) >>> 1) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 29)) >>> 10) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 30)) >>> 19) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 31)) >>> 28) );
		   
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 32)) << 28) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 33)) << 19) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 34)) << 10) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 35)) << 1 ) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 36)) >>> 8 ) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 37)) >>> 17) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 38)) >>> 26) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 39)) >>> 35) );
		   
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 40)) << 21) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 41)) << 12) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 42)) << 3 ) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 43)) >>> 6 ) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 44)) >>> 15) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 45)) >>> 24) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 46)) >>> 33) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 47)) >>> 42) );
		   
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 48)) << 14) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 49)) << 5) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 50)) >>> 4) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 51)) >>> 13) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 52)) >>> 22) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 53)) >>> 31) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 54)) >>> 40) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 55)) >>> 49) );
		   
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 56)) << 7) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 57)) >>> 2) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 58)) >>> 11) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 59)) >>> 20) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 60)) >>> 29) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 61)) >>> 38) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 62)) >>> 47) );
		   bb.setBoard( bb.getBoard() |  ((value & (1l << 63)) >>> 56) );
			   
		   return bb.getBoard();
	}

}
