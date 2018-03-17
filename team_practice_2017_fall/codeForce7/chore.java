package codeForce7;

import java.util.Scanner;

public class chore {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		//int[] temp = new int[n];
		int f = in.nextInt();
		int x = in.nextInt();
		
		long result = f * x;
		for(int i = 0; i < n - f; i++)
		{
			result += in.nextInt();
		}
		
		System.out.println(result);
	}

}
