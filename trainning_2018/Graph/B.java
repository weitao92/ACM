package Graph;
import java.util.*;

/**
 * https://pcs.cs.cloud.vt.edu/contests/69/problems/B
 * @author weitao92
 *
 */
public class B {
	
	static class edge
	{
		String src;
		String det;
		
		public edge(String s, String d)
		{
			src = s;
			det = d;
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
			edges[i] = new edge(src,det);
		}
		
		String[] proteins = new String[map.size()];
		ArrayList<Integer>[] graph = new ArrayList[size];
		int index = 0;
		for(String s : map.keySet())
		{
			proteins[map.get(s)-1] = s;
			graph[index] = new ArrayList<Integer>();
			index += 1;
		}
				
		for(int i = 0; i < e; i++)
		{
			edge ed = edges[i];
			graph[map.get(ed.src)-1].add(map.get(ed.det)-1);
			graph[map.get(ed.det)-1].add(map.get(ed.src)-1);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < q; i++)
		{
			String source = in.next();
			sb.append(source);
			int sourceIndex = map.get(source)-1;
			
			boolean[] visited = new boolean[size];
			ArrayDeque<node> queue = new ArrayDeque<node>();
			PriorityQueue<node> nodes = new PriorityQueue<node>();
			visited[sourceIndex] = true;
			queue.addLast(new node(0,proteins[sourceIndex]));
			
			while(!queue.isEmpty())
			{
				node current = queue.removeFirst();
				nodes.add(current);
				int currentIndex = map.get(current.name)-1;
				
				for(int next : graph[currentIndex])
				{
					if(!visited[next])
					{
						visited[next] = true;
						queue.addLast(new node(current.level + 1, proteins[next]));
					}
				}
			}
			
			nodes.poll();
			int distance = 0;
			while(!nodes.isEmpty())
			{
				node current = nodes.poll();
				if(current.level != distance)
				{
					distance = current.level;
					sb.append("\n" + distance + " " + current.name);
				}
				else
				{
					sb.append(" " + current.name);		
				}
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}

}
