package goodbye2017;

import java.util.*;

public class problemC {
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int r = in.nextInt();
		int[] x = new int[n];
		double[] result = new double[n];
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++)
		{
			x[i] = in.nextInt();
			result[i] = r;
			for(int j = 0; j < i; j++)
			{
				if(Math.abs(x[i] - x[j]) <= 2*r)
				{
					double temp = Math.abs(x[i]-x[j])/2.0;
					double tempY = Math.sqrt(r*r - temp*temp)*2 + result[j];
					result[i] = Math.max(result[i], tempY);
				}
			}
			sb.append(result[i] + " ");
		}
		System.out.print(sb);		
	}

}
