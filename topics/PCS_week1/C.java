package PCS_week1;
import java.util.*;

public class C {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		long k = in.nextLong();
		long a = in.nextLong();
		long b = in.nextLong();
		
		if(a/k == 0 && b/k == 0)
		{
			System.out.println("-1");
			System.exit(0);
		}
		if(a/k > 0)
		{
			if(b/k == 0 && a%k != 0)
			{
				System.out.println("-1");
				System.exit(0);
			}
			else
			{
				System.out.println(a/k + b/k);
				System.exit(0);
			}
		}
		
		if(b/k > 0)
		{
			if(a/k == 0 && b%k != 0)
			{
				System.out.println("-1");
				System.exit(0);
			}
			else
			{
				System.out.println(a/k + b/k);
				System.exit(0);
			}
		}
	}
}
