package Graph;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class topological {
	
	@SuppressWarnings("unchecked")
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		
		ArrayList<Integer>[] gragh = new ArrayList[n];
		for(int i = 0; i < n; i++)
		{
			gragh[i] = new ArrayList<Integer>();
		}
		
		int[] incomings = new int[n];
		for(int i = 0; i < m; i++)
		{
			int first = in.nextInt() - 1;
			int second = in.nextInt() - 1;
			
			gragh[first].add(second);
			incomings[second]++;
		}
		
		in.close();
		System.out.println(sort(gragh, m, incomings));	
	}
	
	private static int sort(ArrayList<Integer>[] gragh, int edges, int[] incomings)
	{
		ArrayDeque<Integer> noIncomings = new ArrayDeque<Integer>();
		for(int i = 0; i < incomings.length; i++)
		{
			if(incomings[i] == 0)
			{
				noIncomings.add(i);
			}
		}
		
		if(noIncomings.size() == 0)
		{
			return 0;
		}
		
		boolean single = true;
		int removed = 0;
		while(!noIncomings.isEmpty())
		{
			if(noIncomings.size() > 1)
			{
				single = false;
			}
			
			int origin = noIncomings.poll();
			for(int next : gragh[origin])
			{
				removed++;
				incomings[next]--;
				if(incomings[next] == 0)
				{
					noIncomings.add(next);
				}
			}
		}
		
		if(removed != edges)
		{
			return 0;
		}
		else
		{
			if(single)
			{
				return 1;
			}
			else
			{
				return 2;
			}
		}
	}
}