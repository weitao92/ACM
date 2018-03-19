package Primes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * https://pcs.cs.cloud.vt.edu/contests/65/problems/C
 * @author weitao92
 *
 */
public class C {
	
	static ArrayList<Long> list;
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		list = new ArrayList<Long>();
		int[] primes = new int[n];
		for(int i = 0; i < n; i++)
		{
			int current = in.nextInt();
			ArrayList<Long> tempList = new ArrayList<Long>();
			for(long temp : list)
			{
				tempList.add(temp*current);
			}
			list.add((long)current);
			list.addAll(tempList);
		}
		list.add(1l);
		Collections.sort(list);
		for(long temp : list)
		{
			System.out.print(temp + " ");
		}
	}

}
