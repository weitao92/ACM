package codeforce_456;

import java.util.*;

/**
 * http://codeforces.com/contest/912/problem/B
 * @author weitao92
 *
 */
public class problemB {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long k = in.nextLong();
		if(k == 1)
		{
			System.out.print(n);
			System.exit(0);
		}
		
		long result = Long.MAX_VALUE >> Long.numberOfLeadingZeros(n)-1;
		System.out.println(result);
		
	}

}
