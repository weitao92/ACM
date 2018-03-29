package NAQ_2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class cake {
	
	static class point
	{
		double x;
		double y;
		
		public point(double x, double y)
		{
			this.x = x;
			this.y = y;
		}
	}
	
	static double diff = 0.0001;
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int r = in.nextInt();
		
		if(n > 2*m)
		{
			System.out.println("no");
			System.exit(0);
		}
		//point[] points = new point[n];
		ArrayList<Double> points = new ArrayList<Double>();
		for(int i = 0; i < n; i++)
		{
			double x = in.nextDouble();
			double y = in.nextDouble();
			double angle = Math.atan2(y,x);
			angle = angle > 0.0 ? 180.0 * (angle / Math.PI)
					: (2*Math.PI + angle) * 360 / (2*Math.PI);
			points.add(angle);
			
			//point p = new point(x,y);
			//points[i] = p;
		}
		Collections.sort(points);
		
		ArrayList<Double> angles = new ArrayList<Double>();
		
		for(int i = 0; i < m; i++)
		{
			double a = in.nextDouble();
			double b = in.nextDouble();
			double c = in.nextDouble();
			double y = (r * a + c) / (-b); 
			double x = r;
			
			double angle = Math.atan2(y, x);
			angle = angle > 0.0 ? 180.0 * (angle / Math.PI)
					: (2*Math.PI + angle) * 360 / (2*Math.PI);
			angles.add(angle);
			if(angle >= 180)
			{
				angles.add(angle - 180.0);
			}
			else
			{
				angles.add(180.0 + angle);
			}
			
		}
		
		Collections.sort(angles);
		
		/**
		for(double p : points)
		{
			System.out.println(p);
		}
		
		System.out.println();
		
		for(double p : angles)
		{
			System.out.println(p);
		}
		**/
		
		for(int i = 0; i < angles.size(); i++)
		{
			double first;
			double second;
			boolean origin = false;
			if(i == angles.size() - 1)
			{
				first = angles.get(i);
				 second = angles.get(0);
				 
				 int count = 0;
					for(double p : points)
					{
						if((Math.abs(p - second) <= diff) ||  (Math.abs(p - first) <= diff 
								&& p < 360.0))
						{
							//System.out.println(p);
							count++;
						}
						if(p == 360.0)
						{
							origin = true;
						}
						//System.out.println(count);
						if(count >= 2)
						{
							//System.out.println(p + " here" + first + " " + second);
							System.out.println("no");
							System.exit(0);
						}
					}
					
					if(count == 0)
					{
						if(origin)
						{
							
						}
						else
						{
							//System.out.println("here");
						System.out.println("no");
						System.exit(0);
						}
					}
			}
			else
			{
				first = angles.get(i);
				second = angles.get(i+1);
				
				int count = 0;
				for(double p : points)
				{
					if(Math.abs(p - first) <= diff && Math.abs(p - second) <= diff)
					{
						count++;
					}
					if(p == 360.0)
					{
						origin = true;
					}
					
					//System.out.println(count);
					if(count >= 2)
					{
						//System.out.println(p + " here" + first + " " + second);
						System.out.println("no");
						System.exit(0);
					}
				}
				
				if(count == 0)
				{
					if(origin)
					{
						
					}
					else
					{
					//System.out.println(" here" );
					System.out.println("no");
					System.exit(0);
					}
				}
			}
			
			
		}
		
		System.out.println("yes");
	}

}
