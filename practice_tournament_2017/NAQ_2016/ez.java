package NAQ_2016;

import java.util.HashMap;
import java.util.Scanner;

public class ez {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		String text = in.nextLine();
		HashMap<Character, String> map = new HashMap<Character, String>();
		map.put('a', "@");
		map.put('A', "@");
		map.put('b', "8");
		map.put('B', "8");
		map.put('c', "(");
		map.put('C', "(");
		map.put('d', "|)");
		map.put('D', "|)");
		map.put('e', "3");
		map.put('E', "3");
		map.put('f', "#");
		map.put('F', "#");
		map.put('g', "6");
		map.put('G', "6");
		map.put('h', "[-]");
		map.put('H', "[-]");
		map.put('i', "|");
		map.put('I', "|");
		map.put('j', "_|");
		map.put('J', "_|");
		map.put('k', "|<");
		map.put('K', "|<");
		map.put('l', "1");
		map.put('L', "1");
		map.put('m', "[]\\/[]");
		map.put('M', "[]\\/[]");
		map.put('n', "[]\\[]");
		map.put('N', "[]\\[]");
		map.put('o', "0");
		map.put('O', "0");
		map.put('p', "|D");
		map.put('P', "|D");
		map.put('q', "(,)");
		map.put('Q', "(,)");
		map.put('r', "|Z");
		map.put('R', "|Z");
		map.put('s', "$");
		map.put('S', "$");
		map.put('t', "']['");
		map.put('T', "']['");
		map.put('u', "|_|");
		map.put('U', "|_|");
		map.put('v', "\\/");
		map.put('V', "\\/");
		map.put('w', "\\/\\/");
		map.put('W', "\\/\\/");
		map.put('x', "}{");
		map.put('X', "}{");
		map.put('y', "`/");
		map.put('Y', "`/");
		map.put('z', "2");
		map.put('Z', "2");
		
		for(int i = 0; i < text.length(); i++)
		{
			char c = text.charAt(i);
			String result = map.get(c);
			if(result != null)
			{
				System.out.print(result);
			}
			else
			{
				System.out.print(c);
			}
		}
		
	}

}
