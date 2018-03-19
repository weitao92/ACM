package codeForce2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class gragh1 {
	
	static class node
	{
		int v;
		boolean red;
		
		public node(int v, boolean red)
		{
			this.v = v;
			this.red = red;
		}
	}
	
	public static void main(String agrs[])
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		Integer[][] gragh = new Integer[n][];
		for(int i = 0; i < n; i++)
		{
			gragh[i] = new Integer[n-i-1];
			
		}
		
		for(int i = 0; i < n-1; i++)
		{
			int s = in.nextInt() - 1;
			int d = in.nextInt() - 1;
			int bigger = s > d ? s : d;
			int smaller = s > d ? d : s;
			gragh[smaller][bigger-smaller-1] = new Integer(1);
			//gragh[d-1][s-1] = 1;
		}
		
		
		
		boolean visited[] = new boolean[n];
		//visited[0] = true;
		LinkedList<node> queue = new LinkedList<node>();
		queue.add(new node(0, true));
		ArrayList<Integer> red = new ArrayList<Integer>();
		ArrayList<Integer> blue = new ArrayList<Integer>();
		boolean[] sets = new boolean[n];
		
		while(!queue.isEmpty())
		{
			node current = queue.removeFirst();
			sets[current.v] = current.red;
			visited[current.v] = true;
			if(current.red)
			{
				red.add(current.v);
			}
			else
			{
				blue.add(current.v);
			}
			
			for(int i = 0; i < n; i++)
			{
				if(i == current.v)
				{
					continue;
				}
				if(i < current.v)
				{
					if(gragh[i][current.v-i-1] != null)
					{
						if(gragh[i][current.v-i-1].equals(new Integer(1)))
						{
							if(!visited[i])
							{
								queue.add(new node(i, !current.red));
							}
						}
					}
				}
				else
				{
					if(gragh[current.v][i-current.v-1] != null)
					{
						if(gragh[current.v][i-current.v-1].equals(new Integer(1)))
						{
							if(!visited[i])
							{
								queue.add(new node(i, !current.red));
							}
						}
					}
				}
			}
		}
		
		//System.out.println(red.size() + " " + blue.size());
		
		long result = 0;
		for(int i = 0; i < n; i++)
		{
			if(sets[i])
			{
				for(int j : blue)
				{
					if(j < i)
					{
						if(gragh[j][i-j-1] == null)
						{
							
								result++;
								gragh[j][i-j-1] = new Integer(1);
							
						}
					}
					else
					{
						if(gragh[i][j-i-1] == null)
						{
							
								result++;
								gragh[i][j-i-1] = new Integer(1);
							
						}
					}
				}
			}
			else
			{
				for(int j : red)
				{
					if(j < i)
					{
						if(gragh[j][i-j-1] == null)
						{
							
								result++;
								gragh[j][i-j-1] = new Integer(1);
							
						}
					}
					else
					{
						if(gragh[i][j-i-1] == null)
						{
								result++;
								gragh[i][j-i-1] = new Integer(1);
							
						}
					}
				}
			}
		}
		
		System.out.println(result);
		
		
		
		
	}

}