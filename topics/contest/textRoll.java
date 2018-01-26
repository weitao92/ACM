package contest;

import java.io.IOException;
import java.util.Scanner;

public class textRoll {
	
	public static void main(String args[]) throws IOException
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		int index = 0;
		
		for(int i = 1; i <= n; i++)
		{
			String line = scan.nextLine();
			Scanner s = new Scanner(line);
			int offset = 0;
			
			while(s.hasNext())
			{
				//System.out.println(i + ":" + index);
				String temp = s.next();
				offset += temp.length() + 1;
				//System.out.println(temp + ":" + offset + ":" + i);
				if(offset < index)
				{
					
				}
				else
				{
					index = offset;
					break;
				}
			}
			
			s.close();
			
		}
		
		System.out.println(index);
		scan.close();
	}

}
