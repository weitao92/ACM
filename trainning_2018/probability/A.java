package probability;

import java.util.Scanner;

/**
 * https://pcs.cs.cloud.vt.edu/contests/66/problems/A
 * @author weitao92
 *
 */
public class A {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long max = 1000000007l;
		long result = 1;
		for(int i = 2; i <= n; i++)
		{
			result *= i;
			if(result >= max)
			{
				result %= max;
			}
		}
		System.out.println(result);
	}

}
