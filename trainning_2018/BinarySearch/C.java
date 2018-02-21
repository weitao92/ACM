package BinarySearch;

import java.util.*;

/**
 * https://pcs.cs.cloud.vt.edu/contests/67/problems/C
 * @author weitao92
 *
 */
public class C {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		double height = in.nextDouble();
		double width = in.nextDouble();
		
		double target = height*2/9.81;
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
		double time = high;
		double velocity = width/time;
		target = velocity;
		low = 0;
		high = target;
		
		while(high - low > Math.ulp(high)*10)
		{
			double mid = (low+high)/2;
			double temp = 2*Math.pow(mid,5) + 3*Math.pow(mid,4) + mid;
			if(temp < target)
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
