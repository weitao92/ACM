package codeForce9;

import java.util.*;

public class crossWord {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long x = in.nextLong();
		long length = 0;
		for(int i = 0; i < n; i++)
		{
			length += in.nextLong();
			length += 1;
		}
		length -= 1;
		
		if(length == x)
		{
			System.out.println("YES");
		}
		else
		{
			System.out.println("NO");
		}
	}

}
