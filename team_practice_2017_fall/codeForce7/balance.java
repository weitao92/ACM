package codeForce7;

import java.util.Scanner;

public class balance {
	
	static char[] text;
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		text = new char[n];
		String next = in.next();
		text = next.toCharArray();
		int[] dp = new int[n];
		int[] cal = new int[n];
		cal[0] = 0;
		
		dp[0] = 0;
		for(int i = 1; i < n; i++)
		{
			int val = cal[i-1];
			int index = i-1-val;
			if(index >= 0)
			{
				if(text[i] != text[index])
				{
					cal[i] = val + 2;
					if(index - 1 >= 0)
					{
						cal[i] += cal[index-1];
					}
				}
				else
				{
					cal[i] = cal(i);
				}
			}
			else
			{
				cal[i] = cal(i);
			}
			dp[i] = Math.max(dp[i-1], cal[i]);
		}
		
		System.out.println(dp[n-1]);
		
		
		
		
	}
	
	private static int cal(int start)
	{
		int bal = 0;
		int result = -2;
		int local = 1;
		while(start >= 0)
		{
			if(bal > start + 1 || bal < -start - 1)
			{
				break;
			}
			if(bal == 0)
			{
				result += local * 2;
				local = 0;
			}
			
			if(text[start] == '1')
			{
				bal++;
				local++;
			}
			else
			{
				bal--;
			}
			start--;
		}
		
		if(bal == 0)
		{
			result += local * 2;
		}
		return result;
	}

}
