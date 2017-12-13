package holidayContest;

import java.util.*;

public class D {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < n; i++)
		{
			int p0 = in.nextInt();
			int p1 = in.nextInt();
			int T = in.nextInt();
			int tf = in.nextInt();
			int r = in.nextInt();
			
			double first = 0;
			double p = (1000-p0)/1000.0;
			first += p * (tf * (r+1) + 20);
			
			double second = 0;
			double pp1 = p1/1000.0;
			double pp2 = (1000 - p1)/1000.0;
			second += pp1 * T * (r+1);
			second += pp2 * ((T + tf) * (r+1) + 20); 
			
			//System.out.println(first + " " + second);
			if(second < first)
			{
				result.append("Test\n");
			}
			else
			{
				result.append("Just submit\n");
			}
		}
		
		System.out.print(result);
	}

}
