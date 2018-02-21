package Primes;

import java.util.*;

/**
 * https://pcs.cs.cloud.vt.edu/contests/65/problems/A
 * @author weitao92
 *
 */
public class A {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		if(n == 1)
		{
			System.out.println("false");
			System.exit(0);
		}
		if(n == 2)
		{
			System.out.println("true");
			System.exit(0);
		}
		if(n%2 == 0)
		{
			System.out.println("false");
			System.exit(0);
		}
		long temp = 3;
		while(temp <= Math.sqrt(n))
		{
			if(n%temp == 0)
			{
				System.out.println("false");
				System.exit(0);
			}
			temp += 2;
		}
		System.out.println("true");
	}

}
