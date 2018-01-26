package Graph;

import java.util.LinkedList;
import java.util.Scanner;

public class vertexCover {
	
	
	class edge
	{
		int start;
		int end;
		
		edge(int start, int end)
		{
			this.start = start;
			this.end = end;
		}
	}
	static LinkedList<Integer> set1;
	static LinkedList<Integer> set2;
	static int[] finished;
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int v = in.nextInt();
		int e = in.nextInt();
		finished = new int[v];

		@SuppressWarnings("unchecked")
		LinkedList<Integer>[] graph = new LinkedList[v];
		for(int i = 0; i < v; i++)
		{
			graph[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < e; i++)
		{
			int start = in.nextInt() - 1;
			int end = in.nextInt() - 1;
			graph[start].add(end);
			graph[end].add(start);
		
		}
		
		in.close();
		
		set1 = new LinkedList<Integer>();
		set2 = new LinkedList<Integer>();
		

		
		for(int i = 0; i < v; i++)
		{
			if(finished[i] == 0)
			{
			
				dfs(i, 1, graph);
			}
		}
		
		for(int i = 0; i < v; i++)
		{
			if(finished[i] == 1)
			{
				set1.add(i+1);
			}
			else
			{
				set2.add(i+1);
			}
		}
		
		System.out.println(set1.size());
		StringBuilder result1 = new StringBuilder();
		for(int i : set1)
		{
			result1.append(i + " ");
		}
		System.out.println(result1);
		
		System.out.println(set2.size());
		StringBuilder result2 = new StringBuilder();
		for(int i : set2)
		{
			result2.append(i + " ");
		}
		System.out.println(result2);
	}
	
	private static void dfs(int src, int mode, LinkedList<Integer>[] graph)
	{
		finished[src] = mode;

		
			for(int i : graph[src])
			{
				if(finished[i] == mode)
				{
					System.out.println("-1");
					System.exit(0);
				}
				else if(finished[i] == 0)
				{
					if(mode == 1)
					{
						dfs(i, 2, graph);
					}
					else
					{
						dfs(i, 1, graph);
					}
				}
			}
		
	}

}
