package goodbye2017;

import java.util.*;

/**
 * http://codeforces.com/contest/908/problem/B
 * @author weitao92
 *
 */
public class problemB {
	
	static int[][] world;
	static int startR = -1;
	static int startC = -1;
	static String instruction;
	static int result = 0;
	static int[] directions = {1,2,3,4};
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		world = new int[n][m];
		
		for(int i = 0; i < n; i++)
		{
			String line = in.next();
			for(int j = 0; j < m; j++)
			{
				//System.out.println(line);
				char c = line.charAt(j);
				if(c == '#')
				{
					world[i][j] = -1;
				}
				else if(c == 'S')
				{
					world[i][j] = 1;
					startR = i;
					startC = j;
				}
				else if(c == 'E')
				{
					world[i][j] = 2;
				}
				else
				{
					world[i][j] = 0;
				}
			}
		}
		instruction = in.next();
		permute(directions, 0);
		System.out.print(result);
	}
	
	private static void permute(int[] directions, int index)
	{
		for(int i = index; i < directions.length; i++)
		{
			int temp = directions[index];
			directions[index] = directions[i];
			directions[i] = temp;
			permute(directions, index+1);
			temp = directions[index];
			directions[index] = directions[i];
			directions[i] = temp;
		}
		if(index == directions.length)
		{
			int currentR = startR;
			int currentC = startC;
			boolean finished = false;
			for(int i = 0; i < instruction.length(); i++)
			{
				if(currentR < 0 || currentR >= world.length || 
						currentC < 0 || currentC >= world[0].length || world[currentR][currentC] == -1)
				{
					break;
				}
				if(world[currentR][currentC] == 2)
				{
					result++;
					finished = true;
					break;
				}
				char c = instruction.charAt(i);
				int current = directions[Character.getNumericValue(c)];
				if(current == 1)
				{
					currentR--;
				}
				else if(current == 2)
				{
					currentC++;
				}
				else if(current == 3)
				{
					currentR++;
				}
				else
				{
					currentC--;
				}
			}
			if(!finished && currentR >= 0 && currentR < world.length 
					&& currentC >= 0 && currentC < world[0].length && world[currentR][currentC] == 2)
			{
				result++;
			}			
		}
	}
	
	private static void printA()
	{
		for(int i = 0; i < 4; i++)
		{
			System.out.print(directions[i] + " ");
		}
		System.out.println();
	}
}