package mid_atlantic_2016;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class delivery {
	
	static class det implements Comparable<det>
	{
		int dis;
		int mail;
		
		public det(int d, int m)
		{
			dis = d;
			mail = m;
		}

		@Override
		public int compareTo(det o) {
			return Integer.compare(dis, o.dis);
		}
		
		
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int cap = in.nextInt();
		ArrayList<det> list = new ArrayList<det>();
		for(int i = 0; i < n; i++)
		{
			int d = in.nextInt();
			int m = in.nextInt();
			det de = new det(d,m);
			list.add(de);
		}
		
		//Collections.sort(list);
		
		BigInteger result = new BigInteger("0");
		
		det origin = new det(0, 0);
		int place = Collections.binarySearch(list, origin);
		place = -place - 1;
		int load;
		while(!list.isEmpty() && place < list.size())
			{
			
			
			load = cap;
			
				//int load = cap;
				det max = list.get(list.size() - 1);
				result = result.add(BigInteger.valueOf(max.dis * 2));
				while(max.dis > 0)
				{
					//max = list.get(list.size() - 1);
					//result += max.dis * 2;
					if(load - max.mail >= 0)
					{
						
						load -= max.mail;
						list.remove(list.size() - 1);
						if(list.size() == 0)
						{
							break;
						}
						else
						{
							max = list.get(list.size() - 1);
						}
					}
					else
					{
						list.get(list.size() - 1).mail -= load;
						break;
					}
				}
				//place = Collections.binarySearch(list, origin);
				//place = -place - 1;
				//System.out.println(place);
			}
			
			
			place = Collections.binarySearch(list, origin);
			place = -place - 1;
			//System.out.println(list.size() +  " " + place);
			
			while(!list.isEmpty() && place > 0)
			{
			
				det min = list.get(0);
				result = result.add(BigInteger.valueOf(Math.abs(min.dis * 2)));
				load = cap;
				while(true)
				{
					if(load - min.mail >= 0)
					{
						load -= min.mail;
						list.remove(0);
						if(list.size() == 0)
						{
							break;
						}
						else
						{
							min = list.get(0);
						}
					}
					else
					{
						list.get(0).mail -= load;
						break;
					}
				}
			}
			System.out.println(result);
		}
		
		
	

}
