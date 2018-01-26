package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class ColoringGraph {
	static int v;
	static LinkedList<Integer>[] gragh;
	static int[] color;
	static int size;
	@SuppressWarnings("unchecked")
	public static void main(String args[])
	{
		size = -1;
		Scanner in = new Scanner(System.in);
		v = in.nextInt();
		color = new int[v];
		gragh = new LinkedList[v];
		for(int i = 0; i < v; i++)
		{
			gragh[i] = new LinkedList<Integer>();
		}
		in.nextLine();
		for(int i = 0; i < v; i++)
		{
			String line = in.nextLine();
			Scanner inner = new Scanner(line);
			while(inner.hasNext())
			{
				gragh[i].add(inner.nextInt());
			}
			inner.close();
		}
		in.close();
		
		Arrays.fill(color, -1);
		System.out.println(color(0));
	}
	
	private static int color(int src)
	{
		color[src] = 0;
		boolean[] colored = new boolean[v];
		size++;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(src);
		
		while(!queue.isEmpty())
		{
			src = queue.removeFirst();
			colored[src] = true;
			for(int i : gragh[src])
			{
				if(color[i] == color[src] || color[i] == -1)
				{
					for(int j = 0; j <= size; j++)
					{
						if(tryColor(i, j))
						{
							color[i] = j;
							break;
						}
					}
					if(color[i] == -1)
					{
						size++;
						color[i] = size;
					}
				}
				
				if(!colored[i] && !queue.contains(i))
				{
					queue.addLast(i);
				}		
			}
		}
	
		return size + 1;
	}
	
	private static boolean tryColor(int src, int col)
	{
		for(int i : gragh[src])
		{
			if(color[i] == col)
			{
				return false;
			}
		}
		
		return true;
	}

}
