package warmUp2;

import java.math.BigInteger;
import java.util.Scanner;

public class cards {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		BigInteger height = new BigInteger(in.next());
		
		BigInteger current = (BigInteger.valueOf(3).add(height.multiply(BigInteger.valueOf(3))))
				.multiply(height).divide(BigInteger.valueOf(2)).subtract(height);
		
		while(!current.mod(BigInteger.valueOf(4)).equals(BigInteger.valueOf(0)))
		{
			height = height.add(BigInteger.valueOf(1));
			BigInteger diff = height.multiply(BigInteger.valueOf(3)).subtract(BigInteger.valueOf(1));
			current = current.add(diff);
		}
		
		System.out.println(height);
	}

}
