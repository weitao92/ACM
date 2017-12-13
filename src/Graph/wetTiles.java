package Graph;

import java.util.LinkedList;
import java.util.Scanner;

public class wetTiles {
	
	static class coordinate
	{
		int i;
		int j;
		int flow;
		
		coordinate(int i, int j, int flow)
		{
			this.i = i;
			this.j = j;
			this.flow = flow;
		}
		
		public boolean equals(Object obj)
		{
			coordinate another = (coordinate) obj;
			return i == another.i && j == another.j;
		}
	}
	
	static int m;
	static int n;
	static int t;
	static int[][] world;
	static LinkedList<coordinate> bag;
	static int result;
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
	
		while(true)
		{
			result = 0;
			bag = new LinkedList<coordinate>();
			n = in.nextInt();
			if(n == -1)
			{
				in.close();
				System.exit(0);
			}
			else
			{
				m = in.nextInt();
				world = new int[m][n];
				t = in.nextInt();
				int l = in.nextInt();
				int w = in.nextInt();
				
				for(int i = 0; i < l; i++)
				{
					int x = in.nextInt();
					int y = in.nextInt();
					coordinate leak = new coordinate(m-y, x-1, 1);
					bag.add(leak);
				}
				
				for(int i = 0; i < w; i++)
				{
					int x1 = in.nextInt();
					int y1 = in.nextInt();
					int x2 = in.nextInt();
					int y2 = in.nextInt();
					
					constructWall(x1,y1,x2,y2);
				}
				
				while(!bag.isEmpty())
				{
					coordinate origin = bag.removeFirst();
					flow(origin);
				}
				//count();
				System.out.println(result);
				
			}
		}	
	}
	
	@SuppressWarnings("unused")
	private static void count()
	{
		for(int i = 0; i < m; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(world[i][j] > 0 && world[i][j] <= t)
				{
					result++;
				}
			}
		}
	}
	
	private static void flow(coordinate origin)
	{
		boolean[][] finished = new boolean[n][n];
		LinkedList<coordinate> queue = new LinkedList<coordinate>();
		queue.addLast(origin);
		
		while(!queue.isEmpty())
		{
			
			coordinate current = queue.removeFirst();
			int flow = current.flow;
			if(world[current.i][current.j] == 0)
			{
				result++;
			}
			finished[current.i][current.j] = true;
			if(world[current.i][current.j] >= 0)
			{
				if(current.flow == t)
				{
					world[current.i][current.j] = t;
					continue;
				}
				if(current.flow < world[current.i][current.j] || world[current.i][current.j] == 0)
				{				
					world[current.i][current.j] = current.flow;		
				}
			}
			
			coordinate top = new coordinate(current.i - 1, current.j, flow+1);
			if(!outOf(top.i, top.j) && !finished[top.i][top.j] && !queue.contains(top))
			{
				queue.addLast(top);
			}
			
			coordinate right = new coordinate(current.i, current.j + 1, flow+1);
			if(!outOf(right.i, right.j) && !finished[right.i][right.j] && !queue.contains(right))
			{
				queue.addLast(right);
			}
			
			coordinate bot = new coordinate(current.i + 1, current.j, flow+1);
			if(!outOf(bot.i, bot.j) && !finished[bot.i][bot.j] && !queue.contains(bot))
			{
				queue.addLast(bot);
			}
			
			coordinate left = new coordinate(current.i, current.j - 1, flow+1);
			if(!outOf(left.i, left.j) && !finished[left.i][left.j] && !queue.contains(left))
			{
				queue.addLast(left);
			}		
		}
	}
	
	@SuppressWarnings("unused")
	private static void display()
	{
		for(int i = 0; i < m; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(world[i][j] == 0)
				{
					System.out.print(" ");
				}
				else if(world[i][j] == 1)
				{
					System.out.print("L");
				}
				else if(world[i][j] == 200001)
				{
					System.out.print("X");
				}
				else
				{
					System.out.print(world[i][j]);
				}
			}
			System.out.println("");
		}
	}
	
	private static void constructWall(int x1, int y1, int x2, int y2)
	{
		if(x1 == x2 && y1 == y2)
		{
			world[m-y1][x1-1] = 200001;
		}
		else if(y1 == y2)
		{
			if(x1 < x2)
			{
				for(int i = x1 - 1; i <= x2 - 1; i++)
				{
					world[m-y1][i] = 200001;
				}
			}
			else
			{
				for(int i = x2 - 1; i <= x1 - 1; i++)
				{
					world[m-y1][i] = 200001;
				}
			}
		}
		else if(x1 == x2)
		{
			if(y1 < y2)
			{
				for(int i = m - y2; i <= m - y1; i++)
				{
					world[i][x1-1] = 200001;
				}
			}
			else
			{
				for(int i = m - y1; i <= m - y2; i++)
				{
					world[i][x1-1] = 200001;
				}
			}
		}
		else
		{
			if(x1 < x2)
			{
				if(y1 < y2)
				{
					for(int i = m-y1, j = x1 - 1; i >= m-y2 && j <= x2 - 1; i--, j++)
					{
						world[i][j] = 200001;
					}
				}
				else
				{
					for(int i = m-y1, j = x1 - 1; i <= m-y2 && j <= x2 - 1; i++, j++)
					{
						world[i][j] = 200001;
					}
				}
			}
			else
			{
				if(y1 < y2)
				{
					for(int i = m-y1, j = x1 - 1; i >= m-y2 && j >= x2 - 1; i--, j--)
					{
						world[i][j] = 200001;
					}
				}
				else
				{
					for(int i = m-y1, j = x1 - 1; i <= m-y2 && j >= x2 - 1; i++, j--)
					{
						world[i][j] = 200001;
					}
				}
			}
		}
	}
	
	private static boolean outOf(int i, int j)
	{
		return (i < 0 || i >= m || j < 0 || j >= n || world[i][j] == 200001);
	}

}
