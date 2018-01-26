package contest;

import java.util.Scanner;

public class reverseNonogram {

	public static void main(String agrs[])
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] grid = new int[n][n];
		boolean mode = false;
		int run = 0;
		
		for(int i = 0; i < n; i++)
		{
			String result = scan.next();
			for(int j = 0; j < n; j++)
			{
				char c = result.charAt(j);
				
				if(c == '.')
				{
					grid[i][j] = 0;
					
				}
				else
				{
					
					grid[i][j] = 1;
				}
			}
			
		}
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				int num = grid[i][j];
				if(num == 0)
				{
					if(run != 0)
					{
						System.out.print(run + " ");
						run = 0;
					}
				}
				else
				{
					mode = true;
					run++;
				}
			}
			
			if(run != 0)
			{
				System.out.println(run);
				run = 0;
			}
			else
			{
				if(mode == true)
				{
					System.out.println("");
				}
				else
				{
					System.out.println(0);
				}
			}
			
			mode = false;
		}
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				int num = grid[j][i];
				if(num == 0)
				{
					if(run != 0)
					{
						System.out.print(run + " ");
						run = 0;
					}
				}
				else
				{
					mode = true;
					run++;
				}
			}
			
			if(run != 0)
			{
				System.out.println(run);
				run = 0;
			}
			else
			{
				if(mode == true)
				{
					System.out.println("");
				}
				else
				{
					System.out.println(0);
				}
			}
			
			mode = false;
		}
		scan.close();
	}

}
