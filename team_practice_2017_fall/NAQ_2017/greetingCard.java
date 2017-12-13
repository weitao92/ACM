package NAQ_2017;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/greetingcard
 * @author weitao92
 *
 */
public class greetingCard {
	
	static class point
	{
		double x;
		double y;
		String p;
		
		public point(double a, double b)
		{
			x = a;
			y = b;
			p = Double.toString(a) + Double.toString(b);
		}
		
		public boolean equals(Object o)
		{
			point another = (point)o;
			
			return x == another.x && y == another.y;
		}
		
		public int hashCode()
		{
			return Objects.hashCode(p);
		}
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		HashMap<point, Integer> map = new HashMap<point, Integer>();
		point[] ps = new point[n];
		
		for(int i = 0; i < n; i++)
		{
			point p = new point(in.nextDouble(), in.nextDouble());
			ps[i] = p;
			if(map.containsKey(p))
			{
				map.put(p, map.get(p) + 1);
			}
			else
			{
				map.put(p, 1);
			}
		}
		
		long result = 0;
		for(int i = 0; i < n; i++)
		{
			point c = ps[i];
			Integer temp = map.get(new point(c.x + 2018, c.y));
			if(temp != null)
			{
				result += temp;
			}
			temp = map.get(new point(c.x - 2018, c.y));
			if(temp != null)
			{
				result += temp;
			}
			temp = map.get(new point(c.x, c.y + 2018));
			if(temp != null)
			{
				result += temp;
			}
			temp = map.get(new point(c.x, c.y - 2018));
			if(temp != null)
			{
				result += temp;
			}
			temp = map.get(new point(c.x + 1118, c.y + 1680));
			if(temp != null)
			{
				result += temp;
			}
			temp = map.get(new point(c.x + 1118, c.y - 1680));
			if(temp != null)
			{
				result += temp;
			}
			temp = map.get(new point(c.x - 1118, c.y + 1680));
			if(temp != null)
			{
				result += temp;
			}
			temp = map.get(new point(c.x - 1118, c.y - 1680));
			if(temp != null)
			{
				result += temp;
			}
			temp = map.get(new point(c.x + 1680, c.y + 1118));
			if(temp != null)
			{
				result += temp;
			}
			temp = map.get(new point(c.x + 1680, c.y - 1118));
			if(temp != null)
			{
				result += temp;
			}
			temp = map.get(new point(c.x - 1680, c.y + 1118));
			if(temp != null)
			{
				result += temp;
			}
			temp = map.get(new point(c.x - 1680, c.y - 1118));
			if(temp != null)
			{
				result += temp;
			}
		}
		
		result /= 2;
		
		
		System.out.println(result);
	}

}
