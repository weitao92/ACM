package MATH;


import java.math.BigInteger;
import java.util.Scanner;

public class pathCountLarge {
	
static BigInteger MOD = new BigInteger("1000000007");
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		in.close();
		int sum = n + m;
		int larger;
		if(n > m)
		{
			larger = n;
		}
		else
		{
			larger = m;
		}
		
		factorial(sum, larger);
	}
	
	private static void factorial(int base, int cancel)
	{
		BigInteger bigger = new BigInteger("1");
		BigInteger smaller = new BigInteger("1");
		long temp = 1;
		for(int i = cancel + 1; i <= base; i++)
		{
			bigger = bigger.multiply(new BigInteger(i + ""));
			if(bigger.compareTo(MOD) >= 0)
			{
				bigger = bigger.mod(MOD);
			}
			smaller = smaller.multiply(new BigInteger(temp + ""));
			if(smaller.compareTo(MOD) >= 0)
			{
				smaller = smaller.mod(MOD);
			}
			temp++;
		}
		/**
		 * Most important code of entire program, imagine bigger as X, smaller as X/Y where
		 * the result we want is Y, and X/Y * Z = 1mod(M), then X * Z = Y(MOD M).
		 */
		bigger = bigger.multiply(smaller.modInverse(MOD));
	    System.out.println(bigger.mod(MOD));
	}

}
