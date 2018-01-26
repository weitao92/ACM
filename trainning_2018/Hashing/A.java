package Hashing;

import java.util.*;

public class A {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		HashSet<String> set = new HashSet<String>();
		int result = 0;
		for(int i = 0; i < n; i++)
		{
			String next = in.next();
			char[] arr = next.toCharArray();
			Arrays.sort(arr);
			String back = new String(arr);
			if(!set.contains(back))
			{
				result++;
				set.add(back);
			}
		}
		System.out.print(result);
	}

}
