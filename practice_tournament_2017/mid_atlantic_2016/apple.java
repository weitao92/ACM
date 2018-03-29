package mid_atlantic_2016;

import java.util.ArrayDeque;
import java.util.Scanner;

public class apple {
	
	public static void main(String agrs[])
	{
		Scanner in = new Scanner(System.in);
		int row = in.nextInt();
		int col = in.nextInt();
		int[][] world = new int[row][col];
		ArrayDeque<Integer>[] list = new ArrayDeque[col];
		int[] space = new int[col];
		for(int i = 0; i < col; i++)
		{
			list[i] = new ArrayDeque<Integer>();
		}
		
		for(int i = 0; i < row; i++)
		{
			String s = in.next();
			for(int j = 0; j < col; j++)
			{
				char c = s.charAt(j);
				if(c == 'a')
				{
					world[i][j] = 1;
					list[j].addFirst(i);
				}
				else if(c == '#')
				{
					world[i][j] = -1;
				}
				else
				{
					space[j] = i;
				}
			}
		}
		

		in.close();
		for(int c = 0; c < col; c++)
		{
			int ori = -1;
			int det = -1;;
			ArrayDeque<Integer> queue = list[c]; 
			
			while(!queue.isEmpty())
			{
				int r = queue.removeFirst();
				
					//ori = r;
					int down = r+1;
					while(down < row)
					{
						if(world[down][c] == 0)
						{
							if(down == ori)
							{
								down = det;
								break;
							}
							else
							{
								down++;
							}
						}
						else
						{
							break;
						}
					}
					
					if(down - 1 == r)
					{
						det = r;
					}
					else
					{
						world[down-1][c] = 1;
						world[r][c] = 0;
						det = down - 1;
					}
					ori = r;
					//System.out.println("col: " + c + " r: " + r + " ori: " + ori + " det: " + det);
			}
		}
		
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
			{
				if(world[i][j] == 0)
				{
					result.append('.');
				}
				else if(world[i][j] == 1)
				{
					result.append('a');
				}
				else
				{
					result.append('#');
				}
				
			}
			result.append('\n');
		}
		
		System.out.println(result);
	}

}
