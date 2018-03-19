package Greedy;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * https://open.kattis.com/problems/bank
 * @author weitao92
 *
 */
public class bankQueue {
	
	static class people implements Comparable<people>
	{
		int index;
		long c;
		int time;
		
		public people(int i, long cash, int t)
		{
			index = i;
			c = cash;
			time = t;
		}
		
		@Override
		public int compareTo(people o) {
			if(c == o.c)
			{
				return Integer.compare(time, o.time);
			}
			else
			{
				return -Long.compare(c, o.c);
			}
		}
		
		public boolean equals(Object o)
		{
			people another = (people)o;
			return index == another.index;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int time = in.nextInt();
		PriorityQueue<people>[] queue = new PriorityQueue[time];
		for(int i = 0; i < time; i++)
		{
			queue[i] = new PriorityQueue<people>();
		}
		
		TreeSet<people> set = new TreeSet<people>();
		for(int i = 0; i < n; i++)
		{
			long c = in.nextLong();
			int t = in.nextInt();
			people p = new people(i,c,t);
			set.add(p);
			
			for(int j = 0; j <= t; j++)
			{
				queue[j].add(p);
			}
		
		}
		
		in.close();
		long result = 0;
		for(int i = time - 1; i >= 0; i--)
		{
			
			while(!queue[i].isEmpty())
			{
				people current = queue[i].poll();
				if(set.contains(current))
				{
					result += current.c;
					set.remove(current);
					break;
				}
			}
		}
		
		System.out.println(result);
	}

}
