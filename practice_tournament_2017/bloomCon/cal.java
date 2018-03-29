package bloomCon;

import java.util.*;

/**
 * https://codecon.bloomberg.com/contest/472/4976
 * @author weitao92
 *
 */
public class cal {
	
	static class tuple
	{
		int a;
		int b;
		int c;
		
		public tuple(int x, int y, int z)
		{
			a = x;
			b = y;
			c = z;
		}
		
		public boolean equals(Object o)
		{
			tuple another = (tuple)o;
			if(a == another.a || b == another.a || c == another.a)
			{
				if(a == another.b || b == another.b || c == another.b)
				{
					if(a == another.c || b == another.c || c == another.c)
					{
						return true;
					}
				}
			}
			
			return false;
		}
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int x = (int)Math.sqrt(n);
		
		int temp = n;
		HashSet<tuple> results = new HashSet<tuple>();
		for(int i = 1; i <= x; i++)
		{
			temp -= i*i;
			for(int j = i; j <= (int)Math.sqrt(temp); j++)
			{
				temp -= j*j;
				for(int k = j; k <= (int)Math.sqrt(temp); k++)
				{
					temp -= k*k;
					if(temp == 0)
					{
						tuple t = new tuple(i,j,k);
						//System.out.println(i + " " + j + " " + k);
						results.add(t);
					}
					temp += k*k;
				}
				temp += j*j;
			}
			temp += i*i;
		}
		
		long result = 0;
		for(tuple t : results)
		{
			result += t.a;
			result += t.b;
			result += t.c;
		}
		
		System.out.print(result);
	}

}
