package codeforce_456;

import java.util.*;

/**
 * http://codeforces.com/contest/912/problem/0
 * @author weitao92
 *
 */
public class problemA {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		long yellow = in.nextLong();
		long blue = in.nextLong();
		long y = 0;
		long b = 0;
		long y1 = in.nextLong();
		y += 2*y1;
		long g1 = in.nextLong();
		y += g1;
		b += g1;
		long b1 = in.nextLong();
		b += 3*b1;
		
		long result = 0;
		if(y > yellow)
		{
			result += y - yellow;
		}
		if(b > blue)
		{
			result += b - blue;
		}
		System.out.print(result);
	}

}
