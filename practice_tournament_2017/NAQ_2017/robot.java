package NAQ_2017;

import java.util.Scanner;

public class robot {
	
	static class point
	{
		int x;
		int y;
		int face;
		
		public point(int a, int b, int f)
		{
			x = a;
			y = b;
			face = f;
		}
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int y = in.nextInt();
		
		int n = in.nextInt();
		int[] ins = new int[n];
		for(int i = 0; i < n; i++)
		{
			String s = in.next();
			if(s.equals("Left"))
			{
				ins[i] = 0;
			}
			else if(s.equals("Right"))
			{
				ins[i] = 1;
			}
			else
			{
				ins[i] = 2;
			}
		}
		
		
		for(int i = 0; i < n; i++)
		{
			point origin = new point(0,0,0);
			for(int s = 0; s < i; s++)
			{
				origin = run(origin, ins[s], origin.face);
			}
			
			if(ins[i] == 0)
			{
				point origin1 = run(origin, 1, origin.face);
				for(int k = i + 1; k < n; k++)
				{
					origin1 = run(origin1, ins[k], origin1.face);
				}
				
				if(origin1.x == x && origin1.y == y)
				{
					System.out.print((i+1) + " Right");
					System.exit(0);
				}
				
				point origin2 = run(origin, 2, origin.face);
				for(int k = i + 1; k < n; k++)
				{
					origin2 = run(origin2, ins[k], origin2.face);
				}
				
				if(origin2.x == x && origin2.y == y)
				{
					System.out.print((i+1) + " Forward");
					System.exit(0);
				}
			}
			else if(ins[i] == 1)
			{
				point origin1 = run(origin, 0, origin.face);
				for(int k = i + 1; k < n; k++)
				{
					origin1 = run(origin1, ins[k], origin1.face);
				}
				
				if(origin1.x == x && origin1.y == y)
				{
					System.out.print((i+1) + " Left");
					System.exit(0);
				}
				
				//System.out.println( i + " " + origin.x + " " + origin.y + " " + origin.face);
				point origin2 = run(origin, 2, origin.face);
				//System.out.println(origin2.x + " " + origin2.y + " " + origin2.face);
				for(int k = i + 1; k < n; k++)
				{
					origin2 = run(origin2, ins[k], origin2.face);
				}
				
				if(origin2.x == x && origin2.y == y)
				{
					System.out.print((i+1) + " Forward");
					System.exit(0);
				}
			}
			else
			{
				point origin1 = run(origin, 0, origin.face);
				for(int k = i + 1; k < n; k++)
				{
					origin1 = run(origin1, ins[k], origin1.face);
				}
				
				if(origin1.x == x && origin1.y == y)
				{
					System.out.print((i+1) + " Left");
					System.exit(0);
				}
				
				point origin2 = run(origin, 1, origin.face);
				for(int k = i + 1; k < n; k++)
				{
					origin2 = run(origin2, ins[k], origin2.face);
				}
				
				if(origin2.x == x && origin2.y == y)
				{
					System.out.print((i+1) + " Right");
					System.exit(0);
				}
			}
		}
	}
	
	private static point run(point o, int ins, int face)
	{
		point origin = new point(o.x, o.y, o.face);
		if(ins == 0)
		{
			if(face == 0)
			{
				origin.face = 3;
				return origin;
			}
			else if(face == 1)
			{
				origin.face = 0;
				return origin;
			}
			else if(face == 2)
			{
				origin.face = 1;
				return origin;
			}
			else
			{
				origin.face = 2;
				return origin;
			}
		}
		else if(ins == 1)
		{
			if(face == 0)
			{
				origin.face = 1;
				return origin;
			}
			else if(face == 1)
			{
				origin.face = 2;
				return origin;
			}
			else if(face == 2)
			{
				origin.face = 3;
				return origin;
			}
			else
			{
				origin.face = 0;
				return origin;
			}
		}
		else
		{
			if(face == 0)
			{
				origin.y++;;
				return origin;
			}
			else if(face == 1)
			{
				origin.x++;
				return origin;
			}
			else if(face == 2)
			{
				origin.y--;
				return origin;
			}
			else
			{
				origin.x--;
				return origin;
			}
		}
	}

}
