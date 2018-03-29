package edu_1;

import java.util.Scanner;

public class B {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int pos = in.nextInt();
		int l = in.nextInt();
		int r = in.nextInt();
		
		if(l == 1 && r == n)
		{
			System.out.println(0);
		}
		else if(l == 1)
		{
			System.out.println(Math.abs(r-pos)+1);
		}
		else if(r == n)
		{
			System.out.println(Math.abs(l-pos)+1);
		}
		else
		{
			if(pos <= l)
			{
				System.out.println(Math.abs(l-pos) + (r-l) + 2);
			}
			else if(pos >= r)
			{
				System.out.println(Math.abs(r-pos) + (r-l) + 2);
			}
			else
			{
				int min = Math.min(pos-l, r-pos);
				System.out.println(min + (r-l) + 2);
			}
		}
	}

}
