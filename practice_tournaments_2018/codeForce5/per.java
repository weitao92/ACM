package codeForce5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class per {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		int[] list = new int[n];
		//TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
		int[] counts = new int[n];
		boolean[] contains = new boolean[n];
		boolean[] firstList = new boolean[n];
		int result = 0;
		for(int i = 0; i < n; i++)
		{
			int value = in.nextInt();
			list[i] = value;
			contains[value-1] = true;
			counts[value - 1]++;
			if(counts[value-1] > 1)
			{
				result++;
			}
		}
		
		
		ArrayDeque<Integer> mins = new ArrayDeque<Integer> ();
		
		//int min = -1;
		for(int i = 0; i < n; i++)
		{
			if(!contains[i])
			{
				mins.addLast(i+1);
			}
		}
		
		for(int i = 0; i < n; i++)
		{
			int current = list[i];
			if(counts[current-1] > 1)
			{
				int min = mins.getFirst();
				if(!firstList[current-1])
				{
				//map.get(current).re
					
					if(min < current)
					{
						list[i] = min;
						counts[current-1]--;
						mins.removeFirst();
						//firstList[current-1] = true;
					}
					else
					{
						firstList[current-1] = true;
						continue;
					}
				}
				else
				{
					list[i] = min;
					counts[current-1]--;
					mins.removeFirst();
				}
			}
		}
		
		System.out.println(result);
		StringBuilder result1 = new StringBuilder();
		for(int i = 0; i < n; i++)
		{
			result1.append(list[i] + " ");
		}
		result1.deleteCharAt(result1.length()-1);
		System.out.println(result1);
	}

}
