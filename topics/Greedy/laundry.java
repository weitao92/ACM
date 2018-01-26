package Greedy;
import java.util.*;

/**
 * https://pcs.cs.cloud.vt.edu/contests/35/problems/C
 * @author weitao92
 *
 */
public class laundry {
	static class wrap implements Comparable<wrap>
	{
		int index;
		long current;
		
		public wrap(int i, long c)
		{
			index = i;
			current = c;
		}

		@Override
		public int compareTo(wrap o) {
			return Long.compare(current, o.current);
		}
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= T; i++)
		{
			sb.append("Case #" + i + ": ");
			int l = in.nextInt();
			int n = in.nextInt();
			long m = in.nextLong();
			long d = in.nextLong();
			long[] arr = new long[n];
			PriorityQueue<wrap> wash = new PriorityQueue<wrap>();
			PriorityQueue<Long> dry = new PriorityQueue<Long>();
			for(int j = 0; j < n; j++)
			{
				long time = in.nextLong();
				arr[j] = time;
				wash.add(new wrap(j, time));
			}
			
			for(int j = 0; j < l; j++)
			{
				wrap current = wash.poll();
				long currentD;
				if(m > 0)
				{
					currentD = 0l;
					m--;
				}
				else
				{
					currentD = dry.poll();
				}
 
				wash.add(new wrap(current.index, current.current + arr[current.index]));
				long mark = Math.max(current.current, currentD);
				dry.add(mark + d);
			}
			long result = 0;
			while(!dry.isEmpty())
			{
				result = dry.poll();
			}
			sb.append(result + "\n");
		}
		System.out.print(sb);
	}

}
