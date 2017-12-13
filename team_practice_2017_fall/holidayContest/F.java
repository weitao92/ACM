package holidayContest;

import java.util.*;

public class F {
	
	static class seg
	{
		int min;
		int max;
		double tL;
		double tH;
		boolean rest;
		
		double m;
		double b;
		
		public seg(int l, int h, double t1, double t2)
		{
			min = l;
			max = h;
			tL = t1;
			tH = t2;
			if(l == h)
			{
				rest = true;
			}
			else
			{
				rest = false;
				m = (max - min) / (tH - tL);
				b = min - m * tL;
			}
		}
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		ArrayList<seg> ascent = new ArrayList<seg>();
		ArrayList<seg> descent = new ArrayList<seg>();
		
		int min = 0;
		double tmin = 0;
		for(int i = 0; i < a; i++)
		{
			int height = in.nextInt();
			int time = in.nextInt();
			
			ascent.add(new seg(min, min+height, tmin, tmin + time));
			min = min+height;
			tmin = tmin + time;
		}
		
		int max = min;
		double tmax = 0;
		for(int i = 0; i < b; i++)
		{
			int height = in.nextInt();
			int time = in.nextInt();
			
			descent.add(new seg(max, max - height, tmax, tmax + time));
			max = max - height;
			tmax = tmax + time;
		}
		
		double gap = 0.0001;
		int index1 = 0;
		int index2 = 0;
		for(double i = gap; i <= tmax; i+=gap)
		{
			double heightA;
			double heightB;
			seg first = ascent.get(index1);
			if(i >= first.tL && i <= first.tH)
			{
				if(first.rest)
				{
					heightA = first.min;
				}
				else
				{
					heightA = i * first.m + first.b;
				}
			}
			else
			{
				index1++;
				first = ascent.get(index1);
				
				if(first.rest)
				{
					heightA = first.min;
				}
				else
				{
					heightA = i * first.m + first.b;
				}
			}
			
			seg second = descent.get(index2);
			if(i >= second.tL && i <= second.tH)
			{
				if(second.rest)
				{
					heightB = second.min;
				}
				else
				{
					heightB = i * second.m + second.b;
				}
			}
			else
			{
				index2++;
				second = descent.get(index2);
				
				if(second.rest)
				{
					heightB = second.min;
				}
				else
				{
					heightB = i * second.m + second.b;
				}
			}
			
			//System.out.println(i + " " + heightA + " " + heightB);
			if(heightA >= heightB)
			//if(heightA == heightB)
			{
				System.out.println(i);
				System.exit(0);
			}
		}
	}

}
