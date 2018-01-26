package Graph;

import java.util.LinkedList;
import java.util.Scanner;

public class birthday_bfs {
	
	static class edge
	{
		int src;
		int det;
		
		edge(int src, int det)
		{
			this.src = src;
			this.det = det;
		}
	}

	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		while(true)
		{
			int v = in.nextInt();
			int e = in.nextInt();
			if(v == 0 && e == 0)
			{
				in.close();
				System.exit(0);
			}
			
			@SuppressWarnings("unchecked")
			LinkedList<Integer>[] graph = new LinkedList[v];
			for(int i = 0; i < v; i++)
			{
				graph[i] = new LinkedList<Integer>();
			}
			LinkedList<edge> edges = new LinkedList<edge>();
			
			for(int i = 0; i < e; i++)
			{
				int start = in.nextInt();
				int end = in.nextInt();
				edge ed = new edge(start, end);
				edges.add(ed);
				graph[start].add(end);
				graph[end].add(start);
			}
			
			boolean result = false;
			for(int i = 0; i < e; i++)
			{			
				edge ed = edges.remove(i);
				LinkedList<Integer> bag = new LinkedList<Integer>();
				boolean[] finished = new boolean[v];
				graph[ed.src].remove(new Integer(ed.det));
				graph[ed.det].remove(new Integer(ed.src));
				dfs(bag, graph, ed.src, finished);
				result = bag.size() == v;
				if(!result)
				{
					System.out.println("Yes");
					break;
				}
				graph[ed.src].add(ed.det);
				graph[ed.det].add(ed.src);
				edges.add(i, ed);
			}
			
			if(result)
			{
				System.out.println("No");
			}
		}
	}
	
	private static void dfs(LinkedList<Integer> bag, LinkedList<Integer>[] graph, int src,
			boolean[] finished)
	{
		if(finished[src])
		{
			return;
		}
		else
		{
			finished[src] = true;
			bag.add(src);
			for(int next : graph[src])
			{
				dfs(bag, graph, next, finished);
			}
		}
	}

}
