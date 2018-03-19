package PrefixSum;

import java.util.Scanner;

public class maxSum2D {

	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[][] world = new long[n][n];
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				world[i][j] = in.nextLong();
				if(i > 0)
				{
					world[i][j] += world[i-1][j];
				}
				if(j > 0)
				{
					world[i][j] += world[i][j-1];
				}
				
				if(i > 0 && j > 0)
				{
					world[i][j] -= world[i-1][j-1];
				}
			}
		}
		in.close();
		long max = Long.MIN_VALUE; //always use MIN as initial max and MAX as initial min.
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				for(int x = i; x < n; x++)
				{
					for(int y = j; y < n; y++)
					{
						long sum = world[x][y];
						if(i > 0)
						{
							sum -= world[i-1][y];
						}
						if(j > 0)
						{
							sum -= world[x][j-1];
						}
						if(i > 0 && j > 0)
						{
							sum += world[i-1][j-1];
						}
						
						if(sum > max)
						{
							max = sum;
						}
					}
				}
			}
		}
		
		System.out.println(max);
	}
}
