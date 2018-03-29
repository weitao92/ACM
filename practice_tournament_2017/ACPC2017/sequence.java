package ACPC2017;

import java.util.*;

public class sequence {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
		{
			arr[i] = in.nextInt();
		}
		
		int q = in.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < q; i++)
		{
			int start = in.nextInt() - 1;
			int num = in.nextInt();
			HashSet<Integer> set = new HashSet<Integer>();
			for(int j = 0; j < num; j++)
			{
				set.add(in.nextInt());
			}
			
			int length = 0;
			for(int index = start; index < n; index++)
			{
				if(set.contains(arr[index]))
				{
					length++;
				}
				else
				{
					break;
				}
			}
			
			sb.append(length + "\n");
		}
		
		System.out.print(sb);
	}

}
