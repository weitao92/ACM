package ECNA2016;
import java.util.*;

public class E {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int max = s.length();
		
		for(int i = 0; i < s.length() - 1; i++)
		{
			for(int j = i + 1; j < s.length(); j++)
			{
				String ss = s;
				String temp = ss.replaceAll(s.substring(i, j), "M");
				int length = temp.length() + ss.substring(i,j).length();
				if(length < max)
				{
					max = length;
				}
			}
		}
		
		System.out.println(max);
	}

}