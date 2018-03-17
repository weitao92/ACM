package progNOVA;

import java.util.HashMap;
import java.util.Scanner;

public class fibo {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		
		HashMap<Integer, Long> map1 = new HashMap<Integer, Long>();
		HashMap<Long, Integer> map2 = new HashMap<Long, Integer>();
		for(int i = 0; i < n; i++)
		{
			long h = in.nextLong();
			if(isFibonacci(h))
			{
				map1.put(i, h);
				map2.put(h, i);
			}
		}
		
		if(map1.size() == 0)
		{
			System.out.println(0);
		}
		else
		{
			
		}
	}
	
	static  boolean isPerfectSquare(long x)
    {
        long s =  (long) Math.sqrt(x);
        return (s*s == x);
    }
      
    static boolean isFibonacci(long n)
    {

        return isPerfectSquare(5*n*n + 4) ||
               isPerfectSquare(5*n*n - 4);
    }

}
