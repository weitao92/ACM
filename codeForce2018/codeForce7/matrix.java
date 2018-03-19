package codeForce7;
import java.util.Scanner;

public class matrix {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int row = in.nextInt();
		int col = in.nextInt();
		int k = in.nextInt();
		
		int[][] mat = new int[row][col];
		
		for(int i = 0; i < row; i ++)
		{
			for(int j = 0; j < col; j++)
			{
				mat[i][j] = in.nextInt();
			}
		}
		
		long max = 0;
		long min = 0;
		//int[][] look = new int[row][col];
		for(int i = 0; i < col; i++)
		{
			int ma = 0;
			int position = -1;
			for(int j = row - 1; j >= 0; j--)
			{
				if(mat[j][i] == 0)
				{
					continue;
				}
				else
				{
					int num = 0;
					int index = j;
					while(index < j + k && index < row)
					{
						if(mat[index][i] == 1)
						{
							num++;
						}
						
						index++;
					}
					
					//look[j][i] = num;
					if(num >= ma)
					{
						ma = num;
						position = j;
					}
					//ma = Math.max(ma, num);
				}
			}
			//System.out.println("for col: " + i + " " + ma + " " + position);
			
			max += ma;
			
			int start = position - 1;
			while(start >= 0)
			{
				if(mat[start][i] == 1)
				{
					min++;
				}
				
				start--;
			}
		}
		
		System.out.println(max + " " + min);
	}

}
