package codeForce3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class tv {
	
	static class pair
	{
		int f;
		int s;
		
		public pair(int first, int second)
		{
			f = first;
			s = second;
		}
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		ArrayList<pair> list = new ArrayList<pair>();
		for(int i = 0; i < n; i++)
		{
			int first = in.nextInt();
			int second = in.nextInt();
			pair p = new pair(first, second);
			list.add(p);
			
			for(int j = first; j <= second; j++)
			{
				if(map.containsKey(j))
				{
					map.put(j, map.get(j) + 1);
				}
				else
				{
					map.put(j, 1);
				}
			}
		}
		
		for(int i = 0; i < list.size(); i++)
		{
			boolean reduntent = true;
			pair p = list.get(i);
			
			for(int j = p.f; j <= p.s; j++)
			{
				if(map.get(j) == 1)
				{
					reduntent = false;
					break;
				}
			}
			
			if(reduntent)
			{
				System.out.println(i+1);
				System.exit(0);
			}
		}
		
		System.out.println("-1");
	}

}
