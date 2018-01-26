package contest;

import java.util.Scanner;

public class DiskGame {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		disk(num, 'A', 'C', 'B');
		in.close();
	}
	
	private static void disk(int num, char src, char det, char temp)
	{
		if(num == 1)
		{
			System.out.println(src + " -> " + det);
		}
		else
		{
			disk(num - 1, src, temp, det);
			disk(1, src, det, temp);
			disk(num - 1, temp, det, src);
		}
	}

}
