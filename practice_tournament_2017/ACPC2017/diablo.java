package ACPC2017;

import java.util.Scanner;

public class diablo {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		double area = in.nextDouble();
		double peri = in.nextDouble();
		
		double radius = Math.sqrt(area / Math.PI);
		double p = 2 * radius * Math.PI;
		if(p <= peri)
		{
			System.out.println("Diablo is happy!");
		}
		else
		{
			System.out.println("Need more materials!");
		}
	}

}
