package contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class partyGames {
	
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		ArrayList<String> names = new ArrayList<String>();
		
		for(int i = 1; i <= num; i++)
		{
			String name = scan.next();
			names.add(name);
		}
		
		Collections.sort(names, new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				return arg0.compareTo(arg1);
			}
	    });
		
		int next = num / 2;
		int prev = next - 1;
		
		String first = names.get(prev);
		String second = names.get(next);
		int length1 = first.length();
		int length2 = second.length();
		
		
		String result = new String();
		for(int i = 0; i < length1; i++)
		{
			char cF = first.charAt(i);
			char cS = second.charAt(i);
			
			if(cF == cS)
			{
				result += cF;
			}
			else
			{
				if(i == length1 - 1)
				{
					result += cF;
					break;
				}
				
						char temp = (char) (cF + 1);
						if(temp == cS)
						{
							
							
							
							if(i != (length2 - 1))
							{
								result += temp;
								break;
							}
							else
							{
							
							
							result += cF;
							int j = i;
							
							while(j < length1 - 1)
							{
								if(j+1 == length1 - 1)
								{
									result += (char)(first.charAt(j + 1));
									break;
								}
								char nextC = (char) (first.charAt(j + 1) + 1);
								
								if(nextC != '[')
								{
									result += nextC;
									break;
								}
								else
								{
									result += 'Z';
									j++;
								}
								
							}
							break;
							}
						}
						else
						{
							result += temp;
							break;
						}
					}
		}
		
		System.out.println(result);
		scan.close();
	}

}
