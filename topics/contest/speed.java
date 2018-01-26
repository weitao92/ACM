package contest;

import java.util.Scanner;

public class speed {
	
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		
		while(true)
		{
			int distance = scan.nextInt();
			int slow = scan.nextInt();
			int fast = scan.nextInt();
			
			if(distance == 0 && slow == 0 && fast == 0)
			{
				break;
			}
			else
			{
				double result = ((double)distance / (double)slow - (double)distance / 
						(double)fast) * 3600;
				//System.out.println(result);
				int duration = 0;
				if(result % 1 == 0)
				{
					duration = (int) result;
				}
				else
				{
					double extra = result % 1;
					if(extra >= 0.5)
					{
						duration = ((int)result) + 1; 
					}
					else
					{
						duration = (int) result;
					}
				}
				
				int hour = duration / 3600;
				int left1 = duration % 3600;
				int min = left1 / 60;
				int sec = left1 % 60;
				
				
				String Min = Integer.toString(min);
				String Sec = Integer.toString(sec);
				if(min < 10)
				{
					Min = "0" + Min;
				}
				
				if(sec < 10)
				{
					Sec = "0" + Sec;
				}
				
				System.out.println(hour + ":" + Min + ":" + Sec);
			}
		}
		
		scan.close();
	}

}
