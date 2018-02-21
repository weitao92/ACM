package Primes;

import java.util.Scanner;

/**
 * https://pcs.cs.cloud.vt.edu/contests/65/problems/B
 * @author weitao92
 *
 */
public class B {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		if(n == 1)
		{
			System.out.println(0);
			System.exit(0);
		}

        boolean[] isPrime = new boolean[n+1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int factor = 2; factor*factor <= n; factor++) {
            if (isPrime[factor]) {
                for (int j = factor; factor*j <= n; j++) {
                    isPrime[factor*j] = false;
                }
            }
        }

        int primes = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) primes++;
        }
        System.out.println(primes);
	}
}