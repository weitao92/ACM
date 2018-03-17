package codeForce7;

import java.util.Scanner;

public class lastDigit {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		long a = in.nextLong();
		long b = in.nextLong();
		
		long diff = b - a;
		if(diff >= 10)
		{
			System.out.println(0);
			System.exit(0);
		}
		else
		{
			long m = b % 10;
			long result = 1;
			while(m > (b%10 - diff))
			{
				result *= m;
				m--;
			}
			
			System.out.println(result % 10);
		}
	}

}
