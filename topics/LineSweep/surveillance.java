package LineSweep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * https://pcs.cs.cloud.vt.edu/contests/52/problems/B
 */
public class surveillance {
	
	static class interval implements Comparable<interval>
	{
		int start;
		int end;
		
		public interval(int start, int end)
		{
			this.start = start;
			this.end = end;
		}
		
		public int compareTo(interval another)
		{
			return Integer.compare(start, another.start);
		}
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int length = in.nextInt();
		int cameras = in.nextInt();
		ArrayList<interval> list = new ArrayList<interval>();
		
		for(int i = 0; i < cameras; i++)
		{
			interval camera = new interval(in.nextInt(), in.nextInt());
			list.add(camera);
		}
		in.close();
		Collections.sort(list);
		
		int leftEnd = 0;
		int rightEnd = 0;
		int index = 0;
		int size = 0;
		
		while(index < cameras && leftEnd < length)
		{		
			while(index < cameras && list.get(index).start <= leftEnd)
			{
				if(list.get(index).end > rightEnd)
				{
					rightEnd = list.get(index).end;
				}
				index++;
			}
			
			if(rightEnd == leftEnd)
			{
				break;
			}
			
			size++;
			leftEnd = rightEnd;
		}
		
		if(rightEnd < length)
		{
			System.out.println("coverage incomplete");
		}
		else
		{
			System.out.println(size);
		}
	}

}
