package BinarySearch;

import java.util.Scanner;

/**
 * https://pcs.cs.cloud.vt.edu/contests/67/problems
 * @author weitao92
 *
 */
public class A {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		double target = in.nextDouble();
		
		double low = 0;
		double high = target;
		
		while(high - low > Math.ulp(high)*10)
		{
			double mid = (low+high)/2;
			if(Math.pow(mid, 2) < target)
			{
				low = mid;
			}
			else
			{
				high = mid;
			}
		}
		
		System.out.println(high);
	}

}
