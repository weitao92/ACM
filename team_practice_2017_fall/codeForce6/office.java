package codeForce6;

import java.util.Scanner;

public class office {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String text = in.next();
		char[] arr = text.toCharArray();
		
		char previous = arr[0];
		boolean seatle = previous == 'S' ? true : false;
		int sf = 0;
		int fs = 0;
		
		for(int i = 1; i < n; i++)
		{
			char current = arr[i];
			if(seatle)
			{
				if(current == 'F')
				{
					sf++;
					seatle = false;
				}
			}
			else
			{
				if(current == 'S')
				{
					fs++;
					seatle = true;
				}
			}
		}
		
		if(sf > fs)
		{
			System.out.println("YES");
		}
		else
		{
			System.out.println("NO");
		}
	}

}
