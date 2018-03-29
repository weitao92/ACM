package holidayContest;

import java.util.*;

public class A {
	
	static class point
	{
		double x;
		double y;
		
		public point(double a, double b)
		{
			x = a;
			y = b;
		}
		
		public boolean equals(Object o)
		{
			point another = (point)o;
			return another.x == x && another.y == y;
		}
		
		public int hashCode()
		{
			return (int) (x*10000000 + y*1);
		}
	}
	
	static class line
	{
		double m;
		double b;
		
		public line(double a, double b)
		{
			m = a;
			this.b = b;
		}
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<line> lines = new ArrayList<line>();
		for(int i = 0; i < n; i++)
		{
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			int x2 = in.nextInt();
			int y2 = in.nextInt();
			
			
		}
	}

}
