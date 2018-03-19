package Graph;
import java.util.*;

/**
 * https://pcs.cs.cloud.vt.edu/contests/69/problems/C
 * @author weitao92
 *
 */
public class C {
	
	static class edge
	{
		String src;
		String det;
		int dis;
		
		public edge(String s, String d, int dis)
		{
			src = s;
			det = d;
			this.dis = dis;
		}
	}
	
	static class node implements Comparable<node>
	{
		int level;
		String name;
		
		public node(int l, String s)
		{
			level = l;
			name = s;
		}

		@Override
		public int compareTo(node o) {
			if(level == o.level)
			{
				return name.compareTo(o.name);
			}
			else
			{
				return Integer.compare(level, o.level);
			}
		}
	}
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int e = in.nextInt();
		int q = in.nextInt();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		edge[] edges = new edge[e];
		int size = 0;
		for(int i = 0; i < e; i++)
		{
			String src = in.next();
			String det = in.next();
			int dis = in.nextInt();
			if(!map.containsKey(src))
			{
				size += 1;
				map.put(src, size);
			}
			if(!map.containsKey(det))
			{
				size += 1;
				map.put(det, size);
			}
			edges[i] = new edge(src,det,dis);
		}
		
		String[] proteins = new String[map.size()];
		ArrayList<edge>[] graph = new ArrayList[size];
		int index = 0;
		for(String s : map.keySet())
		{
			proteins[map.get(s)-1] = s;
			graph[index] = new ArrayList<edge>();
			index += 1;
		}
				
		for(int i = 0; i < e; i++)
		{
			edge ed = edges[i];
			graph[map.get(ed.src)-1].add(ed);
			graph[map.get(ed.det)-1].add(new edge(ed.det, ed.src, ed.dis));
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < q; i++)
		{
			String source = in.next();
			sb.append(source);
			int sourceIndex = map.get(source)-1;
			
			boolean[] visited = new boolean[size];
			PriorityQueue<node> queue = new PriorityQueue<node>();
			PriorityQueue<node> nodes = new PriorityQueue<node>();
			queue.add(new node(0,proteins[sourceIndex]));
			int visitedSize = 0;
			
			while(visitedSize < size)
			{
				node current = queue.poll();
				int currentIndex = map.get(current.name)-1;
				if(visited[currentIndex])
				{
					continue;
				}
				nodes.add(current);
				visitedSize++;
				visited[currentIndex] = true;
				
				for(edge next : graph[currentIndex])
				{
					if(!visited[map.get(next.det)-1])
					{
						queue.add(new node(current.level + next.dis, next.det));
					}
				}
			}
			
			nodes.poll();
			
			while(!nodes.isEmpty())
			{
				node current = nodes.poll();
				sb.append(" " + current.name);
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}

}
