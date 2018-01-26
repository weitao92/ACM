package contest;

import java.util.Scanner;

public class christmas {
	
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		
		while(true)
		{
			long days = scan.nextLong();
			
			if(days == 0)
			{
				scan.close();
				System.exit(0);
			}
			else
			{
				long result = (days * (days+1) * (days+2))/6;
				
				
				System.out.println(result);
			}
		}
	}
}
