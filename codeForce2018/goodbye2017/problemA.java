package goodbye2017;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/908/problem/A
 * @author weitao92
 *
 */
public class problemA {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		String text = in.next();
		int result = 0;
		for(int i = 0; i < text.length(); i++)
		{
			char c = text.charAt(i);
			if(c == '1' || c == '3' || c == '5' || c == '7' || c == '9')
			{
				result++;
			}
			else if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
			{
				result++;
			}
			else
			{
				continue;
			}
		}
		in.close();
		System.out.print(result);
	}

}
