package probability;

import java.util.Scanner;

/**
 * https://pcs.cs.cloud.vt.edu/contests/66/problems/C
 * @author weitao92
 *
 */
public class C {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		double pass = in.nextDouble();
		int n = in.nextInt();
		
		double fail = 1-pass;
		double failall = Math.pow(fail, n);
		double passAtLeastOne = 1-failall;
		double result = Math.pow(passAtLeastOne, 300);
		System.out.println(result);
	}

}
