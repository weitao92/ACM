package Combinatorics;

import java.math.BigInteger;
import java.util.Scanner;

public class pathCount {
	
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
		int temp = 1;
		for(int i = cancel + 1; i <= base; i++)
		{
			bigger = bigger.multiply(new BigInteger(i + ""));
			smaller = smaller.multiply(new BigInteger(temp + ""));
			temp++;
			/**
			if(result.compareTo(MOD) > 0)
			{
				result = result.mod(MOD);
			}
			**/
		}
		
		BigInteger result = bigger.divide(smaller);
		result = result.mod(MOD);
		System.out.println(result);
	}

}
