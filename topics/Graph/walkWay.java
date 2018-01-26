package Graph;

//import java.util.ArrayList;
import java.util.Arrays;
//import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;


public class walkWay {
	
	static class edge implements Comparable<edge>
	{
		int start;
		int end;
		float weight;
		public edge(int start, int end, float weight)
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
		float weight;
		int det;
		public distance(int det, float weight)
		{
			this.det = det;
			this.weight = weight;
		}
		@Override
		public int compareTo(distance o) {
			return Double.compare(weight, o.weight);
		}
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int e = in.nextInt();
		while(e != 0)
		{
			LinkedList<edge> bag = new LinkedList<edge>();
			PriorityQueue<Integer> vertices = new PriorityQueue<Integer>();
			for(int i = 0; i < e; i++)
			{
				int start = in.nextInt();
				int end = in.nextInt();
				int height = in.nextInt();
				float weight = ((float)start + end) * height / 100;
				edge ed = new edge(start, end, weight);
				bag.add(ed);
				if(!vertices.contains(start))
				{
					vertices.add(start);
				}
				if(!vertices.contains(end))
				{
					vertices.add(end);
				}
			}
			
			int v = vertices.size();
			int[] index = new int[v];
			for(int i = 0; i < v; i++)
			{
				index[i] = vertices.poll();
			}
			
			int src = Arrays.binarySearch(index, in.nextInt());
			int det = Arrays.binarySearch(index, in.nextInt());
			
			@SuppressWarnings("unchecked")
			LinkedList<edge>[] graph = new LinkedList[v];
			for(int i = 0; i < v; i++)
			{
				graph[i] = new LinkedList<edge>();
			}
			
			for(edge ed : bag)
			{
				int indexS = Arrays.binarySearch(index, ed.start);
				int indexE = Arrays.binarySearch(index, ed.end);
				edge newEd = new edge(indexS, indexE, ed.weight);
				graph[indexS].add(newEd);
				edge newEd1 = new edge(indexE, indexS, ed.weight);
				graph[indexE].add(newEd1);
			}
			
			dijkstra(src, det, graph, index, v);
			
			e = in.nextInt();
		}
		in.close();
	}
	
	private static void dijkstra(int src, int det, LinkedList<edge>[] graph, int[] indexes, int v)
	{
		PriorityQueue<distance> distanceList = new PriorityQueue<distance>();
		boolean[] finished = new boolean[v];
		distanceList.add(new distance(src, 0));
		
		while(!finished[det])
		{
			distance dt = distanceList.poll();
			if(finished[dt.det])
			{
				continue;
			}
			else
			{
				int index = dt.det;
				if(index == det)
				{
					System.out.println(String.format("%.2f", dt.weight));
					break;
				}
				
				finished[index] = true;
				
				for(edge e : graph[index])
				{
					
					distance newDt = new distance(e.end, dt.weight + e.weight);
					distanceList.add(newDt);

				}
			}
		}
	}

}
