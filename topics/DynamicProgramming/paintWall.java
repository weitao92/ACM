package DynamicProgramming;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class paintWall {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		HashMap<BigInteger, LinkedList<BigInteger>> map = new HashMap<BigInteger, 
				LinkedList<BigInteger>>();
		ArrayList<BigInteger> list = new ArrayList<BigInteger>();
		int artist = in.nextInt();
		for(int i = 0; i < artist; i++)
		{
			BigInteger start = new BigInteger(in.next());
			BigInteger end = new BigInteger(in.next());
			list.add(end);
			if(map.containsKey(end))
			{
				map.get(end).add(start);
			}
			else
			{
				LinkedList<BigInteger> starts = new LinkedList<BigInteger>();
				starts.add(start);
				map.put(end, starts);
			}
		}
		in.close();
		Collections.sort(list);
		
		BigInteger[] results = new BigInteger[artist+1];
		results[0] = new BigInteger("0");
		for(int i = 1; i <= artist; i++)
		{
			BigInteger end = list.get(i-1);
			BigInteger start = map.get(end).removeFirst();
			BigInteger time = end.subtract(start);
			BigInteger first = results[i-1];
			BigInteger second = time.add(results[findNonOverlap(list, 0, i-2, start)]);
			results[i] = first.compareTo(second) >= 0 ? first : second;
		}
		
		System.out.println(results[artist]);
	}
	
	private static int findNonOverlap(ArrayList<BigInteger> list, 
			int start, int end, BigInteger startTime)
	{
		if(start > end)
		{
			return end + 1;
		}
		else
		{
			int mid = (start + end) / 2;
			if(list.get(mid).compareTo(startTime) == 0)
			{
				/**
				while(list.get(mid).compareTo(startTime) == 0)
				{
					mid++;
				}
				**/
				return mid + 1;
			}
			else if(list.get(mid).compareTo(startTime) < 0)
			{
				return findNonOverlap(list, mid + 1, end, startTime);
			}
			else
			{
				return findNonOverlap(list, start, mid - 1, startTime);
			}
		}
	}

}
