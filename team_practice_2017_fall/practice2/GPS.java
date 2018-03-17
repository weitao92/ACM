package practice2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class GPS {
	
	static class distance implements Comparable<distance>
	{
		int pre;
		
		int det;
		double weight;
		
		public distance(int pre, int det, double weight)
		{
			this.pre = pre;
			this.det = det;
			this.weight = weight;
		}
		@Override
		public int compareTo(distance o) {
			return Double.compare(weight, o.weight);
		}
	}
	
	static class coordinate
	{
		int x;
		int y;
		
		public coordinate(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int q = in.nextInt();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String[] towns = new String[n];
		@SuppressWarnings("unchecked")
		LinkedList<distance>[] gragh = new LinkedList[n];
		coordinate[] coordinates = new coordinate[n];
		for(int i = 0; i < n; i++)
		{
			String town = in.next();
			int x = in.nextInt();
			int y = in.nextInt();
			coordinate c = new coordinate(x,y);
			coordinates[i] = c;
			map.put(town, i);
			towns[i] = town;
			gragh[i] = new LinkedList<distance>();
		}
		
		for(int i = 0; i < m; i++)
		{
			String src = in.next();
			String det = in.next();
			double length = in.nextDouble();
			int index1 = map.get(src);
			int index2 = map.get(det);
			coordinate c1 = coordinates[index1];
			coordinate c2 = coordinates[index2];
			
			int X = Math.abs(c1.x - c2.x);
			int Y = Math.abs(c1.y - c2.y);
			double shortest = Math.sqrt(X*X + Y*Y);
			
			if(length >= shortest)
			{
				distance d = new distance(index1, index2, length);
				gragh[index1].add(d);
				gragh[index2].add(new distance(index2, index1, length));
			}
		}
		
		for(int i = 0; i < q; i++)
		{
			int src = map.get(in.next());
			int det = map.get(in.next());
			
			if(src == det)
			{
				System.out.println("0.0" + towns[src] + " " + towns[src]);
				continue;
			}
			
			double[] distances = new double[n];
			distances[src] = 0;
			
			PriorityQueue<distance> distanceList = new PriorityQueue<distance>();
			boolean[] finished = new boolean[n];
			int[] previous = new int[n];
			
			previous[src] = -1;
			for(distance e : gragh[src])
			{
				distance dt = new distance(src, e.det, e.weight);
				distanceList.add(dt);
				previous[e.det] = src;
			}
			finished[src] = true;
			
			while(finished[det] == false)
			{
				distance dt = distanceList.poll();
				if(finished[dt.det])
				{
					continue;
				}
				else
				{
					int index = dt.det;
					distances[index] = dt.weight;
					finished[index] = true;
					previous[index] = dt.pre;
					
					for(distance e : gragh[index])
					{
						
						distance newDt = new distance(index, e.det, dt.weight + e.weight);
						distanceList.add(newDt);

					}
				}
			}

			
			
			int index = det;
			String town = towns[index];
			StringBuilder result = new StringBuilder(town);
			
			while(previous[index] != -1)
			{
				index = previous[index];
				town = towns[index];
				result.insert(0, town + " ");
			}
			
			result.insert(0, distances[det] + " ");
			System.out.println(result);
		}
		
		in.close();
	}

}
