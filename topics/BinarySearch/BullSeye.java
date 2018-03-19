package BinarySearch;

import java.util.Scanner;

/**
 * https://pcs.cs.cloud.vt.edu/problems/58
 */
public class BullSeye {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
	
	    long num = in.nextLong();
	    
	    for(long i = 1; i <= num; i++)
	    {
	    	in.nextLine();
	    	long r = in.nextLong();
	    	long t = in.nextLong();
	    	long result = calculate(r, t);
	    	//Case #x: y
	    	System.out.println("Case #" + i + ": " + result);
	    }
	    
	    in.close();
	}
	
	private static long calculate(long r, long t)
	{
		long sum = 1 + 2*r;
		long n = 1;
		while(sum < t)
		{
			n = n*2;
			sum = (2*n*n - n) + 2*r*n;
		}
		
		//System.out.println("n " + n + "sum " + sum);
		return binarySearch(n/2, n, t, r);
	}
	
	private static long binarySearch(long low, long high, long key, long r)
	{
		while(high >= low)
		{
			long mid = (low + high) / 2;
			long more = mid + 1;
			long sumMore = (2*more*more - more) + 2*r*more;
			long sum = (2*mid*mid - mid) + 2*r*mid;
			
			if(sum == key)
			{
				return mid;
			}
			else if(sum < key)
			{
				if(sumMore > key)
				{
					return mid;
				}
				else
				{
					low = mid + 1;
				}
			}
			else
			{
				high = mid - 1;
			}
			
		}
		
		return 0;
	}

}
