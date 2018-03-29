package microsoft;

import java.util.ArrayList;
import java.util.Scanner;

public class ski {
	
	static class gate
	{
		int upper;
		int lower;
		
		public gate(int a, int b)
		{
			if(a >= b)
			{
				upper = a;
				lower = b;
			}
			else
			{
				upper = b;
				lower = a;
			}
		}
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		for(int i = 0; i < n; i++)
		{
			int m = in.nextInt();
			int start = in.nextInt();
			ArrayList<gate> gates = new ArrayList<gate>();
			for(int j = 0; j < m; j++)
			{
				int first = in.nextInt();
				int second = in.nextInt();
				gate g = new gate(first, second);
				gates.add(g);
			}
			
			double result = 0;
			boolean finished = false;
			int index = 0;
			while(index != m)
			{
				//int index = 0;
				int addition = 0;
				while(success(gates, index, start))
				{
					index++;
					addition++;
				}
				
				if(addition == 0)
				{
					int d1 = Math.abs(gates.get(index).upper - start);
					int d2 = Math.abs(gates.get(index).lower - start);
					int y = 0;
					if(d1 <= d2)
					{
						y = d1;
						start = gates.get(index).upper;
					}
					else
					{
						y = d2;
						start = gates.get(index).lower;
					}
					
					int x = 1;
					double add1 = Math.sqrt(x*x + y*y);
					result += add1;
					continue;
				}
				index--;
				int x = addition;
				int d1 = Math.abs(gates.get(index).upper - start);
				int d2 = Math.abs(gates.get(index).lower - start);
				int y = 0;
				if(d1 <= d2)
				{
					y = d1;
					start = gates.get(index).upper;
				}
				else
				{
					y = d2;
					start = gates.get(index).lower;
				}
				
				double add1 = Math.sqrt(x*x + y*y);
				result += add1;
				index++;
				System.out.println(index + " " + add1);
			}
			
			System.out.println(result);
		}
	}
	
	private static boolean success(ArrayList<gate> gates, int index, int start)
	{
		if(index >= gates.size())
		{
			return false;
		}
		int d1 = Math.abs(gates.get(index).upper - start);
		int d2 = Math.abs(gates.get(index).lower - start);
		int y = 0;
		if(d1 <= d2)
		{
			y = gates.get(index).upper;
		}
		else
		{
			y = gates.get(index).lower;
		}
		for(int i = 0; i < index; i++)
		{
			double frac = 1/(index + 1);
			int distance1 = y - start;
			double limit = distance1 * frac;
			if(limit > 0)
			{
				if(gates.get(i).lower - start > limit || gates.get(i).upper - start > limit)
				{
					return false;
				}
			}
			else
			{
				if(start - gates.get(i).upper > Math.abs(limit) || gates.get(i).lower > start + limit)
				{
					return false;
				}
			}
		}
		
		return true;
	}

}
