package mid_atlantic_2016;

import java.util.Arrays;
import java.util.Scanner;

public class wordOrder {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		String largest = in.next();
		int n = in.nextInt();
		String[] list = new String[n];
		int size = largest.charAt(0) - 96;
		int[] union = new int[size];
		Arrays.fill(union, -1);
		//System.out.println(size);
		int max = 0;
		for(int i = 0; i < n; i++)
		{
			String next = in.next();
			list[i] = next;
			if(next.length() > max)
			{
				max = next.length();
			}
			
		}
		
		int[] ignored = new int[max];
		for(int i = 0; i < n - 1; i++)
		{
			String current = list[i];
			int same = n;
			for(int x = 0; x < current.length(); x++)
			{
				if(ignored[x] != 0 && i < ignored[x])
				{
					same = ignored[x];
					continue;
				}
				char c1 = current.charAt(x);
				boolean changed = false;
				if(same == x + 1)
				{
					break;
				}
				for(int j = i + 1; j < same; j++)
				{
					
					String next = list[j];
					if(next.length() <= x)
					{
						break;
					}
					
					char c2 = next.charAt(x);
					if(c1 == c2)
					{
						continue;
					}
					else
					{
						if(!changed)
						{
							same = j;
							changed = true;
							ignored[x] = j;
						}
						
						int index = c1 - 97;
						while(union[index] != -1)
						{
							index = union[index];
							if(index == c2 - 97)
							{
								//System.out.println(ignored[0] + " " + ignored[1] + " " + ignored[2]
										// + " " + ignored[3] + " " + ignored[4]);
								//System.out.println(next + " x: " + c2+ " " + current + " x: " + c1);
								System.out.println("IMPOSSIBLE");
								System.exit(0);
							}
						}
						union[c2 - 97] = c1 - 97;
						//same = j;
					}
				}
			}
		}
		
		
		
		
		StringBuilder result = new StringBuilder();
		int first = -1;
		int num = 0;
		for(int i = 0; i < size; i++)
		{
			if(union[i] == -1)
			{
				if(num > 0)
				{
					System.out.println("AMBIGUOUS");
					System.exit(0);
				}
				result.append((char)(97 + i));
				first = i;
				num++;
			}
		}
		//System.out.println("i am here " + result);
		while(result.length() != size)
		{
			for(int i = 0; i < size; i++)
			{
				if(union[i] == first)
				{
					result.append((char)(97 + i));
					first = i;
					break;
				}
			}
		}
		System.out.println(result);
	}

}
