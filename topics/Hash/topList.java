package Hash;

import java.util.HashMap;
//import java.util.HashSet;
import java.util.Scanner;

public class topList {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i = 0; i < n; i++)
		{
			map.put(in.next(), i);
		}
		
		int max = -1;
		int previous = -1;
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < n; i++)
		{
			String target = in.next();
			max = Math.max(max, map.get(target));
			
			if(max <= i)
			{
				result.append((i - previous) + "\n");
				previous = i;
			}
		}
		
		System.out.println(result);
		in.close();
	}

}
