package codeForce4;

import java.util.HashSet;
import java.util.Scanner;

public class harryPoter {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		HashSet<String> set = new HashSet<String>();
		for(int i = 0; i < n; i++)
		{
			String name = in.next();
			if(set.contains(name))
			{
				System.out.println("YES");
			}
			else
			{
				System.out.println("NO");
				set.add(name);
			}
		}
	}

}
