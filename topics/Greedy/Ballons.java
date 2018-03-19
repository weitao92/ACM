package Greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Ballons {
	
	static class team implements Comparable<team>
	{
		int da;
		int db;
		int k;
		int min;
		int diff;
		int index;
		
		public team(int da, int db, int k, int i)
		{
			this.da = da;
			this.db = db;
			this.k = k;
			min = da < db ? da : db;
			diff = Math.abs(da - db);
			index = i;
		}

		@Override
		public int compareTo(team o) {
			
			return -Integer.compare(diff, o.diff);
		}
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		while(true)
		{
			int teams = in.nextInt();
			int A = in.nextInt();
			int B = in.nextInt();
			
			if(teams == 0 && A == 0 && B == 0)
			{
				break;
			}
			else
			{
				boolean[] finished = new boolean[teams];
				int finish = 0;
				long distance = 0;
				PriorityQueue<team> queue = new PriorityQueue<team>();
				for(int i = 0; i < teams; i++)
				{
					int k = in.nextInt();
					int da = in.nextInt();
					int db = in.nextInt();
					team t = new team(da,db,k,i);
					queue.add(t);
				}
				
				while(finish != teams)
				{
					team t = queue.poll();
					finished[t.index] = true;
					finish++;
					if(t.min == t.da)
					{	
						if(A - t.k >= 0)
						{
							distance += t.k * t.min;
							A -= t.k;
						}
						else
						{
							distance += A * t.min;
							distance += (t.k - A) * (t.min + t.diff);
							B -= (t.k - A);
							A = 0;
						}
					}
					else
					{
						if(B - t.k >= 0)
						{
							distance += t.k * t.min;
							B -= t.k;
						}
						else
						{
							distance += B * t.min;
							distance += (t.k - B) * (t.min + t.diff);
							A -= (t.k - B);
							B = 0;
						}
					}
				}
				
				System.out.println(distance);
			}
		}
		
		in.close();
	}

}
