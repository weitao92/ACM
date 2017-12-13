package NCPC2017;

import java.util.*;

/**
 * https://open.kattis.com/problems/importspaghetti
 */
public class ProblemI {
	
	static class walk
	{
		int len;
		int current;
		int prev;
		walk preW;
		
		public walk(int l, int cur, int p, walk preW)
		{
			len = l;
			current = cur;
			prev = p;
			this.preW = preW;
		}
	}
	
	static long length = Long.MAX_VALUE;
	static ArrayDeque<Integer> path = new ArrayDeque<Integer>();
	static ArrayList<Integer>[] gragh;
	static int n;
	
	@SuppressWarnings("unchecked")
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		gragh = new ArrayList[n];
		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
		HashMap<Integer, String> map2 = new HashMap<Integer, String>();
		for(int i = 0; i < n; i++)
		{
			gragh[i] = new ArrayList<Integer>();
			String name = in.next();
			map1.put(name, i);
			map2.put(i, name);
		}
		
		for(int i = 0; i < n; i++)
		{
			in.next();
			int k = in.nextInt();
			in.nextLine();
			for(int j = 0; j < k; j++)
			{
				String line = in.nextLine();
				line = line.substring(7, line.length());
				String[] parts = line.split(", ");
				for(String s : parts)
				{
					gragh[i].add(map1.get(s));
				}
			}
		}
		
		
		for(int i = 0; i < n; i++)
		{
			bfs(i);
		}
		
		if(length == Long.MAX_VALUE)
		{
			System.out.print("SHIP IT");
		}
		else
		{
			StringBuilder sb = new StringBuilder();
			for(int i : path)
			{
				sb.append(map2.get(i) + " ");
			}
			sb.substring(0, sb.length() - 1);
			System.out.print(sb);
		}
	}
	
	private static void bfs(int src)
	{
		long local = Long.MAX_VALUE;
		ArrayDeque<Integer> localPath = new ArrayDeque<Integer>();
		ArrayDeque<walk> queue = new ArrayDeque<walk>();
		
		walk start = new walk(0,src,-1,null);
		queue.add(start);
		boolean[] visited = new boolean[n];
		visited[src] = true;
		
		outMost: while(!queue.isEmpty())
		{
			walk path1 = queue.removeFirst();
			
			int current = path1.current;
			
			for(int next : gragh[current])
			{	
				if(next == src)
				{						
					local = path1.len + 1;
					while(path1 != null)
					{
						localPath.addFirst(path1.current);
						path1 = path1.preW;
					}
					
					break outMost;		
				}
				else
				{
					if(!visited[next])
					{
						queue.addLast(new walk(path1.len + 1, next, current, path1));
						visited[next] = true;
					}
				}
				
			}
		}
		
		if(local != Long.MAX_VALUE)
		{
			if(local < length)
			{
				length = local;
				path = localPath;
			}
		}
	}

}
