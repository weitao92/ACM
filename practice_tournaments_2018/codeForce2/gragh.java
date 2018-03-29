package codeForce2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * codeforce 862B.
 * @author weitao92
 *
 */
public class gragh {
	
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
		LinkedList<Integer>[] gragh = new LinkedList[n];
		for(int i = 0; i < n; i++)
		{
			gragh[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < n-1; i++)
		{
			int s = in.nextInt();
			int d = in.nextInt();

			gragh[s-1].add(d-1);
			gragh[d-1].add(s-1);
		}
		
		boolean visited[] = new boolean[n];
		//visited[0] = true;
		LinkedList<node> queue = new LinkedList<node>();
		queue.add(new node(0, true));
		ArrayList<Integer> red = new ArrayList<Integer>();
		ArrayList<Integer> blue = new ArrayList<Integer>();
		//boolean[] sets = new boolean[n];
		
		while(!queue.isEmpty())
		{
			node current = queue.removeFirst();
			//sets[current.v] = current.red;
			visited[current.v] = true;
			if(current.red)
			{
				red.add(current.v);
			}
			else
			{
				blue.add(current.v);
			}
			
			
				for(int k : gragh[current.v])
				{
					if(!visited[k])
					{
						queue.add(new node(k, !current.red));
					}
				}
			
		}
		
		//System.out.println(red.size() + " " + blue.size());
		BigInteger rs = BigInteger.valueOf(red.size());
		BigInteger bs = BigInteger.valueOf(blue.size());
		BigInteger result = (rs.multiply(bs)).subtract(BigInteger.valueOf(n-1));
		/**
		for(int i = 0; i < n; i++)
		{
			TreeSet<Integer> set = new TreeSet<Integer>();
			for(int j = 0; j < n; j++)
			{
				if(j != i)
				{
					set.add(j);
				}
			}
			
			set.removeAll(gragh[i]);
			
			if(sets[i])
			{
				for(int j : blue)
				{
					if(set.contains(j))
					{
						result++;
						gragh[j].add(i);
						//gragh[j][i] = 1;
					}
				}
			}
			else
			{
				for(int j : red)
				{
					if(set.contains(j))
					{
						result++;
						gragh[j].add(i);
						//gragh[j][i] = 1;
					}
				}
			}
		}
		**/
		System.out.println(result);
		
		
		
		
	}

}
