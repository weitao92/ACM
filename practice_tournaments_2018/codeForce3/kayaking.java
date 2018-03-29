package codeForce3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class kayaking {
	
	
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < n*2; i++)
		{
			list.add(in.nextInt());
		}
		Collections.sort(list);
		
		int max = Integer.MAX_VALUE;
		for(int i = 0; i < n*2; i++)
		{
			for(int j = i + 1; j < n*2; j++)
			{
				int sum = 0;
				int index = 0;
				int[] current = new int[2*n - 2];
				for(int x = 0; x < n*2; x++)
				{
					if(x == i || x == j)
					{
						continue;
					}
					else
					{
						current[index++] = list.get(x);
					}
				}
				
				for(int x = 0; x < n*2 -2; x+= 2)
				{
					sum += (current[x+1] - current[x]);
				}
				
				
				max = Math.min(sum, max);
			}
		}
		
		System.out.println(max);
	}

}
