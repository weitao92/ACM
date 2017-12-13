package Graph;

import java.util.LinkedList;
import java.util.Scanner;

public class BFS {
	
	public static void main(String agrs[])
	{
		Scanner scan = new Scanner(System.in);
		int V = scan.nextInt();
		int E = scan.nextInt();
		int initial = scan.nextInt();
		int target = scan.nextInt();
		GraphMatrix G = new GraphMatrix(V);
		
		for(int i = 0; i < E; i++)
		{
			int start = scan.nextInt();
			int end = scan.nextInt();
			G.addEdge(start, end);
		}
		
		//G.display();
		int level = G.BFS(initial, target);
		int min = 0;
		
		if(level % 6 == 0)
		{
			min = level / 6;
		}
		else
		{
			min = (level / 6) + 1;
		}
		
		int max = level;
		
		System.out.println(min + " " + max);
		scan.close();
	}
	
	private static class GraphMatrix
	{
		int[][] matrix;
		boolean[] marked;
		int numOfVertices;
		
		public GraphMatrix(int n)
		{
			numOfVertices = n;
			matrix = new int[n][n];
			marked = new boolean[n];
		}
		
		public void addEdge(int src, int des)
		{
			matrix[src][des] = 1;
			matrix[des][src] = 1;
		}
		
		public boolean hasEdge(int src, int des)
		{
			if(src < 0 || src >= numOfVertices || des < 0 || des >= numOfVertices)
			{
				return false;
			}
			
			return matrix[src][des] == 1;
		}
		
		public int firstNeighbor(int src)
		{
			for(int i = 0; i < numOfVertices; i++)
			{
				if(matrix[src][i] == 1)
				{
					return i;
				}
			}
			
			return -1;
		}
		
		public int nextNeighbor(int src, int prev)
		{
			for(int i = prev + 1; i < numOfVertices; i++)
			{
				if(matrix[src][i] == 1)
				{
					return i;
				}
			}
			
			return -1;
		}
		
		public boolean isMarked(int src)
		{
			return marked[src];
		}
		
		public void mark(int src)
		{
			marked[src] = true;
		}
		
		public int BFS(int src, int target)
		{
			int[] levels = new int[numOfVertices];
			for(int i = 0; i < numOfVertices; i++)
			{
				levels[i] = -1; 
			}
			levels[src] = 0;
			LinkedList <Integer> queue = new LinkedList <Integer> ();
			BFS(src, target, levels, queue, 0);
			
			return levels[target];
		}
		
		private void BFS(int src, int target, int[] levels, LinkedList <Integer> queue, int level)
		{
			mark(src);
			level++;
			//System.out.println(level);
			
			for(int neighbor = firstNeighbor(src); hasEdge(src, neighbor); 
					neighbor = nextNeighbor(src, neighbor))
			{
				if(isMarked(neighbor))
				{
					continue;
				}
				//System.out.println(neighbor + " " + level);
				if(levels[neighbor] == -1)
				{
				levels[neighbor] = level;
				}
				
				if(neighbor == target)
				{
					queue.removeAll(queue);
					return;
				}
				
				if(!queue.contains(neighbor))
				{
					queue.addLast(neighbor);
				}

			}
			
			while(!queue.isEmpty())
			{
				int next = queue.removeFirst();
				//System.out.println(next + " " + levels[next]);
				BFS(next, target, levels, queue, levels[next]);
			}
		}
	}
}
