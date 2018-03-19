package Geometry;

import java.util.Scanner;

/**
 * https://pcs.cs.cloud.vt.edu/contests/40/problems
 */
public class WaterCup {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int d = in.nextInt(); //diameter of cup
		int h = in.nextInt(); //initial level of water height
		int v = in.nextInt(); //drinking speed
		int e = in.nextInt(); //rain speed
		in.close();
		
		double area = Math.pow((double)d/2, 2) * Math.PI;
		if(area * e >= v)
		{
			System.out.println("NO");
		}
		else
		{
			double heightS = (v - area * e) / area;
			System.out.println("YES");
			System.out.println(h/heightS);
		}
	}

}
