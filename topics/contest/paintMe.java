package contest;

import java.util.Scanner;

public class paintMe {
	
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		helper(scan);
	}
	
	private static void helper(Scanner scan)
	{
		int n = scan.nextInt();
		int width = scan.nextInt();
		int length = scan.nextInt();
		int height = scan.nextInt();
		int areaPerCan = scan.nextInt();
		int m = scan.nextInt();
		
		if(n == 0 && width == 0 && length == 0 && height == 0 && areaPerCan == 0
				&& m == 0)
		{
			return;
		}
		else
		{
			long totalArea = width * length + width * height * 2 + length * height * 2;
			
		
			for(int i = 1; i <= m; i++)
			{
				int WD = scan.nextInt();
				int HD = scan.nextInt();
				totalArea -= WD*HD;
			}
			
			long num = (totalArea * n) / areaPerCan;
			if((totalArea * n) % areaPerCan != 0)
			{
				num++;
			}
			System.out.println(num);
			helper(scan);
		}
		
	}

}
