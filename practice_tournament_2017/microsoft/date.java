package microsoft;

import java.util.HashMap;
import java.util.Scanner;

public class date {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext())
		{
			String date = in.next();
			String input = in.next();
			String output = in.next();
			int index = 0;
			HashMap<String, String> map = new HashMap<String, String>();
			//System.out.println(output.length());
			
			for(int i = 0; i <= input.length(); i++)
			{
				if(i == input.length())
				{
					String format = input.substring(index, i);
					String d = date.substring(index, i);
					map.put(format, d); 
				}
				else
				{
					char c = input.charAt(i);
					
					if(c != 'd' && c != 'm' && c != 'y')
					{
						String format = input.substring(index, i);
						
						String d = date.substring(index, i);
						//System.out.println(format + " " + d);
						map.put(format, d);
						index = i + 1;
					}
				}
				
			}
			
			StringBuilder result = new StringBuilder();
			index = 0;
			for(int i = 0; i <= output.length(); i++)
			{
				if(i == output.length())
				{
					String format = output.substring(index, i);
					String d = map.get(format);
					//System.out.println(index + " " + i + format);
					result.append(d);
					result.append("\n");
				}
				else
				{
					char c = output.charAt(i);
					
					if(c != 'd' && c != 'm' && c != 'y')
					{
						String format = output.substring(index, i);
						String d = map.get(format);
						//System.out.println(format + " " + d);
						result.append(d);
						result.append(c);
						
						index = i + 1;
					}
				}
			}
			
			System.out.print(result);
			//System.out.println();
		}
	}

}
