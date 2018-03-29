package mid_atlantic_2015;

import java.util.Scanner;
import java.util.TreeMap;

public class textToSpeech {
	
	static TreeMap<Integer, String> map = new TreeMap<Integer, String>();
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		map.put(0, "zero");
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		map.put(5, "five");
		map.put(6, "six");
		map.put(7, "seven");
		map.put(8, "eight");
		map.put(9, "nine");
		map.put(10, "ten");
		map.put(11, "eleven");
		map.put(12, "twelve");
		map.put(13, "thirteen");
		map.put(14, "fourteen");
		map.put(15, "fifteen");
		map.put(16, "sixteen");
		map.put(17, "seventeen");
		map.put(18, "eighteen");
		map.put(19, "nineteen");
		
		map.put(20, "twenty");
		map.put(30, "thirty");
		map.put(40, "forty");
		map.put(50, "fifty");
		map.put(60, "sixty");
		map.put(70, "seventy");
		map.put(80, "eighty");
		map.put(90, "ninety");
		
		map.put(100, "hundred");
		map.put(1000, "thousand");
		map.put(1000000, "million");
		
		
		while(in.hasNext())
		{
			long num = in.nextLong();
			long ms = 0;
			long remainder = 0;
			if(num < 0)
			{
				in.close();
				System.exit(0);
			}
			else
			{
				StringBuilder result = new StringBuilder();
				ms = num / 1000000;
				remainder = num % 1000000;
				
				if(ms > 0)
				{
					result.append(handle((int)ms));
					if(remainder == 0)
					{
						result.append(" million");
						System.out.println(result);
						continue;
					}
					
					if(remainder / 100 > 0)
					{
						result.append(" million, ");
					}
					else
					{
						result.append(" million and ");
					}
				}
				
				ms = remainder / 1000;
				remainder = remainder % 1000;
				
				if(ms > 0)
				{
					result.append(handle((int)ms));
					if(remainder == 0)
					{
						result.append(" thousand");
						System.out.println(result);
						continue;
					}
					
					if(remainder / 100 > 0)
					{
						result.append(" thousand, ");
					}
					else
					{
						result.append(" thousand and ");
					}
				}
				
				result.append(handle((int)remainder));
				System.out.println(result);
			}
		}
	}
	
	private static String handle(int num)
	{
		String result = new String();
		int first = num / 100;
		int remainder = num % 100;
		
		if(first > 0)
		{
			result += map.get(first);
			result += " hundred ";
			
			if(remainder != 0)
			{
				result += "and ";
			}
			else
			{
				return result;
			}
		}
		
		if(remainder < 20)
		{
			result += map.get(remainder);
			return result;
		}
		else
		{
			int left = remainder % 10;
			if(left == 0)
			{
				result += map.get(remainder);
				return result;
			}
			else
			{
				result += map.get(remainder - left);
				result += "-";
				result += map.get(left);
				return result;
			}
		}
	}

}