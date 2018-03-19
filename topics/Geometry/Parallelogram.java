package Geometry;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://pcs.cs.cloud.vt.edu/contests/39/problems/B
 */
public class Parallelogram {
	
	static class point
	{
		int x;
		int y;
		
		point(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		
		public boolean equals(Object obj)
		{
			point another = (point) obj;
			return x == another.x && y == another.y;
		}
		
		public String toString()
		{
			return new String(x + " " + y);
		}
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		point[] test = new point[3];
		for(int i = 0; i < 3; i++)
		{
			int x = in.nextInt();
			int y = in.nextInt();
			test[i] = new point(x,y);
		}
		in.close();
		
		point first;
		point second;
		point third;
		point fourth1;

		ArrayList<point> results = new ArrayList<point>();
		
		first = test[0];
		second = test[1];
		third = test[2];
		
		fourth1 = new point(second.x - (third.x - first.x), second.y - (third.y - first.y));
		
			results.add(fourth1);

		
		first = test[1];
		second = test[2];
		third = test[0];
		
		fourth1 = new point(second.x - (third.x - first.x), second.y - (third.y - first.y));
		
		
		
			results.add(fourth1);

		
		first = test[0];
		second = test[2];
		third = test[1];
		
		fourth1 = new point(second.x - (third.x - first.x), second.y - (third.y - first.y));
		
		
		
			results.add(fourth1);

		
		System.out.println(3);
		for(point p : results)
		{
			System.out.println(p);
		}
		
	}

}
