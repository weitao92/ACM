package BackTrack;

import java.util.ArrayList;
import java.util.Scanner;

public class graghColor {
	
	static int n;
	static boolean done = false;
	@SuppressWarnings("unchecked")
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		in.nextLine();
		ArrayList<Integer>[] gragh = new ArrayList[n];
		for(int i = 0; i < n; i++)
		{
			gragh[i] = new ArrayList<Integer>();
			String line = in.nextLine();
			String[] separate = line.split(" ");
			for(String s : separate)
			{
				int next = Integer.parseInt(s);
				gragh[i].add(next);
			}
		}
		in.close();
		
		for(int i = 2; i <= 11; i++)
		{
			int[] colors = new int[n];
			for(int j = 0; j < n; j++)
			{
				ArrayList<Integer> list = gragh[j];
				if(list.size() != 0)
				{
					colors[j] = 1;
					colors[list.get(0)] = 2;
					run(i, 0, gragh, colors);
					break;
				}		
			}		
		}
	}
	
	private static void run(int color, int index, ArrayList<Integer>[] gragh, int[] colors)
	{
		if(colors[index] != 0)
		{
			run(color, index + 1, gragh, colors);
			return;
		}
		
		ArrayList<Integer> neighbors = gragh[index];
		for(int i = 1; i <= color; i++)
		{
			boolean ok = true;
			for(int neighbor : neighbors)
			{
				if(neighbor < index)
				{
					if(colors[neighbor] == i)
					{
						ok = false;
						break;
					}
				}
			}
			
			if(ok)
			{
				colors[index] = i;
				if(index == n-1)
				{
					done = true;
					System.out.println(color);
					System.exit(0);
				}
				else
				{
					run(color, index + 1, gragh, colors);
					if(done)
					{
						return;
					}
					else
					{
						colors[index] = 0;
						continue;
					}
				}
			}
		}
	}

}
