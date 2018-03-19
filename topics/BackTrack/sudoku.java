package BackTrack;
import java.util.*;

public class sudoku {
	
	static class cell
	{
		boolean split;
		int p;
		int q;
		
		public cell(boolean s, int p, int q)
		{
			split = s;
			this.p = p;
			this.q = q;
		}
	}
	
	static cell[][] world = new cell[6][6];
	static boolean finished = false;
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);

		for(int i = 0; i < 6; i++)
		{
			String line = in.nextLine();
			String[] parts = line.split(" ");
			for(int j = 0; j < 6; j++)
			{
				String current = parts[j];
				if(current.length() == 1)
				{
					if(current.equals("-"))
					{
						world[i][j] = new cell(false, 0, 0);
					}
					else
					{
						world[i][j] = new cell(false, Integer.parseInt(current), 0);
					}
				}
				else
				{
					int p = current.charAt(0) == '-' ? 0 : 
						Character.getNumericValue(current.charAt(0));
					int q = current.charAt(2) == '-' ? 0 : 
						Character.getNumericValue(current.charAt(2));
					world[i][j] = new cell(true, p, q);
				}
			}
		}
		
		backTrack(0,0);
		//StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 6; j++)
			{
				cell c = world[i][j];
				if(!c.split)
				{
					System.out.print(c.p);
				}
				else
				{
					System.out.print(c.p + "/" + c.q);
				}
				
				if(j != 5)
				{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		//System.out.print(sb);
	}
	
	private static void backTrack(int col, int row)
	{
		if(row >= 6)
		{
			backTrack(col + 1, 0);
			return;
		}
		if(col >= 6)
		{
			finished = true;
			return;
		}
		else
		{			
			//cell temp = new cell(world[row][col].split, world[row][col].p, world[row][col].q);
			if(!world[row][col].split)
			{
				if(world[row][col].p == 0)
				{
					for(int k = 1; k <= 9; k++)
					{
						boolean result = check(row, col, 0, k);
						if(result)
						{
							world[row][col].p = k;
							backTrack(col, row+1);
						}
						if(finished)
						{
							return;
						}
						else
						{
							world[row][col].p = 0;
							continue;
						}
					}
					
					//world[row][col] = temp;
					return;			
				}
				else
				{
					backTrack(col, row+1);
				}
			}
			else//check split
			{
				if(world[row][col].p == 0)
				{
					//temp = new cell(world[row][col].split, world[row][col].p, world[row][col].q);
					for(int k = 1; k <= 9; k++)
					{
						boolean result = check(row, col, 1, k);
						if(result)
						{
							world[row][col].p = k;
							if(world[row][col].q != 0)
							{
								backTrack(col, row+1);
							}
							else
							{
								//cell temp1 = new cell(world[row][col].split, world[row][col].p, world[row][col].q);
								for(int x = k + 1; x <= 9; x++)
								{
									boolean result1 = check(row, col, 2, x);
									if(result1)
									{
										world[row][col].q = x;
										backTrack(col, row+1);
									}
									if(finished)
									{
										return;
									}
									else
									{
										world[row][col].q = 0;
										continue;
									}
								}
								
								world[row][col].q = 0;
								//return;	
							}
						}
						if(finished)
						{
							return;
						}
						else
						{
							world[row][col].p = 0;
							continue;
						}
					}
					
					world[row][col].p = 0;
					return;		
				}
				else
				{
					//temp = new cell(world[row][col].split, world[row][col].p, world[row][col].q);
					if(world[row][col].q == 0)
					{
						for(int x = world[row][col].p + 1; x <= 9; x++)
						{
							boolean result1 = check(row, col, 2, x);
							
							if(result1)
							{
								world[row][col].q = x;
								backTrack(col, row+1);
							}
							if(finished)
							{
								return;
							}
							else
							{
								world[row][col].q = 0;
								continue;
							}
						}
						
						world[row][col].q = 0;
						return;	
					}
					else
					{
						backTrack(col, row+1);
					}
				}
			}
		}
		
	}
	
	/**
	 * mode == 0 means check single. mode == 1 means check p, mode == 2 means check q.
	 * @param x
	 * @param y
	 * @param mode
	 * @param value
	 * @return
	 */
	private static boolean check(int x, int y, int mode, int value)
	{
		for(int i = 0; i < 6; i++)
		{
			if(i != y)
			{
				if(world[x][i].p == value || world[x][i].q == value)
				{
					return false;
				}
			}
		}
		
		for(int i = 0; i < 6; i++)
		{
			if(i != x)
			{
				if(world[i][y].p == value || world[i][y].q == value)
				{
					return false;
				}
			}
		}
		
		int lx = (x/2)*2;
		int ly = (y/3)*3;
		
		if(lx != x || ly != y)
		{
			if(world[lx][ly].p == value || world[lx][ly].q == value)
			{
				return false;
			}
		}
		
		if(lx + 1 != x || ly != y)
		{
			if(world[lx+1][ly].p == value || world[lx+1][ly].q == value)
			{
				return false;
			}
		}
		
		if(lx != x || ly + 1 != y)
		{
			if(world[lx][ly+1].p == value || world[lx][ly+1].q == value)
			{
				return false;
			}
		}
		
		if(lx + 1 != x || ly + 1 != y)
		{
			if(world[lx+1][ly+1].p == value || world[lx+1][ly+1].q == value)
			{
				return false;
			}
		}
		
		if(lx != x || ly + 2 != y)
		{
			if(world[lx][ly+2].p == value || world[lx][ly+2].q == value)
			{
				return false;
			}
		}
		
		if(lx + 1 != x || ly + 2 != y)
		{
			if(world[lx+1][ly+2].p == value || world[lx+1][ly+2].q == value)
			{
				return false;
			}
		}
		
		if(mode == 0)
		{
			
		}
		else if(mode == 1)
		{
			if(world[x][y].q == value)
			{
				return false;
			}
			else
			{
				if(world[x][y].q != 0 && world[x][y].q < value)
				{
					return false;
				}
			}
		}
		else
		{
			if(world[x][y].p == value)
			{
				return false;
			}
			else
			{
				if(world[x][y].p != 0 && world[x][y].p > value)
				{
					return false;
				}
			}
		}
		
		
		return true;
	}

}