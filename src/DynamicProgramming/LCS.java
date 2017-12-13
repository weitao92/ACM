package DynamicProgramming;

import java.util.Scanner;

public class LCS {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		String s1 = in.next();
		String s2 = in.next();
		char[] first = s1.toCharArray();
		char[] second = s2.toCharArray();
		in.close();
		int m = first.length;
		int n = second.length;
		
		int[][] matrix = new int[m+1][n+1];
		
		for(int i = 0; i <= m; i++)
		{
			for(int j = 0; j <= n; j++)
			{
				if(i == 0 || j == 0)
				{
					matrix[i][j] = 0;
				}
				else if(first[i-1] == second[j-1])
				{
					matrix[i][j] = 1 + matrix[i-1][j-1];
					
				}
				else
				{
					matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
				}
			}
		}
		
		System.out.println(matrix[m][n]);
		
	}

}
