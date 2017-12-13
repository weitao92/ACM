package Graph;

import java.util.Scanner;




public class shortestPath {
	
	class graph
	{
		int[][] matrix;
		boolean[] finishedList;
		int[] distanceList;
		
		public graph(int n)
		{
			matrix = new int[n][n];
			finishedList = new boolean[n];
			distanceList = new int[n];
			for(int i = 0; i < n; i++)
			{
				finishedList[i] = false;
				distanceList[i] = Integer.MAX_VALUE;
			}
		}
		
		public void addEdge(int s, int t, int weight)
		{
			matrix[s][t] = weight;
			matrix[t][s] = weight;
		}
		
		public boolean finished()
		{
			for(int i = 0; i < finishedList.length; i++)
			{
				if(finishedList[i] == false)
				{
					return false;
				}
			}
			return true;
		}
		
		public int shortest()
		{
			int min = Integer.MAX_VALUE;
			int next = -1;
			for(int i = 0; i < distanceList.length; i++)
			{
				if(distanceList[i] > 0 && distanceList[i] < min && finishedList[i] == false)
				{
					min = distanceList[i];
					next = i;
				}
			}
			
			return next;
		}
		
		public void update(int t, int weight)
		{
			if(weight < distanceList[t])
			{
				distanceList[t] = weight;
			}
		}
	}
	
	private graph g;
	
	public shortestPath(int n)
	{
		g = new graph(n);
	}
	
	public void dijsktra(int s)
	{
		g.finishedList[s] = true;
		g.distanceList[s] = 0;
		for(int i = 0; i < g.distanceList.length; i++)
		{
			if(g.matrix[s][i] != 0)
			{
				g.update(i, g.matrix[s][i]);
			}
		}
		
		while(!g.finished())
		{
			int next = g.shortest();
			g.finishedList[next] = true;
			
			for(int i = 0; i < g.distanceList.length; i++)
			{
				if(g.matrix[next][i] != 0)
				{
					int newDistance = g.distanceList[next] + g.matrix[next][i];
					g.update(i, newDistance);
				}
			}
		}
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		shortestPath D = new shortestPath(n);
		int e = in.nextInt();
		int src = in.nextInt();
		int det = in.nextInt();
		
		for(int i = 0; i < e; i++)
		{
			int start = in.nextInt();
			int end = in.nextInt();
			int weight = in.nextInt();
			D.g.addEdge(start, end, weight);
		}

		D.dijsktra(src);
		System.out.print(D.g.distanceList[det]);
		in.close();
	}

}
