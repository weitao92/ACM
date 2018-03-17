package codeForce5;

import java.util.HashSet;
import java.util.Scanner;

public class perfect {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String string = in.next();
		int max = 0;
		
		for(int i = 0; i < n; i++)
		{
			HashSet<Character> set = new HashSet<Character>();
			char c = string.charAt(i);
			int result = 0;
			if(!Character.isUpperCase(c))
			{
				
				result = 1;
				set.add(c);
			}
			else
			{
				continue;
			}
			for(int j = i + 1; j < n; j++)
			{
				char next = string.charAt(j);
				if(Character.isUpperCase(next))
				{
					i = j;
					break;
				}
				else
				{
					if(set.contains(next))
					{
						//result++;
					}
					else
					{
						set.add(next);
						result++;
					}
				}
			}
			
			if(result > max)
			{
				max = result;
			}
		}
		
		System.out.println(max);
	}

}
