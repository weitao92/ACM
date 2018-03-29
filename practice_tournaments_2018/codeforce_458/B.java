package codeforce_458;

import java.util.*;

/**
 * http://codeforces.com/contest/914/problem/B
 * @author weitao92
 *
 */
public class B {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < n; i++)
		{
			list.add(in.nextInt());
		}
		
		Collections.sort(list);
		int current = list.get(list.size()-1);
		int len = 0;
		while(!list.isEmpty())
		{
			int temp = list.remove(list.size()-1);
			if(temp != current)
			{
				if(len%2 == 1)
				{
					System.out.println("Conan");
					System.exit(0);
				}
				else
				{
					current = temp;
					len = 1;
				}
			}
			else
			{
				len++;
			}
		}
		if(len%2 == 1)
		{
			System.out.println("Conan");
			System.exit(0);
		}
		else
		{
			System.out.println("Agasa");
			System.exit(0);
		}
	}
}
