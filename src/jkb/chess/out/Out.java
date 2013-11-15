/**
 * 
 */
package jkb.chess.out;

import java.io.PrintStream;

/**
 * @author joeykblack
 *
 */
public class Out
{
	public static PrintStream debug = System.out;
	
	public static void println(Object text)
	{
		System.out.println(text);
	}
	public static void println()
	{
		System.out.println("");
	}
	public static void print(Object text)
	{
		System.out.print(text);
	}
	

	
	public static void printlnDebug(Object text)
	{
		debug.println(text);
	}
	public static void printlnDebug()
	{
		debug.println("");
	}
	public static void printDebug(Object text)
	{
		debug.print(text);
	}

}
