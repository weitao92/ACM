package Geometry;

import java.util.Scanner;

public class ArrowGame {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		double px = in.nextInt();
		double py = in.nextInt();
		double vx = in.nextInt();
		double vy = in.nextInt();
		double a = in.nextInt();
		double b = in.nextInt();
		double c = in.nextInt();
		double d = in.nextInt();
		in.close();
		
		point p1 = new point((double)px, (double)py + b);
		point p2 = new point((double)px - a/2, (double)py);
		point p3 = new point((double)px - c/2, (double)py);
		point p4 = new point((double)px - c/2, (double)py - d);
		point p5 = new point((double)px + c/2, (double)py - d);
		point p6 = new point((double)px + c/2, (double)py);
		point p7 = new point((double)px + a/2, (double)py);
		
		double theta = Math.atan2(vy, vx) - Math.PI/2; // minus pi/2 cuz the origin is vertical.
		p1.rotate(theta,px,py);
		p2.rotate(theta,px,py);
		p3.rotate(theta,px,py);
		p4.rotate(theta,px,py);
		p5.rotate(theta,px,py);
		p6.rotate(theta,px,py);
		p7.rotate(theta,px,py);
		
		//System.out.println(Math.atan2(0.0, 7.0));
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
		System.out.println(p5);
		System.out.println(p6);
		System.out.println(p7);	
	}
	
	static class point
	{
		double x;
		double y;
		
		public point(double x, double y)
		{
			this.x = x;
			this.y = y;
		}
		
		/**
		 * first put the point to origin, then rotate.
		 * @param theta
		 * @param px
		 * @param py
		 */
		public void rotate(double theta, double px, double py)
		{
			x -= px;
			y -= py;
			double mag = Math.hypot(x, y);
			double origin = Math.atan2(y, x);
			double newAngle = origin + theta;
			x = mag * Math.cos(newAngle);
			y = mag * Math.sin(newAngle);
			x += px;
			y += py;
			
		}
		
		public String toString()
		{
			return x + " " + y;
		}
	}

}
