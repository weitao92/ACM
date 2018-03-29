package NAQ_2016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/bigtruck
 * @author weitao92
 *
 */
public class bigTruck {
	
	static class edge implements Comparable<edge>
	{
		int pickup;
		int src;
		int det;
		int w;
		
		public edge(int s, int d, int w, int p)
		{
			src = s;
			det = d;
			this.w = w;
			pickup = p;
		}

		@Override
		public int compareTo(edge o) {
			if(w == o.w)
			{
				return -(Integer.compare(pickup, o.pickup));
			}
			else
			{
				return Integer.compare(w, o.w);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] items = new int[n];
		int[] union = new int[n];
		ArrayList<edge>[] gragh = new ArrayList[n];
		Arrays.fill(union, -1);
		for(int i = 0; i < n; i++)
		{
			items[i] = in.nextInt();
			//items[i].add(in.nextInt());
			gragh[i] = new ArrayList<edge>();
		}
		
		int m = in.nextInt();
		for(int i = 0; i < m; i++)
		{
			int src = in.nextInt() - 1;
			int det = in.nextInt() - 1;
			int weight = in.nextInt();
			int p1 = rootOf(src, union);
			int p2 = rootOf(det, union);
			if(p1 != p2)
			{
				union[p1] = p2;
			}
			gragh[src].add(new edge(src, det, weight, 0));
			gragh[det].add(new edge(det, src, weight, 0));
		}
		
		
		int root1 = rootOf(0, union);
		int root2 = rootOf(n-1, union);
		if(root1 != root2)
		{
			System.out.println("impossible");
			System.exit(0);
		}

		
		
			PriorityQueue<edge> edgeList = new PriorityQueue<edge>();
			boolean[] finished = new boolean[n];
			//int[] previous = new int[n];
			
			//previous[0] = -1;
			for(edge e : gragh[0])
			{
				edge dt = new edge(0, e.det, e.w, items[0]);
				edgeList.add(dt);
				//previous[e.det] = 0;
			}
			finished[0] = true;
				
			while(!finished[n-1])
			{
				edge dt = edgeList.poll();
				int dets = dt.det;
				if(dets == n-1)
				{
					System.out.println(dt.w + " " + (items[n-1] + dt.pickup));
					System.exit(0);
				}
				else
				{
					if(finished[dets])
					{
						continue;
					}
					else
					{
						
						finished[dets] = true;
						//previous[index] = dt.src;
						//maxlist[index] = items[index] + maxlist[dt.src];
						
						for(edge e : gragh[dets])
						{
							
							edge newDt = new edge(dets, e.det, dt.w + e.w, 
									dt.pickup + items[dets]);
							edgeList.add(newDt);
	
						}
					}
				}
			}
			
			//System.out.println("impossible");
		
		

	}
	
	private static int rootOf(int x, int[] union)
	{
		while(union[x] != -1)
		{
			x = union[x];
		}
		
		return x;
	}
}
