package RockyMountain2016;

import java.util.*;

/**
 * https://open.kattis.com/problems/studying
 * @author weitao92
 *
 */
public class studyForExam {
	
	static class subject
	{
		double a;
		double b; 
		double c;
		double time;
		double grade;
		
		public subject(double i, double j, double k, double t)
		{
			a = i;
			b = j;
			c = k;
			time = t;
			grade = c;
		}
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		subject[] subjects = new subject[n];
		int TIME = in.nextInt();
		
		for(int i = 0; i < n; i++)
		{
			double a = in.nextDouble();
			double b = in.nextDouble();
			double c = in.nextDouble();
			subjects[i] = new subject(a,b,c,0);
		}
		
		long time = TIME * 1000;
		double gap = 0.001;
		double result = 0;
		for(int i = 0; i < time; i++)
		{
			double max = Double.MIN_VALUE;
			int index = -1;
			for(int j = 0; j < n; j++)
			{
				subject s = subjects[j];
				double increase = s.a * (2 * s.time * gap + Math.pow(gap, 2)) + s.b * gap;

				if(increase > max)
				{
					max = increase;
					index = j;
				}
			}

			subjects[index].grade += max;
			subjects[index].time += gap;
		}
		
		for(int i = 0; i < n; i++)
		{
			result += subjects[i].grade;
		}
		
		System.out.println(result/n);
	}

}
