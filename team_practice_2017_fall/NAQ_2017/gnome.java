package NAQ_2017;

import java.util.Scanner;

public class gnome {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++)
		{
			int num = in.nextInt();
			int[] s = new int[num];
			boolean first = true;
			for(int j = 0; j < num; j++)
			{
				s[j] = in.nextInt();
				if(j > 0)
				{
					if(s[j] - s[j-1] != 1)
					{
						sb.append((j+1) + "\n");
						//System.out.println(s[j] + " " + s[j-1]);
						first = false;
						break;
					}
				}
			}
			
			in.nextLine();
			if(first)
			{
				sb.append(1 + "\n");
			}
			
		}
		
		System.out.print(sb);
	}

}
