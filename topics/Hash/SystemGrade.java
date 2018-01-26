package Hash;

import java.util.HashMap;
import java.util.Scanner;

public class SystemGrade {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int students = in.nextInt();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int pair = 0;
		
		for(int i = 0; i < students; i++)
		{
			int score = in.nextInt();
			if(map.containsKey(score))
			{
				pair++;
			}
			else
			{
				map.put(12345-score, 0);
			}
		}
		System.out.println(pair);
		in.close();
	}

}
