package edu_1;

import java.util.Scanner;

public class A {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int max = 0;
		for(int i = 0; i < n; i++)
		{
			int length = in.nextInt();
			if(k%length == 0 && length > max)
			{
				max = length;
			}
		}
		System.out.println(k/max);
	}

}
