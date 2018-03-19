package MATH;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * https://pcs.cs.cloud.vt.edu/problems/151
 */
public class extremeBilliard {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		BigInteger m = new BigInteger(in.next());
		BigInteger n = new BigInteger(in.next());
		String start = in.next();
		
		BigInteger gcd = m.gcd(n);
		BigInteger product = m.multiply(n);
		BigInteger lcm = product.divide(gcd);
		
		BigInteger x = lcm.divide(m);
		BigInteger y = lcm.divide(n);
		
		char c1;
		if(x.mod(new BigInteger("2")).equals(new BigInteger("0")))
		{
			c1 = start.charAt(0) == 'S' ? 'S' : 'N';
		}
		else
		{
			c1 = start.charAt(0) == 'S' ? 'N' : 'S';
		}
		System.out.print(c1);
		
		char c2;
		if(y.mod(new BigInteger("2")).equals(new BigInteger("0")))
		{
			c2 = start.charAt(1) == 'W' ? 'W' : 'E';
		}
		else
		{
			c2 = start.charAt(1) == 'W' ? 'E' : 'W';
		}
		System.out.print(c2);
		
		in.close();
	}
}
