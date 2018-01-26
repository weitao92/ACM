package Hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class polling {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int votes = in.nextInt();
		for(int i = 0; i < votes; i++)
		{
			String vote = in.next();
			if(!map.containsKey(vote))
			{
				map.put(vote, 1);
			}
			else
			{
				int count = map.get(vote);
				map.put(vote, count+1);
			}
		}
		
		Set<String> set = map.keySet();
		int max = 0;
		ArrayList<String> finalList = new ArrayList<String>();
		for(String s : set)
		{
			if(map.get(s) > max)
			{
				max = map.get(s);
			}
		}
		for(String s : set)
		{
			if(map.get(s) == max)
			{
				finalList.add(s);
			}
		}
		Collections.sort(finalList);
		for(String s : finalList)
		{
			System.out.println(s);
		}
		
		in.close();
	}

}
