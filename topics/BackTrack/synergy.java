package BackTrack;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://pcs.cs.cloud.vt.edu/contests/36/problems/B
 */
public class synergy {
	
	static boolean[] selected = new boolean[10];
	@SuppressWarnings("unchecked")
	static ArrayList<Integer>[] gragh = new ArrayList[10];
	static player[] players = new player[10];
	static int[] perfect = new int[10];
	static class player
	{
		String name;
		String country;
		String league;
		String team;
		
		public player(String n, String c, String l, String t)
		{
			name = n;
			country = c;
			league = l;
			team = t;
		}
	}

	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		for(int i = 0; i < 10; i++)
		{
			gragh[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < m; i++)
		{		
			int src = in.nextInt();
			int det = in.nextInt();
			gragh[src].add(det);
			gragh[det].add(src);
		}

		for(int i = 1; i <= 10; i++)
		{
			String name = in.next();
			String country = in.next();
			String league = in.next();
			String team = in.next();
			player p = new player(name, country, league, team);
			players[i-1] = p;
		}
		in.close();
	
		run(0);
		System.out.println("no");
	}
	
	private static void run(int index)
	{
		if(index == 10)
		{
			boolean passed = true;
			for(int i = 0; i < 10; i++)
			{
				int degree = gragh[i].size();
				player current = players[perfect[i]];
				int synergy = 0;
				for(int neighbor : gragh[i])
				{
					player n = players[perfect[neighbor]];
					
					if(current.country.equals(n.country))
					{
						synergy++;
					}
					if(current.league.equals(n.league))
					{
						synergy++;
					}
					if(current.team.equals(n.team))
					{
						synergy++;
					}
				}
				
				if(synergy < degree)
				{
					passed = false;
					break;
				}
			}
			
			if(passed)
			{
				System.out.println("yes");
				System.exit(0);
			}
			else
			{
				return;
			}
		}
		
		for(int i = 0; i < 10; i++)
		{
			if(!selected[i])
			{
				selected[i] = true;
				perfect[index] = i;
				run(index + 1);
				selected[i] = false;
			}
		}
	}
}
