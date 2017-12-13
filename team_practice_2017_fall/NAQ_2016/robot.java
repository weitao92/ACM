package NAQ_2016;

import java.util.ArrayList;
import java.util.Scanner;

public class robot {
	
	static class pair
	{
		int x;
		int y;
		
		public pair(int a, int b)
		{
			x = a;
			y = b;
		}
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		for(int i = 0; i < n; i++)
		{
			int l1 = in.nextInt();
			int a1 = in.nextInt();
			int l2 = in.nextInt();
			int a2 = in.nextInt();
			int L = in.nextInt();
			int A = in.nextInt();
			
			int x = 1;
			ArrayList<pair> candidate = new ArrayList<pair>();
			//candidate.add(x);
			while(true)
			{
				if(x*l1 <= L)
				{
					//candidate.add(x);
					double y = (L - x*l1) / (double)l2;
					if(y % 1 == 0 && y != 0)
					{
						pair p = new pair(x, (int)y);
						candidate.add(p);
					}
					x++;
				}
				else
				{
					break;
				}
				
			}
			
			ArrayList<pair> success = new ArrayList<pair>();
			for(pair p : candidate)
			{
				if(p.x * a1 + p.y * a2 == A)
				{
					success.add(p);
				}
			}
			
			if(success.size() == 1)
			{
				System.out.println(success.get(0).x + " " + success.get(0).y);
			}
			else
			{
				System.out.println("?");
			}
		}
	}

}
