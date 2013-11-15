/**
 * 
 */
package jkb.chess.resources;


/**
 * Lots of bit board constants used for calculations 
 * 
 * @author joeykblack
 *
 */
public class BitBoardConst
{
	
	public static final long KING_INITIAL = (1L << 4);
	public static final long QUEEN_INITIAL = (1L << 3);
	public static final long BISHOP_INITIAL = (1L << 5) | (1L << 2);
	public static final long NIGHT_INITIAL = (1L << 6) | (1L << 1);
	public static final long ROOK_INITIAL = (1L << 7) | 1L;
	public static final long PAWN_INITIAL = (1L << 8) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15);

	public static final long EMPTY =           make(	 "0 0 0 0 0 0 0 0",
												 		 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0");
	
	
	/*
	 * Rank
	 */
	
	public static final long RANK_1 =           make(	 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "1 1 1 1 1 1 1 1");
	
	public static final long RANK_2 =           make(	 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "1 1 1 1 1 1 1 1",
														 "0 0 0 0 0 0 0 0");
	
	public static final long RANK_3 =           make(	 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "1 1 1 1 1 1 1 1",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0");
	
	public static final long RANK_4 =           make(	 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "1 1 1 1 1 1 1 1",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0");
	
	public static final long RANK_5 =           make(	 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "1 1 1 1 1 1 1 1",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0");

	
	public static final long RANK_6 =           make(	 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "1 1 1 1 1 1 1 1",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0");

	
	public static final long RANK_7 =           make(	 "0 0 0 0 0 0 0 0",
														 "1 1 1 1 1 1 1 1",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0");

	
	public static final long RANK_8 =           make(	 "1 1 1 1 1 1 1 1",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0");
	
	
	/*
	 * File
	 */

	
	public static final long FILE_A =           make(	 "1 0 0 0 0 0 0 0",
														 "1 0 0 0 0 0 0 0",
														 "1 0 0 0 0 0 0 0",
														 "1 0 0 0 0 0 0 0",
														 "1 0 0 0 0 0 0 0",
														 "1 0 0 0 0 0 0 0",
														 "1 0 0 0 0 0 0 0",
														 "1 0 0 0 0 0 0 0");

	
	public static final long FILE_B =           make(	 "0 1 0 0 0 0 0 0",
														 "0 1 0 0 0 0 0 0",
														 "0 1 0 0 0 0 0 0",
														 "0 1 0 0 0 0 0 0",
														 "0 1 0 0 0 0 0 0",
														 "0 1 0 0 0 0 0 0",
														 "0 1 0 0 0 0 0 0",
														 "0 1 0 0 0 0 0 0");

	
	public static final long FILE_C =           make(	 "0 0 1 0 0 0 0 0",
														 "0 0 1 0 0 0 0 0",
														 "0 0 1 0 0 0 0 0",
														 "0 0 1 0 0 0 0 0",
														 "0 0 1 0 0 0 0 0",
														 "0 0 1 0 0 0 0 0",
														 "0 0 1 0 0 0 0 0",
														 "0 0 1 0 0 0 0 0");

	
	public static final long FILE_D =           make(	 "0 0 0 1 0 0 0 0",
														 "0 0 0 1 0 0 0 0",
														 "0 0 0 1 0 0 0 0",
														 "0 0 0 1 0 0 0 0",
														 "0 0 0 1 0 0 0 0",
														 "0 0 0 1 0 0 0 0",
														 "0 0 0 1 0 0 0 0",
														 "0 0 0 1 0 0 0 0");

	
	public static final long FILE_E =           make(	 "0 0 0 0 1 0 0 0",
														 "0 0 0 0 1 0 0 0",
														 "0 0 0 0 1 0 0 0",
														 "0 0 0 0 1 0 0 0",
														 "0 0 0 0 1 0 0 0",
														 "0 0 0 0 1 0 0 0",
														 "0 0 0 0 1 0 0 0",
														 "0 0 0 0 1 0 0 0");

	
	public static final long FILE_F =           make(	 "0 0 0 0 0 1 0 0",
														 "0 0 0 0 0 1 0 0",
														 "0 0 0 0 0 1 0 0",
														 "0 0 0 0 0 1 0 0",
														 "0 0 0 0 0 1 0 0",
														 "0 0 0 0 0 1 0 0",
														 "0 0 0 0 0 1 0 0",
														 "0 0 0 0 0 1 0 0");

	
	public static final long FILE_G =           make(	 "0 0 0 0 0 0 1 0",
														 "0 0 0 0 0 0 1 0",
														 "0 0 0 0 0 0 1 0",
														 "0 0 0 0 0 0 1 0",
														 "0 0 0 0 0 0 1 0",
														 "0 0 0 0 0 0 1 0",
														 "0 0 0 0 0 0 1 0",
														 "0 0 0 0 0 0 1 0");

	
	public static final long FILE_H =           make(	 "0 0 0 0 0 0 0 1",
														 "0 0 0 0 0 0 0 1",
														 "0 0 0 0 0 0 0 1",
														 "0 0 0 0 0 0 0 1",
														 "0 0 0 0 0 0 0 1",
														 "0 0 0 0 0 0 0 1",
														 "0 0 0 0 0 0 0 1",
														 "0 0 0 0 0 0 0 1");
	
	
	/*
	 * Forward slash
	 */

	public static final long FORWARD_SLASH_1 =           make(	 "0 0 0 0 0 0 0 0",
													 		 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0",
															 "1 0 0 0 0 0 0 0");

	public static final long FORWARD_SLASH_2 =           make(	 "0 0 0 0 0 0 0 0",
													 		 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0",
															 "1 0 0 0 0 0 0 0",
															 "0 1 0 0 0 0 0 0");

	public static final long FORWARD_SLASH_3 =           make(	 "0 0 0 0 0 0 0 0",
													 		 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0",
															 "1 0 0 0 0 0 0 0",
															 "0 1 0 0 0 0 0 0",
															 "0 0 1 0 0 0 0 0");

	public static final long FORWARD_SLASH_4 =           make(	 "0 0 0 0 0 0 0 0",
													 		 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0",
															 "1 0 0 0 0 0 0 0",
															 "0 1 0 0 0 0 0 0",
															 "0 0 1 0 0 0 0 0",
															 "0 0 0 1 0 0 0 0");

	public static final long FORWARD_SLASH_5 =           make(	 "0 0 0 0 0 0 0 0",
													 		 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0",
															 "1 0 0 0 0 0 0 0",
															 "0 1 0 0 0 0 0 0",
															 "0 0 1 0 0 0 0 0",
															 "0 0 0 1 0 0 0 0",
															 "0 0 0 0 1 0 0 0");

	public static final long FORWARD_SLASH_6 =           make(	 "0 0 0 0 0 0 0 0",
													 		 "0 0 0 0 0 0 0 0",
															 "1 0 0 0 0 0 0 0",
															 "0 1 0 0 0 0 0 0",
															 "0 0 1 0 0 0 0 0",
															 "0 0 0 1 0 0 0 0",
															 "0 0 0 0 1 0 0 0",
															 "0 0 0 0 0 1 0 0");

	public static final long FORWARD_SLASH_7 =           make(	 "0 0 0 0 0 0 0 0",
													 		 "1 0 0 0 0 0 0 0",
															 "0 1 0 0 0 0 0 0",
															 "0 0 1 0 0 0 0 0",
															 "0 0 0 1 0 0 0 0",
															 "0 0 0 0 1 0 0 0",
															 "0 0 0 0 0 1 0 0",
															 "0 0 0 0 0 0 1 0");

	public static final long FORWARD_SLASH_8 =           make(	 "1 0 0 0 0 0 0 0",
													 		 "0 1 0 0 0 0 0 0",
															 "0 0 1 0 0 0 0 0",
															 "0 0 0 1 0 0 0 0",
															 "0 0 0 0 1 0 0 0",
															 "0 0 0 0 0 1 0 0",
															 "0 0 0 0 0 0 1 0",
															 "0 0 0 0 0 0 0 1");

	public static final long FORWARD_SLASH_9 =           make(	 "0 1 0 0 0 0 0 0",
													 		 "0 0 1 0 0 0 0 0",
															 "0 0 0 1 0 0 0 0",
															 "0 0 0 0 1 0 0 0",
															 "0 0 0 0 0 1 0 0",
															 "0 0 0 0 0 0 1 0",
															 "0 0 0 0 0 0 0 1",
															 "0 0 0 0 0 0 0 0");

	public static final long FORWARD_SLASH_10=           make(	 "0 0 1 0 0 0 0 0",
													 		 "0 0 0 1 0 0 0 0",
															 "0 0 0 0 1 0 0 0",
															 "0 0 0 0 0 1 0 0",
															 "0 0 0 0 0 0 1 0",
															 "0 0 0 0 0 0 0 1",
															 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0");

	public static final long FORWARD_SLASH_11=           make(	 "0 0 0 1 0 0 0 0",
													 		 "0 0 0 0 1 0 0 0",
															 "0 0 0 0 0 1 0 0",
															 "0 0 0 0 0 0 1 0",
															 "0 0 0 0 0 0 0 1",
															 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0");

	public static final long FORWARD_SLASH_12=           make(	 "0 0 0 0 1 0 0 0",
													 		 "0 0 0 0 0 1 0 0",
															 "0 0 0 0 0 0 1 0",
															 "0 0 0 0 0 0 0 1",
															 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0");

	public static final long FORWARD_SLASH_13=           make(	 "0 0 0 0 0 1 0 0",
													 		 "0 0 0 0 0 0 1 0",
															 "0 0 0 0 0 0 0 1",
															 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0");

	public static final long FORWARD_SLASH_14=           make(	 "0 0 0 0 0 0 1 0",
													 		 "0 0 0 0 0 0 0 1",
															 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0");

	public static final long FORWARD_SLASH_15=           make(	 "0 0 0 0 0 0 0 1",
													 		 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0",
															 "0 0 0 0 0 0 0 0");
	
	/*
	 * Back Slash
	 */

	public static final long BACK_SLASH_1  =           make(	 "1 0 0 0 0 0 0 0",
														 		 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0");

	public static final long BACK_SLASH_2  =           make(	 "0 1 0 0 0 0 0 0",
														 		 "1 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0");

	public static final long BACK_SLASH_3  =           make(	 "0 0 1 0 0 0 0 0",
														 		 "0 1 0 0 0 0 0 0",
																 "1 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0");

	public static final long BACK_SLASH_4  =           make(	 "0 0 0 1 0 0 0 0",
														 		 "0 0 1 0 0 0 0 0",
																 "0 1 0 0 0 0 0 0",
																 "1 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0");

	public static final long BACK_SLASH_5  =           make(	 "0 0 0 0 1 0 0 0",
														 		 "0 0 0 1 0 0 0 0",
																 "0 0 1 0 0 0 0 0",
																 "0 1 0 0 0 0 0 0",
																 "1 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0");

	public static final long BACK_SLASH_6  =           make(	 "0 0 0 0 0 1 0 0",
														 		 "0 0 0 0 1 0 0 0",
																 "0 0 0 1 0 0 0 0",
																 "0 0 1 0 0 0 0 0",
																 "0 1 0 0 0 0 0 0",
																 "1 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0");

	public static final long BACK_SLASH_7  =           make(	 "0 0 0 0 0 0 1 0",
														 		 "0 0 0 0 0 1 0 0",
																 "0 0 0 0 1 0 0 0",
																 "0 0 0 1 0 0 0 0",
																 "0 0 1 0 0 0 0 0",
																 "0 1 0 0 0 0 0 0",
																 "1 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0");

	public static final long BACK_SLASH_8  =           make(	 "0 0 0 0 0 0 0 1",
														 		 "0 0 0 0 0 0 1 0",
																 "0 0 0 0 0 1 0 0",
																 "0 0 0 0 1 0 0 0",
																 "0 0 0 1 0 0 0 0",
																 "0 0 1 0 0 0 0 0",
																 "0 1 0 0 0 0 0 0",
																 "1 0 0 0 0 0 0 0");

	public static final long BACK_SLASH_9  =           make(	 "0 0 0 0 0 0 0 0",
														 		 "0 0 0 0 0 0 0 1",
																 "0 0 0 0 0 0 1 0",
																 "0 0 0 0 0 1 0 0",
																 "0 0 0 0 1 0 0 0",
																 "0 0 0 1 0 0 0 0",
																 "0 0 1 0 0 0 0 0",
																 "0 1 0 0 0 0 0 0");

	public static final long BACK_SLASH_10 =           make(	 "0 0 0 0 0 0 0 0",
														 		 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 1",
																 "0 0 0 0 0 0 1 0",
																 "0 0 0 0 0 1 0 0",
																 "0 0 0 0 1 0 0 0",
																 "0 0 0 1 0 0 0 0",
																 "0 0 1 0 0 0 0 0");

	public static final long BACK_SLASH_11 =           make(	 "0 0 0 0 0 0 0 0",
														 		 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 1",
																 "0 0 0 0 0 0 1 0",
																 "0 0 0 0 0 1 0 0",
																 "0 0 0 0 1 0 0 0",
																 "0 0 0 1 0 0 0 0");

	public static final long BACK_SLASH_12 =           make(	 "0 0 0 0 0 0 0 0",
														 		 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 1",
																 "0 0 0 0 0 0 1 0",
																 "0 0 0 0 0 1 0 0",
																 "0 0 0 0 1 0 0 0");

	public static final long BACK_SLASH_13 =           make(	 "0 0 0 0 0 0 0 0",
														 		 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 1",
																 "0 0 0 0 0 0 1 0",
																 "0 0 0 0 0 1 0 0");

	public static final long BACK_SLASH_14 =           make(	 "0 0 0 0 0 0 0 0",
														 		 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 1",
																 "0 0 0 0 0 0 1 0");

	public static final long BACK_SLASH_15 =           make(	 "0 0 0 0 0 0 0 0",
														 		 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 0",
																 "0 0 0 0 0 0 0 1");
	
	
	
	
	
	/*
	 * Evaluation maps
	 */

	public static final long CENTER =           make(	 "0 0 0 0 0 0 0 0",
												 		 "0 0 0 0 0 0 0 0",
														 "0 0 1 1 1 1 0 0",
														 "0 0 1 1 1 1 0 0",
														 "0 0 1 1 1 1 0 0",
														 "0 0 1 1 1 1 0 0",
														 "0 0 0 0 0 0 0 0",
														 "0 0 0 0 0 0 0 0");
	
	
	
	
	
	public static long getRank(int row)
	{
		long board;
		switch (row)
		{
		case 0:
			board = RANK_1;
			break;
		case 1:
			board = RANK_2;
			break;
		case 2:
			board = RANK_3;
			break;
		case 3:
			board = RANK_4;
			break;
		case 4:
			board = RANK_5;
			break;
		case 5:
			board = RANK_6;
			break;
		case 6:
			board = RANK_7;
			break;
		case 7:
			board = RANK_8;
			break;
		default:
			board = 0l;
		}
		return board;
	}
	
	public static long getFile(int col)
	{
		long board;
		switch (col)
		{
		case 0:
			board = FILE_A;
			break;
		case 1:
			board = FILE_B;
			break;
		case 2:
			board = FILE_C;
			break;
		case 3:
			board = FILE_D;
			break;
		case 4:
			board = FILE_E;
			break;
		case 5:
			board = FILE_F;
			break;
		case 6:
			board = FILE_G;
			break;
		case 7:
			board = FILE_H;
			break;
		default:
			board = 0l;
		}
		return board;
	}
	
	public static long getBackSlash(int row, int col)
	{
		int num = col - row + 8;
		long value = 0l;
		
		switch (num)
		{
		case 1:
			value = BACK_SLASH_1;
			break;
		case 2:
			value = BACK_SLASH_2;
			break;
		case 3:
			value = BACK_SLASH_3;
			break;
		case 4:
			value = BACK_SLASH_4;
			break;
		case 5:
			value = BACK_SLASH_5;
			break;
		case 6:
			value = BACK_SLASH_6;
			break;
		case 7:
			value = BACK_SLASH_7;
			break;
		case 8:
			value = BACK_SLASH_8;
			break;
		case 9:
			value = BACK_SLASH_9;
			break;
		case 10:
			value = BACK_SLASH_10;
			break;
		case 11:
			value = BACK_SLASH_11;
			break;
		case 12:
			value = BACK_SLASH_12;
			break;
		case 13:
			value = BACK_SLASH_13;
			break;
		case 14:
			value = BACK_SLASH_14;
			break;
		case 15:
			value = BACK_SLASH_15;
			break;
		}
		
		return value;
	}
	
	public static long getForwardSlash(int row, int col)
	{
		int num = col + row + 1;
		long value = 0l;
		
		switch (num)
		{
		case 1:
			value = FORWARD_SLASH_1;
			break;
		case 2:
			value = FORWARD_SLASH_2;
			break;
		case 3:
			value = FORWARD_SLASH_3;
			break;
		case 4:
			value = FORWARD_SLASH_4;
			break;
		case 5:
			value = FORWARD_SLASH_5;
			break;
		case 6:
			value = FORWARD_SLASH_6;
			break;
		case 7:
			value = FORWARD_SLASH_7;
			break;
		case 8:
			value = FORWARD_SLASH_8;
			break;
		case 9:
			value = FORWARD_SLASH_9;
			break;
		case 10:
			value = FORWARD_SLASH_10;
			break;
		case 11:
			value = FORWARD_SLASH_11;
			break;
		case 12:
			value = FORWARD_SLASH_12;
			break;
		case 13:
			value = FORWARD_SLASH_13;
			break;
		case 14:
			value = FORWARD_SLASH_14;
			break;
		case 15:
			value = FORWARD_SLASH_15;
			break;
		}
		
		return value;
	}
	
	public static long make (String r8, String r7, String r6, String r5, String r4, String r3, String r2, String r1)
	{
		boolean start1 = false;
		if (r8.endsWith("1"))
		{
			r8 = r8.subSequence(0, r8.length()-2) + "0";
			start1 = true;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(r1);
		sb.append(r2);
		sb.append(r3);
		sb.append(r4);
		sb.append(r5);
		sb.append(r6);
		sb.append(r7);
		sb.append(r8);
		long result = Long.parseLong(sb.reverse().toString().replace(" ", ""), 2);
		if (start1)
		{
			result |= (1l << 63);
		}
		return result;
		
	}


}
