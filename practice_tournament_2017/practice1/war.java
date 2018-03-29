package practice1;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class war {
	
	static class city implements Comparable<city>
	{
		int name;
		int troop;
		
		city(int name, int troop)
		{
			this.name = name;
			this.troop = troop;
		}

		@Override
		public int compareTo(city o) {
			if(troop < o.troop)
			{
				return -1;
			}
			else if(troop == o.troop)
			{
				return 0;
			}
			else
			{
				return 1;
			}
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int k = in.nextInt();
		
		int[] troops = new int[num];
		ArrayList<city> cities = new ArrayList<city>(num);
		LinkedList<Integer>[] gragh = new LinkedList[num];
		for(int i = 0; i < num; i++)
		{
			gragh[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < num; i++)
		{
			int troop = in.nextInt();
			city c = new city(i, troop);
			cities.add(c);
			troops[i] = troop;
			int neighbor = in.nextInt();
			for(int j = 0; j < neighbor; j++)
			{
				gragh[i].add(in.nextInt());
			}
		}
		
		for(int i = 0; i < num; i++)
		{
			LinkedList<Integer> neighbors = gragh[i];
			for(int j : neighbors)
			{
				cities.get(i).troop += troops[j];
			}
		}
		
		//Collections.sort(cities);
		
		while(true)
		{
			boolean finished = true;
			
			for(int i = 0; i < num; i++)
			{
				city c = cities.get(i);
				if(c == null)
				{
					continue;
				}
				else
				{
					if(c.troop < k)
					{
						finished = false;
						cities.set(i, null);
						LinkedList<Integer> neighbors = gragh[i];
						for(int j : neighbors)
						{
							if(cities.get(j) != null)
							{
								cities.get(j).troop -= troops[i];
							}
						}
					}
				}
			}
			
			if(finished)
			{
				break;
			}
		}
		
		int result = 0;
		int sum = 0;
		for(int i = 0; i < num; i++)
		{
			if(cities.get(i) != null)
			{
				result++;
				sum += troops[i];
			}
		}
		
		System.out.println(result + " " + sum);
		
		in.close();
	}

}
