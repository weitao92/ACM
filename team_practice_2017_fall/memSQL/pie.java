package memSQL;

import java.util.Scanner;
/**
 * codeforce 859C
 * @author weitao92
 *
 */
public class pie {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		long[] pies = new long[n];
		for(int i = 0; i < n; i++)
		{
			pies[i] = in.nextLong();
		}
		in.close();
		
		long[] bob = new long[n]; // since bob has the first choice, he's in control.
		bob[n-1] = pies[n-1]; //when down to last one, the best case is always eat it.
		long total = pies[n-1];
		
		for(int i = n-2; i >= 0; i--) //backtrack
		{
			long a = bob[i+1]; //this is when you chose not to eat pies[i], then u will have control
							   //next round, and bob[i+1] is the best scenario from i+1 to n.
			long b = pies[i] + (total - bob[i+1]); //this is when you chose eat pies[i], then alice
												   //will gain control next round and u can only get
												   //what left since alice will chose best scenario.
			
			bob[i] = Math.max(a, b);
			total += pies[i];
		}
		
		System.out.println(total - bob[0] + " " + bob[0]);
		
	}

}
