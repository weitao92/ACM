package IO;

import java.util.Scanner;

public class billiard {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		String firstLine = in.nextLine();
		int n = firstLine.length();
		int m = 1;
		
		while(in.nextLine().charAt(0) != 'o')
		{
			m++;
		}
		m++;
		in.close();
		
		int[][] world = new int[m][n];
		for(int i = 0; i < m; i++)
		{
			for(int j = 0; j < n; j++)
			{
				world[i][j] = -1;
			}
		}
		
		for(int i = 0; i < n; i++)
		{
			world[0][i] = 0;
			world[m-1][i] = 0;
		}
		
		for(int i = 1; i < m - 1; i++)
		{
			world[i][0] = 1;
			world[i][n-1] = 1; 
		}
		
		world[m-1][0] = 2;
		play(world, 1, m - 2, 2, 3);
		
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < m; i++)
		{
			for(int j = 0; j < n; j++)
			{
				int result = world[i][j];
				
				switch (result)
				{
					case -1:
						builder.append(" ");
						break;
					case 0:
						builder.append("-");
						break;
					case 1:
						builder.append("|");
						break;
					case 2:
						builder.append("/");
						break;
					case -2:
						builder.append("\\");
						break;
					case 4: 
						builder.append("o");
						break;
							
				}		
			}
			
			builder.append("\n");
		}
		
		System.out.println(builder);
		
	}
	
	private static void play(int[][] world, int x, int y, int direction, int wall)
	{
		if(x == 0 && y == 0)
		{
			world[y][x] = 4;
			return;
		}
		else if(x == 0 && y == world.length - 1)
		{
			world[y][x] = 4;
			return;
		}
		else if(x == (world[0].length - 1) && y == 0)
		{
			world[y][x] = 4;
			return;
		}
		else if(x == (world[0].length - 1) && y == world.length - 1)
		{
			world[y][x] = 4;
			return;
		}
		else
		{
			if(y == 0)
			{
				wall = 1;
				
				if(direction == 2)
				{
					direction = 0 - direction;
					play(world, x, y + 1, direction, wall);
				}
				else
				{
					direction = 0 - direction;
					play(world, x, y + 1, direction, wall);
				}
				
			}
			else if(y == world.length - 1)
			{
				wall = 3;
				if(direction == 2)
				{
					direction = 0 - direction;
					play(world, x, y - 1, direction, wall);
				}
				else
				{
					direction = 0 - direction;
					play(world, x, y - 1, direction, wall);
				}
			}
			else if(x == 0)
			{
				wall = 4;
				if(direction == 2)
				{
					direction = 0 - direction;
					play(world, x + 1, y, direction, wall);
				}
				else
				{
					direction = 0 - direction;
					play(world, x + 1, y, direction, wall);
				}
			}
			else if(x == world[0].length - 1)
			{
				wall = 2;
				
				if(direction == 2)
				{
					direction = 0 - direction;
					play(world, x - 1, y, direction, wall);
				}
				else
				{
					direction = 0 - direction;
					play(world, x - 1, y, direction, wall);
				}
			
			}
			else
			{
				world[y][x] = direction;
				if(wall == 1)
				{
					if(direction == 2)
					{
						play(world, x - 1, y + 1, direction, wall);
					}
					else
					{
						play(world, x + 1, y + 1, direction, wall);
					}
				}
				else if(wall == 2)
				{
					if(direction == 2)
					{
						play(world, x - 1, y + 1, direction, wall);
					}
					else
					{
						play(world, x - 1, y - 1, direction, wall);
					}
				}
				else if(wall == 3)
				{
					if(direction == 2)
					{
						play(world, x + 1, y - 1, direction, wall);
					}
					else
					{
						play(world, x - 1, y - 1, direction, wall);
					}
				}
				else if(wall == 4)
				{
					if(direction == 2)
					{
						play(world, x + 1, y - 1, direction, wall);
					}
					else
					{
						play(world, x + 1, y + 1, direction, wall);
					}
				}
			}
			
		}
	}

}
