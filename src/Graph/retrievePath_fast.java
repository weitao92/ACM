package Graph;

//import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class retrievePath_fast {
	
	static class edge implements Comparable<edge>
	{
		int start;
		int end;
		int weight;
		public edge(int start, int end, int weight)
		{
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(edge o) {
			if(weight == o.weight)
			{
				return 0;
			}
			else
			{
				return weight > o.weight ? 1 : -1;
			}
		}
	}
	
	static class distance implements Comparable<distance>
	{
		int pre;
		int weight;
		int det;
		public distance(int pre, int det, int weight)
		{
			this.pre = pre;
			this.det = det;
			this.weight = weight;
		}
		@Override
		public int compareTo(distance o) {
			return Long.compare(weight, o.weight);
		}
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		@SuppressWarnings("unchecked")
		LinkedList<edge>[] graph = new LinkedList[n];
		for(int i = 0; i < n; i++)
		{
			graph[i] = new LinkedList<edge>();
		}

		for(int i = 0; i < m; i++)
		{
			int start = in.nextInt();
			int end = in.nextInt();
			int weight = in.nextInt();
			graph[start-1].add(new edge(start-1, end-1, weight));
			graph[end-1].add(new edge(end - 1, start-1, weight));
		}
		in.close();
		
		boolean[] connected = new boolean[n];
		connected[0] = true;
		LinkedList<edge> heap = new LinkedList<edge>();
		for(edge e : graph[0])
		{
			heap.addLast(e);
		}
		
		while(!heap.isEmpty())
		{
			edge e = heap.removeFirst();
			if(!(connected[e.start] && connected[e.end]))
			{
				int cut;
				if(!connected[e.start])
				{
					cut = e.start;
				}
				else
				{
					cut = e.end;
				}
				connected[cut] = true;
				
				for(edge ed : graph[cut])
				{
					if(!(connected[ed.start] && connected[ed.end]))
					{
						heap.addLast(ed);
					}
				}
			}
		}
		
		if(connected[n-1] == false)
		{
			System.out.println("-1");
		}
		else
		{
			PriorityQueue<distance> distanceList = new PriorityQueue<distance>();
			boolean[] finished = new boolean[n];
			int[] previous = new int[n];
			
			previous[0] = -1;
			for(edge e : graph[0])
			{
				distance dt = new distance(0, e.end, e.weight);
				distanceList.add(dt);
				previous[e.end] = 0;
			}
			finished[0] = true;
			
			while(finished[n-1] == false)
			{
				distance dt = distanceList.poll();
				if(finished[dt.det])
				{
					continue;
				}
				else
				{
					int index = dt.det;
					finished[index] = true;
					previous[index] = dt.pre;
					
					for(edge e : graph[index])
					{
						
						distance newDt = new distance(index, e.end, dt.weight + e.weight);
						distanceList.add(newDt);

						}
					}
				}

			
			StringBuilder result = new StringBuilder(" " + n);
			int index = n-1;
			while(previous[index] != 0)
			{
				int pre1 = previous[index] + 1;
				result.insert(0, " "+ pre1);
				index = previous[index];
			}
			result.insert(0, "1");
			System.out.print(result);
		}
		
	}


}
