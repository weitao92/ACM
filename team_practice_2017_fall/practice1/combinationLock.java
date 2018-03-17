package practice1;

import java.util.Scanner;

public class combinationLock {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		while(true)
		{
			int n = in.nextInt();
			int t1 = in.nextInt();
			int t2 = in.nextInt();
			int t3 = in.nextInt();
			
			if(n == 0 && t1 == 0 && t2 == 0 && t3 == 0)
			{
				in.close();
				System.exit(0);
			}
			else
			{
				int sum = 4*n - 1;
				
				if(t1 <= t2)
				{
					sum += t2 - t1;
				}
				else
				{
					sum += (n - (t1 - t2));
				}
				
				if(t2 >= t3)
				{
					sum += t2 - t3;
				}
				else
				{
					sum += (n - (t3 - t2));
				}
				
				System.out.println(sum);
			}
		}
	}

}
