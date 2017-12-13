package NAQ_2017;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/bumped
 * @author weitao92
 *
 */
public class trip {
	
	static class path implements Comparable<path>
	{
		int src;
		int det;
		long cost;
		int count;
		
		public path(int s, int d, long c, int count)
		{
			src = s;
			det = d;
			cost = c;
			this.count = count;
		}

		@Override
		public int compareTo(path o) {
			return Long.compare(cost, o.cost);
		}
		
		
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<path>[] gragh = new ArrayList[n];
		int m = in.nextInt();
		for(int i = 0; i < n; i++)
		{
			gragh[i] = new ArrayList<path>();
		}
		int f = in.nextInt();
		int src = in.nextInt();
		int det = in.nextInt();
		
		for(int i = 0; i < m; i++)
		{
			int a = in.nextInt();
			int b = in.nextInt();
			int cost = in.nextInt();
			path first = new path(a,b,cost,0);
			path second = new path(b,a,cost,0);
			gragh[a].add(first);
			gragh[b].add(second);
		}
		
		for(int i = 0; i < f; i++)
		{
			int a = in.nextInt();
			int b = in.nextInt();
			gragh[a].add(new path(a,b,0,1));
		}
		
		PriorityQueue<path> edgeList = new PriorityQueue<path>();
		boolean[] finished = new boolean[n];
		//int[] previous = new int[n];
		//int[] maxlist = new int[n];
		long[] results = new long[n];
		
		//previous[0] = -1;
		for(path e : gragh[src])
		{
			
			edgeList.add(e);
		}
		finished[src] = true;
		//int count = 0;
		//maxlist[0] = items[0];
		
		
		while(!finished[det])
		{
			path dt = edgeList.poll();
			int dets = dt.det;
			if(finished[dets])
			{
				continue;
			}
				else
				{
					if(dt.count > 1)
					{
						continue;
					}
					
					finished[dets] = true;
					results[dets] = dt.cost;
					//previous[index] = dt.src;
					//maxlist[index] = items[index] + maxlist[dt.src];
					
					for(path e : gragh[dets])
					{
						if(e.cost == 0)
						{
						
							path newDt = new path(dets, e.det, dt.cost + e.cost, dt.count + 1);
							edgeList.add(newDt);
						}
						else
						{
							path newDt = new path(dets, e.det, dt.cost + e.cost, dt.count);
							edgeList.add(newDt);
						}

					}
				}
			
		}
		
		System.out.println(results[det]);
	}

}
