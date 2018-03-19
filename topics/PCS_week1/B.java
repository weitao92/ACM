package PCS_week1;

import java.util.*;

/**
 * https://pcs.cs.cloud.vt.edu/contests/62/problems/B
 * @author weitao92
 *
 */
public class B {
	
	static class pair
	{
		int x;
		int y;
		
		public pair(int a, int b){
			x = a; y = b;
		}
	}
	
	static class whatever implements Comparable<whatever>
	{
		String key;
		int value;
		
		public whatever(String k, int v)
		{
			key = k;
			value = v;
		}
		@Override
		public int compareTo(whatever o) {
			if(value == o.value)
			{
				return key.compareTo(o.key);
			}
			return Integer.compare(value, o.value);
		}
		
	}
	
	static HashMap<Character, pair> m = new HashMap<Character, pair>();
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		char[][] map = new char[3][10];
		char[] c1 = {'q','w','e','r','t','y','u','i','o','p'};
		char[] c2 = {'a','s','d','f','g','h','j','k','l','0'};
		char[] c3 = {'z','x','c','v','b','n','m','0','0','0'};
		map[0] = c1;
		map[1] = c2;
		map[2] = c3;
		
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				if(map[i][j] != '0')
				{
					m.put(map[i][j], new pair(i,j));
				}
			}
		}
		int tests = in.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < tests; i++)
		{
			String original = in.next();
			ArrayList<whatever> w = new ArrayList<whatever>();
			int n = in.nextInt();
			for(int j = 0; j < n; j++)
			{
				String s1 = in.next();
				w.add(new whatever(s1, compare(original, s1)));			
			}
			Collections.sort(w);
			for(whatever w1 : w)
			{
				sb.append(w1.key + " " + w1.value + "\n");
			}
		}
		System.out.print(sb);
	}
	
	private static int compare(String a, String b)
	{
		int result = 0;
		for(int i = 0; i < a.length(); i++)
		{
			char c1 = a.charAt(i);
			char c2 = b.charAt(i);
			if(c1 == c2)
			{
				continue;
			}
			pair p1 = m.get(c1);
			pair p2 = m.get(c2);
			result += Math.abs(p1.x - p2.x);
			result += Math.abs(p1.y - p2.y);
		}
		return result;
	}

}
