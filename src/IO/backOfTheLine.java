package IO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class backOfTheLine {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		ArrayList<String> bank = new ArrayList<String>(num);
		for(int i = 0; i < num; i++)
		{
			String word = in.next();
			String reverse = new String("");
			for(int j = word.length() - 1; j >= 0; j--)
			{
				reverse += word.charAt(j);
			}
			
			if(reverse.compareTo(word) > 0)
			{
				bank.add(reverse);
			}
			else
			{
				bank.add(word);
			}
		}
		
		Collections.sort(bank);
		String temp = new String("");
		for(int i = bank.size() - 1; i >= 0; i--)
		{
			temp += bank.get(i);
		}
		
		String name = temp.substring(0, 1).toUpperCase() + temp.substring(1);
		
		if(name.compareTo(new String("Acorn")) > 0)
		{
			System.out.println(name);
		}
		else
		{
			System.out.println("Acorn");
		}
		in.close();
	}

}
