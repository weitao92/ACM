package MATH;

import java.util.Scanner;

public class isPrime {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int target = in.nextInt();
		
		for(int i = 2; i*i <= target; i++)
		{
			if(target % i == 0)
			{
				System.out.println("false");
				in.close();
				System.exit(0);
			}
		}
		System.out.println("true");
	}
}
