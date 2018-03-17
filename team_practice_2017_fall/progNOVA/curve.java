package progNOVA;

import java.util.Scanner;

public class curve {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int low = in.nextInt();
		int high = in.nextInt();
		
		
		
			boolean inf = (high == 100);
			
			int result = x;
			int index = 0;
			
			for(int i = 0; i <= 9; i++)
			{
				result = cal(x, i);
				
				if(result >= low && result <= high)
				{
					index = i;
					break;
				}
				
				if(result > high)
				{
					System.out.println("impossible");
					System.exit(0);
				}
			}
			System.out.print(index + " ");
			
			if(inf)
			{
				System.out.print("inf");
			}
			else
			{
				for(int i = index + 1; i <= 9; i++)
				{
					result = cal(x, i);
					if(result > high)
					{
						System.out.print(i-1);
						System.exit(0);
					}
				}
			}
	}
	
	private static int cal(int val, int times)
	{
		double result = val;
		for(int i = 1; i <= times; i++)
		{
			result = 10 * Math.sqrt(result);
		}
		
		if(result % 1 == 0)
		{
			return (int)result;
		}
		else
		{
			return ((int)result) + 1;
		}
	}

}
