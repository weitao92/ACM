package Combinatorics;

import java.util.Scanner;

public class countNumber {
	
	static int base;
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		base = in.nextInt();
		int length = in.nextInt();
		in.close();
		
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < base; i++)
		{
			generate(result, length, i);
		}
	}
	
	private static void generate(StringBuilder result, int index, int num)
	{
		if(index == 1)
		{
			result.append(num);
			System.out.println(result);
			result.deleteCharAt(result.length()-1);
			
		}
		else
		{
			
				result.append(num);
				for(int j = 0; j < base; j++)
				{
					generate(result, index - 1, j);
					
				}
				result.deleteCharAt(result.length()-1);
			
		}
	}

}
