package NAQ_2017;

import java.util.*;

/**
 * https://naq17.kattis.com/problems/suspensionbridges
 * @author weitao92
 *
 */
public class bridge {
	
	//static double error = 0.000000001;
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		double d = in.nextDouble();
		double s = in.nextDouble();
		
		
		double a = find(d,s);
		//int index = Arrays.binarySearch(sample, 0.0);
		
		
		
		double result = 2 * a * Math.sinh(d / (2*a));
		System.out.println(result);
	}
	
	private static double find(double d, double s)
	{
		double low = 0;
		double high = 1000000000;
		double mid = low + (high - low)/2;
		double result = mid + s - mid * Math.cosh(d / (2*mid));
		while (Math.abs(result) > Math.max(1e-12, 10* Math.ulp(result)))
		{	
			if(result < 0)
			{
				low = mid;
			}
			else
			{
				high = mid;
			}
			
			mid = low + (high - low)/2;
			result = mid + s - mid * Math.cosh(d / (2*mid));
		}
		
		return mid;
	}

}
