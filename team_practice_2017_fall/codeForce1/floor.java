package codeForce1;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * codeforce 861B.
 * 
 * @author weitao92
 *
 */
public class floor {
	
	static class flat implements Comparable<flat>
	{
		int flat;
		int floor;
		
		public flat(int f, int l)
		{
			flat = f;
			floor = l;
		}
		@Override
		public int compareTo(flat o) {
			if(flat < o.flat)
			{
				return -1;
			}
			else if(flat == o.flat)
			{
				return 0;
			}
			else
			{
				return 1;
			}
		}
		
	}
	
	public static void main(String agrs[])
	{
		Scanner in = new Scanner(System.in);
		int target = in.nextInt();
		int m = in.nextInt();
		ArrayList<flat> list = new ArrayList<flat>();
		
		if(m == 0)
		{
			if(target == 1)
			{
				System.out.println("1");
			}
			else
			{
				System.out.println("-1");
			}
			System.exit(0);
		}
		
		for(int i = 0; i < m; i++)
		{
			flat a = new flat(in.nextInt(), in.nextInt());
			list.add(a);
		}
		
		in.close();
		
		Collections.sort(list);
		TreeSet<Integer> candidates = new TreeSet<Integer>();
		ArrayList<Integer> remove = new ArrayList<Integer>();
		flat first = list.get(0);
		if(first.floor != 1)
		{
			int gap = test(first.flat, first.floor);
			candidates.add(gap);
			
			int can = gap + 1;
			while(can < first.flat)
			{
				if(can * (first.floor - 1) >= first.flat)
				{
					break;
				}
				else
				{
					candidates.add(can);
					can++;
				}
			}				
		}
		else
		{
			flat second = null;
			
			for(int i = 1; i < list.size(); i++)
			{
				flat a = list.get(i);
				if(a.floor != 1)
				{
					second = a;
					first = list.get(i - 1);
					break;
				}
			}
			
			//candidates.add(first.flat);
			if(second == null)
			{
				if(target <= list.get(list.size()-1).flat)
				{
				System.out.println("1");
				
				}
				else
				{
					System.out.println("-1");
				}
				System.exit(0);
			}
			else
			{
				//candidates.add(first.flat);
				int can = first.flat;
				
				while(can < second.flat)
				{
					int result = test(second.flat, can);
					if(result == second.floor)
					{
						candidates.add(can);
						//System.out.println(can);
						can++;
					}
					else if(result < second.floor)
					{
						break;
					}
					else
					{
						can++;
					}
				}
			}
		}
		//set.addAll(candidates);
		
		for(int i = 1; i < list.size(); i++)
		{
			if(candidates.size() == 0)
			{
				System.out.println("-1");
				System.exit(0);
			}
			flat f = list.get(i);
			
			for(int c : candidates)
			{
				if(test(f.flat, c) == f.floor)
				{
					continue;
				}
				else
				{
					remove.add(c);
				}
			}
			
			candidates.removeAll(remove);
		}
		
		TreeSet<Integer> results = new TreeSet<Integer>();
		if(candidates.size() > 1)
		{
			for(int i : candidates)
			{
				results.add(test(target, i));
			}
			
			if(results.size() > 1)
			{
				System.out.println("-1");
			}
			else
			{
				System.out.println(results.first());
			}
		}
		else
		{
			System.out.println(test(target,candidates.first()));
		}
	}
	
	private static int test(int fa, int fl)
	{
		int result = 0;
		if(fa % fl == 0)
		{
			result = fa / fl;
		}
		else
		{
			result = fa/fl + 1;
		}
		
		return result;
	}

}
