package Graph;
import java.util.*;

/**
 * https://pcs.cs.cloud.vt.edu/contests/69/problems/D
 * @author weitao92
 *
 */
public class D {
	
	static class edge implements Comparable<edge>
	{
		//int src;
		int det;
		int len;
		
		public edge(int d, int l)
		{
			//src = s;
			det = d;
			len = l;
		}

		@Override
		public int compareTo(edge o) {
			return Integer.compare(len, o.len);
		}
	}
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int v = in.nextInt();
		int e = in.nextInt();
		ArrayList<edge>[] graph = new ArrayList[v];
		for(int i = 0; i < v; i++)
		{
			graph[i] = new ArrayList<edge>();
		}
		
		for(int i = 0; i < e; i++)
		{
			int src = in.nextInt();
			int det = in.nextInt();
			int len = in.nextInt();
			graph[src].add(new edge(det, len));
		}
		
		int t = in.nextInt();
		HashSet<Integer> set = new HashSet<Integer>();
		int[] targets = new int[t];
		for(int i = 0; i < t; i++)
		{
			targets[i] = in.nextInt();
			set.add(targets[i]);
		}
		
		PriorityQueue<edge> queue = new PriorityQueue<edge>();
		boolean[] visited = new boolean[v];
		queue.add(new edge(0,0));
		long result = 0;
		
		while(!set.isEmpty())
		{
			edge current = queue.poll();
			if(visited[current.det])
			{
				continue;
			}
			visited[current.det] = true;
			
			if(set.contains(current.det))
			{
				set.remove(current.det);
				result += current.len;
			}
			
			for(edge next : graph[current.det])
			{
				queue.add(new edge(next.det, next.len + current.len));
			}		
		}
		
		for(int i = 0; i < t; i++)
		{
			int target = targets[i];
			boolean[] visit = new boolean[v];
			PriorityQueue<edge> q = new PriorityQueue<edge>();
			q.add(new edge(target, 0));
			
			while(true)
			{
				edge current = q.poll();
				if(current.det == 0)
				{
					result += current.len;
					break;
				}
				if(visit[current.det])
				{
					continue;
				}
				visit[current.det] = true;
				for(edge next : graph[current.det])
				{
					q.add(new edge(next.det, next.len + current.len));
				}	
			}
		}
		
		System.out.println(result);
	}

}
