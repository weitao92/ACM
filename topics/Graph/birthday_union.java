package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class birthday_union {
	
	static class edge
	{
		int src;
		int det;
		
		edge(int src, int det)
		{
			this.src = src;
			this.det = det;
		}
	}

	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		while(true)
		{
			int v = in.nextInt();
			int e = in.nextInt();
			if(v == 0 && e == 0)
			{
				in.close();
				System.exit(0);
			}

			LinkedList<edge> edges = new LinkedList<edge>();
			
			for(int i = 0; i < e; i++)
			{
				edge ed = new edge(in.nextInt(), in.nextInt());
				edges.add(ed);
			}
			
			boolean result = true;
			outMost: for(int i = 0; i < e; i++)
			{			
				int[] union = new int[v];
				Arrays.fill(union, -1);
				edge ed = edges.remove(i);
				int num = v;
				for(edge e1 : edges)
				{
					int start = e1.src;
					int end = e1.det;
					int root1 = root(start, union);
					int root2 = root(end, union);
					
					if(root1 != root2)
					{
						union[root1] = root2;
						num--;
					}
				}
				
				result = num == 1;
				if(!result)
				{
					System.out.println("Yes");
					break outMost;
				}
				edges.add(i, ed);
			}
			
			if(result)
			{
				System.out.println("No");
			}
		}
	}
	
	private static int root(int i, int[] union)
	{
		while(union[i] != -1)
		{
			i = union[i];
		}
		return i;
	}
	
	@SuppressWarnings("unused")
	private static boolean count(int[] union)
	{
		int num = 0;
		for(int a : union)
		{
			if(a == -1)
			{
				num++;
			}
			if(num > 1)
			{
				return false;
			}
		}
		
		return true;
	}
}
