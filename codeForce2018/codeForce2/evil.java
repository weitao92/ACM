package codeForce2;

import java.util.Scanner;

/**
 * codeforce 862A
 * @author weitao92
 *
 */
public class evil {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		boolean[] set = new boolean[101];
		
		int n = in.nextInt();
		int x = in.nextInt();
		
		for(int i = 0; i < n; i++)
		{
			int next = in.nextInt();
			set[next] = true;
		}
		
		int result;
		if(set[x])
		{
			result = 1;
		}
		else
		{
			result = 0;
		}
		
		for(int i = x-1; i >= 0; i--)
		{
			if(set[i])
			{
				continue;
			}
			else
			{
				result++;
			}
		}
		
		System.out.println(result);
	}

}
