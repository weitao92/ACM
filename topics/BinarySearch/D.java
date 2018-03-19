package BinarySearch;
import java.util.*;

/**
 * https://pcs.cs.cloud.vt.edu/contests/67/problems/D
 * @author weitao92
 *
 */
public class D {
	
	static int[] posts;
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int p = in.nextInt();
		int c = in.nextInt();
		posts = new int[p];
		long sum = 0;
		int largest = -1;
		for(int i = 0; i < p; i++)
		{
			int post = in.nextInt();
			posts[i] = post;
			sum += post;
			largest = Math.max(largest, post);
		}
		
		long high = sum;
		long low = largest;
		
		while(high > low)
		{
			long mid = (high + low)/2;

			if(fit(mid, p, c))
			{
				high = mid;
			}
			else
			{
				low = mid + 1;
			}
		}
		
		System.out.println(high);
	}
	
	private static boolean fit(long height, int p, int c)
	{
		long current = posts[0];
		int columns = 1;
		for(int i = 1; i < p; i++)
		{
			if(current + 10 + posts[i] > height)
			{
				columns++;
				current = posts[i];
			}
			else
			{
				current += 10 + posts[i];
			}
		}
		
		return columns <= c;
	}

}
