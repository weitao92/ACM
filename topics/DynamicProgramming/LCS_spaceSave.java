package DynamicProgramming;

import java.util.Scanner;

public class LCS_spaceSave {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		String s1 = in.next();
		String s2 = in.next();
		char[] first = s1.toCharArray();
		char[] second = s2.toCharArray();
		in.close();
		
		int m = first.length, n = second.length;
		 
	    int[][] L = new int[2][n+1];
	 
	    // Binary index, used to index current row and
	    // previous row.
	    int bi = 0;
	 
	    for (int i=0; i<=m; i++)
	    {
	        // Compute current binary index
	        bi = i&1;
	 
	        for (int j=0; j<=n; j++)
	        {
	            if (i == 0 || j == 0)
	                L[bi][j] = 0;
	 
	            else if (first[i-1] == second[j-1])
	                L[bi][j] = L[1-bi][j-1] + 1;
	 
	            else
	                L[bi][j] = Math.max(L[1-bi][j], L[bi][j-1]);
	        }
	    }
	 
	    /* Last filled entry contains length of LCS
	       for X[0..n-1] and Y[0..m-1] */
	    System.out.println(L[bi][n]);
	}

}
