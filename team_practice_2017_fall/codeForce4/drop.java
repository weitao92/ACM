package codeForce4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

public class drop {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Long> constant = new ArrayList<Long>();
		long p  = in.nextLong();
		long q = in.nextLong();
		long r = in.nextLong();
		
		
		long[] values = new long[n];
		
		for(int i = 0; i < n; i++)
		{
			long value = in.nextLong();
			values[i] = value;
		}
		
		long[] P = new long[n];
		P[0] = p * values[0];
		long max = p*values[0];
		for(int i = 1; i < n; i++)
		{
			long current = p * values[i];
			if(current > max)
			{
				max = current;
				P[i] = max;
			}
			else
			{
				P[i] = max;
			}
		}
		
		long[] Q = new long[n];
		max = P[0] + q*values[0];
		Q[0] = max;
		for(int i = 1; i < n; i++)
		{
			long current = q * values[i] + P[i];
			if(current > max)
			{
				max = current;
				Q[i] = max;
			}
			else
			{
				Q[i] = max;
			}
		}
		
		long[] R = new long[n];
		max = Q[0] + r*values[0];
		R[0] = max;
		for(int i = 1; i < n; i++)
		{
			long current = r * values[i] + Q[i];
			if(current > max)
			{
				max = current;
				R[i] = max;
			}
			else
			{
				R[i] = max;
			}
		}
		
		System.out.println(R[n-1]);
		
	}

}