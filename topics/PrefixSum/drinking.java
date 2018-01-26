package PrefixSum;

import java.util.Arrays;
import java.util.Scanner;

public class drinking {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] prices = new int[n];
		
		for(int i = 0; i < n; i++)
		{
			prices[i] = in.nextInt();
		}
		
		Arrays.sort(prices);
		
		int m = in.nextInt();
		int results[] = new int[m];
		
		for(int i = 0; i < m; i++)
		{
			int money = in.nextInt();
			int index = Arrays.binarySearch(prices, money);
			if(index < 0)
			{
				index = (-index) - 1;
			}
			else
			{
				while(index < n && prices[index] == money)
				{
					index++;
				}
			}
			results[i] = index;
		}
		in.close();
		
		for(int i : results)
		{
			System.out.println(i);
		}
	}

}
