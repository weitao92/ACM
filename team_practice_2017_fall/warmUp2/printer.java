package warmUp2;

import java.util.Scanner;

public class printer {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		if(n == 1)
		{
			System.out.println(1);
		}
		else
		{
			int current = 1;
			int day = 0;
			while(current < n)
			{
				current *= 2;
				day++;
			}
			day++;
			System.out.println(day);
		}
	}

}
