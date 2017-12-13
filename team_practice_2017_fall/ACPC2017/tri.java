package ACPC2017;

import java.util.Scanner;

public class tri {
	
	//static double error = 0.000001;
	static double y;
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		y = in.nextDouble();
		double low = Math.pow(Math.E, -Math.E);
		double high = Math.pow(Math.E, 1/Math.E);
		
		double x = cal(low, high);
		System.out.println(x);
	}
	
	private static double cal(double low, double high)
	{
		//double mid = low + (high - low)/2;
		
		
		while(true)
		{
			double mid = low + (high - low)/2;
			double result = Math.pow(mid, y);
			if(Math.abs(result - y) <= 0.0000000001)
			{
				return mid;
			}
			else
			{
				if(result > y)
				{
					high = mid;
				}
				else
				{
					low = mid;
				}
			}
		}
	}

}
