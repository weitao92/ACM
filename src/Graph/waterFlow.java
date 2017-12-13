package Graph;

import java.util.LinkedList;
import java.util.Scanner;

public class waterFlow {
	
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
	}
	
	static LinkedList<coordinate> bag;
	static int[][] room;
	static int n;
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		in.nextLine();
		room = new int[n][n];
		bag = new LinkedList<coordinate>();
		
		for(int i = 0; i < n; i++)
		{
			String line = in.nextLine();
			//System.out.println(line.length());
			
			for(int j = 0; j < n; j++)
			{
	
				char c = line.charAt(j);
				if(c == 'o')
				{
					coordinate origin = new coordinate(i,j,0);
					bag.add(origin);
					room[i][j] = -1;
				}
				else if(c == 'X')
				{
					room[i][j] = 10; 
				}
				else
				{
					room[i][j] = 11;
				}
			}
		}
		in.close();
		//System.out.println(bag.size());
		while(!bag.isEmpty())
		{
			coordinate origin = bag.removeLast();
			flow(origin);
		}

		StringBuilder result = new StringBuilder();
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(room[i][j] == -1)
				{
					result.append("o");
				}
				else if(room[i][j] == 10)
				{
					result.append("X");
				}
				else if(room[i][j] == 11)
				{
					result.append(" ");
				}
				else
				{
					result.append(room[i][j]);
				}
			}
			result.append("\n");
		}
		
		System.out.println(result);
	
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
			finished[current.i][current.j] = true;
			if(room[current.i][current.j] >= 0)
			{
				if(current.flow > 9)
				{
					current.flow = 9;
				}
				if(current.flow < room[current.i][current.j])
				{
					
					room[current.i][current.j] = current.flow;
					
				}
			}
			
			coordinate top = new coordinate(current.i - 1, current.j, flow+1);
			if(!outOf(top.i, top.j) && !finished[top.i][top.j])
			{
				queue.addLast(top);
			}
			
			coordinate right = new coordinate(current.i, current.j + 1, flow+1);
			if(!outOf(right.i, right.j) && !finished[right.i][right.j])
			{
				queue.addLast(right);
			}
			
			coordinate bot = new coordinate(current.i + 1, current.j, flow+1);
			if(!outOf(bot.i, bot.j) && !finished[bot.i][bot.j])
			{
				queue.addLast(bot);
			}
			
			coordinate left = new coordinate(current.i, current.j - 1, flow+1);
			if(!outOf(left.i, left.j) && !finished[left.i][left.j])
			{
				queue.addLast(left);
			}
			
			
		}
	}
	
	private static boolean outOf(int i, int j)
	{
		return (i < 0 || i >= n || j < 0 || j >= n || room[i][j] == 10);
	}
}
