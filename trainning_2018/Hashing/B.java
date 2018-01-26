package Hashing;

import java.util.*;

public class B {
	
	static class candidate implements Comparable<candidate>
	{
		String name;
		int vote;
		
		public candidate(String n, int v)
		{
			name = n;
			vote = v;
		}

		@Override
		public int compareTo(candidate a) {
			if(vote == a.vote)
			{
				return name.compareTo(a.name);
			}
			return -Integer.compare(vote, a.vote);
		}
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i < n; i++)
		{
			String next = in.next();
			if(!map.containsKey(next))
			{
				map.put(next, 1);
			}
			else
			{
				map.put(next, map.get(next)+1);
			}
		}
		PriorityQueue<candidate> maxHeap = new PriorityQueue<candidate>();
		for(String s : map.keySet())
		{
			maxHeap.add(new candidate(s, map.get(s)));
		}
		StringBuilder sb = new StringBuilder();
		candidate first = maxHeap.poll();
		sb.append(first.name + "\n");
		while(!maxHeap.isEmpty() && maxHeap.peek().vote == first.vote)
		{
			sb.append(maxHeap.poll().name + "\n");
		}
		System.out.print(sb);
	}

}
