package Geometry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * https://pcs.cs.cloud.vt.edu/problems/240
 */
public class levee {
	
	static class cood implements Comparable<cood>
	{
		double area;
		double peri;
		
		public cood(double area, double peri)
		{
			this.area = area;
			this.peri = peri;
		}

		@Override
		public int compareTo(cood o) {
			if (Math.abs(area - o.area) < 0.001) {
	            return Double.compare(peri, o.peri);
	        }
	        return Double.compare(area, o.area);
		}
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		while(true)
		{
			
			double x1 = in.nextDouble();
			double y1 = in.nextDouble();
			double x2 = in.nextDouble();
			double y2 = in.nextDouble();
			double x3 = in.nextDouble();
			double y3 = in.nextDouble();
			double x4 = in.nextDouble();
			double y4 = in.nextDouble();
			
			if(x1 == 0.0 && y1 == 0.0 && x2 == 0.0 && y2 == 0.0 && x3 == 0.0 && y3 == 0.0
					&& x4 == 0.0 && y4 == 0.0)
			{
				in.close();
				System.exit(0);
			}
			else
			{
				double x = 0, y = 0, b1 = 0, m1 = 0, b2 = 0, m2 = 0;
				boolean e1 = false, e2 = false;
				
				if(x3 - x1 == 0)
				{
					e1 = true;
					x = x1;
				}
				else
				{
					m1 = (y3 - y1) / (x3 - x1);
					b1 = (y1 - m1 * x1);
				}
				
				
				if(x4 - x2 == 0)
				{
					e2 = true;
					x = x2;
				}
				else
				{
					m2 = (y4 - y2) / (x4 - x2);
					b2 = (y2 - m2 * x2);
				}
				
				if(!e1 && !e2)
				{
					x = (b2 - b1) / (m1 - m2);
				
					y = x * m1 + b1;
				}
				else if(e1)
				{
					y = m2 * x + b2;
				}
				else if(e2)
				{
					y = m1 * x + b1;
				}
				
				/**
				ArrayList<double> perimeters = new ArrayList<double>();
				perimeters.add(perimeter(x1,y1,x2,y2,x,y));
				perimeters.add(perimeter(x2,y2,x3,y3,x,y));
				perimeters.add(perimeter(x3,y3,x4,y4,x,y));
				perimeters.add(perimeter(x4,y4,x1,y1,x,y));
				Collections.sort(perimeters);
				**/
				
				ArrayList<cood> coods = new ArrayList<cood>();
				coods.add(area(x1,y1,x2,y2,x,y));
				coods.add(area(x2,y2,x3,y3,x,y));
				coods.add(area(x3,y3,x4,y4,x,y));
				coods.add(area(x4,y4,x1,y1,x,y));
				Collections.sort(coods);
				
				for(int i = 3; i >= 0; i--)
				{
					System.out.printf("%.3f", coods.get(i).area);
					System.out.print(" ");
					System.out.printf("%.3f", coods.get(i).peri);
					System.out.print(" ");
				}
				System.out.println();
			}
		}
	}
	
	private static double perimeter(double x1, double y1, double x2, double y2, double x, double y)
	{
		double l1 = (double) Math.sqrt((( x2 - x1 ) * ( x2 - x1 )) + (( y2 - y1 ) * ( y2 - y1 )));
		double l2 = (double) Math.sqrt((( x - x1 ) * ( x - x1 )) + (( y - y1 ) * ( y - y1 )));
		double l3 = (double) Math.sqrt((( x - x2 ) * ( x - x2 )) + (( y - y2 ) * ( y - y2 )));
		return l1 + l2 + l3;
	}
	
	private static cood area(double x1, double y1, double x2, double y2, double x, double y)
	{
		double l1 = Math.sqrt((Math.abs( x2 - x1 ) * Math.abs( x2 - x1 )) + (Math.abs( y2 - y1 ) * Math.abs( y2 - y1 )));
		double l2 = Math.sqrt((Math.abs( x - x1 ) * Math.abs( x - x1 )) + (Math.abs( y - y1 ) * Math.abs( y - y1 )));
		double l3 = Math.sqrt((Math.abs( x - x2 ) * Math.abs( x - x2 )) + (Math.abs( y - y2 ) * Math.abs( y - y2 )));
		double s = (l1 + l2 + l3) / 2;
		double area = Math.sqrt(s * Math.abs(s-l1) * Math.abs(s-l2) * Math.abs(s-l3));
		double peri = l1 + l2 + l3;
		return new cood(area, peri);
	}

}