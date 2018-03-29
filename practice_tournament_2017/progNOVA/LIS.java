package progNOVA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LIS {
	
	static int[] list;
	static int num;
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		num = in.nextInt();
		list = new int[num];
		for(int i = 0; i < num; i++)
		{
			list[i] = in.nextInt();
		}
		in.close();
		int max = cal();
		ArrayList<Integer> results = new ArrayList<Integer>();
		for(int i = 0; i < num; i++)
		{
			int c = list[i];
			list[i] = -1;
			int current = cal();
			list[i] = c;
			if(current < max)
			{
				results.add(c);
			}
		}
		
		if(results.isEmpty())
		{
			System.out.println("-1");
			System.exit(0);
		}
		
		Collections.sort(results);
		for(int i : results)
		{
			System.out.print(i + " ");
		}
		System.out.println();
		
		//System.out.println(max);
	}
	
	private static int cal()
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i < num; i++)
		{
			if(list[i] == -1)
			{
				continue;
			}
			int position = Collections.binarySearch(result, list[i]);
			if(position >= 0)
			{
				continue;
			}
			else
			{
				position = -position - 1;
				if(position == result.size())
				{
					result.add(list[i]);
				}
				else//first element in the list bigger than list[i], replace it.
				{
					result.set(position, list[i]);
				}
			}
		}
		
		return result.size();
	}

}
