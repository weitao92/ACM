package codeForce8;
import java.util.*;

public class doctors {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int current = 0;
		for(int i = 0; i < n; i++)
		{
			int start = in.nextInt();
			int d = in.nextInt();
			if(current < start)
			{
				current = start;
				continue;
			}
			else
			{
				int diff = current - start;
				if(diff != 0 && diff % d == 0)
				{
					current = current + d;
					continue;				
				}
				else
				{
					current = start + (diff / d + 1) * d;
					continue;
				}
			}
		}
		
		System.out.println(current);
	}

}
