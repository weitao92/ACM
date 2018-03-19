package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class LIS {
	
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
		
		int[] results = new int[num];
		Arrays.fill(results, 1);
		for(int i = 1; i < num; i++)
		{
			for(int j = 0; j < i; j++)
			{
				if(list[i] <= list[j])
				{
					continue;
				}
				else
				{
					if(results[j] + 1 > results[i])
					{
						results[i] = results[j] + 1;
					}
				}
			}
		}
		
		int max = 0;
		for(int i = 0; i < num; i++)
		{
			if(results[i] > max)
			{
				max = results[i];
			}
		}
		
		System.out.println(max);
	}

}
