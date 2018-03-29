package holidayContest;

import java.util.*;

public class C {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int j = 0; j < n; j++)
		{
			double r1 = in.nextDouble();
			double r2 = in.nextDouble();
			double h = in.nextDouble();
			double v = in.nextDouble();
			
			double gap = 0.0000001;
			double total = 0;
			for(double i = gap; i <= h; i+= gap)
			{
				double radius = r2 + (r1-r2)*(Math.pow((h-2*i),2) / Math.pow(h, 2));
				double area = Math.pow(radius, 2) * Math.PI;
				total += area * gap;
				if(total >= v)
				{
					sb.append(i + "\n");
					break;
				}
			}
		}
		
		System.out.print(sb);
	}

}
