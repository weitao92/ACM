package ECNA2016;
import java.util.*;

/**
 * https://open.kattis.com/problems/lost
 * @author weitao92
 *
 */
public class D {
	
	static class edge
	{
		int src;
		int det;
		int length;
		int level;
		
		public edge(int s, int d, int len, int l)
		{
			src = s;
			det = d;
			length = len;
			level = l;
		}
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<edge>[] gragh = new ArrayList[n+1];
		int m = in.nextInt();
		HashMap<String,Integer> map1 = new HashMap<String,Integer>();
		map1.put("English", 0);
		
		for(int i = 1; i <= n; i++)
		{
			String name = in.next();
			map1.put(name, i);
		}
		
		for(int i = 0; i <= n; i++)
		{
			gragh[i] = new ArrayList<edge>();
		}
		
		for(int i = 0; i < m; i++)
		{
			String source = in.next();
			String destination = in.next();
			int length = in.nextInt();
			
			//edge e = new edge(map1.get(source), map1.get(destination), length, 0);
			gragh[map1.get(source)].add(new edge(map1.get(source), map1.get(destination), length, 0));
			gragh[map1.get(destination)].add(new edge(map1.get(destination), map1.get(source), length, 0));
		}
		
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		long result = 0;
		long currentLevel = 0;
		boolean[] visited = new boolean[n+1];
		visited[0] = true;
		ArrayDeque<edge> queue = new ArrayDeque<edge>();
		
		for(edge e : gragh[0])
		{
			queue.addLast(new edge(e.src, e.det, e.length, 1));
			int next = e.det;
			if(!map.containsKey(next))
			{
				map.put(next, e.length);
			}
			else
			{
				int cl = map.get(next);
				if(e.length < cl)
				{
					map.put(next, e.length);
				}
			}
		}
		
		//ArrayDeque<edge> queue = new ArrayDeque<edge>();
		while(!queue.isEmpty())
		{
			edge current = queue.removeFirst();
			
			if(current.level > currentLevel)
			{
				for(int key : map.keySet())
				{
					visited[key] = true;
					result += map.get(key);
				}
				
				currentLevel = current.level;
				map = new HashMap<Integer,Integer>();
			}
			
			for(edge e : gragh[current.det])
			{
				if(!visited[e.det])
				{
					queue.addLast(new edge(e.src, e.det, e.length, current.level + 1));
					int next = e.det;
					if(!map.containsKey(next))
					{
						map.put(next, e.length);
					}
					else
					{
						int cl = map.get(next);
						if(e.length < cl)
						{
							map.put(next, e.length);
						}
					}
				}
			}
		}
		
		for(int key : map.keySet())
		{
			visited[key] = true;
			result += map.get(key);
		}
		
		for(int i = 1; i <= n; i++)
		{
			if(!visited[i])
			{
				System.out.println("Impossible");
				System.exit(0);
			}
		}
		
		System.out.println(result);
	}

}