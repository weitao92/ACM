package BackTrack;

import java.util.Scanner;

public class N_queen {
	
	static int[][] board;
	static int n;
	static boolean finished;
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		in.close();
		board = new int[n][n];
		finished = false;
		backTrack(0);
		
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(board[i][j] == 0)
				{
					result.append(".");
				}
				else
				{
					result.append("x");
				}
			}
			result.append("\n");
		}
		
		System.out.println(result);
	}
	
	private static void backTrack(int col)
	{
		if(col >= n)
		{
			return;
		}
		else
		{
			for(int i = 0; i < n; i++)
			{
				if(!dangerous(i,col))
				{
					board[i][col] = 1;
					if(col == n - 1)
					{
						finished = true;
						return;
					}
					backTrack(col + 1);
				}
				
				if(finished)
				{
					break;
				}
				else
				{
					board[i][col] = 0;
				}
			}
		}
	}
	
	private static boolean dangerous(int row, int col)
	{
		for(int i = 0; i < col; i++)
		{
			if(board[row][i] == 1)
			{
				return true;
			}
		}
		
		int x = row - 1;
		int y = col - 1;
		while(x >= 0 && y >= 0)
		{
			if(board[x--][y--] == 1)
			{
				return true;
			}
		}
		
		int i = row + 1;
		int j = col - 1;
		while(i < n && j >= 0)
		{
			if(board[i++][j--] == 1)
			{
				return true;
			}
		}
		
		return false;
		
	}

}
