package PrefixSum;

import java.util.Scanner;

public class flowers {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		long[] flowers = new long[n];
		for(int i = 0; i < n; i++)
		{
			int current = in.nextInt();
			flowers[i] = current;
			if(i > 0)
			{
				flowers[i] += flowers[i-1];
			}
		}
		
		long result = 0;
		for(int i = 0; i < m; i++)
		{
			int first = in.nextInt() - 1;
			int second = in.nextInt() - 1;
			long sum = flowers[second];
			if(first > 0)
			{
				sum -= flowers[first-1];
			}
			
			if(sum > 0)
			{
				result += sum;
			}
		}
		in.close();
		System.out.println(result);
	}

}
