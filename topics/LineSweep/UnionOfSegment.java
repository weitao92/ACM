package LineSweep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://pcs.cs.cloud.vt.edu/contests/52/problems/C
 */
public class UnionOfSegment {
	
	static class interval implements Comparable<interval>
	{
		int start;
		int end;
		
		interval(int start, int end)
		{
			this.start = start;
			this.end = end;
		}
		
		public int compareTo(interval another)
		{
			return Integer.compare(start, another.start);
		}
	}
	
	static class point implements Comparable<point>
	{
		int coordinate;
		boolean isStart;
		
		point(int coordinate, boolean isStart)
		{
			this.coordinate = coordinate;
			this.isStart = isStart;
		}
		
		public int compareTo(point another)
		{
			if(coordinate == another.coordinate)
			{
				if(isStart && !another.isStart)
				{
					return -1;
				}
				else if(isStart && another.isStart)
				{
					return 0;
				}
				else if(!isStart && !another.isStart)
				{
					return 0;
				}
				else
				{
					return 1;
				}
			}

			return Integer.compare(coordinate, another.coordinate);
		}
	}
	
	
	static interval[] world;
	static point[] points;
	static ArrayList<interval> results;
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		world = new interval[n];
		points = new point[2*n];
		results = new ArrayList<interval>();
		
		for(int i = 0; i < n; i++)
		{
			int start = in.nextInt();
			int end = in.nextInt();
			point s1 = new point(start, true);
			point e1 = new point(end, false);
			points[2*i] = s1;
			points[2*i+1] = e1;
			interval v = new interval(start, end);		
			world[i] = v;
		}
		Arrays.sort(points);
		Arrays.sort(world);
		in.close();
		
		int numOfInterval = 0;
		int start = -1;
		int end = -1;
		for(int i = 0; i < 2*n; i++)
		{
			point p = points[i];
			if(p.isStart)
			{
				numOfInterval++;
				if(numOfInterval == k)
				{
					start = p.coordinate;
				}
			}
			else
			{
				if(numOfInterval == k)
				{
					end = p.coordinate;
					interval temp = new interval(start, end);
					results.add(temp);
				}
				numOfInterval--;
			}
		}
		
		System.out.println(results.size());
		for(int i = 0; i < results.size(); i++)
		{
			interval v = results.get(i);
			System.out.println(v.start + " " + v.end);
		}
	}

}
