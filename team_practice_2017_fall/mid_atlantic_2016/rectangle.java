package mid_atlantic_2016;

import java.util.Scanner;

public class rectangle {
	
	static class rec
	{
		int w;
		int h;
		
		public rec(int height, int width)
		{
			w = width;
			h = height;
		}
	}
	
	public static void main(String agrs[])
	{
		Scanner in = new Scanner(System.in);
		rec[] recs = new rec[3];
		for(int i = 0; i < 3; i++)
		{
			int h = in.nextInt();
			int w = in.nextInt();
			recs[i] = new rec(h,w);
		}
		
		//rec r;
		for(int i = 0; i < 3; i++)
		{
			rec ori = recs[i];
			int first;
			int second;
			if(i == 0)
			{
				first = 1;
				second = 2;
			}
			else if(i == 1)
			{
				first = 0;
				second = 2;
			}
			else
			{
				first = 0;
				second = 1;
			}
			
			rec r = recs[first];
			rec next = recs[second];
			rec newOne;
			if(r.h == next.h)
			{
				newOne = new rec(r.h, r.w + next.w);
			}
			else if(r.h == next.w)
			{
				newOne = new rec(r.h, r.w + next.h);
			}
			else if(r.w == next.w)
			{
				newOne = new rec(r.h + next.h, r.w);
			}
			else if(r.w == next.h)
			{
				newOne = new rec(r.h + next.w, r.w);
			}
			else
			{
				continue;
			}
			
			rec result;
			if(ori.h == newOne.h)
			{
				result = new rec(ori.h, ori.w + newOne.w);
			}
			else if(ori.h == newOne.w)
			{
				result = new rec(ori.h, ori.w + newOne.h);
			}
			else if(ori.w == newOne.w)
			{
				result = new rec(ori.h + newOne.h, ori.w);
			}
			else if(ori.w == newOne.h)
			{
				result = new rec(ori.h + newOne.w, ori.w);
			}
			else
			{
				continue;
			}
			
			if(result.h == result.w)
			{
				System.out.println("YES");
				System.exit(0);
			}
		}
		System.out.println("NO");
	}

}
