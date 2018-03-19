package MATH;

import java.util.Arrays;
import java.util.Scanner;

public class numOfprime {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int target = in.nextInt();
		in.close();
		boolean[] numbers = new boolean[target+1];
		Arrays.fill(numbers, true);
		int result = 0;
		
		for(int i = 2; i <= target; i++)
		{
			if(numbers[i])
			{
				if(isPrime(i))
				{
					result++;
					clear(numbers, i, target);
				}
			}	
		}
		
		System.out.println(result);
	}
	
	private static void clear(boolean[] numbers, int prime, int target)
	{
		for(int i = 1; i*prime <= target; i++)
		{
			numbers[i*prime] = false;
		}
	}
	
	private static boolean isPrime(int n)
	{
		for(int i = 2; i*i <= n; i++)
		{
			if(n % i == 0)
			{
				return false;
			}
		}
		
		return true;
	}

}
