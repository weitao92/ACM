package Hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class nickName {
	
	public static void main(String agrs[])
	{
		Scanner in = new Scanner(System.in);
		int people = in.nextInt();
		int log = in.nextInt();
		HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
		
		for(int i = 0; i < people; i++)
		{
			String name = in.next();
			LinkedList<String> first = new LinkedList<String>();
			first.addFirst(name);
			map.put(name, first);
		}
		
		for(int i = 0; i < log; i++)
		{
			@SuppressWarnings("unused")
			String first = in.next();
			String original = in.next();
			String nickName = in.next();
			LinkedList<String> names = map.get(original);
			names.addFirst(nickName);
			map.remove(original);
			if(map.containsKey(nickName))
			{
				System.out.println("Invalid");
				System.exit(0);
			}
			else
			{
				map.put(nickName, names);
			}
		}
		
		in.close();
		Set<String> set = map.keySet();
		ArrayList<String> bag = new ArrayList<String>();
		for(String s : set)
		{
			bag.add(s);
		}
		Collections.sort(bag);
		
		for(String s : bag)
		{
			LinkedList<String> names = map.get(s);
			System.out.println(s + ":" + names.getLast());
		}
	}

}
