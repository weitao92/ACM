package Geometry;

import java.util.Scanner;

/**
 * https://www.facebook.com/hackercup/problem/1254819954559001/
 * @author weitao92
 *
 */
public class progressBar {
	
	static double diff = 0.000001;
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		for(int i = 0; i < n; i++)
		{
			System.out.print("Case #" + (i+1) + ": ");
			double p = in.nextDouble();
			double x = in.nextDouble() - 50;
			double y = in.nextDouble() - 50;
			double hypo = Math.hypot(x, y);
			//System.out.println("hypo: " + hypo);
			
			if(hypo > 50 + diff)
			{
				System.out.println("white");
			}
			else
			{
				double angle = Math.atan2(y, x);
				double progress = 360.0 * p / 100.0;
				System.out.println(angle);
				angle = angle > 0.0 ? 180.0 * (angle / Math.PI)
						: (2*Math.PI + angle) * 360 / (2*Math.PI);
				//System.out.println(angle + " " + progress);
				if(angle == 90.0)
				{
					System.out.println("black");
					continue;
				}
				
				if(angle >= 0 && angle < 90.0)
				{
					if(90.0 - angle <= progress)
					{
						System.out.println("black");
					}
					else
					{
						System.out.println("white");
					}
				}
				else
				{
					if(angle - 90.0  + progress >= 360)
					{
						System.out.println("black");
					}
					else
					{
						System.out.println("white");
					}
				}
			}
		}
		
		in.close();
	}

}
