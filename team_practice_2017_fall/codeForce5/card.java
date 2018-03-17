package codeForce5;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;


public class card {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for(int i = 0; i < n; i++)
		{
			int value = in.nextInt();
			if(map.containsKey(value))
			{
				map.put(value, map.get(value) + 1);
			}
			else
			{
				map.put(value, 1);
			}
		}
		
		Set<Integer> set = map.keySet();
		if(set.size() != 2)
		{
			System.out.println("NO");
		}
		else
		{
			Iterator<Integer> it = set.iterator();
			int a = it.next();
			int sizea = map.get(a);
			int b = it.next();
			int sizeb = map.get(b);
			if(sizea != sizeb)
			{
				System.out.println("NO");
			}
			else
			{
				System.out.println("YES");
				System.out.println(a + " " + b);
			}
		}
	}

}
