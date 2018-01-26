package Graph;

import java.util.Arrays;
import java.util.Scanner;

public class noCycle {
	
	static int[] union;
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int v = in.nextInt();
		int e = in.nextInt();
		union = new int[v];
		Arrays.fill(union, -1);
		for(int i = 0; i < e; i++)
		{
			int start = in.nextInt();
			int end = in.nextInt();
			int r1 = root(start);
			int r2 = root(end);
			if(r1 != r2)
			{
				union[r1] = r2;
			}
			else
			{
				System.out.println("Bad");
				System.exit(0);
			}		
		}
		System.out.println("Good");
		in.close();
	}
	
	
	private static int root(int target)
	{
		int root = target;
		while(union[root] != -1)
		{
			root = union[root];
		}
		
		return root;
	}

}
