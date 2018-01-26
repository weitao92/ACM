package edu_1;

import java.util.*;

public class C {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < a.length(); i++)
		{
			int temp = Character.getNumericValue(a.charAt(i));
			list.add(temp);
		}
		Collections.sort(list);
		
		if(a.length() < b.length())
		{
			String temp = "";
			for(int i = list.size()-1; i >= 0; i--)
			{
				temp += list.get(i);
			}
			
			System.out.println(temp);
			System.exit(0);
		}
		String temp = "";
		if(a.length() > b.length())
		{
			int diff = a.length() - b.length();
			for(int i = 0; i < diff; i++)
			{
				temp += list.remove(0);
			}
		}

		for(int i = 0; i < b.length(); i++)
		{
			int current = Character.getNumericValue(b.charAt(i));
			int index = Collections.binarySearch(list, current);
			if(index >= 0)
			{
				temp += current;
				list.remove(index);
			}
			else
			{
				//System.out.println(index);
				index = -index - 1;
				if(index > 0)
				{
					index--;
					temp += list.get(index);
					list.remove(index);
					break;
				}
				else
				{
					String last = temp.substring(temp.length()-1, temp.length());
					temp = temp.substring(0, temp.length()-1);
					temp += list.get(list.size()-1);
					temp += last;
					list.remove(list.size()-1);
					break;
				}
			}
		}
		for(int i = list.size()-1; i >= 0; i--)
		{
			temp += list.get(i);
		}
		
		System.out.println(temp);
		System.exit(0);
	}
	
	
	static long toLong(ArrayList<Integer> arr)
	{
		String temp = "";
		for(int i : arr)
		{
			temp += i;
		}
		
		return Long.parseLong(temp);
	}

}
