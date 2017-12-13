package NAQ_2017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/imperfectgps
 * @author weitao92
 *
 */
public class gps {
	
	static class position
	{
		double x;
		double y;
	
		public position(double a, double b)
		
		{
			x = a;
			y = b;
		}
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int t = in.nextInt();
		
		double result = 0.0;
		position[] ps = new position[n];
		int[] times = new int[n];
		int record = 0;
		int max = 0;
		double[] ds = new double[n-1];
		for(int i = 0; i < n; i++)
		{
			double x = in.nextDouble();
			double y = in.nextDouble();
			int time = in.nextInt();
			if(time > max)
			{
				max = time;
			}
			times[i] = time;
			position p = new position(x,y);
			ps[i] = p;
			
			if(i > 0)
			{
				double tx = x - ps[i-1].x;
				double ty = y - ps[i-1].y;
				double distance = Math.hypot(tx, ty);
				result += distance;
				ds[i-1] = distance;
			}
		}
		
		position[] positions = new position[max + 1];
		positions[0] = ps[0];
		ArrayList<position> ps1 = new ArrayList<position>();
		ps1.add(ps[0]);
		//int initial = 0;
		double mis = 0;
		for(int initial = t; initial <= max; initial+= t)
		{
			
			int index = Arrays.binarySearch(times, initial);
			if(index < 0)
			{
				index = -index - 1;
			}
			
			int first = times[index-1];
			int second = times[index];
			
			position p1 = ps[index-1];
			position p2 = ps[index];
			
			double distance = ds[index - 1];
			int temp = initial - times[index - 1];
			double frac = (double)temp / (second - first);
			position np = new position(p1.x + (p2.x - p1.x)*frac, p1.y + (p2.y - p1.y)*frac);
			ps1.add(np);
			//mis += distance * frac;
		}
		
		ps1.add(ps[ps.length-1]);
		
		for(int i = 1; i < ps1.size(); i++)
		{
			position first = ps1.get(i);
			position prev = ps1.get(i-1);
			double distance = Math.hypot(first.x - prev.x, first.y - prev.y);
			mis += distance;
		}
		//System.out.println(result);
		//System.out.println(mis);
		
		double last = (result - mis) / result;
		last = last * 100;
		System.out.println(last);
	}

}
