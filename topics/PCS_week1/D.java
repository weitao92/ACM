package PCS_week1;

import java.util.*;

/**
 * https://pcs.cs.cloud.vt.edu/contests/62/problems/D
 * @author weitao92
 *
 */
public class D {
	
	static ArrayList<Integer> primes = new ArrayList<Integer>();
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = 100;
		boolean[] isPrime = new boolean[n+1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int factor = 2; factor*factor <= n; factor++) {
            if (isPrime[factor]) {
                for (int j = factor; factor*j <= n; j++) {
                    isPrime[factor*j] = false;
                }
            }
        }
    
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) primes.add(i);
        }
        StringBuilder sb = new StringBuilder();
        out: while(true)
        {
        	int min = in.nextInt();
        	int max = in.nextInt();
        	if(min == 0 && max == 0)
        	{
        		System.out.print(sb);
        		System.exit(0);
        	}
        	int target = 2;
        	while(target <= max)
        	{
        		target *= 2;
        	}
        	inner: while(true)
        	{
        		target /= 2;
        		if(target >= min && target <= max)
        		{
        			sb.append(target + "\n");
        			continue out;
        		}
        		else
        		{
        			for(int i = 1; i < primes.size(); i++)
        			{
        				int prime = primes.get(i);
        				int temp = prime*target;
        				if(temp < min)
        				{
        					continue;
        				}
        				if(temp > max)
        				{
        					continue inner;
        				}
        				if(temp >= min && temp <= max)
        				{
        					sb.append(temp + "\n");
                			continue out;
        				}
        			}
        		}
        	}
        }
	}
}
