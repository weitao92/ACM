package Graph;
import java.util.*;

/**
 * https://pcs.cs.cloud.vt.edu/contests/69/problems/A
 * @author weitao92
 *
 */
public class A {
	
	static class point
	{
		int x;
		int y;
		
		public point(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		
		@Override public boolean equals(Object o)
		{
			point another = (point)o;
			return x == another.x && y == another.y;
		}
	}
	
	static class edge implements Comparable<edge>
	{
		point p;
		int length;
		
		public edge(point p, int l)
		{
			this.p = p;
			length = l;
		}

		@Override
		public int compareTo(edge o) {
			return Integer.compare(length, o.length);
		}
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int row = in.nextInt();
		int col = in.nextInt();
		int[][] world = new int[row][col];
		int out = 0;
		in.nextLine();
		for(int i = 0; i < row; i++)
		{
			String line = in.nextLine();
			for(int j = 0; j < col; j++)
			{
				char c = line.charAt(j);
				if(c == '#')
				{
					world[i][j] = -1;
				}
				else if(c == 'c')
				{
					world[i][j] = 0;
				}
				else
				{
					if(i == 0 || i == row-1 || j == 0 || j == col-1)
					{
						world[i][j] = 2;
						out++;
					}
					else
					{
						world[i][j] = 1;
					}
				}
			}
		}
		
		ArrayList<edge>[][] graph = new ArrayList[row][col];
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
			{
				if(world[i][j] == 0 || world[i][j] == 1)
				{
					graph[i][j] = new ArrayList<edge>();
					if(world[i-1][j] == 0)
					{
						graph[i][j].add(new edge(new point(i-1,j),1));
					}
					if(world[i-1][j] == 1 || world[i-1][j] == 2)
					{
						graph[i][j].add(new edge(new point(i-1,j),0));
					}
					
					if(world[i][j+1] == 0)
					{
						graph[i][j].add(new edge(new point(i,j+1),1));
					}
					if(world[i][j+1] == 1 || world[i][j+1] == 2)
					{
						graph[i][j].add(new edge(new point(i,j+1),0));
					}
					
					if(world[i+1][j] == 0)
					{
						graph[i][j].add(new edge(new point(i+1,j),1));
					}
					if(world[i+1][j] == 1 || world[i+1][j] == 2)
					{
						graph[i][j].add(new edge(new point(i+1,j),0));
					}
					
					if(world[i][j-1] == 0)
					{
						graph[i][j].add(new edge(new point(i,j-1),1));
					}
					if(world[i][j-1] == 1 || world[i][j-1] == 2)
					{
						graph[i][j].add(new edge(new point(i,j-1),0));
					}				
				}
			}
		}
		
		int targetRow = in.nextInt()-1;
		int targetCol = in.nextInt()-1;
		boolean[][] visited = new boolean[row][col];
		PriorityQueue<edge> queue = new PriorityQueue<edge>();
		queue.add(new edge(new point(targetRow,targetCol),1));
		int min = Integer.MAX_VALUE;
		
		while(out > 0 && !queue.isEmpty())
		{
			edge current = queue.poll();
			point p = current.p;
			//System.out.println(p.x + " " + p.y);
			if(visited[p.x][p.y])
			{
				continue;
			}
			visited[p.x][p.y] = true;
			if(world[p.x][p.y] == 2)
			{
				out--;
				min = Math.min(min, current.length);
				continue;
			}
			
			for(edge next : graph[p.x][p.y])
			{
				//if(!visited[next.p.x][next.p.y])
				{
					queue.add(new edge(next.p, current.length + next.length));
				}
			}
		}
		
		System.out.println(min);
	}

}