package progNOVA;

import java.util.Scanner;

public class code {
	
	static int[][] mat;
	static class cor
	{
		int x; 
		int y;
		public cor(int a, int b)
		{
			x = a;
			y = b;
		}
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		mat = new int[3][3];
		
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				mat[i][j] = in.nextInt();
			}
		}
		
		double result = 0;
		for(int i = 1; i <= 8; i++)
		{
			cor c = find(i);
			cor next = find(i+1);
			
			double x = Math.abs(next.x - c.x);
			double y = Math.abs(next.y - c.y);
			result += Math.hypot(x, y);
		}
		
		System.out.println(result);
	}
	
	private static cor find(int index)
	{
		int x = -1;
		int y = -1; 
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if(mat[i][j] == index)
				{
					x = i;
					y = j;
					break;
				}
			}
		}
		
		return new cor(x,y);
	}

}
