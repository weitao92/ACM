package contest;

import java.util.Scanner;

public class perfectShuffle {
	
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		String[] first;
		String[] second;		
		String[] results = new String[num];
		
		if(num % 2 == 0)
		{
			first = new String[num/2];
			second = new String[num/2];
			for(int i = 0; i < num/2; i++)
			{
				first[i] = scan.next();
			}
			for(int j = 0; j < num/2; j++)
			{
				second[j] = scan.next();
			}
			
			for(int x = 0; x < num/2; x++)
			{
				results[2*x] = first[x];
				results[2*x+1] = second[x];
			}
		}
		else
		{
			first = new String[(num/2) + 1];
			second = new String[num/2];
			for(int i = 0; i < (num/2) + 1; i++)
			{
				first[i] = scan.next();
			}
			for(int j = 0; j < num/2; j++)
			{
				second[j] = scan.next();
			}
			
			for(int x = 0; x < num/2; x++)
			{
				results[2*x] = first[x];
				results[2*x+1] = second[x];
			}
			
			results[num-1] = first[num/2];
		}

		for(int i = 0; i < num; i++)
		{
			System.out.println(results[i]);
		}
		
		scan.close();
	}

}
