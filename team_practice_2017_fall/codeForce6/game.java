package codeForce6;

import java.util.Scanner;

public class game {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int limit = in.nextInt();
		int current = 0;
		double result = 0;
		for(int i = 0; i < n; i++)
		{
			int fast = in.nextInt();
			int slow = in.nextInt();
			int pro = in.nextInt();
			double probability = pro / 100.0;
			current += slow;
			if(current > limit || (current == limit && i < n-1))
			{
				double expec = 1.0 / probability - 1.0;
				result += fast;
				result += expec * slow;
				current -= slow;
				current += fast;
			}
			else
			{
				//System.out.println(fast * probability + " " + slow * (1-probability));
				double first = fast * probability + slow * (1.0-probability);
				double expec = 1 / probability - 1;
				double second = fast + slow * expec;
				System.out.println(first + " " + second + " " + result);
				if(first <= second)
				{
					result += first;
				}
				else
				{
					result += second;
				}
			}
		}
		
		System.out.println(result);
	}

}
