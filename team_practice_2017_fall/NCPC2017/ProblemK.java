package NCPC2017;

import java.util.*;

/**
 * https://open.kattis.com/problems/kayaking
 * @author weitao92
 *
 */
public class ProblemK {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int b = in.nextInt();
		int n = in.nextInt();
		int e = in.nextInt();
		
		int sb = in.nextInt();
		int sn = in.nextInt();
		int se = in.nextInt();
		
		int m = (b+n+e)/2;
		int[] boats = new int[m];
		for(int i = 0; i < m; i++)
		{
			boats[i] = in.nextInt();
		}
		
		Arrays.sort(boats);
		
		long low = 0;
		long high = 100000*2000;
		
		while(low <= high)
		{
			long mid = (low + high)/2;
			if(possible(b,n,e,sb,sn,se,mid,boats))
			{
				low = mid + 1;
			}
			else
			{
				high = mid - 1;
			}
		}
		
		System.out.print(high);
	}
	
	private static boolean possible(int b, int n, int e, int sb, int sn, int se, 
			long speed, int[] boats)
	{
		for(int c : boats)
		{
			if(b >= 2 && speed <= c * (sb+sb))
			{
				b -= 2;
				continue;
			}
			
			if(b >= 1 && n >= 1 && speed <= c * (sb + sn))
			{
				b--;
				n--;
				continue;
			}

			if(sn*2 <= sb + se)
			{
				if(n >= 2 && speed <= c*(sn+sn))
				{
					n -=2;
					continue;
				}
				
				if(b >= 1 && e >= 1 && speed <= c*(sb+se))
				{
					b--;
					e--;
					continue;
				}
			}
			else
			{
				if(b >= 1 && e >= 1 && speed <= c*(sb+se))
				{
					b--;
					e--;
					continue;
				}
				if(n >= 2 && speed <= c*(sn+sn))
				{
					n -=2;
					continue;
				}
			}
					
			if(n >= 1 && e >= 1 && speed <= c*(sn+se))
			{
				n--;
				e--;
				continue;
			}
			
			if(e >= 2 && speed <= c*(se+se))
			{
				e-=2;
				continue;
			}
			
			return false;
		}
		
		return true;
	}

}
