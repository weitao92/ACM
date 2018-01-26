package Graph;

import java.util.LinkedList;
import java.util.Scanner;

public class vertexCover_bfs {
	
	static LinkedList<Integer> set1;
	static LinkedList<Integer> set2;
	static int[] color;
	static LinkedList<Integer>[] gragh;
	@SuppressWarnings("unchecked")
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int v = in.nextInt();
		int e = in.nextInt();
		color = new int[v]; // think of a bipartite graph.

		gragh = new LinkedList[v];
		for(int i = 0; i < v; i++)
		{
			gragh[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < e; i++)
		{
			int start = in.nextInt() - 1;
			int end = in.nextInt() - 1;
			gragh[start].add(end);
			gragh[end].add(start);
		
		}
		
		in.close();
		
		set1 = new LinkedList<Integer>();
		set2 = new LinkedList<Integer>();
		
		for(int i = 0; i < v; i++)
		{
			if(color[i] == 0) // every iteration is using BFS to get one tree. 
			{
				bfs(i);
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
	
	/**
	 * use bfs to build one bipartite tree.
	 * @param src
	 * @param c
	 */
	private static void bfs(int src)
	{
		color[src] = 1;
		set1.add(src + 1);
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(src);
		
		while(!queue.isEmpty())
		{
			src = queue.removeFirst();
			for(int i : gragh[src])
			{
				if(color[i] == color[src])
				{
					System.out.println("-1");
					System.exit(0);
				}
				else
				{
					if(color[i] == 0)
					{
						if(color[src] == 1)
						{
							color[i] = 2;
							set2.add(i + 1);
						}
						else
						{
							color[i] = 1;
							set1.add(i + 1);
						}
						
						queue.addLast(i);
					}
				}
			}
		}
	}

}
