package codeForce9;

import java.util.*;

public class timeLine {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int t = in.nextInt();
		
		for(int i = 0; i < n; i++)
		{
			int day = in.nextInt();
			int diff = 86400 - day;
			t -= diff;
			
			if(t <= 0)
			{
				System.out.println(i + 1);
				System.exit(0);
			}
		}
	}

}
