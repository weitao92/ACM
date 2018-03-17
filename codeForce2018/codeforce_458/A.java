package codeforce_458;

import java.util.*;

/**
 * http://codeforces.com/contest/914/problem/A
 * @author weitao92
 *
 */
public class A {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int result = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++)
		{
			int current = in.nextInt();
			if(current < 0)
			{
				if(current > result)
					result = current;
				continue;
			}
			double root = Math.sqrt((double)current);
			if(root%1 != 0 && current > result)
			{
				result = current;
			}
		}
		System.out.println(result);
	}
}
