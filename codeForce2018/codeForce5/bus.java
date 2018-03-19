package codeForce5;

import java.util.Scanner;

public class bus {
	
	public static void main(String agrs[])
	{
		Scanner in = new Scanner(System.in);
		long end = in.nextLong();
		long cap = in.nextLong();
		long gas = in.nextLong();
		long k = in.nextLong();
		
		long result = 0;
		//boolean going = true;
		long soFar = -1;
		long dis = gas;
		long fuel = cap;
		if(cap < gas || cap < end - gas)
		{
			
			System.out.println("-1");
			System.exit(0);
		}
		while(soFar < k - 1)
		{
			soFar++;
			if(fuel < dis)
			{
				//System.out.println(soFar + " " + fuel + " " + dis);
				System.out.println(-1);
				System.exit(0);
			}
			else
			{
				fuel -= dis;
				if((end - dis)*2 <= fuel || ((end - dis) <= fuel && soFar == k-1))
				{
					dis = end - dis;
					fuel -= dis;
				}
				else
				{
					result++;
					fuel = cap;
					dis = end - dis;
					fuel -= dis;
				}
			}
		}
		
		System.out.println(result);
	}

}
