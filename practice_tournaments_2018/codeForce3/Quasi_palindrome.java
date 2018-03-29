package codeForce3;

import java.util.Scanner;

public class Quasi_palindrome {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		String text = in.next();
		
		int first = 0;
		int second = text.length() - 1;
		
		while(text.charAt(second) == '0')
		{
			second--;
			if(text.charAt(first) == '0')
			{
				first++;
			}
			
		}
		
		boolean result = true;
		
		while(first <= second)
		{
			if(text.charAt(first) != text.charAt(second))
			{
				result = false;
				break;
			}
			else
			{
				first++;
				second--;
			}
		}
		
		if(result)
		{
		System.out.println("YES");
		}
		else
		{
			System.out.println("NO");
		}
	}

}
