package contest;

import java.util.Scanner;

public class CantorSet {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		while(in.hasNext())
		{
			int input = in.nextInt();
			input = (int) Math.pow(3, input);
			StringBuilder result = cantor(0, input);
			System.out.println(result.toString());
		}
		in.close();
	}
	
	private static StringBuilder cantor(int start, int end)
	{
		//System.out.println(start + " " + end);
		if(end - start == 1)
		{
			return new StringBuilder("-");
			
		}
		else
		{
			int mid = (end - start) / 3;
			StringBuilder result = cantor(start, start + mid);
			for(int i = 0; i < mid; i++)
			{
				result.append(" ");
			}
			result.append(cantor(start + mid + mid, end));
			return result;
		}
	}

}