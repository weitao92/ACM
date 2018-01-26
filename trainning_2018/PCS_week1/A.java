package PCS_week1;
import java.util.*;

/**
 * https://pcs.cs.cloud.vt.edu/contests/62/problems
 * @author weitao92
 *
 */
public class A {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int tests = in.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < tests; i++)
		{
			HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
			HashMap<String, HashSet<String>> map1 = new HashMap<String, HashSet<String>>();
			int n = in.nextInt();
			for(int j = 0; j < n; j++)
			{
				in.next();
				int m1 = in.nextInt();
				HashSet<String> foreigns = new HashSet<String>();
				for(int k = 0; k < m1; k++)
				{
					String foreign1 = in.next();
					foreigns.add(foreign1);
				}
				int m2 = in.nextInt();
				HashSet<String> natives = new HashSet<String>();
				for(int k = 0; k < m2; k++)
				{
					String native1 = in.next();
					natives.add(native1);
				}
				
				for(String foreign : foreigns)
				{
					if(map.containsKey(foreign))
					{
						map.put(foreign, union(map.get(foreign), natives));
					}
					else
					{
						map.put(foreign, natives);
					}
				}
				for(String nn : natives)
				{
					if(map1.containsKey(nn))
					{
						map1.put(nn, union(map1.get(nn), foreigns));
					}
					else
					{
						map1.put(nn, foreigns);
					}
				}
			}
			
			HashMap<String, HashSet<String>> result = new HashMap<String, HashSet<String>>();
			for(String key : map.keySet())
			{
				result.put(key, new HashSet<String>());
				HashSet<String> s = map.get(key);
				for(String ss : s)
				{
					if(map1.get(ss).contains(key))
					{
						result.get(key).add(ss);
					}
				}
			}
			PriorityQueue<String> f = new PriorityQueue<String>();
			f.addAll(result.keySet());
			while(!f.isEmpty())
			{
				String first = f.remove();
				HashSet<String> set = result.get(first);
				PriorityQueue<String> na = new PriorityQueue<String>();
				na.addAll(set);
				while(!na.isEmpty())
				{
					String possible = na.remove();
					sb.append("(" + first + ", " + possible + ")\n");
				}
			}
			sb.append("\n");
		}
		sb = new StringBuilder(sb.substring(0, sb.length()-2));
		in.close();
		System.out.print(sb);
	}
	
	private static HashSet<String> union(HashSet<String> A, HashSet<String> B)
	{		
		HashSet<String> C = new HashSet<String>();
		for(String s : A)
		{
			if(B.contains(s))
			{
				C.add(s);
			}
		}
		return C;
	}

}
