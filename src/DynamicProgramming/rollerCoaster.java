package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://pcs.cs.cloud.vt.edu/problems/91
 * @author weitao92
 *
 */
public class rollerCoaster {
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext())
		{
			int n = in.nextInt();
			int reduce = in.nextInt();
			int limit = in.nextInt();
			
			if(n == 0 && reduce == 0 && limit == 0)
			{
				in.close();
				System.exit(0);
			}
			else
			{
				int[] fun = new int[n];
				int[] dizzy = new int[n];
				int sum = 0;
				
				for(int i = 0; i < n; i++)
				{
					int f = in.nextInt();
					int d = in.nextInt();
					sum += f;
					fun[i] = f;
					dizzy[i] = d;
				}
				
				int[][] dp = new int[n+1][sum+1];
				for(int i = 0; i <= n; i++)
				{
					Arrays.fill(dp[i], Integer.MAX_VALUE);
				}
				dp[0][0] = 0;
				
				for(int i = 0; i < n; i++)
				{
					for(int j = 0; j <= sum; j++)
					{
						if(dp[i][j] != Integer.MAX_VALUE)//this score of happniess is possible
						{
							int min = dp[i][j] - reduce < 0 ? 0 : dp[i][j] - reduce;
							dp[i+1][j] = Math.min(dp[i+1][j], min);
							
							if(dp[i][j] + dizzy[i] <= limit)
							{
								dp[i+1][j+fun[i]] = Math.min(dp[i+1][j+fun[i]], 
										dp[i][j] + dizzy[i]);
							}
						}
					}
				}
				
				for(int i = sum; i >= 0; i--)
				{
					if(dp[n][i] != Integer.MAX_VALUE)
					{
						System.out.println(i);
						break;
					}
				}

	
			}
		}
	}
}
