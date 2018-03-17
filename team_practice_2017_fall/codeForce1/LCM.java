package codeForce1;

import java.util.Scanner;
/**
 * codeforce 861A.
 * @author weitao92
 *
 */
public class LCM {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		long n = in.nextLong();
		long k = in.nextLong();
		in.close();
		
		if(k == 0)
		{
			System.out.println(n);
		}
		else
		{
			long base = 1;
			for(int i = 0; i < k; i++)
			{
				base *= 10;
			}
			
			long gcd = gcd(n, base);
			long result = n * base / gcd;
			System.out.println(result);
		}
	}
	
	private static long gcd(long m, long n)
	{
		long previous;
		long current;
		if(m >= n)
		{
			previous = m;
			current = n;
		}
		else
		{
			previous = n;
			current = m;
		}
		
		while(current != 0)
		{
			long temp = previous % current;
			previous = current;
			current = temp;
		}
		
		return previous;
	}

}
