package NY_regional_2016;

import java.util.*;

public class ProblemG {
	
	static int[][] world = new int[8][8];
	static boolean finished = false;
	static HashSet<Integer> set = new HashSet<Integer>();
	static TreeSet<Integer> left = new TreeSet<Integer>();
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				int next = in.nextInt();
				if(next != -1)
				{
					world[i][j] = next;
					set.add(next);
				}
			}
		}
		
		for(int i = 1; i <= 64; i++)
		{
			left.add(i);
		}
		
		backTrack(0,0);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				sb.append(world[i][j] + " ");
			}
			sb.substring(0, sb.length() - 1);
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
	private static void backTrack(int x, int y)
	{
		if(x >= 8)
		{
			backTrack(0, y+1);
			return;
		}
		if(y >= 8)
		{
			finished = true;
			return;
		}
		else
		{
			
			if(world[x][y] != 0)
			{
				backTrack(x+1, y);
				//return;
			}
			else
			{
				int rowS = 0;
				int numR = 0;
				int colS = 0;
				int numC = 0;
				int low1 = 1;
				int low2 = 1;
				int high1 = 64;
				int high2 = 64;
				for(int i = 0; i < 8 && i != y; i++)
				{
					if(world[x][i] != 0)
					{
						rowS += world[x][i];
						numR++;
					}
				}
				
				int temp = 260 - rowS;
				
				
				if(numR == 7)
				{
					if(temp > 0 && temp <= 64)
					{
						//int temp = 260 - rowS;
						if(check(x,y,temp))
						{
							world[x][y] = temp;
							set.add(temp);
							left.remove(temp);
							backTrack(x+1, y);
							
							if(finished)
							{
								return;
							}
							else
							{
								world[x][y] = 0;
								set.remove(temp);
								left.add(temp);
								//return;
							}
						}
					}
				}
				else
				{
					int diff = 7 - numR;
					high1 = temp;
					low1 = temp;
					ArrayList<Integer> templist = new ArrayList<Integer>();
					for(int i = 0; i < diff; i++)
					{
						int first = left.pollFirst();
						templist.add(first);
						high1 -= first;
					}
					left.addAll(templist);
					templist.clear();
					for(int i = 0; i < diff; i++)
					{
						int last = left.pollLast();
						templist.add(last);
						low1 -= last;
					}
					left.addAll(templist);
					
				}
				
				
				for(int i = 0; i < 8 && i != x; i++)
				{
					if(world[i][y] != 0)
					{
						colS += world[i][y];
						numC++;
					}
				}
				
				temp = 260 - colS;
				
				if(numC == 7)
				{
					if(temp > 0 && temp <= 64)
					{
						if(check(x,y,temp))
						{
							world[x][y] = temp;
							set.add(temp);
							left.remove(temp);
							backTrack(x+1, y);
							
							if(finished)
							{
								return;
							}
							else
							{
								world[x][y] = 0;
								set.remove(temp);
								left.add(temp);
								//return;
							}
						}
					}
				}
				else
				{
					int diff = 7 - numC;
					high2 = temp;
					low2 = temp;
					ArrayList<Integer> templist = new ArrayList<Integer>();
					for(int i = 0; i < diff; i++)
					{
						int first = left.pollFirst();
						templist.add(first);
						high2 -= first;
					}
					left.addAll(templist);
					templist.clear();
					for(int i = 0; i < diff; i++)
					{
						int last = left.pollLast();
						templist.add(last);
						low2 -= last;
					}
					left.addAll(templist);				
				}
				
				int low = low1 >= low2 ? low1 : low2;
				int high = high1 >= high2 ? high2 : high1;
				low = low < 1 ? 1 : low;
				high = high > 64 ? 64 : high;
				
				for(int i = low; i <= high; i++)
				{
					if(!set.contains(i))
					{
						boolean result = check(x,y,i);
						if(result)
						{
							world[x][y] = i;
							set.add(i);
							left.remove(i);
							backTrack(x+1,y);
						}
						
						if(finished)
						{
							return;
						}
						else
						{
							world[x][y] = 0;
							set.remove(i);
							left.add(i);
							continue;
						}
					}
				}
				
				System.out.println(x + " " + y + " " + set.size() + " " + finished);
				//world[x][y] = 0;
				return;
			}
		}
	}
	
	private static boolean check(int x, int y, int value)
	{
		
		if(set.contains(value + 1))
		{
			//boolean check = false;
			
			if(x - 1 >= 0 && y - 2 >= 0)
			{
				if(world[x-1][y-2] == value+1)
				{
					return true;
				}
			}
			if(x - 2 >= 0 && y - 1 >= 0)
			{
				if(world[x-2][y-1] == value+1)
				{
					return true;
				}
			}
			if(x - 2 >= 0 && y + 1 <= 7)
			{
				if(world[x-2][y+1] == value+1)
				{
					return true;
				}
			}
			if(x - 1 >= 0 && y + 2 <= 7)
			{
				if(world[x-1][y+2] == value+1)
				{
					return true;
				}
			}
			if(x + 1 <= 7 && y + 2 <= 7)
			{
				if(world[x+1][y+2] == value+1)
				{
					return true;
				}
			}
			if(x + 2 <= 7 && y + 1 <= 7)
			{
				if(world[x+2][y+1] == value+1)
				{
					return true;
				}
			}
			if(x + 2 <= 7 && y - 1 >= 0)
			{
				if(world[x+2][y-1] == value+1)
				{
					return true;
				}
			}
			if(x + 1 <= 7 && y - 2 >= 0)
			{
				if(world[x+1][y-2] == value+1)
				{
					return true;
				}
			}
			
			return false;
		}
		
		return true;	
	}

}
