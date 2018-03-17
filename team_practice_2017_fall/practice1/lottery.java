package practice1;

import java.util.Scanner;

public class lottery {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		while(true)
		{
			int n = in.nextInt();
			if(n == 0)
			{
				System.exit(0);
			}
			outMost: 
			{
				boolean[] cover = new boolean[49];
				for(int i = 0; i < n; i++)
				{
					for(int j = 0; j < 6; j++)
					{
						int next = in.nextInt();
						cover[next - 1] = true;
					}
				}
				
				for(int i = 0; i < 49; i++)
				{
					if(cover[i] == false)
					{
						System.out.println("No");
						break outMost;
					}
				}
				in.close();
				System.out.println("Yes");
			}
			
		}
	}

}
