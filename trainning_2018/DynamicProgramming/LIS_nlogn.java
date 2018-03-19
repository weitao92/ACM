package DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LIS_nlogn {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int[] list = new int[num];
		for(int i = 0; i < num; i++)
		{
			list[i] = in.nextInt();
		}
		in.close();
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i < num; i++)
		{
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
		
		System.out.println(result.size());
	}

}
