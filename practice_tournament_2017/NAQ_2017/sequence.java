package NAQ_2017;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class sequence {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		TreeMap<Integer, Character> tree = new TreeMap<Integer, Character>();
		for(int i = 1; i <= 26; i++)
		{
			map.put((char)(96 + i), i);
			tree.put(i, (char)(96 + i));
		}
		map.put((char)32, 0);
		tree.put(0, (char)32);
		
		int n = in.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++)
		{
			String ins = in.next();
			String text = in.nextLine();
			text = text.substring(1, text.length());
			//System.out.println(text + " " + text.length());
			
			int[] origin = new int[text.length()];
			int[] result = new int[text.length()];
			for(int j = 0; j < text.length(); j++)
			{
				origin[j] = map.get(text.charAt(j));
			}
			
			if(ins.equals("e"))
			{
				result[0] = origin[0];
				for(int x = 1; x < text.length(); x++)
				{
					result[x] = result[x-1] + origin[x];
				}
				
				for(int x = 0; x < text.length(); x++)
				{
					result[x] = result[x] % 27;
				}
				
				//StringBuilder sb = new StringBuilder();
				for(int x = 0; x < text.length(); x++)
				{
					sb.append(tree.get(result[x]));
				}
				sb.append("\n");
			}
			else
			{
				result[0] = origin[0];
				for(int x = 1; x < text.length(); x++)
				{
					if(origin[x] >= origin[x-1])
					{
						result[x] = origin[x] - origin[x-1];
					}
					else
					{
						result[x] = origin[x] + 27 - origin[x-1];
					}
				}
				
				for(int x = 0; x < text.length(); x++)
				{
					result[x] = result[x] % 27;
				}
				
				
				for(int x = 0; x < text.length(); x++)
				{
					sb.append(tree.get(result[x]));
				}
				sb.append("\n");
			}
			
		}
		//sb.deleteCharAt(sb.length()-1);
		System.out.print(sb);
	}

}
