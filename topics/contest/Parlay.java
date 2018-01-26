package contest;

import java.util.Scanner;

public class Parlay {
	
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		double initial = scan.nextInt();
		int num = scan.nextInt();
		double total = initial;
		
		
		for(int i = 1; i <= num; i++)
		{
			double bet = scan.nextInt();
			
			double multiple = 0;
			if(bet < 0)
			{
				bet = 0 - bet;
				multiple = 100 / bet;
				multiple += 0.000001;
				int temp = (int) (multiple / 0.001);
				
				multiple = temp/1000.0;
				
			}
			else
			{
				multiple = bet / 100;
				multiple += 0.000001;
				int temp = (int) (multiple / 0.001);
				
				multiple = temp/1000.0;
				
			}
			
			String result = scan.next();
			
			
			if(result.equals("Win"))
			{
				
				double won = total * multiple;
				won += 0.000001;
				int temp = (int) (won / 0.01);
				
				won = temp/100.0;
				
				
				total = total + won;
				
				
				
				
			}
			else if(result.equals("Tie"))
			{
				continue;
			}
			else
			{
				total = 0.00;
				break;
			}
		}
		
		if(total > 1000000)
		{
			total = 1000000.00;
		}
		
		total += 0.000001;
		int temp = (int) (total / 0.01);
		
		total = temp/100.0;
		
		String result = new String("$");
		result += Double.toString(total);
		if(result.endsWith(".0") || result.endsWith(".1") || result.endsWith(".2") || result.endsWith(".3")
				|| result.endsWith(".4") || result.endsWith(".5") || result.endsWith(".6") || result.endsWith(".7")
				|| result.endsWith(".8") || result.endsWith(".9"))
		{
			result += "0";
		}
		int length = result.length();
		if(length >= 8)
		{
			result = result.substring(0, length - 6) + "," + result.substring(length - 6, length);
		}
		
		length = result.length();
		if(length >= 12)
		{
			result = result.substring(0, length - 10) + "," + result.substring(length - 10, length);
		}
		
		System.out.println(result);
		scan.close();
	}

}
