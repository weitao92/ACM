package practice2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class duplicate {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		String text = in.next();
		in.close();
		int length = text.length();
		HashSet<String> set = new HashSet<String>();
		ArrayList<Integer> intervals = new ArrayList<Integer>();
		
		for(int i = 3; i < length; i++)
		{
			for(int j = 0; j < length - i; j++)
			{
				String pat = text.substring(j, j + i);
				int previous = j;
				if(!set.contains(pat))
				{
					set.add(pat);
					
					for(int k = j + 1; k <= length - i; k++)
					{
						String tar = text.substring(k, k + i);
						if(pat.equals(tar))
						{
							int interval = k - previous;
							System.out.println("first: " + previous + " second: " + k + " interval: "
									 + interval + " String: " + tar);
							intervals.add(interval);
							previous = k;
						}
					}
				}
				else
				{
					continue;
				}	
			}
		}
		
		int ans = intervals.get(0);
		for(int i : intervals)
		{
			System.out.println(i);
			ans = gcd(ans, i);
		}
		//System.out.println(ans);
		
		char[] sample = text.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int len = 0;
		
			for(int i = 4; i < sample.length; i+= 5)
			{
				len++;
				char c = sample[i];
				if(map.containsKey(c))
				{
					int value = map.get(c);
					map.put(c,  value + 1);
				}
				else
				{
					map.put(c, 1);
				}
			}
		
		
		double result = 0;
		for(int i = 65; i <= 90; i++)
		{
			char c = (char)i;
			Integer frequency = map.get(c);
			if(frequency != null)
			{
				System.out.println("for character " + c + " : the frequence in column 1 is: " 
					+ frequency);
				double first = combination(frequency, 2);
				double second = combination(len, 2);
				double third = first / second;
				result += third;
			}
		}
		
		System.out.println("the result for column 1 is: " + result);
	}
	
	private static int gcd(int a, int b)
	{
		int previous;
		int current;
		
		if(a >= b)
		{
			previous = a;
			current = b;
		}
		else
		{
			previous = b;
			current = a;
		}
		
		while(current != 0)
		{
			int temp = previous % current;
			previous = current;
			current = temp;
		}
		
		return previous;
	}
	
	private static double combination(int m, int n)
	{
		int difference = m - n;
		int bigger;
		int smaller;
		
		if(difference >= n)
		{
			bigger = difference;
			smaller = n;
		}
		else
		{
			bigger = n;
			smaller = difference;
		}
		
		int first = 1;
		for(int i = bigger + 1; i <= m; i++)
		{
			first = first * i;
		}
		
		int second = 1;
		for(int i = 1; i <= smaller; i++)
		{
			second = second * i;
		}
		
		return first / second;
	}
}