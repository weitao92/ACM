package IO;

import java.util.Scanner;

public class balance {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		String input = in.next();
		int left = 0;
		
		in.close();
		for(int i = 0; i < input.length(); i++)
		{
			char c = input.charAt(i);
			if(c == '(')
			{
				left++;
			}
			else
			{
				left--;
			}
			
			if(left < 0)
			{
				System.out.println("unbalanced");
				System.exit(0);
			}
		}
		
		if(left == 0)
		{
			System.out.println("balanced");
		}
		else
		{
			System.out.println("unbalanced");
		}

	}

}
