package PrefixSum;

import java.util.Scanner;

public class mollysChemical {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		boolean negative;
		if(k >= 0)
		{
			negative = false;
		}
		else
		{
			negative = true;
			k = Math.abs(k);
		}
		long[] sum = new long[n];
		
		for(int i = 0; i < n; i++)
		{
			sum[i] = in.nextLong();
			if(i > 0)
			{
				sum[i] += sum[i-1];
			}
		}
		in.close();
		long num = 0;
		for(int i = 0; i < n; i++)
		{
			for(int j = i; j < n; j++)
			{
				long current = sum[j];
				if(i > 0)
				{
					current -= sum[i-1];
				}
				
				if(!negative)
				{
					if(current < 0)
					{
						continue;
					}
					else if(current == 0)
					{
						if(k == 0)
						{
							num++;
							continue;
						}
						else
						{
							continue;
						}
					}
					else
					{
						if(k == 0)
						{
							continue;
						}
						if(current == 1 && k == 1)
						{
							num++;
							continue;
						}
						else if(current == 1)
						{
							num++;
							continue;
						}
						else if(k == 1)
						{
							continue;
						}
						
						double result = Math.log((double)current) / Math.log((double)k);
						//System.out.println(current + " " + result);
						if(result % 1 == 0 && result >= 0)
						{
							num++;
							continue;
						}
					}
				}
				else
				{
					if(current > 0)
					{
						double first = Math.log((double)current);
						double second = Math.log((double)k);
						double result;
						if(first == second)
						{
							if(first != 0)
							{
								continue;
							}
							else
							{
								num++;
								continue;
							}
						}
						else
						{
							result = first / second;
						}
						//System.out.println(current + " " + result);
						if(result % 1 == 0 && result >= 0 && result % 2 == 0)
						{
							num++;
							continue;
						}
					}
					else if(current == 0)
					{
						continue;
					}
					else
					{
						current = Math.abs(current);
						double first = Math.log((double)current);
						double second = Math.log((double)k);
						double result;
						if(first == second)
						{
							result = 1;
							num++;
							continue;
						}
						else
						{
							result = first / second;
						}
						
						//System.out.println(current + " " + result);
						if(result % 1 == 0 && result >= 0 && result % 2 == 1)
						{
							num++;
							continue;
						}
					}
				}
			}
		}
		System.out.println(num);
	}

}
