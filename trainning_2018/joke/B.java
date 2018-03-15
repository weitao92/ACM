package joke;
import java.util.*;

public class B {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		long[] fibo = new long[40];
		fibo[0] = 1;
		fibo[1] = 1;
		for(int i = 2; i < 40; i++)
		{
			fibo[i] = fibo[i-1]+fibo[i-2];
		}
		
		int q = in.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < q; i++)
		{
			sb.append(fibo[in.nextInt()-1]+"\n");
		}
		System.out.print(sb);
	}

}
