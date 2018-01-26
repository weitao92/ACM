package Graph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class buttonBashing {
	
	@SuppressWarnings("unchecked")
	static LinkedList<Integer>[] gragh = new LinkedList[3601];
	static int num;
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int tests = in.nextInt();
		for(int i = 0; i < tests; i++)
		{
			num = 0;
			int b = in.nextInt();
			int time = in.nextInt();
			for(int j = 0; j < 3601; j++)
			{
				gragh[j] = new LinkedList<Integer>();
			}
			
			for(int j = 0; j < b; j++)
			{
				int button = in.nextInt();
				//System.out.println(button);
				for(int x = 0; x <= 3600 - button && x <= 3600; x++)
				{
					if(x+button >= 0)
					{
						gragh[x].add(x+button);
						gragh[x+button].add(x);
					}
				}
			}
			
			
			for(int j = time; j <= 3600; j++)
			{
				boolean result = bfs(j);
				if(result)
				{
					int difference = j - time;
					System.out.println(num + " " + difference);
					break;
				}
			}
		}
		
		in.close();
	}
	
	static class point
	{
		int value;
		int level;
		
		point(int value, int level)
		{
			this.value = value;
			this.level = level;
		}
	}
	
	private static boolean bfs(int src)
	{
		Queue<point> queue = new ArrayDeque<point>();
		boolean[] checked = new boolean[3601];
		queue.add(new point(src, 0));
		
		while(!queue.isEmpty())
		{
			point p = queue.poll();
			checked[p.value] = true;
			if(p.value == 0)
			{
				num = p.level;
				return true;
			}
			else
			{
				for(int i : gragh[p.value])
				{
					if(!checked[i])
					{
						queue.add(new point(i, p.level + 1));
					}
				}
			}
		}
		
		return false;
	}

}
