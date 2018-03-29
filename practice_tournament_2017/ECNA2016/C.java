package ECNA2016;
import java.util.*;

public class C {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		String message = in.next();
		String key = in.next();
		StringBuilder result = new StringBuilder();
		StringBuilder str = new StringBuilder();
		str.append(key);
		for(int i = 0; i < message.length(); i++)
		{
			char ch = (char)(((message.charAt(i) - str.charAt(i) + 26)%26)+65);
			result.append(ch);
			str.append(ch);
		}
		
		System.out.println(result);
	}

}
