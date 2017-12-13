package ACPC2017;

import java.util.Scanner;

public class specialNum {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		String first = in.next();
		String second = in.next();
		int size1 = first.length();
		int size2 = second.length();
		
		int zeros = size2 - 1;
		StringBuilder result = new StringBuilder();
		if(zeros >= size1)
		{
			result.append("0");
			result.append(".");
			for(int i = 0; i < zeros - size1; i++)
			{
				result.append("0");
			}
			int index = all(first);
			result.append(first.substring(0, index + 1));
		}
		else
		{
			String f = first.substring(0, size1 - zeros);
			String s = first.substring(size1-zeros, size1);
			result.append(f);
			int index = all(s);
			if(index == -1)
			{
				
			}
			else
			{
				result.append(".");
				result.append(s.substring(0, index + 1));
			}
		}
		
		System.out.println(result);
	}
	
	private static int all(String s)
	{
		for(int i = s.length() - 1; i >= 0; i--)
		{
			if(s.charAt(i) != '0')
			{
				return i;
			}
		}
		
		return -1;
	}

}
