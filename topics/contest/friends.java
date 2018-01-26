package contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class friends {
	class edge
	{
		int src;
		int det;
		
		public edge(int src, int det)
		{
			this.src = src;
			this.det = det;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String args[])
	{
		friends friend = new friends();
		Scanner in = new Scanner(System.in);
		int v = in.nextInt();
		int e = in.nextInt();
		
		ArrayList<String> names = new ArrayList<String>(v);
		LinkedList<edge>[] graph = new LinkedList[v];
		for(int i = 0; i < v; i++)
		{
			graph[i] = new LinkedList<edge>();
			names.add(in.next());
		}
		

		for(int i = 0; i < e; i++)
		{
			String first = in.next();
			String second = in.next();
			int i1 = names.indexOf(first);
			int i2 = names.indexOf(second);
			edge e1 = friend.new edge(i1, i2);
			edge e2 = friend.new edge(i2, i1);
			graph[i1].add(e1);
			graph[i2].add(e2);
		}
		
		String src1 = in.next();
		int src = names.indexOf(src1);
		LinkedList<edge> queue = new LinkedList<edge>();
		ArrayList<Integer> bag = new ArrayList<Integer>();
		
		for(edge temp : graph[src])
		{
			queue.addLast(temp);
		}
		
		bag.add(src);
		
		while(!queue.isEmpty())
		{
			edge ed = queue.removeFirst();
			if(isCut(bag, ed))
			{
				bag.add(ed.det);
				LinkedList<edge> newCut = graph[ed.det];
				for(edge temp : newCut)
				{
					if(isCut(bag, temp))
					{
						queue.addLast(temp);
					}
				}
			}
		}
		
		bag.remove(0);
		ArrayList<Integer> friendList = new ArrayList<Integer>();
		for(edge temp : graph[src])
		{
			friendList.add(temp.det);
		}
		
		ArrayList<String> group = new ArrayList<String>();
		for(int i : bag)
		{
			if(!friendList.contains(i))
			{
				group.add(names.get(i));
			}
		}
		
		if(group.isEmpty())
		{
			System.out.println("none");
		}
		else
		{
			Collections.sort(group);
			for(String name : group)
			{
				System.out.println(name);
			}
		}
		
		in.close();
		
	}
	
	private static boolean isCut(ArrayList<Integer> bag, edge e)
	{
		if(bag.contains(e.det) && bag.contains(e.src))
		{
			return false;
		}
		else
		{
			return true;
		}
	}

}
