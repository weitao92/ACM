package DynamicProgramming;
import java.util.Scanner;

/**
 * alright this is a question about longest common contiguous sub-sequence.
 * @author weitao92
 *
 */
public class LCS_contiguous {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		String first = in.next();
		String second = in.next();
		in.close();
		
		char[] l1 = first.toCharArray();
		char[] l2 = second.toCharArray();
		int m = l1.length;
		int n = l2.length;
		StringBuilder result = lcs(l1, l2, m, n);
	
		System.out.println(result);
	}
	
	private static StringBuilder lcs(char[] first, char[]second, int m, int n)
	{
		int[][] matrix = new int[m+1][n+1];

		for(int i = 0; i <= m; i++)
		{
			for(int j = 0; j <= n; j++)
			{
				if(i == 0 || j == 0)
				{
					matrix[i][j] = 0;
				}
				else
				{
					if(first[i - 1] == second[j - 1])
					{
						matrix[i][j] = 1 + matrix[i-1][j-1];
					}
					else
					{
						matrix[i][j] = 0;
					}
				}
			}
		}
		
		int max = -1;
		int x = -1;
		int y = -1;
		for(int i = 1; i <= n; i++)
		{
			for(int j = 1; j <= m; j++)
			{
				if(matrix[j][i] > max)
				{
					max = matrix[j][i];
					x = j;
					y = i;
					
				}
			}
		}
		
		StringBuilder result = new StringBuilder();
		
		while(matrix[x][y] != 0)
		{
			result.insert(0, first[x-1]);
			x--;
			y--;
		}
		
		return result;
	}

}
