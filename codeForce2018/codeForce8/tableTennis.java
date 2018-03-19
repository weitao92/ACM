package codeForce8;
import java.util.*;

public class tableTennis {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long k = in.nextLong();
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		int max = -1;
		for(int i = 0; i < n; i++)
		{
			int power = in.nextInt();
			queue.addLast(power);
			if(power > max)
			{
				max = power;
			}
		}
		if(k > n-2)
		{
			System.out.println(max);
		}
		else
		{
			int first = queue.removeFirst();
			int wins = 0;
			for(int i = 1; i <= n-2; i++)
			{
				if(wins == k)
				{
					break;
				}
				int oppo = queue.removeFirst();
				if(first > oppo)
				{
					wins++;
					queue.addLast(oppo);
				}
				else
				{
					queue.addLast(first);
					first = oppo;
					wins = 1;
				}
			}
			
			if(wins == k)
			{
				System.out.println(first);
			}
			else
			{
				System.out.println(max);
			}
		}
	}

}
