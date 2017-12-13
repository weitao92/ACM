package bloomCon;
import java.util.*;

public class halloween {
	
	static class point
	{
		int x;
		int y;
		
		public point(int a, int b)
		{
			x = a;
			y = b;
		}
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] mat = new int[n][m];
		int max = in.nextInt();
		
		int sx = in.nextInt();
		int sy = in.nextInt();
		int ex = in.nextInt();
		int ey = in.nextInt();
		
		boolean[][] visited = new boolean[n][m];
		visited[sx][sy] = true;
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
			{
				mat[i][j] = in.nextInt();
			}
		}
		
		int index = 0;
		int cx = sx;
		int cy = sy;
		long result = mat[sx][sy];
		long ma = 0;
		ArrayDeque<point> queue = new ArrayDeque<point>();
		queue.add(new point(sx, sy));
		//int index = 0;
		while(!queue.isEmpty())
		{
		
			index++;
			point p = queue.poll();
			cx = p.x;
			cy = p.y;
			result += mat[cx][cy];
			index++;
			if(index == max)
			{
				if(result > ma)
				{
					ma = result;
				}
			}
			if(cy-1 >= 0)
			{
				point np = new point(cx, cy-1);
				if(!visited[cx][cy-1])
				{
					queue.add(np);
				}
			}
			if(cx - 1 >= 0)
			{
				point np =new point(cx-1,cy);
				if(!visited[cx-1][cy])
				{
					queue.add(np);
				}
			}
			if(cy + 1 <n)
			{
				point np =new point(cx, cy+1);
				if(!visited[cx][cy+1])
				{
					queue.add(np);
				}
			}
			if(cx + 1 < m)
			{
				point np =new point(cx+1, cy);
				if(!visited[cx+1][cy])
				{
					queue.add(np);
				}
			}
		}
	}

}
