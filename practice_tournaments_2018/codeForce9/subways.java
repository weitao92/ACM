package codeForce9;

import java.util.*;

/**
 * http://codeforces.com/contest/884/problem/C
 * @author weitao92
 *
 */
public class subways {

	//static HashSet<Integer>[] gragh;
	static int n;
	static int[] roots;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		roots = new int[n];
		Arrays.fill(roots, -1);
		int[] sub = new int[n];
		
		for(int i = 0; i < n; i++)
		{
			int next = in.nextInt() - 1;
			int r1 = rootOf(i);
			int value1;
			if(sub[r1] == 0)
			{
				value1 = 1;
			}
			else
			{
				value1 = sub[r1];
			}
			int r2 = rootOf(next);
			int value2;
			if(sub[r2] == 0)
			{
				value2 = 1;
			}
			else
			{
				value2 = sub[r2];
			}
			
			if(r1 != r2)
			{
				roots[r1] = r2;
				sub[r2] = value1 + value2;
			}
		}
		
		/**
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < n; i++)
		{
			int r = rootOf(i);
			if(!map.containsKey(r))
			{
				map.put(r, 1);
			}
			else
			{
				map.put(r, map.get(r) + 1);
			}
		}
		
		ArrayList<Integer> sets = new ArrayList<Integer>(map.values());
		**/
		
		ArrayList<Integer> sets = new ArrayList<Integer>();
		for(int i = 0; i < n; i++)
		{
			if(roots[i] == -1)
			{
				int num = sub[i];
				if(num == 0)
				{
					num = 1;
				}
				//System.out.println("for root: " + i + " the num of subset is: " + num);
				sets.add(num);
			}
		}
		
		
		if(sets.size() < 2)
		{
			//System.out.println("i am here");
			System.out.println((long)(Math.pow(sets.get(0), 2)));
			System.exit(0);
		}
		Collections.sort(sets);
		int largest = sets.remove(sets.size()-1);
		int second = sets.remove(sets.size()-1);
		long result = (long) Math.pow((largest + second),2);
		for(int left : sets)
		{
			result += (long)Math.pow(left, 2);
		}
		
		System.out.println(result);
	}
	
	private static int rootOf(int src)
	{
		while(roots[src] != -1)
		{
			src = roots[src];
		}
		
		return src;
	}
	
	

}
