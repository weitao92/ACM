package codeForce3;


import java.util.ArrayList;
import java.util.Scanner;

public class game {
	
	static class pair
	{
		int pa;
		int pb;
		
		public pair(int pA, int pB)
		
		{
			pa = pA;
			pb = pB;
		}
		
		public boolean equals(Object obj)
		{
			pair another = (pair) obj;
			return 
					pa == another.pa && pb == another.pb;
		} 
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		long k = in.nextLong();
		int pA = in.nextInt();
		int pB = in.nextInt();
		pair first = new pair(pA, pB);
		ArrayList<pair> pairs= new ArrayList<pair>();
		pairs.add(first);
		int[][] alice = new int[3][3];
		int[][] bob = new int[3][3];
		
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				alice[i][j] = in.nextInt();
			}
		}
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				bob[i][j] = in.nextInt();
			}
		}
		
		long A = 0;
		long B = 0;
		int Ascore = 0;
		int Bscore = 0;
		long i = 0;
		int start = 0;
		for(i = 0; i < k; i++)
		{
			int result = aliceWin(pA, pB);
			if(result > 0)
			{
				Ascore = 1;
				Bscore = 0;
			}
			else if(result == 0)
			{
				Ascore = 0;
				Bscore = 0;
			}
			else
			{
				Ascore = 0;
				Bscore = 1;
			}
			A += Ascore;
			B += Bscore;
			
			int cA = alice[pA-1][pB-1];
			int cB = bob[pA-1][pB-1];
			pair newP = new pair(cA, cB);
			
			int index = -1;
			
			for(long j = i; j >= 0; j--)
			{
				if(pairs.get((int)j).equals(newP))
				{
					index = (int)j;
				}
			}
			
			if(index == -1)
			{
				pA = cA;
				pB = cB;
				pairs.add(newP);
			}
			else
			{
				start = index;
				break;
			}
			
		}
		
		
		
		long left = k - i - 1;
		long gap = i - (long)start + 1;
		long leftOver = left % gap;
		//System.out.println(A + " " + B);
		//System.out.println(left + " " + gap + " " + leftOver);
		Ascore = 0;
		Bscore = 0;
		long Aleft = 0;
		long Bleft = 0;
		int leftl = 0;
		int as = 0;
		int bs = 0;
		for(long x = start; x <= i; x++)
		{
			pA = pairs.get((int)x).pa;
			pB = pairs.get((int)x).pb;
			int result = aliceWin(pA, pB);
			if(result > 0)
			{
				as = 1;
				bs = 0;
			}
			else if(result == 0)
			{
				as = 0;
				bs = 0;
			}
			else
			{
				as = 0;
				bs = 1;
			}
			
			
			if(leftl < leftOver)
			{
				Aleft += as;
				Bleft += bs;
			}
			Ascore += as;
			Bscore += bs;
			leftl ++;
		}
		
		//System.out.println(Ascore + " " + Bscore + " " + Aleft + " " + Bleft);
		
		
		/**
		for(long j = 0; j < left / gap; j++)
		{
			A += Ascore;
			B += Bscore;
		}
		**/
		A += Ascore * (left / gap);
		B += Bscore * (left / gap);
		//System.out.println(A + " " + B);
		A += Aleft;
		B += Bleft;
		
		System.out.println(A + " " + B);
	}
	
	private static int aliceWin(int a, int b)
	{
		if(a == 1)
		{
			if(b == 3)
			{
				return 1;
			}
			else
			{
				return Integer.compare(a, b);
			}
		}
		else if(a == 2)
		{
			return Integer.compare(a, b);
		}
		else
		{
			if(b == 1)
			{
				return -1;
			}
			else
			{
				return Integer.compare(a, b);
			}
		}
	}

}
