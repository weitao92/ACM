package bloomCon;

import java.util.*;

/**
 * https://codecon.bloomberg.com/contest/472/4975
 * @author weitao92
 *
 */
public class linking {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		String target = in.next();
		
		int n = in.nextInt();
		HashMap<String, PriorityQueue<String>> gragh = new HashMap<String, PriorityQueue<String>>();
		HashMap<String, ArrayList<String>> gragh1 = new HashMap<String, ArrayList<String>>();
		HashMap<String, Integer> index1 = new HashMap<String, Integer>();
		HashMap<Integer, String> index2 = new HashMap<Integer, String>();
		int[] into = new int[n];
		String[] libs = new String[n];
		//ArrayList<Integer>[] gragh = new ArrayList[n];
		for(int i = 0; i < n; i++)
		{
			String lib = in.next();
			libs[i] = lib;
			index1.put(lib, i);
			index2.put(i, lib);
			ArrayList<String> ls = new ArrayList<String>();
			//ArrayList<String> dep = new ArrayList<String>();
			int m = in.nextInt();
			for(int j = 0; j < m; j++)
			{
				String name = in.next();
				ls.add(name);
				if(gragh.get(name) == null)
				{
					PriorityQueue<String> adj = new PriorityQueue<String>();
					adj.add(lib);
					gragh.put(name, adj);
				}
				else
				{
					gragh.get(name).add(lib);
				}
				//dep.add(name);
				into[i]++;
			}
			gragh1.put(lib, ls);
			//gragh.put(lib, dep);
		}
		
		
		
		for(int i = 0; i < n; i++)
		{
			String current = libs[i];
			if(gragh.get(current) == null)
			{
				gragh.put(current, new PriorityQueue<String>());
			}
		}
		
		boolean[] connected = new boolean[n];
		int start = index1.get(target);
		connected[start] = true;
		ArrayDeque<String> queue1 = new ArrayDeque<String>();
		queue1.add(target);
		while(!queue1.isEmpty())
		{
			String c = queue1.removeFirst();
			int index = index1.get(c);
			connected[index] = true;
			for(String s : gragh1.get(c))
			{
				int ni = index1.get(s);
				if(!connected[ni])
				{
					queue1.addLast(s);
				}
			}
		}
		
		PriorityQueue<String> queue = new PriorityQueue<String>();
		for(int i = 0; i < n; i++)
		{
			if(into[i] == 0)
			{
				String name = index2.get(i);
				if(name.equals(target))
				{
					System.out.print(target);
					System.exit(0);
				}
				queue.add(index2.get(i));
				
				
			}
		}
		
		StringBuilder sb = new StringBuilder();
		boolean finish = true;
		while(finish)
		{
			ArrayList<String> list = new ArrayList<String>();
			while(!queue.isEmpty())
			{
				String current = queue.poll();
				int id = index1.get(current);
				if(!connected[id])
				{
					continue;
				}
				PriorityQueue<String> adj = gragh.get(current);
				//System.out.println(adj.size());
				while(!adj.isEmpty())
				{
					String next = adj.poll();
					int index = index1.get(next);
					into[index]--;
					if(into[index] == 0)
					{
						list.add(next);
					}
				}
				
				sb.append(current + " ");
				if(current.equals(target))
				{
					finish = false;
					break;
				}
			}
			queue.addAll(list);
		}
		
		System.out.print(sb);
		
		
	}

}
