package Hashing;

import java.util.*;

/**
 * https://pcs.cs.cloud.vt.edu/contests/64/problems/E
 * @author weitao92
 *
 */
public class D {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		String dict = in.next();		
		int n = in.nextInt();
		String[] arr = new String[n];
		HashSet<Integer> sizes = new HashSet<Integer>();
		for(int i = 0; i < n; i++)
		{
			String next = in.next();
			arr[i] = next;
			sizes.add(next.length());
		}
		@SuppressWarnings("unchecked")
		HashMap<String, Integer>[] maps = new HashMap[27];
		for(int l : sizes)
		{
			maps[l] = getMap(dict, l);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++)
		{
			String next = arr[i];
			HashMap<String, Integer> current = maps[next.length()];
			sb.append(get(current, next) + "\n");
		}
		System.out.print(sb);
	}
	
	private static HashMap<String, Integer> getMap(String dict, int length)
	{
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i <= dict.length()-length; i++)
		{
			String sub = dict.substring(i, i+length);
			if(!map.containsKey(sub))
			{
				map.put(sub, 1);
			}
			else
			{
				map.put(sub, map.get(sub)+1);
			}
		}
		return map;
	}
	
	private static int get(HashMap<String, Integer> map, String target)
	{
		if(map.containsKey(target))
		{
			return map.get(target);
		}
		else
		{
			return 0;
		}
	}

}
