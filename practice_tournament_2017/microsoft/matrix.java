package microsoft;

import java.util.Scanner;

public class matrix {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext())
		{
			String matrix = in.nextLine();
			
			int m = 0;
			
			String temp = matrix;
			while(true)
			{
				int index = temp.indexOf(";");
				if(index == -1)
				{
					break;
				}
				else
				{
					m++;
					temp = temp.substring(index + 1, temp.length());
				}
			}
			m++;
			
			int n = 0;
			while(true)
			{
				int index = temp.indexOf(",");
				if(index == -1)
				{
					break;
				}
				else
				{
					n++;
					temp = temp.substring(index + 1, temp.length());
				}
			}
			n++;
			
			int[][] mat = new int[m][n];
			temp = matrix;
			int start = 0;
			for(int i = 0; i < m; i++)
			{
				for(int j = 0; j < n - 1; j++)
				{
					int index = temp.indexOf(",");
					String value = temp.substring(0, index);
					mat[i][j] = Integer.parseInt(value);
					index++;
					temp = temp.substring(index, temp.length());
				}
				if(i != m-1)
				{
				int index1 = temp.indexOf(";");
				//System.out.println(temp + " " + index1 + " ");
				String value1 = temp.substring(0, index1);
				mat[i][n-1] = Integer.parseInt(value1);
				temp = temp.substring(index1 + 1, temp.length());
				}
				else
				{
					mat[m-1][n-1] = Integer.parseInt(temp);
				}
			}
			
			boolean result = true;
			outmost: for(int i = 0; i < m; i++)
			{
				for(int j = 0; j < n; j++)
				{
					if(i == j)
					{
						continue;
					}
					else
					{
						if(mat[i][j] != mat[j][i])
						{
							result = false;
							break outmost;
						}
					}
				}
			}
			
			if(result)
			{
				System.out.println("Symmetric");
			}
			else
			{
				System.out.println("Not symmetric");
			}
		}
	}

}
