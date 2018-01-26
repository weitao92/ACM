package contest;

import java.util.Scanner;

public class easy {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		int B = in.nextInt();
		
		while(!(A == 0 && B == 0))
		{
			int sum = A + B;
			System.out.println(sum);
			A = in.nextInt();
			B = in.nextInt();
		}
		
		in.close();
	}

}
